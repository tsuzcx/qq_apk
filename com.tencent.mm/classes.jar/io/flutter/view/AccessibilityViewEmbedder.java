package io.flutter.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

class AccessibilityViewEmbedder
{
  private static final String TAG = "AccessibilityBridge";
  private final Map<View, Rect> embeddedViewToDisplayBounds;
  private final SparseArray<ViewAndId> flutterIdToOrigin;
  private int nextFlutterId;
  private final Map<ViewAndId, Integer> originToFlutterId;
  private final AccessibilityViewEmbedder.ReflectionAccessors reflectionAccessors;
  private final View rootAccessibilityView;
  
  AccessibilityViewEmbedder(View paramView, int paramInt)
  {
    AppMethodBeat.i(190662);
    this.reflectionAccessors = new AccessibilityViewEmbedder.ReflectionAccessors(null);
    this.flutterIdToOrigin = new SparseArray();
    this.rootAccessibilityView = paramView;
    this.nextFlutterId = paramInt;
    this.originToFlutterId = new HashMap();
    this.embeddedViewToDisplayBounds = new HashMap();
    AppMethodBeat.o(190662);
  }
  
  private void addChildrenToFlutterNode(AccessibilityNodeInfo paramAccessibilityNodeInfo1, View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9787);
    int i = 0;
    if (i < paramAccessibilityNodeInfo1.getChildCount())
    {
      Object localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$500(this.reflectionAccessors, paramAccessibilityNodeInfo1, i);
      int k;
      int j;
      if (localObject != null)
      {
        k = AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue());
        localObject = new ViewAndId(paramView, k, null);
        if (!this.originToFlutterId.containsKey(localObject)) {
          break label110;
        }
        j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
      }
      for (;;)
      {
        paramAccessibilityNodeInfo2.addChild(this.rootAccessibilityView, j);
        i += 1;
        break;
        label110:
        j = this.nextFlutterId;
        this.nextFlutterId = (j + 1);
        cacheVirtualIdMappings(paramView, k, j);
      }
    }
    AppMethodBeat.o(9787);
  }
  
  private void cacheVirtualIdMappings(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9788);
    paramView = new ViewAndId(paramView, paramInt1, null);
    this.originToFlutterId.put(paramView, Integer.valueOf(paramInt2));
    this.flutterIdToOrigin.put(paramInt2, paramView);
    AppMethodBeat.o(9788);
  }
  
  private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, View paramView)
  {
    AppMethodBeat.i(9785);
    AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityNodeInfo.setSource(this.rootAccessibilityView, paramInt);
    localAccessibilityNodeInfo.setClassName(paramAccessibilityNodeInfo.getClassName());
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(paramView);
    copyAccessibilityFields(paramAccessibilityNodeInfo, localAccessibilityNodeInfo);
    setFlutterNodesTranslateBounds(paramAccessibilityNodeInfo, localRect, localAccessibilityNodeInfo);
    addChildrenToFlutterNode(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    setFlutterNodeParent(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    AppMethodBeat.o(9785);
    return localAccessibilityNodeInfo;
  }
  
  private void copyAccessibilityFields(AccessibilityNodeInfo paramAccessibilityNodeInfo1, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9790);
    paramAccessibilityNodeInfo2.setAccessibilityFocused(paramAccessibilityNodeInfo1.isAccessibilityFocused());
    paramAccessibilityNodeInfo2.setCheckable(paramAccessibilityNodeInfo1.isCheckable());
    paramAccessibilityNodeInfo2.setChecked(paramAccessibilityNodeInfo1.isChecked());
    paramAccessibilityNodeInfo2.setContentDescription(paramAccessibilityNodeInfo1.getContentDescription());
    paramAccessibilityNodeInfo2.setEnabled(paramAccessibilityNodeInfo1.isEnabled());
    paramAccessibilityNodeInfo2.setClickable(paramAccessibilityNodeInfo1.isClickable());
    paramAccessibilityNodeInfo2.setFocusable(paramAccessibilityNodeInfo1.isFocusable());
    paramAccessibilityNodeInfo2.setFocused(paramAccessibilityNodeInfo1.isFocused());
    paramAccessibilityNodeInfo2.setLongClickable(paramAccessibilityNodeInfo1.isLongClickable());
    paramAccessibilityNodeInfo2.setMovementGranularities(paramAccessibilityNodeInfo1.getMovementGranularities());
    paramAccessibilityNodeInfo2.setPassword(paramAccessibilityNodeInfo1.isPassword());
    paramAccessibilityNodeInfo2.setScrollable(paramAccessibilityNodeInfo1.isScrollable());
    paramAccessibilityNodeInfo2.setSelected(paramAccessibilityNodeInfo1.isSelected());
    paramAccessibilityNodeInfo2.setText(paramAccessibilityNodeInfo1.getText());
    paramAccessibilityNodeInfo2.setVisibleToUser(paramAccessibilityNodeInfo1.isVisibleToUser());
    if (Build.VERSION.SDK_INT >= 18) {
      paramAccessibilityNodeInfo2.setEditable(paramAccessibilityNodeInfo1.isEditable());
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAccessibilityNodeInfo2.setCanOpenPopup(paramAccessibilityNodeInfo1.canOpenPopup());
      paramAccessibilityNodeInfo2.setCollectionInfo(paramAccessibilityNodeInfo1.getCollectionInfo());
      paramAccessibilityNodeInfo2.setCollectionItemInfo(paramAccessibilityNodeInfo1.getCollectionItemInfo());
      paramAccessibilityNodeInfo2.setContentInvalid(paramAccessibilityNodeInfo1.isContentInvalid());
      paramAccessibilityNodeInfo2.setDismissable(paramAccessibilityNodeInfo1.isDismissable());
      paramAccessibilityNodeInfo2.setInputType(paramAccessibilityNodeInfo1.getInputType());
      paramAccessibilityNodeInfo2.setLiveRegion(paramAccessibilityNodeInfo1.getLiveRegion());
      paramAccessibilityNodeInfo2.setMultiLine(paramAccessibilityNodeInfo1.isMultiLine());
      paramAccessibilityNodeInfo2.setRangeInfo(paramAccessibilityNodeInfo1.getRangeInfo());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramAccessibilityNodeInfo2.setError(paramAccessibilityNodeInfo1.getError());
      paramAccessibilityNodeInfo2.setMaxTextLength(paramAccessibilityNodeInfo1.getMaxTextLength());
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramAccessibilityNodeInfo2.setContextClickable(paramAccessibilityNodeInfo1.isContextClickable());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramAccessibilityNodeInfo2.setDrawingOrder(paramAccessibilityNodeInfo1.getDrawingOrder());
      paramAccessibilityNodeInfo2.setImportantForAccessibility(paramAccessibilityNodeInfo1.isImportantForAccessibility());
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramAccessibilityNodeInfo2.setAvailableExtraData(paramAccessibilityNodeInfo1.getAvailableExtraData());
      paramAccessibilityNodeInfo2.setHintText(paramAccessibilityNodeInfo1.getHintText());
      paramAccessibilityNodeInfo2.setShowingHintText(paramAccessibilityNodeInfo1.isShowingHintText());
    }
    AppMethodBeat.o(9790);
  }
  
  private void setFlutterNodeParent(AccessibilityNodeInfo paramAccessibilityNodeInfo1, View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9786);
    paramAccessibilityNodeInfo1 = AccessibilityViewEmbedder.ReflectionAccessors.access$300(this.reflectionAccessors, paramAccessibilityNodeInfo1);
    if (paramAccessibilityNodeInfo1 == null)
    {
      AppMethodBeat.o(9786);
      return;
    }
    int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(paramAccessibilityNodeInfo1.longValue());
    paramAccessibilityNodeInfo1 = (Integer)this.originToFlutterId.get(new ViewAndId(paramView, i, null));
    if (paramAccessibilityNodeInfo1 != null) {
      paramAccessibilityNodeInfo2.setParent(this.rootAccessibilityView, paramAccessibilityNodeInfo1.intValue());
    }
    AppMethodBeat.o(9786);
  }
  
  private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo paramAccessibilityNodeInfo1, Rect paramRect, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9789);
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInParent(localRect);
    paramAccessibilityNodeInfo2.setBoundsInParent(localRect);
    localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInScreen(localRect);
    localRect.offset(paramRect.left, paramRect.top);
    paramAccessibilityNodeInfo2.setBoundsInScreen(localRect);
    AppMethodBeat.o(9789);
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    AppMethodBeat.i(190706);
    Object localObject = (ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(190706);
      return null;
    }
    if (!this.embeddedViewToDisplayBounds.containsKey(((ViewAndId)localObject).view))
    {
      AppMethodBeat.o(190706);
      return null;
    }
    if (((ViewAndId)localObject).view.getAccessibilityNodeProvider() == null)
    {
      AppMethodBeat.o(190706);
      return null;
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo = ((ViewAndId)localObject).view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(((ViewAndId)localObject).id);
    if (localAccessibilityNodeInfo == null)
    {
      AppMethodBeat.o(190706);
      return null;
    }
    localObject = convertToFlutterNode(localAccessibilityNodeInfo, paramInt, ((ViewAndId)localObject).view);
    AppMethodBeat.o(190706);
    return localObject;
  }
  
  public Integer getRecordFlutterId(View paramView, AccessibilityRecord paramAccessibilityRecord)
  {
    AppMethodBeat.i(190718);
    paramAccessibilityRecord = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityRecord);
    if (paramAccessibilityRecord == null)
    {
      AppMethodBeat.o(190718);
      return null;
    }
    int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(paramAccessibilityRecord.longValue());
    paramView = (Integer)this.originToFlutterId.get(new ViewAndId(paramView, i, null));
    AppMethodBeat.o(190718);
    return paramView;
  }
  
  public AccessibilityNodeInfo getRootNode(View paramView, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(190701);
    AccessibilityNodeInfo localAccessibilityNodeInfo = paramView.createAccessibilityNodeInfo();
    Long localLong = AccessibilityViewEmbedder.ReflectionAccessors.access$100(this.reflectionAccessors, localAccessibilityNodeInfo);
    if (localLong == null)
    {
      AppMethodBeat.o(190701);
      return null;
    }
    this.embeddedViewToDisplayBounds.put(paramView, paramRect);
    cacheVirtualIdMappings(paramView, AccessibilityViewEmbedder.ReflectionAccessors.access$200(localLong.longValue()), paramInt);
    paramView = convertToFlutterNode(localAccessibilityNodeInfo, paramInt, paramView);
    AppMethodBeat.o(190701);
    return paramView;
  }
  
  public boolean onAccessibilityHoverEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9791);
    ViewAndId localViewAndId = (ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localViewAndId == null)
    {
      AppMethodBeat.o(9791);
      return false;
    }
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(localViewAndId.view);
    paramInt = paramMotionEvent.getPointerCount();
    MotionEvent.PointerProperties[] arrayOfPointerProperties = new MotionEvent.PointerProperties[paramInt];
    MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[paramInt];
    paramInt = 0;
    while (paramInt < paramMotionEvent.getPointerCount())
    {
      arrayOfPointerProperties[paramInt] = new MotionEvent.PointerProperties();
      paramMotionEvent.getPointerProperties(paramInt, arrayOfPointerProperties[paramInt]);
      MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
      paramMotionEvent.getPointerCoords(paramInt, localPointerCoords);
      arrayOfPointerCoords[paramInt] = new MotionEvent.PointerCoords(localPointerCoords);
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.x -= localRect.left;
      localPointerCoords = arrayOfPointerCoords[paramInt];
      localPointerCoords.y -= localRect.top;
      paramInt += 1;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), paramMotionEvent.getPointerCount(), arrayOfPointerProperties, arrayOfPointerCoords, paramMotionEvent.getMetaState(), paramMotionEvent.getButtonState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
    boolean bool = localViewAndId.view.dispatchGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(9791);
    return bool;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(190715);
    ViewAndId localViewAndId = (ViewAndId)this.flutterIdToOrigin.get(paramInt1);
    if (localViewAndId == null)
    {
      AppMethodBeat.o(190715);
      return false;
    }
    AccessibilityNodeProvider localAccessibilityNodeProvider = localViewAndId.view.getAccessibilityNodeProvider();
    if (localAccessibilityNodeProvider == null)
    {
      AppMethodBeat.o(190715);
      return false;
    }
    boolean bool = localAccessibilityNodeProvider.performAction(localViewAndId.id, paramInt2, paramBundle);
    AppMethodBeat.o(190715);
    return bool;
  }
  
  public View platformViewOfNode(int paramInt)
  {
    AppMethodBeat.i(190726);
    Object localObject = (ViewAndId)this.flutterIdToOrigin.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(190726);
      return null;
    }
    localObject = ((ViewAndId)localObject).view;
    AppMethodBeat.o(190726);
    return localObject;
  }
  
  public boolean requestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(190712);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramAccessibilityEvent);
    Object localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityEvent);
    if (localObject == null)
    {
      AppMethodBeat.o(190712);
      return false;
    }
    int i = AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue());
    Integer localInteger = (Integer)this.originToFlutterId.get(new ViewAndId(paramView1, i, null));
    localObject = localInteger;
    int j;
    if (localInteger == null)
    {
      j = this.nextFlutterId;
      this.nextFlutterId = (j + 1);
      localObject = Integer.valueOf(j);
      cacheVirtualIdMappings(paramView1, i, ((Integer)localObject).intValue());
    }
    localAccessibilityEvent.setSource(this.rootAccessibilityView, ((Integer)localObject).intValue());
    localAccessibilityEvent.setClassName(paramAccessibilityEvent.getClassName());
    localAccessibilityEvent.setPackageName(paramAccessibilityEvent.getPackageName());
    i = 0;
    while (i < localAccessibilityEvent.getRecordCount())
    {
      paramAccessibilityEvent = localAccessibilityEvent.getRecord(i);
      localObject = AccessibilityViewEmbedder.ReflectionAccessors.access$600(this.reflectionAccessors, paramAccessibilityEvent);
      if (localObject == null)
      {
        AppMethodBeat.o(190712);
        return false;
      }
      localObject = new ViewAndId(paramView1, AccessibilityViewEmbedder.ReflectionAccessors.access$200(((Long)localObject).longValue()), null);
      if (!this.originToFlutterId.containsKey(localObject))
      {
        AppMethodBeat.o(190712);
        return false;
      }
      j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
      paramAccessibilityEvent.setSource(this.rootAccessibilityView, j);
      i += 1;
    }
    boolean bool = this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(paramView2, localAccessibilityEvent);
    AppMethodBeat.o(190712);
    return bool;
  }
  
  static class ViewAndId
  {
    final int id;
    final View view;
    
    private ViewAndId(View paramView, int paramInt)
    {
      this.view = paramView;
      this.id = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(9826);
      if (this == paramObject)
      {
        AppMethodBeat.o(9826);
        return true;
      }
      if (!(paramObject instanceof ViewAndId))
      {
        AppMethodBeat.o(9826);
        return false;
      }
      paramObject = (ViewAndId)paramObject;
      if ((this.id == paramObject.id) && (this.view.equals(paramObject.view)))
      {
        AppMethodBeat.o(9826);
        return true;
      }
      AppMethodBeat.o(9826);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(9827);
      int i = this.view.hashCode();
      int j = this.id;
      AppMethodBeat.o(9827);
      return (i + 31) * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder
 * JD-Core Version:    0.7.0.1
 */