package io.flutter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
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
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Keep
public class AccessibilityViewEmbedder
{
  private static final String TAG = "AccessibilityBridge";
  private final Map<View, Rect> embeddedViewToDisplayBounds;
  private final SparseArray<AccessibilityViewEmbedder.b> flutterIdToOrigin;
  private int nextFlutterId;
  private final Map<AccessibilityViewEmbedder.b, Integer> originToFlutterId;
  private final a reflectionAccessors;
  private final View rootAccessibilityView;
  
  AccessibilityViewEmbedder(View paramView, int paramInt)
  {
    AppMethodBeat.i(255133);
    this.reflectionAccessors = new a((byte)0);
    this.flutterIdToOrigin = new SparseArray();
    this.rootAccessibilityView = paramView;
    this.nextFlutterId = paramInt;
    this.originToFlutterId = new HashMap();
    this.embeddedViewToDisplayBounds = new HashMap();
    AppMethodBeat.o(255133);
  }
  
  private void addChildrenToFlutterNode(AccessibilityNodeInfo paramAccessibilityNodeInfo1, View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9787);
    int i = 0;
    if (i < paramAccessibilityNodeInfo1.getChildCount())
    {
      Object localObject = a.a(this.reflectionAccessors, paramAccessibilityNodeInfo1, i);
      int k;
      int j;
      if (localObject != null)
      {
        k = a.Xr(((Long)localObject).longValue());
        localObject = new AccessibilityViewEmbedder.b(paramView, k, (byte)0);
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
    paramView = new AccessibilityViewEmbedder.b(paramView, paramInt1, (byte)0);
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
    paramAccessibilityNodeInfo1 = a.b(this.reflectionAccessors, paramAccessibilityNodeInfo1);
    if (paramAccessibilityNodeInfo1 == null)
    {
      AppMethodBeat.o(9786);
      return;
    }
    int i = a.Xr(paramAccessibilityNodeInfo1.longValue());
    paramAccessibilityNodeInfo1 = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.b(paramView, i, (byte)0));
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
    AppMethodBeat.i(255139);
    Object localObject = (AccessibilityViewEmbedder.b)this.flutterIdToOrigin.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(255139);
      return null;
    }
    if (!this.embeddedViewToDisplayBounds.containsKey(((AccessibilityViewEmbedder.b)localObject).view))
    {
      AppMethodBeat.o(255139);
      return null;
    }
    if (((AccessibilityViewEmbedder.b)localObject).view.getAccessibilityNodeProvider() == null)
    {
      AppMethodBeat.o(255139);
      return null;
    }
    AccessibilityNodeInfo localAccessibilityNodeInfo = ((AccessibilityViewEmbedder.b)localObject).view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(((AccessibilityViewEmbedder.b)localObject).id);
    if (localAccessibilityNodeInfo == null)
    {
      AppMethodBeat.o(255139);
      return null;
    }
    localObject = convertToFlutterNode(localAccessibilityNodeInfo, paramInt, ((AccessibilityViewEmbedder.b)localObject).view);
    AppMethodBeat.o(255139);
    return localObject;
  }
  
  public Integer getRecordFlutterId(View paramView, AccessibilityRecord paramAccessibilityRecord)
  {
    AppMethodBeat.i(255159);
    paramAccessibilityRecord = a.a(this.reflectionAccessors, paramAccessibilityRecord);
    if (paramAccessibilityRecord == null)
    {
      AppMethodBeat.o(255159);
      return null;
    }
    int i = a.Xr(paramAccessibilityRecord.longValue());
    paramView = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.b(paramView, i, (byte)0));
    AppMethodBeat.o(255159);
    return paramView;
  }
  
  public AccessibilityNodeInfo getRootNode(View paramView, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(255135);
    AccessibilityNodeInfo localAccessibilityNodeInfo = paramView.createAccessibilityNodeInfo();
    Long localLong = a.a(this.reflectionAccessors, localAccessibilityNodeInfo);
    if (localLong == null)
    {
      AppMethodBeat.o(255135);
      return null;
    }
    this.embeddedViewToDisplayBounds.put(paramView, paramRect);
    cacheVirtualIdMappings(paramView, a.Xr(localLong.longValue()), paramInt);
    paramView = convertToFlutterNode(localAccessibilityNodeInfo, paramInt, paramView);
    AppMethodBeat.o(255135);
    return paramView;
  }
  
  public boolean onAccessibilityHoverEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9791);
    AccessibilityViewEmbedder.b localb = (AccessibilityViewEmbedder.b)this.flutterIdToOrigin.get(paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(9791);
      return false;
    }
    Rect localRect = (Rect)this.embeddedViewToDisplayBounds.get(localb.view);
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
    boolean bool = localb.view.dispatchGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(9791);
    return bool;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(255157);
    AccessibilityViewEmbedder.b localb = (AccessibilityViewEmbedder.b)this.flutterIdToOrigin.get(paramInt1);
    if (localb == null)
    {
      AppMethodBeat.o(255157);
      return false;
    }
    AccessibilityNodeProvider localAccessibilityNodeProvider = localb.view.getAccessibilityNodeProvider();
    if (localAccessibilityNodeProvider == null)
    {
      AppMethodBeat.o(255157);
      return false;
    }
    boolean bool = localAccessibilityNodeProvider.performAction(localb.id, paramInt2, paramBundle);
    AppMethodBeat.o(255157);
    return bool;
  }
  
  public View platformViewOfNode(int paramInt)
  {
    AppMethodBeat.i(255162);
    Object localObject = (AccessibilityViewEmbedder.b)this.flutterIdToOrigin.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(255162);
      return null;
    }
    localObject = ((AccessibilityViewEmbedder.b)localObject).view;
    AppMethodBeat.o(255162);
    return localObject;
  }
  
  public boolean requestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(255155);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramAccessibilityEvent);
    Object localObject = a.a(this.reflectionAccessors, paramAccessibilityEvent);
    if (localObject == null)
    {
      AppMethodBeat.o(255155);
      return false;
    }
    int i = a.Xr(((Long)localObject).longValue());
    Integer localInteger = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.b(paramView1, i, (byte)0));
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
      localObject = a.a(this.reflectionAccessors, paramAccessibilityEvent);
      if (localObject == null)
      {
        AppMethodBeat.o(255155);
        return false;
      }
      localObject = new AccessibilityViewEmbedder.b(paramView1, a.Xr(((Long)localObject).longValue()), (byte)0);
      if (!this.originToFlutterId.containsKey(localObject))
      {
        AppMethodBeat.o(255155);
        return false;
      }
      j = ((Integer)this.originToFlutterId.get(localObject)).intValue();
      paramAccessibilityEvent.setSource(this.rootAccessibilityView, j);
      i += 1;
    }
    boolean bool = this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(paramView2, localAccessibilityEvent);
    AppMethodBeat.o(255155);
    return bool;
  }
  
  static class a
  {
    private final Method aayK;
    private final Method aayL;
    private final Method aayM;
    private final Method aayN;
    private final Field aayO;
    private final Method aayP;
    
    @SuppressLint({"PrivateApi"})
    private a()
    {
      AppMethodBeat.i(9792);
      for (;;)
      {
        Method localMethod3;
        Method localMethod2;
        Field localField;
        try
        {
          localMethod4 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          try
          {
            localMethod5 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            if (Build.VERSION.SDK_INT > 26) {}
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            try
            {
              localMethod3 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
              try
              {
                localMethod2 = AccessibilityNodeInfo.class.getMethod("getChildId", new Class[] { Integer.TYPE });
                localObject1 = null;
                localField = null;
              }
              catch (NoSuchMethodException localNoSuchMethodException4)
              {
                Object localObject1;
                b.iAf();
                localMethod1 = null;
                localField = null;
                localMethod2 = null;
                continue;
              }
              this.aayK = localMethod4;
              this.aayL = localMethod3;
              this.aayM = localMethod5;
              this.aayN = localMethod2;
              this.aayO = localField;
              this.aayP = localObject1;
              AppMethodBeat.o(9792);
              return;
              localNoSuchMethodException1 = localNoSuchMethodException1;
              Method localMethod4 = null;
              b.iAf();
              continue;
              localNoSuchMethodException2 = localNoSuchMethodException2;
              Method localMethod5 = null;
              b.iAf();
            }
            catch (NoSuchMethodException localNoSuchMethodException3)
            {
              localMethod3 = null;
              b.iAf();
              continue;
            }
          }
        }
        try
        {
          localField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
          localField.setAccessible(true);
          Method localMethod1 = Class.forName("android.util.LongArray").getMethod("get", new Class[] { Integer.TYPE });
          localMethod2 = null;
          localMethod3 = null;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          b.iAf();
          Object localObject2 = null;
          localField = null;
          localMethod2 = null;
          localMethod3 = null;
        }
        catch (NullPointerException localNullPointerException)
        {
          break label205;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label205;
        }
        catch (NoSuchMethodException localNoSuchMethodException5)
        {
          label205:
          break label205;
        }
      }
    }
    
    private Long a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
    {
      AppMethodBeat.i(9794);
      if ((this.aayN == null) && ((this.aayO == null) || (this.aayP == null)))
      {
        AppMethodBeat.o(9794);
        return null;
      }
      if (this.aayN != null) {}
      for (;;)
      {
        try
        {
          paramAccessibilityNodeInfo = (Long)this.aayN.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(9794);
          return paramAccessibilityNodeInfo;
        }
        catch (IllegalAccessException paramAccessibilityNodeInfo)
        {
          b.iAg();
          AppMethodBeat.o(9794);
          return null;
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo)
        {
          b.iAg();
          continue;
        }
        try
        {
          long l = ((Long)this.aayP.invoke(this.aayO.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
          AppMethodBeat.o(9794);
          return Long.valueOf(l);
        }
        catch (IllegalAccessException paramAccessibilityNodeInfo)
        {
          b.iAg();
        }
        catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo)
        {
          b.iAg();
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo)
        {
          label144:
          break label144;
        }
      }
    }
    
    private Long a(AccessibilityRecord paramAccessibilityRecord)
    {
      AppMethodBeat.i(9796);
      if (this.aayM == null)
      {
        AppMethodBeat.o(9796);
        return null;
      }
      try
      {
        paramAccessibilityRecord = (Long)this.aayM.invoke(paramAccessibilityRecord, new Object[0]);
        AppMethodBeat.o(9796);
        return paramAccessibilityRecord;
      }
      catch (IllegalAccessException paramAccessibilityRecord)
      {
        b.iAg();
        AppMethodBeat.o(9796);
        return null;
      }
      catch (InvocationTargetException paramAccessibilityRecord)
      {
        for (;;)
        {
          b.iAg();
        }
      }
    }
    
    private static boolean aC(long paramLong, int paramInt)
    {
      return (1L << paramInt & paramLong) != 0L;
    }
    
    private Long b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(9793);
      if (this.aayK == null)
      {
        AppMethodBeat.o(9793);
        return null;
      }
      try
      {
        paramAccessibilityNodeInfo = (Long)this.aayK.invoke(paramAccessibilityNodeInfo, new Object[0]);
        AppMethodBeat.o(9793);
        return paramAccessibilityNodeInfo;
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        b.iAg();
        AppMethodBeat.o(9793);
        return null;
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        for (;;)
        {
          b.iAg();
        }
      }
    }
    
    private Long c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(9795);
      if (this.aayL != null) {}
      Parcel localParcel;
      try
      {
        l = ((Long)this.aayL.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
        AppMethodBeat.o(9795);
        return Long.valueOf(l);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        b.iAg();
        if (Build.VERSION.SDK_INT < 26)
        {
          b.iAf();
          AppMethodBeat.o(9795);
          return null;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          b.iAg();
        }
        paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
        localParcel = Parcel.obtain();
        localParcel.setDataPosition(0);
        paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        long l = localParcel.readLong();
        if (aC(l, 0)) {
          localParcel.readInt();
        }
        if (aC(l, 1)) {
          localParcel.readLong();
        }
        if (aC(l, 2)) {
          localParcel.readInt();
        }
        if (!aC(l, 3)) {}
      }
      for (paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());; paramAccessibilityNodeInfo = null)
      {
        localParcel.recycle();
        AppMethodBeat.o(9795);
        return paramAccessibilityNodeInfo;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder
 * JD-Core Version:    0.7.0.1
 */