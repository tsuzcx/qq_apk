package io.flutter.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AccessibilityViewEmbedder$a
{
  private final Method Ngo;
  private final Method Ngp;
  private final Method Ngq;
  private final Method Ngr;
  private final Field Ngs;
  private final Method Ngt;
  
  @SuppressLint({"PrivateApi"})
  private AccessibilityViewEmbedder$a()
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
            this.Ngo = localMethod4;
            this.Ngp = localMethod3;
            this.Ngq = localMethod5;
            this.Ngr = localMethod2;
            this.Ngs = localField;
            this.Ngt = localObject1;
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
  
  private static boolean aq(long paramLong, int paramInt)
  {
    return (1L << paramInt & paramLong) != 0L;
  }
  
  final Long a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
  {
    AppMethodBeat.i(9794);
    if ((this.Ngr == null) && ((this.Ngs == null) || (this.Ngt == null)))
    {
      AppMethodBeat.o(9794);
      return null;
    }
    if (this.Ngr != null) {}
    for (;;)
    {
      try
      {
        paramAccessibilityNodeInfo = (Long)this.Ngr.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
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
        l = ((Long)this.Ngt.invoke(this.Ngs.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
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
  
  final Long a(AccessibilityRecord paramAccessibilityRecord)
  {
    AppMethodBeat.i(9796);
    if (this.Ngq == null)
    {
      AppMethodBeat.o(9796);
      return null;
    }
    try
    {
      paramAccessibilityRecord = (Long)this.Ngq.invoke(paramAccessibilityRecord, new Object[0]);
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
    if (this.Ngo == null)
    {
      AppMethodBeat.o(9793);
      return null;
    }
    try
    {
      paramAccessibilityNodeInfo = (Long)this.Ngo.invoke(paramAccessibilityNodeInfo, new Object[0]);
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
    if (this.Ngp != null) {}
    try
    {
      l = ((Long)this.Ngp.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
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
      if (aq(l, 0)) {
        localParcel.readInt();
      }
      if (aq(l, 1)) {
        localParcel.readLong();
      }
      if (aq(l, 2)) {
        localParcel.readInt();
      }
      if (aq(l, 3))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.a
 * JD-Core Version:    0.7.0.1
 */