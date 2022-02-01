package io.flutter.view;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AccessibilityViewEmbedder$ReflectionAccessors
{
  private final Field childNodeIdsField;
  private final Method getChildId;
  private final Method getParentNodeId;
  private final Method getRecordSourceNodeId;
  private final Method getSourceNodeId;
  private final Method longArrayGetIndex;
  
  private AccessibilityViewEmbedder$ReflectionAccessors()
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
              Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
              localMethod1 = null;
              localField = null;
              localMethod2 = null;
              continue;
            }
            this.getSourceNodeId = localMethod4;
            this.getParentNodeId = localMethod3;
            this.getRecordSourceNodeId = localMethod5;
            this.getChildId = localMethod2;
            this.childNodeIdsField = localField;
            this.longArrayGetIndex = localObject1;
            AppMethodBeat.o(9792);
            return;
            localNoSuchMethodException1 = localNoSuchMethodException1;
            Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
            Method localMethod4 = null;
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
            Method localMethod5 = null;
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
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
        Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
        Object localObject2 = null;
        localField = null;
        localMethod2 = null;
        localMethod3 = null;
      }
      catch (NullPointerException localNullPointerException)
      {
        break label221;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label221;
      }
      catch (NoSuchMethodException localNoSuchMethodException5)
      {
        label221:
        break label221;
      }
    }
  }
  
  private Long getChildId(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
  {
    AppMethodBeat.i(9794);
    if ((this.getChildId == null) && ((this.childNodeIdsField == null) || (this.longArrayGetIndex == null)))
    {
      AppMethodBeat.o(9794);
      return null;
    }
    if (this.getChildId != null) {}
    for (;;)
    {
      try
      {
        paramAccessibilityNodeInfo = (Long)this.getChildId.invoke(paramAccessibilityNodeInfo, new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(9794);
        return paramAccessibilityNodeInfo;
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", "Failed to access getChildId method.", paramAccessibilityNodeInfo);
        AppMethodBeat.o(9794);
        return null;
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", "The getChildId method threw an exception when invoked.", paramAccessibilityNodeInfo);
        continue;
      }
      try
      {
        long l = ((Long)this.longArrayGetIndex.invoke(this.childNodeIdsField.get(paramAccessibilityNodeInfo), new Object[] { Integer.valueOf(paramInt) })).longValue();
        AppMethodBeat.o(9794);
        return Long.valueOf(l);
      }
      catch (IllegalAccessException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", "Failed to access longArrayGetIndex method or the childNodeId field.", paramAccessibilityNodeInfo);
      }
      catch (ArrayIndexOutOfBoundsException paramAccessibilityNodeInfo)
      {
        Log.w("AccessibilityBridge", "The longArrayGetIndex method threw an exception when invoked.", paramAccessibilityNodeInfo);
      }
      catch (InvocationTargetException paramAccessibilityNodeInfo)
      {
        label159:
        break label159;
      }
    }
  }
  
  private Long getParentNodeId(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(9795);
    if (this.getParentNodeId != null) {}
    try
    {
      long l = ((Long)this.getParentNodeId.invoke(paramAccessibilityNodeInfo, new Object[0])).longValue();
      AppMethodBeat.o(9795);
      return Long.valueOf(l);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("AccessibilityBridge", "Failed to access getParentNodeId method.", localIllegalAccessException);
      paramAccessibilityNodeInfo = yoinkParentIdFromParcel(paramAccessibilityNodeInfo);
      AppMethodBeat.o(9795);
      return paramAccessibilityNodeInfo;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", "The getParentNodeId method threw an exception when invoked.", localInvocationTargetException);
      }
    }
  }
  
  private Long getRecordSourceNodeId(AccessibilityRecord paramAccessibilityRecord)
  {
    AppMethodBeat.i(9796);
    if (this.getRecordSourceNodeId == null)
    {
      AppMethodBeat.o(9796);
      return null;
    }
    try
    {
      paramAccessibilityRecord = (Long)this.getRecordSourceNodeId.invoke(paramAccessibilityRecord, new Object[0]);
      AppMethodBeat.o(9796);
      return paramAccessibilityRecord;
    }
    catch (IllegalAccessException paramAccessibilityRecord)
    {
      Log.w("AccessibilityBridge", "Failed to access the getRecordSourceNodeId method.", paramAccessibilityRecord);
      AppMethodBeat.o(9796);
      return null;
    }
    catch (InvocationTargetException paramAccessibilityRecord)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", "The getRecordSourceNodeId method threw an exception when invoked.", paramAccessibilityRecord);
      }
    }
  }
  
  private Long getSourceNodeId(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(9793);
    if (this.getSourceNodeId == null)
    {
      AppMethodBeat.o(9793);
      return null;
    }
    try
    {
      paramAccessibilityNodeInfo = (Long)this.getSourceNodeId.invoke(paramAccessibilityNodeInfo, new Object[0]);
      AppMethodBeat.o(9793);
      return paramAccessibilityNodeInfo;
    }
    catch (IllegalAccessException paramAccessibilityNodeInfo)
    {
      Log.w("AccessibilityBridge", "Failed to access getSourceNodeId method.", paramAccessibilityNodeInfo);
      AppMethodBeat.o(9793);
      return null;
    }
    catch (InvocationTargetException paramAccessibilityNodeInfo)
    {
      for (;;)
      {
        Log.w("AccessibilityBridge", "The getSourceNodeId method threw an exception when invoked.", paramAccessibilityNodeInfo);
      }
    }
  }
  
  private static int getVirtualNodeId(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private static boolean isBitSet(long paramLong, int paramInt)
  {
    return (1L << paramInt & paramLong) != 0L;
  }
  
  private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(190626);
    if (Build.VERSION.SDK_INT < 26)
    {
      Log.w("AccessibilityBridge", "Unexpected Android version. Unable to find the parent ID.");
      AppMethodBeat.o(190626);
      return null;
    }
    paramAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramAccessibilityNodeInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    long l = localParcel.readLong();
    if (isBitSet(l, 0)) {
      localParcel.readInt();
    }
    if (isBitSet(l, 1)) {
      localParcel.readLong();
    }
    if (isBitSet(l, 2)) {
      localParcel.readInt();
    }
    paramAccessibilityNodeInfo = localObject;
    if (isBitSet(l, 3)) {
      paramAccessibilityNodeInfo = Long.valueOf(localParcel.readLong());
    }
    localParcel.recycle();
    AppMethodBeat.o(190626);
    return paramAccessibilityNodeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.ReflectionAccessors
 * JD-Core Version:    0.7.0.1
 */