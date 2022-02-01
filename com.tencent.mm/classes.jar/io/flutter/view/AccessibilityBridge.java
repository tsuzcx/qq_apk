package io.flutter.view;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccessibilityBridge
  extends AccessibilityNodeProvider
{
  private static final int ACTION_SHOW_ON_SCREEN = 16908342;
  private static int FIRST_RESOURCE_ID = 267386881;
  private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
  private static final int ROOT_NODE_ID = 0;
  private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0F;
  private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0F;
  private static final String TAG = "AccessibilityBridge";
  private final AccessibilityChannel accessibilityChannel;
  private int accessibilityFeatureFlags;
  private SemanticsNode accessibilityFocusedSemanticsNode;
  private final AccessibilityManager accessibilityManager;
  private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
  private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
  private final AccessibilityViewEmbedder accessibilityViewEmbedder;
  private final ContentObserver animationScaleObserver;
  private final ContentResolver contentResolver;
  private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
  private Integer embeddedAccessibilityFocusedNodeId;
  private Integer embeddedInputFocusedNodeId;
  private final List<Integer> flutterNavigationStack;
  private final Map<Integer, SemanticsNode> flutterSemanticsTree;
  private SemanticsNode hoveredObject;
  private SemanticsNode inputFocusedSemanticsNode;
  private boolean isReleased;
  private SemanticsNode lastInputFocusedSemanticsNode;
  private Integer lastLeftFrameInset;
  private OnAccessibilityChangeListener onAccessibilityChangeListener;
  private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
  private int previousRouteId;
  private final View rootAccessibilityView;
  private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
  
  public AccessibilityBridge(View paramView, AccessibilityChannel paramAccessibilityChannel, AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, PlatformViewsAccessibilityDelegate paramPlatformViewsAccessibilityDelegate)
  {
    this(paramView, paramAccessibilityChannel, paramAccessibilityManager, paramContentResolver, new AccessibilityViewEmbedder(paramView, 65536), paramPlatformViewsAccessibilityDelegate);
    AppMethodBeat.i(9750);
    AppMethodBeat.o(9750);
  }
  
  public AccessibilityBridge(View paramView, AccessibilityChannel paramAccessibilityChannel, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, AccessibilityViewEmbedder paramAccessibilityViewEmbedder, PlatformViewsAccessibilityDelegate paramPlatformViewsAccessibilityDelegate)
  {
    AppMethodBeat.i(190647);
    this.flutterSemanticsTree = new HashMap();
    this.customAccessibilityActions = new HashMap();
    this.accessibilityFeatureFlags = 0;
    this.flutterNavigationStack = new ArrayList();
    this.previousRouteId = 0;
    this.lastLeftFrameInset = Integer.valueOf(0);
    this.isReleased = false;
    this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler()
    {
      public void announce(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public void onLongPress(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        AccessibilityBridge.access$200(AccessibilityBridge.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public void onTap(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        AccessibilityBridge.access$200(AccessibilityBridge.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public void onTooltip(String paramAnonymousString)
      {
        AppMethodBeat.i(9691);
        AccessibilityEvent localAccessibilityEvent = AccessibilityBridge.access$300(AccessibilityBridge.this, 0, 32);
        localAccessibilityEvent.getText().add(paramAnonymousString);
        AccessibilityBridge.access$400(AccessibilityBridge.this, localAccessibilityEvent);
        AppMethodBeat.o(9691);
      }
      
      public void updateCustomAccessibilityActions(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9692);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        AccessibilityBridge.this.updateCustomAccessibilityActions(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
        AppMethodBeat.o(9692);
      }
      
      public void updateSemantics(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9693);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        AccessibilityBridge.this.updateSemantics(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
        AppMethodBeat.o(9693);
      }
    };
    this.accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener()
    {
      public void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9797);
        if (AccessibilityBridge.this.isReleased)
        {
          AppMethodBeat.o(9797);
          return;
        }
        if (paramAnonymousBoolean)
        {
          AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
          AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
        }
        for (;;)
        {
          if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
            AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(paramAnonymousBoolean, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
          }
          AppMethodBeat.o(9797);
          return;
          AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(null);
          AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
        }
      }
    };
    this.animationScaleObserver = new ContentObserver(new Handler())
    {
      public void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9776);
        onChange(paramAnonymousBoolean, null);
        AppMethodBeat.o(9776);
      }
      
      public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        AppMethodBeat.i(9777);
        if (AccessibilityBridge.this.isReleased)
        {
          AppMethodBeat.o(9777);
          return;
        }
        int i;
        if (Build.VERSION.SDK_INT < 17)
        {
          paramAnonymousUri = null;
          if ((paramAnonymousUri == null) || (!paramAnonymousUri.equals("0"))) {
            break label104;
          }
          i = 1;
          label48:
          if (i == 0) {
            break label109;
          }
          AccessibilityBridge.access$1102(AccessibilityBridge.this, AccessibilityBridge.this.accessibilityFeatureFlags | AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value);
        }
        for (;;)
        {
          AccessibilityBridge.access$1200(AccessibilityBridge.this);
          AppMethodBeat.o(9777);
          return;
          paramAnonymousUri = Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
          break;
          label104:
          i = 0;
          break label48;
          label109:
          AccessibilityBridge.access$1102(AccessibilityBridge.this, AccessibilityBridge.this.accessibilityFeatureFlags & (AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.accessibilityChannel = paramAccessibilityChannel;
    this.accessibilityManager = paramAccessibilityManager;
    this.contentResolver = paramContentResolver;
    this.accessibilityViewEmbedder = paramAccessibilityViewEmbedder;
    this.platformViewsAccessibilityDelegate = paramPlatformViewsAccessibilityDelegate;
    this.accessibilityStateChangeListener.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (AccessibilityBridge.this.isReleased)
          {
            AppMethodBeat.o(9778);
            return;
          }
          if (paramAnonymousBoolean) {
            AccessibilityBridge.access$1102(AccessibilityBridge.this, AccessibilityBridge.this.accessibilityFeatureFlags | AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
          }
          for (;;)
          {
            AccessibilityBridge.access$1200(AccessibilityBridge.this);
            if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
              AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            AccessibilityBridge.access$1300(AccessibilityBridge.this);
            AccessibilityBridge.access$1102(AccessibilityBridge.this, AccessibilityBridge.this.accessibilityFeatureFlags & (AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.touchExplorationStateChangeListener.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.animationScaleObserver.onChange(false);
        paramView = Settings.Global.getUriFor("transition_animation_scale");
        this.contentResolver.registerContentObserver(paramView, false, this.animationScaleObserver);
      }
      if (paramPlatformViewsAccessibilityDelegate != null) {
        paramPlatformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
      }
      AppMethodBeat.o(190647);
      return;
      this.touchExplorationStateChangeListener = null;
    }
  }
  
  private AccessibilityEvent createTextChangedEvent(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(paramInt, 16);
    localAccessibilityEvent.setBeforeText(paramString1);
    localAccessibilityEvent.getText().add(paramString2);
    paramInt = 0;
    while ((paramInt < paramString1.length()) && (paramInt < paramString2.length()) && (paramString1.charAt(paramInt) == paramString2.charAt(paramInt))) {
      paramInt += 1;
    }
    if ((paramInt >= paramString1.length()) && (paramInt >= paramString2.length()))
    {
      AppMethodBeat.o(9763);
      return null;
    }
    localAccessibilityEvent.setFromIndex(paramInt);
    int j = paramString1.length() - 1;
    int i = paramString2.length() - 1;
    while ((j >= paramInt) && (i >= paramInt) && (paramString1.charAt(j) == paramString2.charAt(i)))
    {
      j -= 1;
      i -= 1;
    }
    localAccessibilityEvent.setRemovedCount(j - paramInt + 1);
    localAccessibilityEvent.setAddedCount(i - paramInt + 1);
    AppMethodBeat.o(9763);
    return localAccessibilityEvent;
  }
  
  private CustomAccessibilityAction getOrCreateAccessibilityAction(int paramInt)
  {
    AppMethodBeat.i(9759);
    CustomAccessibilityAction localCustomAccessibilityAction2 = (CustomAccessibilityAction)this.customAccessibilityActions.get(Integer.valueOf(paramInt));
    CustomAccessibilityAction localCustomAccessibilityAction1 = localCustomAccessibilityAction2;
    if (localCustomAccessibilityAction2 == null)
    {
      localCustomAccessibilityAction1 = new CustomAccessibilityAction();
      CustomAccessibilityAction.access$3702(localCustomAccessibilityAction1, paramInt);
      CustomAccessibilityAction.access$3202(localCustomAccessibilityAction1, FIRST_RESOURCE_ID + paramInt);
      this.customAccessibilityActions.put(Integer.valueOf(paramInt), localCustomAccessibilityAction1);
    }
    AppMethodBeat.o(9759);
    return localCustomAccessibilityAction1;
  }
  
  private SemanticsNode getOrCreateSemanticsNode(int paramInt)
  {
    AppMethodBeat.i(9758);
    SemanticsNode localSemanticsNode2 = (SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt));
    SemanticsNode localSemanticsNode1 = localSemanticsNode2;
    if (localSemanticsNode2 == null)
    {
      localSemanticsNode1 = new SemanticsNode(this);
      SemanticsNode.access$002(localSemanticsNode1, paramInt);
      this.flutterSemanticsTree.put(Integer.valueOf(paramInt), localSemanticsNode1);
    }
    AppMethodBeat.o(9758);
    return localSemanticsNode1;
  }
  
  private SemanticsNode getRootSemanticsNode()
  {
    AppMethodBeat.i(9757);
    SemanticsNode localSemanticsNode = (SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localSemanticsNode;
  }
  
  private void handleTouchExploration(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.flutterSemanticsTree.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    SemanticsNode localSemanticsNode = SemanticsNode.access$3800(getRootSemanticsNode(), new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localSemanticsNode != this.hoveredObject)
    {
      if (localSemanticsNode != null) {
        sendAccessibilityEvent(localSemanticsNode.id, 128);
      }
      if (this.hoveredObject != null) {
        sendAccessibilityEvent(this.hoveredObject.id, 256);
      }
      this.hoveredObject = localSemanticsNode;
    }
    AppMethodBeat.o(9762);
  }
  
  private AccessibilityEvent obtainAccessibilityEvent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9766);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.rootAccessibilityView, paramInt1);
    AppMethodBeat.o(9766);
    return localAccessibilityEvent;
  }
  
  private void onTouchExplorationExit()
  {
    AppMethodBeat.i(9761);
    if (this.hoveredObject != null)
    {
      sendAccessibilityEvent(this.hoveredObject.id, 256);
      this.hoveredObject = null;
    }
    AppMethodBeat.o(9761);
  }
  
  private boolean performCursorMoveAction(SemanticsNode paramSemanticsNode, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(9755);
    int i = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    boolean bool = paramBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    switch (i)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(9755);
        return false;
        if ((paramBoolean) && (SemanticsNode.access$2200(paramSemanticsNode, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!SemanticsNode.access$2200(paramSemanticsNode, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)));
      this.accessibilityChannel.dispatchSemanticsAction(paramInt, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (SemanticsNode.access$2200(paramSemanticsNode, Action.MOVE_CURSOR_FORWARD_BY_WORD)))
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!SemanticsNode.access$2200(paramSemanticsNode, Action.MOVE_CURSOR_BACKWARD_BY_WORD)));
    this.accessibilityChannel.dispatchSemanticsAction(paramInt, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.accessibilityManager.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(obtainAccessibilityEvent(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  private void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.accessibilityManager.isEnabled())
    {
      AppMethodBeat.o(9765);
      return;
    }
    this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, paramAccessibilityEvent);
    AppMethodBeat.o(9765);
  }
  
  private void sendLatestAccessibilityFlagsToFlutter()
  {
    AppMethodBeat.i(190654);
    this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    AppMethodBeat.o(190654);
  }
  
  private void sendWindowChangeEvent(SemanticsNode paramSemanticsNode)
  {
    AppMethodBeat.i(190711);
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(paramSemanticsNode.id, 32);
    String str = SemanticsNode.access$5900(paramSemanticsNode);
    paramSemanticsNode = str;
    if (str == null) {
      paramSemanticsNode = " ";
    }
    localAccessibilityEvent.getText().add(paramSemanticsNode);
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(190711);
  }
  
  private void sendWindowContentChangeEvent(int paramInt)
  {
    AppMethodBeat.i(190714);
    AccessibilityEvent localAccessibilityEvent = obtainAccessibilityEvent(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(190714);
  }
  
  private boolean shouldSetCollectionInfo(final SemanticsNode paramSemanticsNode)
  {
    AppMethodBeat.i(9752);
    if ((paramSemanticsNode.scrollChildren > 0) && ((SemanticsNode.access$1500(this.accessibilityFocusedSemanticsNode, new Predicate()
    {
      public boolean test(AccessibilityBridge.SemanticsNode paramAnonymousSemanticsNode)
      {
        return paramAnonymousSemanticsNode == paramSemanticsNode;
      }
    })) || (!SemanticsNode.access$1500(this.accessibilityFocusedSemanticsNode, new Predicate()
    {
      public boolean test(AccessibilityBridge.SemanticsNode paramAnonymousSemanticsNode)
      {
        AppMethodBeat.i(190624);
        boolean bool = AccessibilityBridge.SemanticsNode.access$1600(paramAnonymousSemanticsNode, AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
        AppMethodBeat.o(190624);
        return bool;
      }
    }))))
    {
      AppMethodBeat.o(9752);
      return true;
    }
    AppMethodBeat.o(9752);
    return false;
  }
  
  private void willRemoveSemanticsNode(SemanticsNode paramSemanticsNode)
  {
    AppMethodBeat.i(190721);
    SemanticsNode.access$2602(paramSemanticsNode, null);
    if ((paramSemanticsNode.platformViewId != -1) && (this.embeddedAccessibilityFocusedNodeId != null) && (this.accessibilityViewEmbedder.platformViewOfNode(this.embeddedAccessibilityFocusedNodeId.intValue()) == this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(paramSemanticsNode.platformViewId))))
    {
      sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), 65536);
      this.embeddedAccessibilityFocusedNodeId = null;
    }
    if (this.accessibilityFocusedSemanticsNode == paramSemanticsNode)
    {
      sendAccessibilityEvent(this.accessibilityFocusedSemanticsNode.id, 65536);
      this.accessibilityFocusedSemanticsNode = null;
    }
    if (this.inputFocusedSemanticsNode == paramSemanticsNode) {
      this.inputFocusedSemanticsNode = null;
    }
    if (this.hoveredObject == paramSemanticsNode) {
      this.hoveredObject = null;
    }
    AppMethodBeat.o(190721);
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    if (paramInt >= 65536)
    {
      localObject1 = this.accessibilityViewEmbedder.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.flutterSemanticsTree.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject2 = (SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt));
    if (localObject2 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((SemanticsNode)localObject2).platformViewId != -1)
    {
      localObject1 = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(((SemanticsNode)localObject2).platformViewId));
      if (this.platformViewsAccessibilityDelegate.usesVirtualDisplay(Integer.valueOf(((SemanticsNode)localObject2).platformViewId)))
      {
        localObject3 = SemanticsNode.access$1800((SemanticsNode)localObject2);
        localObject1 = this.accessibilityViewEmbedder.getRootNode((View)localObject1, ((SemanticsNode)localObject2).id, (Rect)localObject3);
        AppMethodBeat.o(9753);
        return localObject1;
      }
    }
    Object localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject1).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject1).setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject1).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject1).setSource(this.rootAccessibilityView, paramInt);
    ((AccessibilityNodeInfo)localObject1).setFocusable(SemanticsNode.access$1900((SemanticsNode)localObject2));
    boolean bool1;
    if (this.inputFocusedSemanticsNode != null)
    {
      if (this.inputFocusedSemanticsNode.id == paramInt)
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject1).setFocused(bool1);
      }
    }
    else
    {
      if (this.accessibilityFocusedSemanticsNode != null)
      {
        if (this.accessibilityFocusedSemanticsNode.id != paramInt) {
          break label1537;
        }
        bool1 = true;
        label323:
        ((AccessibilityNodeInfo)localObject1).setAccessibilityFocused(bool1);
      }
      if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_TEXT_FIELD))
      {
        ((AccessibilityNodeInfo)localObject1).setPassword(SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_OBSCURED));
        if (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_READ_ONLY)) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.EditText");
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_READ_ONLY)) {
            break label1543;
          }
          bool1 = true;
          label395:
          ((AccessibilityNodeInfo)localObject1).setEditable(bool1);
          if ((((SemanticsNode)localObject2).textSelectionBase != -1) && (((SemanticsNode)localObject2).textSelectionExtent != -1)) {
            ((AccessibilityNodeInfo)localObject1).setTextSelection(((SemanticsNode)localObject2).textSelectionBase, ((SemanticsNode)localObject2).textSelectionExtent);
          }
          if ((Build.VERSION.SDK_INT > 18) && (this.accessibilityFocusedSemanticsNode != null) && (this.accessibilityFocusedSemanticsNode.id == paramInt)) {
            ((AccessibilityNodeInfo)localObject1).setLiveRegion(1);
          }
        }
        if (!SemanticsNode.access$2200((SemanticsNode)localObject2, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
          break label1881;
        }
        ((AccessibilityNodeInfo)localObject1).addAction(256);
      }
    }
    label591:
    label1621:
    label1752:
    label1881:
    for (int j = 1;; j = 0)
    {
      if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(512);
        j = 1;
      }
      int i = j;
      if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.MOVE_CURSOR_FORWARD_BY_WORD))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.MOVE_CURSOR_BACKWARD_BY_WORD))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(512);
        j = i | 0x2;
      }
      ((AccessibilityNodeInfo)localObject1).setMovementGranularities(j);
      Object localObject4;
      label871:
      label1141:
      boolean bool4;
      if ((Build.VERSION.SDK_INT >= 21) && (((SemanticsNode)localObject2).maxValueLength >= 0))
      {
        if (((SemanticsNode)localObject2).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject1).setMaxTextLength(i - ((SemanticsNode)localObject2).currentValueLength + ((SemanticsNode)localObject2).maxValueLength);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SET_SELECTION)) {
            ((AccessibilityNodeInfo)localObject1).addAction(131072);
          }
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.COPY)) {
            ((AccessibilityNodeInfo)localObject1).addAction(16384);
          }
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.CUT)) {
            ((AccessibilityNodeInfo)localObject1).addAction(65536);
          }
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.PASTE)) {
            ((AccessibilityNodeInfo)localObject1).addAction(32768);
          }
        }
        if ((SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_BUTTON)) || (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_LINK))) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.Button");
        }
        if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_IMAGE)) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.DISMISS)))
        {
          ((AccessibilityNodeInfo)localObject1).setDismissable(true);
          ((AccessibilityNodeInfo)localObject1).addAction(1048576);
        }
        if (((SemanticsNode)localObject2).parent == null) {
          break label1561;
        }
        ((AccessibilityNodeInfo)localObject1).setParent(this.rootAccessibilityView, SemanticsNode.access$2600((SemanticsNode)localObject2).id);
        localObject3 = SemanticsNode.access$1800((SemanticsNode)localObject2);
        if (((SemanticsNode)localObject2).parent == null) {
          break label1573;
        }
        localObject4 = SemanticsNode.access$1800(((SemanticsNode)localObject2).parent);
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject1).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject1).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject1).setVisibleToUser(true);
        if ((SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.HAS_ENABLED_STATE)) && (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_ENABLED))) {
          break label1583;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject1).setEnabled(bool1);
        if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.TAP))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((SemanticsNode)localObject2).onTapOverride == null)) {
            break label1589;
          }
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, SemanticsNode.access$2700((SemanticsNode)localObject2).hint));
          ((AccessibilityNodeInfo)localObject1).setClickable(true);
        }
        if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.LONG_PRESS))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((SemanticsNode)localObject2).onLongPressOverride == null)) {
            break label1605;
          }
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, SemanticsNode.access$2900((SemanticsNode)localObject2).hint));
          ((AccessibilityNodeInfo)localObject1).setLongClickable(true);
        }
        if ((SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_LEFT)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_UP)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_RIGHT)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_DOWN)))
        {
          ((AccessibilityNodeInfo)localObject1).setScrollable(true);
          if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.HAS_IMPLICIT_SCROLLING))
          {
            if ((!SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_LEFT)) && (!SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_RIGHT))) {
              break label1632;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!shouldSetCollectionInfo((SemanticsNode)localObject2))) {
              break label1621;
            }
            ((AccessibilityNodeInfo)localObject1).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((SemanticsNode)localObject2).scrollChildren, false));
          }
          if ((SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_LEFT)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_UP))) {
            ((AccessibilityNodeInfo)localObject1).addAction(4096);
          }
          if ((SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_RIGHT)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.SCROLL_DOWN))) {
            ((AccessibilityNodeInfo)localObject1).addAction(8192);
          }
        }
        if ((SemanticsNode.access$2200((SemanticsNode)localObject2, Action.INCREASE)) || (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.DECREASE)))
        {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.SeekBar");
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.INCREASE)) {
            ((AccessibilityNodeInfo)localObject1).addAction(4096);
          }
          if (SemanticsNode.access$2200((SemanticsNode)localObject2, Action.DECREASE)) {
            ((AccessibilityNodeInfo)localObject1).addAction(8192);
          }
        }
        if ((SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_LIVE_REGION)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject1).setLiveRegion(1);
        }
        if (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_TEXT_FIELD)) {
          break label1678;
        }
        ((AccessibilityNodeInfo)localObject1).setText(SemanticsNode.access$3000((SemanticsNode)localObject2));
        boolean bool3 = SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.HAS_CHECKED_STATE);
        bool4 = SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.HAS_TOGGLED_STATE);
        if (!bool3)
        {
          bool1 = bool2;
          if (!bool4) {}
        }
        else
        {
          bool1 = true;
        }
        ((AccessibilityNodeInfo)localObject1).setCheckable(bool1);
        if (!bool3) {
          break label1713;
        }
        ((AccessibilityNodeInfo)localObject1).setChecked(SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_CHECKED));
        if (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
          break label1702;
        }
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.RadioButton");
        label1396:
        ((AccessibilityNodeInfo)localObject1).setSelected(SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_SELECTED));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject1).setHeading(SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_HEADER));
        }
        if ((this.accessibilityFocusedSemanticsNode == null) || (this.accessibilityFocusedSemanticsNode.id != paramInt)) {
          break label1742;
        }
        ((AccessibilityNodeInfo)localObject1).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((SemanticsNode)localObject2).customAccessibilityActions == null)) {
          break label1752;
        }
        localObject3 = ((SemanticsNode)localObject2).customAccessibilityActions.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (CustomAccessibilityAction)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(((CustomAccessibilityAction)localObject4).resourceId, ((CustomAccessibilityAction)localObject4).label));
        }
        bool1 = false;
        break;
        bool1 = false;
        break label323;
        bool1 = false;
        break label395;
        i = ((SemanticsNode)localObject2).value.length();
        break label591;
        ((AccessibilityNodeInfo)localObject1).setParent(this.rootAccessibilityView);
        break label811;
        ((AccessibilityNodeInfo)localObject1).setBoundsInParent((Rect)localObject3);
        break label871;
        bool1 = false;
        break label909;
        ((AccessibilityNodeInfo)localObject1).addAction(16);
        ((AccessibilityNodeInfo)localObject1).setClickable(true);
        break label971;
        ((AccessibilityNodeInfo)localObject1).addAction(32);
        ((AccessibilityNodeInfo)localObject1).setLongClickable(true);
        break label1026;
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.HorizontalScrollView");
        break label1141;
        label1632:
        if ((Build.VERSION.SDK_INT > 18) && (shouldSetCollectionInfo((SemanticsNode)localObject2)))
        {
          ((AccessibilityNodeInfo)localObject1).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((SemanticsNode)localObject2).scrollChildren, 0, false));
          break label1141;
        }
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.ScrollView");
        break label1141;
        if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.SCOPES_ROUTE)) {
          break label1315;
        }
        ((AccessibilityNodeInfo)localObject1).setContentDescription(SemanticsNode.access$3000((SemanticsNode)localObject2));
        break label1315;
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.CheckBox");
        break label1396;
        if (!bool4) {
          break label1396;
        }
        ((AccessibilityNodeInfo)localObject1).setChecked(SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_TOGGLED));
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.Switch");
        break label1396;
        ((AccessibilityNodeInfo)localObject1).addAction(64);
      }
      localObject2 = ((SemanticsNode)localObject2).childrenInTraversalOrder.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SemanticsNode)((Iterator)localObject2).next();
        if (!SemanticsNode.access$1600((SemanticsNode)localObject3, Flag.IS_HIDDEN))
        {
          if (((SemanticsNode)localObject3).platformViewId != -1)
          {
            localObject4 = this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(((SemanticsNode)localObject3).platformViewId));
            if (!this.platformViewsAccessibilityDelegate.usesVirtualDisplay(Integer.valueOf(((SemanticsNode)localObject3).platformViewId)))
            {
              ((AccessibilityNodeInfo)localObject1).addChild((View)localObject4);
              continue;
            }
          }
          ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, ((SemanticsNode)localObject3).id);
        }
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
  }
  
  public boolean externalViewRequestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(190882);
    if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(paramView1, paramView2, paramAccessibilityEvent))
    {
      AppMethodBeat.o(190882);
      return false;
    }
    paramView1 = this.accessibilityViewEmbedder.getRecordFlutterId(paramView1, paramAccessibilityEvent);
    if (paramView1 == null)
    {
      AppMethodBeat.o(190882);
      return false;
    }
    switch (paramAccessibilityEvent.getEventType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190882);
      return true;
      this.hoveredObject = null;
      continue;
      this.embeddedAccessibilityFocusedNodeId = paramView1;
      this.accessibilityFocusedSemanticsNode = null;
      continue;
      this.embeddedInputFocusedNodeId = null;
      this.embeddedAccessibilityFocusedNodeId = null;
      continue;
      this.embeddedInputFocusedNodeId = paramView1;
      this.inputFocusedSemanticsNode = null;
    }
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt)
  {
    AppMethodBeat.i(9756);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(9756);
      return null;
      if (this.inputFocusedSemanticsNode != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.inputFocusedSemanticsNode.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.embeddedInputFocusedNodeId != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.embeddedInputFocusedNodeId.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.accessibilityFocusedSemanticsNode != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.accessibilityFocusedSemanticsNode.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.embeddedAccessibilityFocusedNodeId == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.embeddedAccessibilityFocusedNodeId.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  public int getHoveredObjectId()
  {
    AppMethodBeat.i(190810);
    int i = this.hoveredObject.id;
    AppMethodBeat.o(190810);
    return i;
  }
  
  public boolean isAccessibilityEnabled()
  {
    AppMethodBeat.i(190823);
    boolean bool = this.accessibilityManager.isEnabled();
    AppMethodBeat.o(190823);
    return bool;
  }
  
  public boolean isTouchExplorationEnabled()
  {
    AppMethodBeat.i(190829);
    boolean bool = this.accessibilityManager.isTouchExplorationEnabled();
    AppMethodBeat.o(190829);
    return bool;
  }
  
  public boolean onAccessibilityHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.accessibilityManager.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.flutterSemanticsTree.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    SemanticsNode localSemanticsNode = SemanticsNode.access$3800(getRootSemanticsNode(), new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if ((localSemanticsNode != null) && (localSemanticsNode.platformViewId != -1))
    {
      boolean bool = this.accessibilityViewEmbedder.onAccessibilityHoverEvent(localSemanticsNode.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      handleTouchExploration(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      onTouchExplorationExit();
    }
    Log.d("flutter", "unexpected accessibility hover event: ".concat(String.valueOf(paramMotionEvent)));
    AppMethodBeat.o(9760);
    return false;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(9754);
    boolean bool;
    if (paramInt1 >= 65536)
    {
      bool = this.accessibilityViewEmbedder.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.embeddedAccessibilityFocusedNodeId = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    SemanticsNode localSemanticsNode = (SemanticsNode)this.flutterSemanticsTree.get(Integer.valueOf(paramInt1));
    if (localSemanticsNode == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = FIRST_RESOURCE_ID;
      paramBundle = (CustomAccessibilityAction)this.customAccessibilityActions.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.CUSTOM_ACTION, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.TAP);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.LONG_PRESS);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (SemanticsNode.access$2200(localSemanticsNode, Action.SCROLL_UP)) {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SCROLL_UP);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (SemanticsNode.access$2200(localSemanticsNode, Action.SCROLL_LEFT))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SCROLL_LEFT);
        }
        else
        {
          if (!SemanticsNode.access$2200(localSemanticsNode, Action.INCREASE)) {
            break;
          }
          SemanticsNode.access$2402(localSemanticsNode, localSemanticsNode.increasedValue);
          sendAccessibilityEvent(paramInt1, 4);
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.INCREASE);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (SemanticsNode.access$2200(localSemanticsNode, Action.SCROLL_DOWN)) {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SCROLL_DOWN);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (SemanticsNode.access$2200(localSemanticsNode, Action.SCROLL_RIGHT))
        {
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SCROLL_RIGHT);
        }
        else
        {
          if (!SemanticsNode.access$2200(localSemanticsNode, Action.DECREASE)) {
            break;
          }
          SemanticsNode.access$2402(localSemanticsNode, localSemanticsNode.decreasedValue);
          sendAccessibilityEvent(paramInt1, 4);
          this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.DECREASE);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 512: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = performCursorMoveAction(localSemanticsNode, paramInt1, paramBundle, false);
      AppMethodBeat.o(9754);
      return bool;
    case 256: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = performCursorMoveAction(localSemanticsNode, paramInt1, paramBundle, true);
      AppMethodBeat.o(9754);
      return bool;
    case 128: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
      sendAccessibilityEvent(paramInt1, 65536);
      this.accessibilityFocusedSemanticsNode = null;
      this.embeddedAccessibilityFocusedNodeId = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
      sendAccessibilityEvent(paramInt1, 32768);
      if (this.accessibilityFocusedSemanticsNode == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.accessibilityFocusedSemanticsNode = localSemanticsNode;
      if ((SemanticsNode.access$2200(localSemanticsNode, Action.INCREASE)) || (SemanticsNode.access$2200(localSemanticsNode, Action.DECREASE))) {
        sendAccessibilityEvent(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SHOW_ON_SCREEN);
      AppMethodBeat.o(9754);
      return true;
    case 131072: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      HashMap localHashMap = new HashMap();
      paramInt2 = i;
      if (paramBundle != null)
      {
        paramInt2 = i;
        if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT"))
        {
          paramInt2 = i;
          if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 != 0)
      {
        localHashMap.put("base", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
        localHashMap.put("extent", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
      }
      for (;;)
      {
        this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.SET_SELECTION, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localSemanticsNode.textSelectionExtent));
        localHashMap.put("extent", Integer.valueOf(localSemanticsNode.textSelectionExtent));
      }
    case 16384: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.COPY);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.CUT);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.PASTE);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.accessibilityChannel.dispatchSemanticsAction(paramInt1, Action.DISMISS);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public void release()
  {
    AppMethodBeat.i(9751);
    this.isReleased = true;
    if (this.platformViewsAccessibilityDelegate != null) {
      this.platformViewsAccessibilityDelegate.detachAccessibiltyBridge();
    }
    setOnAccessibilityChangeListener(null);
    this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
    if (Build.VERSION.SDK_INT >= 19) {
      this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
    }
    this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
    this.accessibilityChannel.setAccessibilityMessageHandler(null);
    AppMethodBeat.o(9751);
  }
  
  public void reset()
  {
    AppMethodBeat.i(9767);
    this.flutterSemanticsTree.clear();
    if (this.accessibilityFocusedSemanticsNode != null) {
      sendAccessibilityEvent(this.accessibilityFocusedSemanticsNode.id, 65536);
    }
    this.accessibilityFocusedSemanticsNode = null;
    this.hoveredObject = null;
    sendWindowContentChangeEvent(0);
    AppMethodBeat.o(9767);
  }
  
  public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener paramOnAccessibilityChangeListener)
  {
    this.onAccessibilityChangeListener = paramOnAccessibilityChangeListener;
  }
  
  void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    AppMethodBeat.i(190860);
    if (paramByteBuffer.hasRemaining())
    {
      CustomAccessibilityAction localCustomAccessibilityAction = getOrCreateAccessibilityAction(paramByteBuffer.getInt());
      CustomAccessibilityAction.access$3902(localCustomAccessibilityAction, paramByteBuffer.getInt());
      int i = paramByteBuffer.getInt();
      if (i == -1)
      {
        str = null;
        label46:
        CustomAccessibilityAction.access$3302(localCustomAccessibilityAction, str);
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label86;
        }
      }
      label86:
      for (String str = null;; str = paramArrayOfString[i])
      {
        CustomAccessibilityAction.access$2802(localCustomAccessibilityAction, str);
        break;
        str = paramArrayOfString[i];
        break label46;
      }
    }
    AppMethodBeat.o(190860);
  }
  
  void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    AppMethodBeat.i(190870);
    Object localObject1 = new ArrayList();
    while (paramByteBuffer.hasRemaining())
    {
      localObject2 = getOrCreateSemanticsNode(paramByteBuffer.getInt());
      SemanticsNode.access$4000((SemanticsNode)localObject2, paramByteBuffer, paramArrayOfString);
      if (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_HIDDEN))
      {
        if (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_FOCUSED)) {
          this.inputFocusedSemanticsNode = ((SemanticsNode)localObject2);
        }
        if (((SemanticsNode)localObject2).hadPreviousConfig) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
    Object localObject2 = new HashSet();
    paramByteBuffer = getRootSemanticsNode();
    ArrayList localArrayList = new ArrayList();
    if (paramByteBuffer != null)
    {
      paramArrayOfString = new float[16];
      Matrix.setIdentityM(paramArrayOfString, 0);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject3 = this.rootAccessibilityView.getRootWindowInsets();
        if (localObject3 != null)
        {
          if (!this.lastLeftFrameInset.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
          {
            SemanticsNode.access$4202(paramByteBuffer, true);
            SemanticsNode.access$4302(paramByteBuffer, true);
          }
          this.lastLeftFrameInset = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
          Matrix.translateM(paramArrayOfString, 0, this.lastLeftFrameInset.intValue(), 0.0F, 0.0F);
        }
      }
      SemanticsNode.access$4400(paramByteBuffer, paramArrayOfString, (Set)localObject2, false);
      SemanticsNode.access$4500(paramByteBuffer, localArrayList);
    }
    paramByteBuffer = null;
    Object localObject3 = localArrayList.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      paramArrayOfString = (SemanticsNode)((Iterator)localObject3).next();
      if (this.flutterNavigationStack.contains(Integer.valueOf(paramArrayOfString.id))) {
        break label1241;
      }
      paramByteBuffer = paramArrayOfString;
    }
    label657:
    label697:
    label1214:
    label1228:
    label1231:
    label1241:
    for (;;)
    {
      break;
      paramArrayOfString = paramByteBuffer;
      if (paramByteBuffer == null)
      {
        paramArrayOfString = paramByteBuffer;
        if (localArrayList.size() > 0) {
          paramArrayOfString = (SemanticsNode)localArrayList.get(localArrayList.size() - 1);
        }
      }
      if ((paramArrayOfString != null) && ((paramArrayOfString.id != this.previousRouteId) || (localArrayList.size() != this.flutterNavigationStack.size())))
      {
        this.previousRouteId = paramArrayOfString.id;
        sendWindowChangeEvent(paramArrayOfString);
      }
      this.flutterNavigationStack.clear();
      paramByteBuffer = localArrayList.iterator();
      while (paramByteBuffer.hasNext())
      {
        paramArrayOfString = (SemanticsNode)paramByteBuffer.next();
        this.flutterNavigationStack.add(Integer.valueOf(paramArrayOfString.id));
      }
      paramByteBuffer = this.flutterSemanticsTree.entrySet().iterator();
      while (paramByteBuffer.hasNext())
      {
        paramArrayOfString = (SemanticsNode)((Map.Entry)paramByteBuffer.next()).getValue();
        if (!((Set)localObject2).contains(paramArrayOfString))
        {
          willRemoveSemanticsNode(paramArrayOfString);
          paramByteBuffer.remove();
        }
      }
      sendWindowContentChangeEvent(0);
      localObject1 = ((ArrayList)localObject1).iterator();
      float f3;
      float f2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SemanticsNode)((Iterator)localObject1).next();
        if (SemanticsNode.access$4600((SemanticsNode)localObject2))
        {
          paramByteBuffer = obtainAccessibilityEvent(((SemanticsNode)localObject2).id, 4096);
          f3 = ((SemanticsNode)localObject2).scrollPosition;
          f2 = ((SemanticsNode)localObject2).scrollExtentMax;
          f1 = f3;
          if (Float.isInfinite(((SemanticsNode)localObject2).scrollExtentMax))
          {
            if (f3 <= 70000.0F) {
              break label1231;
            }
            f2 = 100000.0F;
          }
        }
      }
      for (float f1 = 70000.0F;; f1 = f3)
      {
        label622:
        int i;
        if (Float.isInfinite(((SemanticsNode)localObject2).scrollExtentMin))
        {
          f3 = f2 + 100000.0F;
          f2 = f1;
          if (f1 < -70000.0F) {
            f2 = -70000.0F;
          }
          f2 += 100000.0F;
          f1 = f3;
          if ((!SemanticsNode.access$5000((SemanticsNode)localObject2, Action.SCROLL_UP)) && (!SemanticsNode.access$5000((SemanticsNode)localObject2, Action.SCROLL_DOWN))) {
            break label762;
          }
          paramByteBuffer.setScrollY((int)f2);
          paramByteBuffer.setMaxScrollY((int)f1);
          if (((SemanticsNode)localObject2).scrollChildren <= 0) {
            break label814;
          }
          paramByteBuffer.setItemCount(((SemanticsNode)localObject2).scrollChildren);
          paramByteBuffer.setFromIndex(((SemanticsNode)localObject2).scrollIndex);
          paramArrayOfString = ((SemanticsNode)localObject2).childrenInHitTestOrder.iterator();
          i = 0;
          if (!paramArrayOfString.hasNext()) {
            break label800;
          }
          if (SemanticsNode.access$1600((SemanticsNode)paramArrayOfString.next(), Flag.IS_HIDDEN)) {
            break label1228;
          }
          i += 1;
        }
        for (;;)
        {
          break label697;
          f2 -= ((SemanticsNode)localObject2).scrollExtentMin;
          f3 = f1 - ((SemanticsNode)localObject2).scrollExtentMin;
          f1 = f2;
          f2 = f3;
          break label622;
          label762:
          if ((!SemanticsNode.access$5000((SemanticsNode)localObject2, Action.SCROLL_LEFT)) && (!SemanticsNode.access$5000((SemanticsNode)localObject2, Action.SCROLL_RIGHT))) {
            break label657;
          }
          paramByteBuffer.setScrollX((int)f2);
          paramByteBuffer.setMaxScrollX((int)f1);
          break label657;
          paramByteBuffer.setToIndex(((SemanticsNode)localObject2).scrollIndex + i - 1);
          sendAccessibilityEvent(paramByteBuffer);
          if ((SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_LIVE_REGION)) && (SemanticsNode.access$5300((SemanticsNode)localObject2))) {
            sendWindowContentChangeEvent(((SemanticsNode)localObject2).id);
          }
          if ((this.accessibilityFocusedSemanticsNode != null) && (this.accessibilityFocusedSemanticsNode.id == ((SemanticsNode)localObject2).id) && (!SemanticsNode.access$5400((SemanticsNode)localObject2, Flag.IS_SELECTED)) && (SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_SELECTED)))
          {
            paramByteBuffer = obtainAccessibilityEvent(((SemanticsNode)localObject2).id, 4);
            paramByteBuffer.getText().add(((SemanticsNode)localObject2).label);
            sendAccessibilityEvent(paramByteBuffer);
          }
          if ((this.inputFocusedSemanticsNode != null) && (this.inputFocusedSemanticsNode.id == ((SemanticsNode)localObject2).id) && ((this.lastInputFocusedSemanticsNode == null) || (this.lastInputFocusedSemanticsNode.id != this.inputFocusedSemanticsNode.id)))
          {
            this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
            sendAccessibilityEvent(obtainAccessibilityEvent(((SemanticsNode)localObject2).id, 8));
            label991:
            if ((this.inputFocusedSemanticsNode == null) || (this.inputFocusedSemanticsNode.id != ((SemanticsNode)localObject2).id) || (!SemanticsNode.access$5400((SemanticsNode)localObject2, Flag.IS_TEXT_FIELD)) || (!SemanticsNode.access$1600((SemanticsNode)localObject2, Flag.IS_TEXT_FIELD)) || ((this.accessibilityFocusedSemanticsNode != null) && (this.accessibilityFocusedSemanticsNode.id != this.inputFocusedSemanticsNode.id))) {
              break label1205;
            }
            if (((SemanticsNode)localObject2).previousValue == null) {
              break label1207;
            }
            paramByteBuffer = ((SemanticsNode)localObject2).previousValue;
            if (((SemanticsNode)localObject2).value == null) {
              break label1214;
            }
          }
          for (paramArrayOfString = ((SemanticsNode)localObject2).value;; paramArrayOfString = "")
          {
            paramByteBuffer = createTextChangedEvent(((SemanticsNode)localObject2).id, paramByteBuffer, paramArrayOfString);
            if (paramByteBuffer != null) {
              sendAccessibilityEvent(paramByteBuffer);
            }
            if ((((SemanticsNode)localObject2).previousTextSelectionBase == ((SemanticsNode)localObject2).textSelectionBase) && (((SemanticsNode)localObject2).previousTextSelectionExtent == ((SemanticsNode)localObject2).textSelectionExtent)) {
              break;
            }
            paramByteBuffer = obtainAccessibilityEvent(((SemanticsNode)localObject2).id, 8192);
            paramByteBuffer.getText().add(paramArrayOfString);
            paramByteBuffer.setFromIndex(((SemanticsNode)localObject2).textSelectionBase);
            paramByteBuffer.setToIndex(((SemanticsNode)localObject2).textSelectionExtent);
            paramByteBuffer.setItemCount(paramArrayOfString.length());
            sendAccessibilityEvent(paramByteBuffer);
            break;
            if (this.inputFocusedSemanticsNode != null) {
              break label991;
            }
            this.lastInputFocusedSemanticsNode = null;
            break label991;
            break;
            paramByteBuffer = "";
            break label1073;
          }
          AppMethodBeat.o(190870);
          return;
        }
        f2 = 100000.0F;
      }
    }
  }
  
  public static enum Action
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(9783);
      TAP = new Action("TAP", 0, 1);
      LONG_PRESS = new Action("LONG_PRESS", 1, 2);
      SCROLL_LEFT = new Action("SCROLL_LEFT", 2, 4);
      SCROLL_RIGHT = new Action("SCROLL_RIGHT", 3, 8);
      SCROLL_UP = new Action("SCROLL_UP", 4, 16);
      SCROLL_DOWN = new Action("SCROLL_DOWN", 5, 32);
      INCREASE = new Action("INCREASE", 6, 64);
      DECREASE = new Action("DECREASE", 7, 128);
      SHOW_ON_SCREEN = new Action("SHOW_ON_SCREEN", 8, 256);
      MOVE_CURSOR_FORWARD_BY_CHARACTER = new Action("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      MOVE_CURSOR_BACKWARD_BY_CHARACTER = new Action("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      SET_SELECTION = new Action("SET_SELECTION", 11, 2048);
      COPY = new Action("COPY", 12, 4096);
      CUT = new Action("CUT", 13, 8192);
      PASTE = new Action("PASTE", 14, 16384);
      DID_GAIN_ACCESSIBILITY_FOCUS = new Action("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      DID_LOSE_ACCESSIBILITY_FOCUS = new Action("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      CUSTOM_ACTION = new Action("CUSTOM_ACTION", 17, 131072);
      DISMISS = new Action("DISMISS", 18, 262144);
      MOVE_CURSOR_FORWARD_BY_WORD = new Action("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      MOVE_CURSOR_BACKWARD_BY_WORD = new Action("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      $VALUES = new Action[] { TAP, LONG_PRESS, SCROLL_LEFT, SCROLL_RIGHT, SCROLL_UP, SCROLL_DOWN, INCREASE, DECREASE, SHOW_ON_SCREEN, MOVE_CURSOR_FORWARD_BY_CHARACTER, MOVE_CURSOR_BACKWARD_BY_CHARACTER, SET_SELECTION, COPY, CUT, PASTE, DID_GAIN_ACCESSIBILITY_FOCUS, DID_LOSE_ACCESSIBILITY_FOCUS, CUSTOM_ACTION, DISMISS, MOVE_CURSOR_FORWARD_BY_WORD, MOVE_CURSOR_BACKWARD_BY_WORD };
      AppMethodBeat.o(9783);
    }
    
    private Action(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static class CustomAccessibilityAction
  {
    private String hint;
    private int id = -1;
    private String label;
    private int overrideId = -1;
    private int resourceId = -1;
  }
  
  static enum Flag
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(9679);
      HAS_CHECKED_STATE = new Flag("HAS_CHECKED_STATE", 0, 1);
      IS_CHECKED = new Flag("IS_CHECKED", 1, 2);
      IS_SELECTED = new Flag("IS_SELECTED", 2, 4);
      IS_BUTTON = new Flag("IS_BUTTON", 3, 8);
      IS_TEXT_FIELD = new Flag("IS_TEXT_FIELD", 4, 16);
      IS_FOCUSED = new Flag("IS_FOCUSED", 5, 32);
      HAS_ENABLED_STATE = new Flag("HAS_ENABLED_STATE", 6, 64);
      IS_ENABLED = new Flag("IS_ENABLED", 7, 128);
      IS_IN_MUTUALLY_EXCLUSIVE_GROUP = new Flag("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      IS_HEADER = new Flag("IS_HEADER", 9, 512);
      IS_OBSCURED = new Flag("IS_OBSCURED", 10, 1024);
      SCOPES_ROUTE = new Flag("SCOPES_ROUTE", 11, 2048);
      NAMES_ROUTE = new Flag("NAMES_ROUTE", 12, 4096);
      IS_HIDDEN = new Flag("IS_HIDDEN", 13, 8192);
      IS_IMAGE = new Flag("IS_IMAGE", 14, 16384);
      IS_LIVE_REGION = new Flag("IS_LIVE_REGION", 15, 32768);
      HAS_TOGGLED_STATE = new Flag("HAS_TOGGLED_STATE", 16, 65536);
      IS_TOGGLED = new Flag("IS_TOGGLED", 17, 131072);
      HAS_IMPLICIT_SCROLLING = new Flag("HAS_IMPLICIT_SCROLLING", 18, 262144);
      IS_READ_ONLY = new Flag("IS_READ_ONLY", 19, 1048576);
      IS_FOCUSABLE = new Flag("IS_FOCUSABLE", 20, 2097152);
      IS_LINK = new Flag("IS_LINK", 21, 4194304);
      $VALUES = new Flag[] { HAS_CHECKED_STATE, IS_CHECKED, IS_SELECTED, IS_BUTTON, IS_TEXT_FIELD, IS_FOCUSED, HAS_ENABLED_STATE, IS_ENABLED, IS_IN_MUTUALLY_EXCLUSIVE_GROUP, IS_HEADER, IS_OBSCURED, SCOPES_ROUTE, NAMES_ROUTE, IS_HIDDEN, IS_IMAGE, IS_LIVE_REGION, HAS_TOGGLED_STATE, IS_TOGGLED, HAS_IMPLICIT_SCROLLING, IS_READ_ONLY, IS_FOCUSABLE, IS_LINK };
      AppMethodBeat.o(9679);
    }
    
    private Flag(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface OnAccessibilityChangeListener
  {
    public abstract void onAccessibilityChanged(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  static class SemanticsNode
  {
    final AccessibilityBridge accessibilityBridge;
    private int actions;
    private float bottom;
    private List<SemanticsNode> childrenInHitTestOrder;
    private List<SemanticsNode> childrenInTraversalOrder;
    private int currentValueLength;
    private List<AccessibilityBridge.CustomAccessibilityAction> customAccessibilityActions;
    private String decreasedValue;
    private int flags;
    private boolean globalGeometryDirty;
    private Rect globalRect;
    private float[] globalTransform;
    private boolean hadPreviousConfig;
    private String hint;
    private int id;
    private String increasedValue;
    private float[] inverseTransform;
    private boolean inverseTransformDirty;
    private String label;
    private float left;
    private int maxValueLength;
    private AccessibilityBridge.CustomAccessibilityAction onLongPressOverride;
    private AccessibilityBridge.CustomAccessibilityAction onTapOverride;
    private SemanticsNode parent;
    private int platformViewId;
    private int previousActions;
    private int previousFlags;
    private String previousLabel;
    private float previousScrollExtentMax;
    private float previousScrollExtentMin;
    private float previousScrollPosition;
    private int previousTextSelectionBase;
    private int previousTextSelectionExtent;
    private String previousValue;
    private float right;
    private int scrollChildren;
    private float scrollExtentMax;
    private float scrollExtentMin;
    private int scrollIndex;
    private float scrollPosition;
    private AccessibilityBridge.TextDirection textDirection;
    private int textSelectionBase;
    private int textSelectionExtent;
    private float top;
    private float[] transform;
    private String value;
    
    SemanticsNode(AccessibilityBridge paramAccessibilityBridge)
    {
      AppMethodBeat.i(9803);
      this.id = -1;
      this.hadPreviousConfig = false;
      this.childrenInTraversalOrder = new ArrayList();
      this.childrenInHitTestOrder = new ArrayList();
      this.inverseTransformDirty = true;
      this.globalGeometryDirty = true;
      this.accessibilityBridge = paramAccessibilityBridge;
      AppMethodBeat.o(9803);
    }
    
    private void collectRoutes(List<SemanticsNode> paramList)
    {
      AppMethodBeat.i(9806);
      if (hasFlag(AccessibilityBridge.Flag.SCOPES_ROUTE)) {
        paramList.add(this);
      }
      Iterator localIterator = this.childrenInTraversalOrder.iterator();
      while (localIterator.hasNext()) {
        ((SemanticsNode)localIterator.next()).collectRoutes(paramList);
      }
      AppMethodBeat.o(9806);
    }
    
    private boolean didChangeLabel()
    {
      AppMethodBeat.i(190680);
      if ((this.label == null) && (this.previousLabel == null))
      {
        AppMethodBeat.o(190680);
        return false;
      }
      if ((this.label == null) || (this.previousLabel == null) || (!this.label.equals(this.previousLabel)))
      {
        AppMethodBeat.o(190680);
        return true;
      }
      AppMethodBeat.o(190680);
      return false;
    }
    
    private boolean didScroll()
    {
      AppMethodBeat.i(190674);
      if ((!Float.isNaN(this.scrollPosition)) && (!Float.isNaN(this.previousScrollPosition)) && (this.previousScrollPosition != this.scrollPosition))
      {
        AppMethodBeat.o(190674);
        return true;
      }
      AppMethodBeat.o(190674);
      return false;
    }
    
    private void ensureInverseTransform()
    {
      AppMethodBeat.i(190695);
      if (!this.inverseTransformDirty)
      {
        AppMethodBeat.o(190695);
        return;
      }
      this.inverseTransformDirty = false;
      if (this.inverseTransform == null) {
        this.inverseTransform = new float[16];
      }
      if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
        Arrays.fill(this.inverseTransform, 0.0F);
      }
      AppMethodBeat.o(190695);
    }
    
    private SemanticsNode getAncestor(Predicate<SemanticsNode> paramPredicate)
    {
      AppMethodBeat.i(190646);
      for (SemanticsNode localSemanticsNode = this.parent; localSemanticsNode != null; localSemanticsNode = localSemanticsNode.parent) {
        if (paramPredicate.test(localSemanticsNode))
        {
          AppMethodBeat.o(190646);
          return localSemanticsNode;
        }
      }
      AppMethodBeat.o(190646);
      return null;
    }
    
    private Rect getGlobalRect()
    {
      return this.globalRect;
    }
    
    private String getRouteName()
    {
      AppMethodBeat.i(9807);
      if ((hasFlag(AccessibilityBridge.Flag.NAMES_ROUTE)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.childrenInTraversalOrder.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((SemanticsNode)((Iterator)localObject).next()).getRouteName();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    private String getValueLabelHint()
    {
      int i = 0;
      AppMethodBeat.i(9812);
      Object localObject = new StringBuilder();
      String str1 = this.value;
      String str2 = this.label;
      String str3 = this.hint;
      while (i < 3)
      {
        String str4 = new String[] { str1, str2, str3 }[i];
        if ((str4 != null) && (str4.length() > 0))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(", ");
          }
          ((StringBuilder)localObject).append(str4);
        }
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 0)
      {
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(9812);
        return localObject;
      }
      AppMethodBeat.o(9812);
      return null;
    }
    
    private boolean hadAction(AccessibilityBridge.Action paramAction)
    {
      return (this.previousActions & paramAction.value) != 0;
    }
    
    private boolean hadFlag(AccessibilityBridge.Flag paramFlag)
    {
      return (this.previousFlags & paramFlag.value) != 0;
    }
    
    private boolean hasAction(AccessibilityBridge.Action paramAction)
    {
      return (this.actions & paramAction.value) != 0;
    }
    
    private boolean hasFlag(AccessibilityBridge.Flag paramFlag)
    {
      return (this.flags & paramFlag.value) != 0;
    }
    
    private SemanticsNode hitTest(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(9805);
      float f2 = paramArrayOfFloat[3];
      float f1 = paramArrayOfFloat[0] / f2;
      f2 = paramArrayOfFloat[1] / f2;
      if ((f1 < this.left) || (f1 >= this.right) || (f2 < this.top) || (f2 >= this.bottom))
      {
        AppMethodBeat.o(9805);
        return null;
      }
      float[] arrayOfFloat = new float[4];
      Iterator localIterator = this.childrenInHitTestOrder.iterator();
      while (localIterator.hasNext())
      {
        SemanticsNode localSemanticsNode = (SemanticsNode)localIterator.next();
        if (!localSemanticsNode.hasFlag(AccessibilityBridge.Flag.IS_HIDDEN))
        {
          localSemanticsNode.ensureInverseTransform();
          Matrix.multiplyMV(arrayOfFloat, 0, localSemanticsNode.inverseTransform, 0, paramArrayOfFloat, 0);
          localSemanticsNode = localSemanticsNode.hitTest(arrayOfFloat);
          if (localSemanticsNode != null)
          {
            AppMethodBeat.o(9805);
            return localSemanticsNode;
          }
        }
      }
      if (isFocusable())
      {
        AppMethodBeat.o(9805);
        return this;
      }
      AppMethodBeat.o(9805);
      return null;
    }
    
    private boolean isFocusable()
    {
      AppMethodBeat.i(190710);
      if (hasFlag(AccessibilityBridge.Flag.SCOPES_ROUTE))
      {
        AppMethodBeat.o(190710);
        return false;
      }
      if (hasFlag(AccessibilityBridge.Flag.IS_FOCUSABLE))
      {
        AppMethodBeat.o(190710);
        return true;
      }
      if (((((AccessibilityBridge.Action.SCROLL_RIGHT.value | AccessibilityBridge.Action.SCROLL_LEFT.value | AccessibilityBridge.Action.SCROLL_UP.value | AccessibilityBridge.Action.SCROLL_DOWN.value) ^ 0xFFFFFFFF) & this.actions) != 0) || (this.flags != 0) || ((this.label != null) && (!this.label.isEmpty())) || ((this.value != null) && (!this.value.isEmpty())) || ((this.hint != null) && (!this.hint.isEmpty())))
      {
        AppMethodBeat.o(190710);
        return true;
      }
      AppMethodBeat.o(190710);
      return false;
    }
    
    private void log(String paramString, boolean paramBoolean) {}
    
    private float max(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9811);
      paramFloat1 = Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9811);
      return paramFloat1;
    }
    
    private float min(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    private static boolean nullableHasAncestor(SemanticsNode paramSemanticsNode, Predicate<SemanticsNode> paramPredicate)
    {
      AppMethodBeat.i(9802);
      if ((paramSemanticsNode != null) && (paramSemanticsNode.getAncestor(paramPredicate) != null))
      {
        AppMethodBeat.o(9802);
        return true;
      }
      AppMethodBeat.o(9802);
      return false;
    }
    
    private void transformPoint(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      AppMethodBeat.i(9809);
      Matrix.multiplyMV(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat3, 0);
      float f = paramArrayOfFloat1[3];
      paramArrayOfFloat1[0] /= f;
      paramArrayOfFloat1[1] /= f;
      paramArrayOfFloat1[2] /= f;
      paramArrayOfFloat1[3] = 0.0F;
      AppMethodBeat.o(9809);
    }
    
    private void updateRecursively(float[] paramArrayOfFloat, Set<SemanticsNode> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.globalGeometryDirty) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.globalTransform == null) {
          this.globalTransform = new float[16];
        }
        Matrix.multiplyMM(this.globalTransform, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        transformPoint(arrayOfFloat1, this.globalTransform, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        transformPoint(arrayOfFloat2, this.globalTransform, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        transformPoint(arrayOfFloat3, this.globalTransform, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        transformPoint(arrayOfFloat4, this.globalTransform, paramArrayOfFloat);
        if (this.globalRect == null) {
          this.globalRect = new Rect();
        }
        this.globalRect.set(Math.round(min(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(min(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(max(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(max(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.globalGeometryDirty = false;
      }
      paramArrayOfFloat = this.childrenInTraversalOrder.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((SemanticsNode)paramArrayOfFloat.next()).updateRecursively(this.globalTransform, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    private void updateWith(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.hadPreviousConfig = true;
      this.previousValue = this.value;
      this.previousLabel = this.label;
      this.previousFlags = this.flags;
      this.previousActions = this.actions;
      this.previousTextSelectionBase = this.textSelectionBase;
      this.previousTextSelectionExtent = this.textSelectionExtent;
      this.previousScrollPosition = this.scrollPosition;
      this.previousScrollExtentMax = this.scrollExtentMax;
      this.previousScrollExtentMin = this.scrollExtentMin;
      this.flags = paramByteBuffer.getInt();
      this.actions = paramByteBuffer.getInt();
      this.maxValueLength = paramByteBuffer.getInt();
      this.currentValueLength = paramByteBuffer.getInt();
      this.textSelectionBase = paramByteBuffer.getInt();
      this.textSelectionExtent = paramByteBuffer.getInt();
      this.platformViewId = paramByteBuffer.getInt();
      this.scrollChildren = paramByteBuffer.getInt();
      this.scrollIndex = paramByteBuffer.getInt();
      this.scrollPosition = paramByteBuffer.getFloat();
      this.scrollExtentMax = paramByteBuffer.getFloat();
      this.scrollExtentMin = paramByteBuffer.getFloat();
      int i = paramByteBuffer.getInt();
      String str;
      if (i == -1)
      {
        str = null;
        this.label = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label363;
        }
        str = null;
        label211:
        this.value = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label371;
        }
        str = null;
        label230:
        this.increasedValue = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.decreasedValue = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.textDirection = AccessibilityBridge.TextDirection.fromInt(paramByteBuffer.getInt());
        this.left = paramByteBuffer.getFloat();
        this.top = paramByteBuffer.getFloat();
        this.right = paramByteBuffer.getFloat();
        this.bottom = paramByteBuffer.getFloat();
        if (this.transform == null) {
          this.transform = new float[16];
        }
        i = 0;
        while (i < 16)
        {
          this.transform[i] = paramByteBuffer.getFloat();
          i += 1;
        }
        str = paramArrayOfString[i];
        break;
        label363:
        str = paramArrayOfString[i];
        break label211;
        label371:
        str = paramArrayOfString[i];
        break label230;
        label379:
        str = paramArrayOfString[i];
        break label249;
      }
      this.inverseTransformDirty = true;
      this.globalGeometryDirty = true;
      int j = paramByteBuffer.getInt();
      this.childrenInTraversalOrder.clear();
      this.childrenInHitTestOrder.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = AccessibilityBridge.access$6000(this.accessibilityBridge, paramByteBuffer.getInt());
        paramArrayOfString.parent = this;
        this.childrenInTraversalOrder.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = AccessibilityBridge.access$6000(this.accessibilityBridge, paramByteBuffer.getInt());
        paramArrayOfString.parent = this;
        this.childrenInHitTestOrder.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.customAccessibilityActions = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.customAccessibilityActions == null)
      {
        this.customAccessibilityActions = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = AccessibilityBridge.access$6100(this.accessibilityBridge, paramByteBuffer.getInt());
        if (paramArrayOfString.overrideId != AccessibilityBridge.Action.TAP.value) {
          break label625;
        }
        this.onTapOverride = paramArrayOfString;
      }
      for (;;)
      {
        this.customAccessibilityActions.add(paramArrayOfString);
        i += 1;
        break label559;
        this.customAccessibilityActions.clear();
        break;
        label625:
        if (paramArrayOfString.overrideId == AccessibilityBridge.Action.LONG_PRESS.value) {
          this.onLongPressOverride = paramArrayOfString;
        } else {
          this.customAccessibilityActions.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge
 * JD-Core Version:    0.7.0.1
 */