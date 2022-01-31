package com.tencent.ttpic.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceAttr.PTFace;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.SizeI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AlgoUtils
{
  private static final Random mRandom = new Random(System.currentTimeMillis());
  
  public static native void RGBA2YUV420SP(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP3(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void YUVNV21TORGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2);
  
  public static native void YUVX2YUV(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static SizeI calCutSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 / paramInt2 >= paramDouble) {
      return new SizeI((int)(paramInt2 * paramDouble), paramInt2);
    }
    return new SizeI(paramInt1, (int)(paramInt1 / paramDouble));
  }
  
  public static float[] calPositions(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, paramFloat4 };
  }
  
  public static float[] calPositionsTriangles(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat2, paramFloat1, paramFloat4, paramFloat3, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat3, paramFloat2 };
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, double paramDouble)
  {
    int i;
    int m;
    int k;
    int j;
    if (paramInt1 / paramInt2 >= paramDouble)
    {
      i = (int)(paramInt2 * paramDouble);
      m = (paramInt1 - i) / 2;
      k = m + i;
      i = 0;
      j = paramInt2;
    }
    for (;;)
    {
      float f1 = m / paramInt1;
      float f2 = k / paramInt1;
      float f3 = j / paramInt2;
      float f4 = i / paramInt2;
      return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
      j = (int)(paramInt1 / paramDouble);
      i = (paramInt2 - j) / 2;
      j += i;
      k = paramInt1;
      m = 0;
    }
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt3 == 90) || (paramInt3 == 270)) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      if (paramInt2 / paramInt1 >= paramDouble)
      {
        paramInt3 = (int)(paramInt1 * paramDouble);
        k = (paramInt2 - paramInt3) / 2;
        j = k + paramInt3;
        paramInt3 = 0;
        i = paramInt1;
      }
      for (;;)
      {
        float f1 = k / paramInt2;
        float f2 = j / paramInt2;
        float f3 = i / paramInt1;
        float f4 = paramInt3 / paramInt1;
        return new float[] { f1, f3, f1, f4, f2, f4, f2, f3 };
        i = (int)(paramInt2 / paramDouble);
        paramInt3 = (paramInt1 - i) / 2;
        i += paramInt3;
        j = paramInt2;
        k = 0;
      }
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
    }
  }
  
  public static float distanceOfPoint2Line(PointF paramPointF1, PointF paramPointF2, float paramFloat, PointF paramPointF3)
  {
    float f1 = getDistance(paramPointF1, paramPointF3);
    float f2 = getDistance(paramPointF2, paramPointF3);
    float f3 = (paramFloat + f1 + f2) / 2.0F;
    f1 = (float)Math.sqrt((f3 - f1) * ((f3 - paramFloat) * f3) * (f3 - f2));
    if (f1 < 0.001D) {
      return 0.0F;
    }
    return f1 * 2.0F / paramFloat;
  }
  
  public static float getDistance(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    double d1 = paramPointF1.x - paramPointF2.x;
    double d2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(d1 * d1 + d2 * d2);
  }
  
  public static List<PointF> mapPoints(List<PointF> paramList, Matrix paramMatrix)
  {
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      arrayOfFloat1[0] = localPointF.x;
      arrayOfFloat1[1] = localPointF.y;
      paramMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
      localPointF.x = arrayOfFloat2[0];
      localPointF.y = arrayOfFloat2[1];
    }
    return paramList;
  }
  
  public static PointF middlePoint(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return new PointF();
    }
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public static native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static int randValueDiff(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 1) {
      return 1;
    }
    int i;
    do
    {
      i = mRandom.nextInt(paramInt2) + 1;
    } while (paramInt1 == i);
    return i;
  }
  
  public static List<float[]> rotateAngles(List<float[]> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    paramInt = (paramInt + 360) % 360;
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      float[] arrayOfFloat = (float[])paramList.next();
      if ((paramInt == 90) || (paramInt == 270)) {
        localArrayList.add(new float[] { -arrayOfFloat[1], -arrayOfFloat[0], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      } else {
        localArrayList.add(new float[] { arrayOfFloat[0], arrayOfFloat[1], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      }
    }
    return localArrayList;
  }
  
  public static void rotateAngles(PTFaceAttr paramPTFaceAttr, int paramInt)
  {
    if ((paramPTFaceAttr == null) || (paramPTFaceAttr.getFaceInfos() == null)) {
      return;
    }
    paramInt = (paramInt + 360) % 360;
    Iterator localIterator = paramPTFaceAttr.getFaceInfos().iterator();
    label32:
    PTFaceAttr.PTFace localPTFace;
    float[] arrayOfFloat;
    if (localIterator.hasNext())
    {
      localPTFace = (PTFaceAttr.PTFace)localIterator.next();
      arrayOfFloat = localPTFace.getFaceAngle();
      if ((paramInt != 90) && (paramInt != 270)) {
        break label118;
      }
      paramPTFaceAttr = new float[3];
      paramPTFaceAttr[0] = (-arrayOfFloat[1]);
      paramPTFaceAttr[1] = (-arrayOfFloat[0]);
      paramPTFaceAttr[2] = ((float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D));
    }
    for (;;)
    {
      localPTFace.setFaceAngle(paramPTFaceAttr);
      break label32;
      break;
      label118:
      paramPTFaceAttr = new float[3];
      paramPTFaceAttr[0] = arrayOfFloat[0];
      paramPTFaceAttr[1] = arrayOfFloat[1];
      paramPTFaceAttr[2] = ((float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D));
    }
  }
  
  public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList != null)
    {
      int j = 0;
      int i = paramInt3;
      paramInt3 = j;
      if (paramInt3 < paramList.size())
      {
        FaceStatus localFaceStatus = (FaceStatus)paramList.get(paramInt3);
        i = (i + 360) % 360;
        float f;
        label93:
        Matrix localMatrix;
        if (i == 90)
        {
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = (-localFaceStatus.yaw);
          localFaceStatus.yaw = f;
          localFaceStatus.roll += i;
          localMatrix = new Matrix();
          localMatrix.reset();
          localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
          localMatrix.postRotate(i, 0.0F, 0.0F);
          if ((i != 90) && (i != 270)) {
            break label316;
          }
          localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
        }
        for (;;)
        {
          float[] arrayOfFloat = new float[2];
          localMatrix.mapPoints(arrayOfFloat, new float[] { localFaceStatus.tx, localFaceStatus.ty });
          localFaceStatus.tx = arrayOfFloat[0];
          localFaceStatus.ty = arrayOfFloat[1];
          paramInt3 += 1;
          break;
          if (i == 180)
          {
            localFaceStatus.pitch = (-localFaceStatus.pitch);
            localFaceStatus.yaw = (-localFaceStatus.yaw);
            localFaceStatus.roll += i;
            break label93;
          }
          if (i != 270) {
            break label93;
          }
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = localFaceStatus.yaw;
          localFaceStatus.yaw = (-f);
          localFaceStatus.roll += i;
          break label93;
          label316:
          localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        }
      }
    }
    return paramList;
  }
  
  public static List<PointF> rotatePoints(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return localObject;
    }
    paramInt3 = (paramInt3 + 360) % 360;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
    localMatrix.postRotate(paramInt3, 0.0F, 0.0F);
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
    }
    for (;;)
    {
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PointF)localIterator.next();
        arrayOfFloat1[0] = ((PointF)localObject).x;
        arrayOfFloat1[1] = ((PointF)localObject).y;
        localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
        ((PointF)localObject).x = arrayOfFloat2[0];
        ((PointF)localObject).y = arrayOfFloat2[1];
      }
      localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
    }
  }
  
  public static List<List<PointF>> rotatePointsForList(List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(rotatePoints((List)paramList.next(), paramInt1, paramInt2, paramInt3));
    }
    return localArrayList;
  }
  
  public static void rotatePointsForList(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramPTFaceAttr == null) || (paramPTFaceAttr.getFaceInfos() == null)) {}
    for (;;)
    {
      return;
      paramPTFaceAttr = paramPTFaceAttr.getFaceInfos().iterator();
      while (paramPTFaceAttr.hasNext())
      {
        PTFaceAttr.PTFace localPTFace = (PTFaceAttr.PTFace)paramPTFaceAttr.next();
        localPTFace.setFacePoints(rotatePoints(localPTFace.getFacePoints(), paramInt1, paramInt2, paramInt3));
      }
    }
  }
  
  public static List<Float> substract(List<Float> paramList, float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramArrayOfFloat == null)) {
      return localArrayList;
    }
    int i = 0;
    while (i < Math.min(paramList.size(), paramArrayOfFloat.length))
    {
      localArrayList.add(Float.valueOf(((Float)paramList.get(i)).floatValue() - paramArrayOfFloat[i]));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.AlgoUtils
 * JD-Core Version:    0.7.0.1
 */