package io.flutter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public final View JcJ;
  public final a JeL;
  final SparseArray<b.b> JeM;
  public final Map<b.b, Integer> JeN;
  final Map<View, Rect> JeO;
  public int JeP;
  
  b(View paramView)
  {
    AppMethodBeat.i(9784);
    this.JeL = new a((byte)0);
    this.JeM = new SparseArray();
    this.JcJ = paramView;
    this.JeP = 65536;
    this.JeN = new HashMap();
    this.JeO = new HashMap();
    AppMethodBeat.o(9784);
  }
  
  private static void a(AccessibilityNodeInfo paramAccessibilityNodeInfo1, Rect paramRect, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9789);
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo1.getBoundsInScreen(localRect);
    localRect.offset(paramRect.left, paramRect.top);
    paramAccessibilityNodeInfo2.setBoundsInScreen(localRect);
    AppMethodBeat.o(9789);
  }
  
  private void a(AccessibilityNodeInfo paramAccessibilityNodeInfo1, View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9786);
    paramAccessibilityNodeInfo1 = this.JeL.c(paramAccessibilityNodeInfo1);
    if (paramAccessibilityNodeInfo1 == null)
    {
      AppMethodBeat.o(9786);
      return;
    }
    int i = (int)(paramAccessibilityNodeInfo1.longValue() >> 32);
    paramAccessibilityNodeInfo1 = (Integer)this.JeN.get(new b.b(paramView, i, (byte)0));
    if (paramAccessibilityNodeInfo1 != null) {
      paramAccessibilityNodeInfo2.setParent(this.JcJ, paramAccessibilityNodeInfo1.intValue());
    }
    AppMethodBeat.o(9786);
  }
  
  private static void a(AccessibilityNodeInfo paramAccessibilityNodeInfo1, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
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
  
  private void b(AccessibilityNodeInfo paramAccessibilityNodeInfo1, View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(9787);
    int i = 0;
    if (i < paramAccessibilityNodeInfo1.getChildCount())
    {
      Object localObject = this.JeL.a(paramAccessibilityNodeInfo1, i);
      int k;
      int j;
      if (localObject != null)
      {
        k = (int)(((Long)localObject).longValue() >> 32);
        localObject = new b.b(paramView, k, (byte)0);
        if (!this.JeN.containsKey(localObject)) {
          break label111;
        }
        j = ((Integer)this.JeN.get(localObject)).intValue();
      }
      for (;;)
      {
        paramAccessibilityNodeInfo2.addChild(this.JcJ, j);
        i += 1;
        break;
        label111:
        j = this.JeP;
        this.JeP = (j + 1);
        B(paramView, k, j);
      }
    }
    AppMethodBeat.o(9787);
  }
  
  public final void B(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9788);
    paramView = new b.b(paramView, paramInt1, (byte)0);
    this.JeN.put(paramView, Integer.valueOf(paramInt2));
    this.JeM.put(paramInt2, paramView);
    AppMethodBeat.o(9788);
  }
  
  final AccessibilityNodeInfo a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, View paramView)
  {
    AppMethodBeat.i(9785);
    AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.JcJ, paramInt);
    localAccessibilityNodeInfo.setPackageName(this.JcJ.getContext().getPackageName());
    localAccessibilityNodeInfo.setSource(this.JcJ, paramInt);
    localAccessibilityNodeInfo.setClassName(paramAccessibilityNodeInfo.getClassName());
    Rect localRect = (Rect)this.JeO.get(paramView);
    a(paramAccessibilityNodeInfo, localAccessibilityNodeInfo);
    a(paramAccessibilityNodeInfo, localRect, localAccessibilityNodeInfo);
    b(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    a(paramAccessibilityNodeInfo, paramView, localAccessibilityNodeInfo);
    AppMethodBeat.o(9785);
    return localAccessibilityNodeInfo;
  }
  
  public final boolean b(int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9791);
    b.b localb = (b.b)this.JeM.get(paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(9791);
      return false;
    }
    Rect localRect = (Rect)this.JeO.get(localb.view);
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
  
  public static final class a
  {
    private final Method JeQ;
    private final Method JeR;
    private final Method JeS;
    private final Method JeT;
    private final Field JeU;
    private final Method JeV;
    
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
                localMethod1 = null;
                localField = null;
                localMethod2 = null;
                continue;
              }
              this.JeQ = localMethod4;
              this.JeR = localMethod3;
              this.JeS = localMethod5;
              this.JeT = localMethod2;
              this.JeU = localField;
              this.JeV = localObject1;
              AppMethodBeat.o(9792);
              return;
              localNoSuchMethodException1 = localNoSuchMethodException1;
              Method localMethod4 = null;
              continue;
              localNoSuchMethodException2 = localNoSuchMethodException2;
              Method localMethod5 = null;
            }
            catch (NoSuchMethodException localNoSuchMethodException3)
            {
              localMethod3 = null;
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
          Object localObject2 = null;
          localField = null;
          localMethod2 = null;
          localMethod3 = null;
        }
        catch (NullPointerException localNullPointerException)
        {
          break label193;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label193;
        }
        catch (NoSuchMethodException localNoSuchMethodException5)
        {
          label193:
          break label193;
        }
      }
    }
    
    private static boolean ah(long paramLong, int paramInt)
    {
      return (1L << paramInt & paramLong) != 0L;
    }
    
    final Long a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
    {
      AppMethodBeat.i(9794);
      if ((this.JeT == null) && ((this.JeU == null) || (this.JeV == null)))
      {
        AppMethodBeat.o(9794);
        return null;
      }
      if (this.JeT != null) {}
      for (;;)
      {
        try
        {
          paramAccessibilityNodeInfo = (Long)this.JeT.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(9794);
          return paramAccessibilityNodeInfo;
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo)
        {
          long l;
          continue;
        }
        catch (IllegalAccessException paramAccessibilityNodeInfo)
        {
          continue;
        }
        try
        {
          l = ((Long)this.JeV.invoke(this.JeU.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
          AppMethodBeat.o(9794);
          return Long.valueOf(l);
        }
        catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo)
        {
          AppMethodBeat.o(9794);
          return null;
        }
        catch (InvocationTargetException paramAccessibilityNodeInfo) {}catch (IllegalAccessException paramAccessibilityNodeInfo) {}
      }
    }
    
    public final Long a(AccessibilityRecord paramAccessibilityRecord)
    {
      AppMethodBeat.i(9796);
      if (this.JeS == null)
      {
        AppMethodBeat.o(9796);
        return null;
      }
      try
      {
        paramAccessibilityRecord = (Long)this.JeS.invoke(paramAccessibilityRecord, new Object[0]);
        AppMethodBeat.o(9796);
        return paramAccessibilityRecord;
      }
      catch (InvocationTargetException paramAccessibilityRecord)
      {
        AppMethodBeat.o(9796);
        return null;
      }
      catch (IllegalAccessException paramAccessibilityRecord)
      {
        label46:
        break label46;
      }
    }
    
    final Long b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(9793);
      if (this.JeQ == null)
      {
        AppMethodBeat.o(9793);
        return null;
      }
      try
      {
        paramAccessibilityNodeInfo = (Long)this.JeQ.invoke(paramAccessibilityNodeInfo, new Object[0]);
        AppMethodBeat.o(9793);
        return paramAccessibilityNodeInfo;
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        AppMethodBeat.o(9793);
        return null;
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        label46:
        break label46;
      }
    }
    
    final Long c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      AppMethodBeat.i(9795);
      if (this.JeR != null) {}
      try
      {
        l = ((Long)this.JeR.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
        AppMethodBeat.o(9795);
        return Long.valueOf(l);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        if (Build.VERSION.SDK_INT < 26)
        {
          AppMethodBeat.o(9795);
          return null;
        }
        paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
        Parcel localParcel = Parcel.obtain();
        localParcel.setDataPosition(0);
        paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        long l = localParcel.readLong();
        if (ah(l, 0)) {
          localParcel.readInt();
        }
        if (ah(l, 1)) {
          localParcel.readLong();
        }
        if (ah(l, 2)) {
          localParcel.readInt();
        }
        if (ah(l, 3))
        {
          paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());
          localParcel.recycle();
          AppMethodBeat.o(9795);
          return paramAccessibilityNodeInfo;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          continue;
          paramAccessibilityNodeInfo = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.view.b
 * JD-Core Version:    0.7.0.1
 */