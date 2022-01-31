package com.tencent.ttpic.ar.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider;
import com.tencent.ttpic.ar.sensor.orientationProvider.OrientationProvider;
import com.tencent.ttpic.ar.sensor.orientationProvider.SimpleOrientationSensorProvider;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.HashSet;

public class ARMatrixUtil
{
  private static String[] blackList;
  private static HashSet<String> blackSet;
  public static float cameraRightX;
  public static float cameraRightY;
  public static float cameraRightZ;
  public static float cameraUpX;
  public static float cameraUpY;
  public static float cameraUpZ;
  public static float cameraX;
  public static float cameraY;
  public static float cameraZ;
  private static boolean canUseImprovedSensorProvider;
  public static float far;
  public static boolean isFrontCamera;
  private static boolean isInBlackList;
  private static boolean isProjectionMatInitialized;
  private static float[] mMVPMatrix;
  private static float[] mProjectionMatrix;
  private static float[] mViewMatrix;
  public static float near;
  public static float nearRectHeight;
  public static float nearRectWidth;
  public static OrientationProvider orientationProvider;
  private static int renderHeight;
  private static int renderWidth;
  
  static
  {
    AppMethodBeat.i(81763);
    mProjectionMatrix = new float[16];
    mViewMatrix = new float[16];
    mMVPMatrix = new float[16];
    canUseImprovedSensorProvider = true;
    blackSet = new HashSet();
    blackList = new String[] { "XIAOMI_Redmi_Note_2" };
    isInBlackList = false;
    AppMethodBeat.o(81763);
  }
  
  public static float[] calProjectionMatrix(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(81750);
    if (!isProjectionMatInitialized)
    {
      nearRectWidth = 56.25F;
      float f4 = renderHeight * 1.0F / renderWidth;
      float f1 = -nearRectWidth / 2.0F;
      float f2 = nearRectWidth / 2.0F;
      float f3 = -nearRectWidth / 2.0F * f4;
      f4 = nearRectWidth / 2.0F * f4;
      nearRectHeight = f4 - f3;
      near = paramFloat1;
      far = paramFloat2;
      Matrix.frustumM(mProjectionMatrix, 0, f1, f2, f3, f4, near, far);
      isProjectionMatInitialized = true;
    }
    float[] arrayOfFloat = mProjectionMatrix;
    AppMethodBeat.o(81750);
    return arrayOfFloat;
  }
  
  public static float[] calViewMatrix()
  {
    AppMethodBeat.i(81751);
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, 0.0F, cameraX, cameraY, cameraZ, cameraUpX, cameraUpY, cameraUpZ);
    float[] arrayOfFloat = mViewMatrix;
    AppMethodBeat.o(81751);
    return arrayOfFloat;
  }
  
  private static void changeToSimpleOrientationProvider()
  {
    AppMethodBeat.i(81756);
    orientationProvider.stop();
    SimpleOrientationSensorProvider localSimpleOrientationSensorProvider = new SimpleOrientationSensorProvider((SensorManager)VideoGlobalContext.getContext().getSystemService("sensor"));
    orientationProvider = localSimpleOrientationSensorProvider;
    localSimpleOrientationSensorProvider.start();
    AppMethodBeat.o(81756);
  }
  
  private static float cos(float paramFloat)
  {
    AppMethodBeat.i(81759);
    paramFloat = (float)Math.cos(paramFloat);
    AppMethodBeat.o(81759);
    return paramFloat;
  }
  
  public static float[] getMovedMVPMatrix(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(81749);
    calProjectionMatrix(paramFloat1, paramFloat2);
    calViewMatrix();
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    float[] arrayOfFloat = mMVPMatrix;
    AppMethodBeat.o(81749);
    return arrayOfFloat;
  }
  
  private static void getRotation44(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(81757);
    float[] arrayOfFloat = new float[3];
    int i = 0;
    while (i < 3)
    {
      paramArrayOfFloat1[i] *= 0.01745329F;
      i += 1;
    }
    paramArrayOfFloat2[0] = (cos(arrayOfFloat[0]) * cos(arrayOfFloat[1]) * 1.0F);
    paramArrayOfFloat2[1] = (sin(arrayOfFloat[0]) * cos(arrayOfFloat[1]) * 1.0F);
    paramArrayOfFloat2[2] = (-1.0F * sin(arrayOfFloat[1]));
    paramArrayOfFloat2[4] = ((cos(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * sin(arrayOfFloat[2]) - sin(arrayOfFloat[0]) * cos(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[5] = ((sin(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * sin(arrayOfFloat[2]) + cos(arrayOfFloat[0]) * cos(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[6] = (cos(arrayOfFloat[1]) * sin(arrayOfFloat[2]) * 1.0F);
    paramArrayOfFloat2[8] = ((cos(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * cos(arrayOfFloat[2]) + sin(arrayOfFloat[0]) * sin(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[9] = ((sin(arrayOfFloat[0]) * sin(arrayOfFloat[1]) * cos(arrayOfFloat[2]) - cos(arrayOfFloat[0]) * sin(arrayOfFloat[2])) * 1.0F);
    paramArrayOfFloat2[10] = (cos(arrayOfFloat[1]) * cos(arrayOfFloat[2]) * 1.0F);
    paramArrayOfFloat2[15] = 1.0F;
    AppMethodBeat.o(81757);
  }
  
  private static boolean hasGyroscope()
  {
    AppMethodBeat.i(81760);
    boolean bool = VideoGlobalContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
    AppMethodBeat.o(81760);
    return bool;
  }
  
  private static boolean isSensorDataNaN(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81755);
    if ((Float.isNaN(paramArrayOfFloat[0])) || (Float.isNaN(paramArrayOfFloat[1])) || (Float.isNaN(paramArrayOfFloat[2])))
    {
      AppMethodBeat.o(81755);
      return true;
    }
    AppMethodBeat.o(81755);
    return false;
  }
  
  public static void setIsInBlackList(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(81762);
    String[] arrayOfString = blackList;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      blackSet.add(str);
      i += 1;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (blackSet.contains(paramString)) {
        bool1 = true;
      }
    }
    isInBlackList = bool1;
    AppMethodBeat.o(81762);
  }
  
  public static void setOrientationVector(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(81748);
    float f = paramFloat1;
    if (isFrontCamera) {
      f = -paramFloat1;
    }
    cameraRightX = f;
    paramFloat1 = paramFloat2;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat2;
    }
    cameraRightY = paramFloat1;
    paramFloat1 = paramFloat3;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat3;
    }
    cameraRightZ = paramFloat1;
    paramFloat1 = paramFloat4;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat4;
    }
    cameraX = paramFloat1;
    paramFloat1 = paramFloat5;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat5;
    }
    cameraY = paramFloat1;
    paramFloat1 = paramFloat6;
    if (isFrontCamera) {
      paramFloat1 = -paramFloat6;
    }
    cameraZ = paramFloat1;
    paramFloat1 = cameraRightX;
    paramFloat2 = cameraRightY;
    paramFloat3 = cameraRightZ;
    paramFloat4 = cameraX;
    paramFloat5 = cameraY;
    paramFloat6 = cameraZ;
    float[] arrayOfFloat = vectorNormalization(vectorCrossProduct(new float[] { paramFloat1, paramFloat2, paramFloat3 }, new float[] { paramFloat4, paramFloat5, paramFloat6 }));
    cameraUpX = arrayOfFloat[0];
    cameraUpY = arrayOfFloat[1];
    cameraUpZ = arrayOfFloat[2];
    AppMethodBeat.o(81748);
  }
  
  private static float sin(float paramFloat)
  {
    AppMethodBeat.i(81758);
    paramFloat = (float)Math.sin(paramFloat);
    AppMethodBeat.o(81758);
    return paramFloat;
  }
  
  public static void startOrientationSensor()
  {
    AppMethodBeat.i(81752);
    boolean bool;
    if (orientationProvider == null)
    {
      if ((!hasGyroscope()) || (isInBlackList)) {
        break label68;
      }
      bool = true;
      canUseImprovedSensorProvider = bool;
      if (!bool) {
        break label73;
      }
    }
    label68:
    label73:
    for (Object localObject = new ImprovedOrientationSensor2Provider((SensorManager)VideoGlobalContext.getContext().getSystemService("sensor"));; localObject = new SimpleOrientationSensorProvider((SensorManager)VideoGlobalContext.getContext().getSystemService("sensor")))
    {
      orientationProvider = (OrientationProvider)localObject;
      orientationProvider.start();
      AppMethodBeat.o(81752);
      return;
      bool = false;
      break;
    }
  }
  
  public static void stopOrientationSensor()
  {
    AppMethodBeat.i(81753);
    if (orientationProvider != null) {
      orientationProvider.stop();
    }
    AppMethodBeat.o(81753);
  }
  
  public static void updateOrientation()
  {
    AppMethodBeat.i(81754);
    float[] arrayOfFloat2 = new float[3];
    orientationProvider.getEulerAngles(arrayOfFloat2);
    if ((canUseImprovedSensorProvider) && (isSensorDataNaN(arrayOfFloat2)))
    {
      changeToSimpleOrientationProvider();
      canUseImprovedSensorProvider = false;
      AppMethodBeat.o(81754);
      return;
    }
    float[] arrayOfFloat1 = new float[16];
    getRotation44(arrayOfFloat2, arrayOfFloat1);
    arrayOfFloat2 = new float[16];
    Matrix.multiplyMM(arrayOfFloat2, 0, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }, 0, arrayOfFloat1, 0);
    setOrientationVector(arrayOfFloat2[4], arrayOfFloat2[6], arrayOfFloat2[5], -arrayOfFloat2[8], -arrayOfFloat2[10], -arrayOfFloat2[9]);
    AppMethodBeat.o(81754);
  }
  
  public static void updateRenderSize(int paramInt1, int paramInt2)
  {
    isProjectionMatInitialized = false;
    renderWidth = paramInt1;
    renderHeight = paramInt2;
  }
  
  private static float[] vectorCrossProduct(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[1] * paramArrayOfFloat2[2] - paramArrayOfFloat1[2] * paramArrayOfFloat2[1], paramArrayOfFloat1[2] * paramArrayOfFloat2[0] - paramArrayOfFloat1[0] * paramArrayOfFloat2[2], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] - paramArrayOfFloat1[1] * paramArrayOfFloat2[0] };
  }
  
  private static float[] vectorNormalization(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81761);
    float[] arrayOfFloat = new float[3];
    float f = (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1] + paramArrayOfFloat[2] * paramArrayOfFloat[2]);
    if (f > 0.0D)
    {
      paramArrayOfFloat[0] /= f;
      paramArrayOfFloat[1] /= f;
      paramArrayOfFloat[2] /= f;
    }
    AppMethodBeat.o(81761);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.ar.util.ARMatrixUtil
 * JD-Core Version:    0.7.0.1
 */