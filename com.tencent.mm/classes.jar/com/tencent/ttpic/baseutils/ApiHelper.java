package com.tencent.ttpic.baseutils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import java.lang.reflect.Field;

public class ApiHelper
{
  public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
  public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
  public static final boolean HAS_CAMERA_FOCUS_AREA;
  public static final boolean HAS_CAMERA_HDR;
  public static final boolean HAS_CAMERA_HDR_PLUS;
  public static final boolean HAS_CAMERA_METERING_AREA;
  public static final boolean HAS_DISPLAY_LISTENER;
  public static final boolean HAS_FACE_DETECTION;
  public static final boolean HAS_GET_CAMERA_DISABLED;
  public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT;
  
  static
  {
    boolean bool2 = false;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label223;
      }
      bool1 = true;
      label26:
      HAS_AUTO_FOCUS_MOVE_CALLBACK = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label228;
      }
      bool1 = true;
      label40:
      HAS_CAMERA_FOCUS_AREA = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label233;
      }
      bool1 = true;
      label54:
      HAS_CAMERA_METERING_AREA = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label238;
      }
      bool1 = true;
      label68:
      HAS_CAMERA_HDR = bool1;
      if (Build.VERSION.SDK_INT < 19) {
        break label243;
      }
      bool1 = true;
      label82:
      HAS_CAMERA_HDR_PLUS = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label248;
      }
      bool1 = true;
      label96:
      HAS_DISPLAY_LISTENER = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label253;
      }
      bool1 = true;
      label110:
      CAN_START_PREVIEW_IN_JPEG_CALLBACK = bool1;
    }
    for (;;)
    {
      try
      {
        if ((!hasMethod(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!hasMethod(Camera.class, "startFaceDetection", new Class[0])) || (!hasMethod(Camera.class, "stopFaceDetection", new Class[0]))) {
          continue;
        }
        bool1 = hasMethod(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        label223:
        label228:
        label233:
        label238:
        label243:
        label248:
        label253:
        bool1 = false;
        continue;
      }
      HAS_FACE_DETECTION = bool1;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 14) {
        bool1 = hasMethod(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      }
      HAS_GET_CAMERA_DISABLED = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
      bool1 = false;
      break label40;
      bool1 = false;
      break label54;
      bool1 = false;
      break label68;
      bool1 = false;
      break label82;
      bool1 = false;
      break label96;
      bool1 = false;
      break label110;
      bool1 = false;
    }
  }
  
  public static int getIntFieldIfExists(Class<?> paramClass1, String paramString, Class<?> paramClass2, int paramInt)
  {
    try
    {
      int i = paramClass1.getDeclaredField(paramString).getInt(paramClass2);
      return i;
    }
    catch (Exception paramClass1) {}
    return paramInt;
  }
  
  private static boolean hasField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  public static boolean hasGingerbread()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasHoneycombMR1()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean hasIceCreamSandwich()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean hasJellyBean()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean hasJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean hasJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean hasKitkat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean hasLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private static boolean hasMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  private static boolean hasMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static boolean hasNougat()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isAndroid_8_1()
  {
    return Build.VERSION.SDK_INT == 27;
  }
  
  public static boolean isExactlyKitkat()
  {
    return Build.VERSION.SDK_INT == 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.ApiHelper
 * JD-Core Version:    0.7.0.1
 */