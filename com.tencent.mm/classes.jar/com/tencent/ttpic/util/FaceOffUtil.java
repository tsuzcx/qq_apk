package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.model.FaceItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceOffUtil
{
  private static final String COORDS_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
  private static final String COORDS_FILE_FACE_HEAD_CROP = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
  private static final String COORDS_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
  private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static PointF EMPTY_POINT;
  public static final int[] FaceMeshTriangles;
  public static final int[] FaceMeshTrianglesFaceAverage;
  private static String GRAY_FILE_CRAZY_FACE;
  private static String GRAY_FILE_CROP_HEAD_FACE;
  private static String GRAY_FILE_FACE_SKIN;
  private static String GRAY_FILE_HAS_EYE;
  private static String GRAY_FILE_NO_EYE;
  public static final int IRIS_TRIANGLE_COUNT = 8;
  public static final int[] IrisMeshTriangles;
  public static final int NO_HOLE_TRIANGLE_COUNT = 230;
  public static final int NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE = 184;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(83910);
    TAG = FaceOffUtil.class.getSimpleName();
    GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
    GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
    GRAY_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/grayImages/crazyfacegray.png";
    GRAY_FILE_CROP_HEAD_FACE = "assets://camera/camera_video/faceOff/grayImages/faceheadcropgray.png";
    GRAY_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/grayImages/faceMask_skin.png";
    EMPTY_POINT = new PointF();
    FaceMeshTrianglesFaceAverage = new int[] { 0, 1, 35, 1, 35, 36, 35, 36, 42, 20, 35, 42, 19, 20, 35, 19, 20, 26, 19, 26, 96, 19, 90, 96, 26, 95, 96, 25, 26, 95, 21, 25, 26, 20, 21, 26, 20, 21, 42, 21, 41, 42, 41, 42, 43, 36, 42, 43, 36, 37, 43, 36, 37, 57, 2, 36, 57, 2, 3, 57, 3, 4, 65, 4, 5, 65, 5, 65, 67, 5, 6, 67, 6, 7, 67, 7, 67, 68, 7, 8, 68, 8, 68, 69, 68, 69, 73, 68, 73, 74, 67, 68, 74, 65, 67, 74, 65, 75, 82, 57, 58, 75, 58, 75, 76, 75, 76, 82, 65, 74, 82, 74, 81, 82, 73, 74, 81, 70, 72, 73, 69, 70, 73, 10, 69, 70, 9, 10, 69, 8, 9, 69, 10, 11, 70, 12, 13, 71, 13, 66, 71, 13, 14, 66, 14, 15, 66, 60, 61, 79, 59, 60, 64, 59, 60, 78, 59, 77, 78, 76, 77, 81, 59, 76, 77, 58, 59, 76, 58, 59, 64, 56, 58, 64, 56, 57, 58, 37, 38, 43, 38, 40, 43, 38, 39, 40, 38, 39, 56, 39, 55, 56, 23, 39, 55, 56, 62, 64, 47, 61, 62, 46, 47, 61, 15, 16, 61, 17, 45, 46, 17, 18, 45, 27, 28, 45, 28, 45, 52, 28, 29, 52, 29, 51, 52, 29, 50, 51, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 48, 62, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 32, 94, 32, 92, 94, 32, 33, 92, 29, 30, 50, 27, 28, 34, 27, 34, 93, 27, 91, 93, 34, 92, 93, 33, 34, 92, 23, 31, 94, 23, 24, 94, 22, 23, 24, 21, 22, 24, 40, 41, 43, 22, 39, 40, 22, 23, 39, 21, 24, 25, 24, 25, 95, 24, 94, 95, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 79, 80, 66, 71, 72, 70, 71, 72, 60, 78, 79, 1, 2, 36, 95, 96, 99, 92, 93, 105, 91, 104, 105, 14, 103, 104, 11, 102, 103, 7, 101, 102, 4, 100, 101, 90, 99, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 105, 106, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 96, 99, 0, 90, 100, 21, 40, 41, 21, 22, 40, 23, 31, 83, 23, 55, 83, 31, 63, 83, 55, 56, 83, 56, 62, 83, 62, 63, 83, 49, 62, 63, 48, 49, 62, 30, 31, 49, 30, 49, 50, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 52, 53, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 62, 64, 60, 61, 62, 16, 46, 61, 16, 17, 46, 77, 78, 81, 78, 80, 81, 72, 80, 81, 72, 73, 81, 11, 70, 71, 11, 12, 71, 0, 19, 90, 0, 19, 35, 18, 27, 91, 18, 27, 45, 3, 57, 65, 57, 65, 75, 61, 66, 79, 15, 61, 66 };
    FaceMeshTriangles = new int[] { 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 58, 64, 59, 64, 58, 57, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 61, 64, 62, 64, 61, 60, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 84, 63, 83, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 64, 60, 59, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 83, 56, 55, 56, 83, 62, 64, 57, 56, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 56, 62, 64, 124, 125, 49, 63, 62, 83, 83, 55, 84, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100 };
    IrisMeshTriangles = new int[] { 0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 1, 5, 6, 7, 5, 7, 8, 5, 8, 9, 5, 9, 6 };
    AppMethodBeat.o(83910);
  }
  
  public static List<PointF> genPoints(List<Float> paramList)
  {
    AppMethodBeat.i(83900);
    ArrayList localArrayList = new ArrayList();
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(83900);
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      localArrayList.add(new PointF(((Float)paramList.get(i * 2)).floatValue(), ((Float)paramList.get(i * 2 + 1)).floatValue()));
      i += 1;
    }
    AppMethodBeat.o(83900);
    return localArrayList;
  }
  
  public static List<PointF> genPointsDouble(List<Double> paramList)
  {
    AppMethodBeat.i(83901);
    ArrayList localArrayList = new ArrayList();
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(83901);
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      localArrayList.add(new PointF(((Double)paramList.get(i * 2)).floatValue(), ((Double)paramList.get(i * 2 + 1)).floatValue()));
      i += 1;
    }
    AppMethodBeat.o(83901);
    return localArrayList;
  }
  
  public static void getCropNormalFaceFeature(List<PointF> paramList)
  {
    AppMethodBeat.i(83909);
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    float f3 = 1.0F / f1;
    float f4 = 1.0F / f2;
    int i = 0;
    while (i < paramList.size())
    {
      float f5 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(101), f2, (PointF)paramList.get(i));
      float f6 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(105), f1, (PointF)paramList.get(i));
      ((PointF)paramList.get(i)).set(f3 * f5, f4 * f6);
      i += 1;
    }
    AppMethodBeat.o(83909);
  }
  
  public static Bitmap getFaceBitmap(String paramString)
  {
    AppMethodBeat.i(83903);
    paramString = getFaceBitmap(paramString, 2147483647, 2147483647);
    AppMethodBeat.o(83903);
    return paramString;
  }
  
  public static Bitmap getFaceBitmap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83904);
    if (paramString == null)
    {
      AppMethodBeat.o(83904);
      return null;
    }
    if (paramString.startsWith("/")) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2); !BitmapUtils.isLegal(paramString); paramString = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(paramString), paramInt1, paramInt2))
    {
      AppMethodBeat.o(83904);
      return null;
    }
    AppMethodBeat.o(83904);
    return paramString;
  }
  
  public static Bitmap getFaceBitmap(String paramString, FaceItem paramFaceItem)
  {
    AppMethodBeat.i(83902);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(paramString) + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647); !BitmapUtils.isLegal(paramString); paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647))
    {
      AppMethodBeat.o(83902);
      return null;
    }
    AppMethodBeat.o(83902);
    return paramString;
  }
  
  public static FaceOffUtil.FEATURE_TYPE getFeatureType(int paramInt)
  {
    AppMethodBeat.i(83899);
    Object localObject = FaceOffUtil.FEATURE_TYPE.values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      FaceOffUtil.FEATURE_TYPE localFEATURE_TYPE = localObject[i];
      if (localFEATURE_TYPE.value == paramInt)
      {
        AppMethodBeat.o(83899);
        return localFEATURE_TYPE;
      }
      i += 1;
    }
    localObject = FaceOffUtil.FEATURE_TYPE.NO_EYE;
    AppMethodBeat.o(83899);
    return localObject;
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList)
  {
    AppMethodBeat.i(83896);
    if ((BaseUtils.isEmpty(paramList)) || (paramList.size() < 90))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(83896);
      return paramList;
    }
    PointF localPointF3 = (PointF)paramList.get(83);
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(83)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    double d1 = Math.atan((f1 - f2) / (((PointF)paramList.get(83)).y + f3));
    f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    PointF localPointF1 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(d1)));
    paramList.add(localPointF1);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    PointF localPointF2 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(d1)));
    paramList.add(localPointF2);
    f1 = (float)(AlgoUtils.getDistance((PointF)paramList.get(59), localPointF3) * 1.2D);
    localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(d1)));
    int i = 2;
    double d2;
    double d3;
    while (i > 0)
    {
      d1 = Math.toRadians(i * 30.0F);
      PointF localPointF4 = new PointF();
      localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(d1)));
      d2 = localPointF2.y;
      d3 = localPointF2.y - localPointF3.y;
      localPointF4.y = ((float)(d2 - Math.sin(d1) * d3));
      paramList.add(localPointF4);
      i -= 1;
    }
    i = 3;
    while (i > 0)
    {
      d1 = Math.toRadians(i * 30.0F);
      localPointF2 = new PointF();
      localPointF2.x = ((float)(localPointF3.x - (localPointF3.x - localPointF1.x) * Math.cos(d1)));
      d2 = localPointF1.y;
      d3 = localPointF1.y - localPointF3.y;
      localPointF2.y = ((float)(d2 - Math.sin(d1) * d3));
      paramList.add(localPointF2);
      i -= 1;
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    localPointF1 = (PointF)paramList.get(64);
    localPointF2 = (PointF)paramList.get(54);
    localPointF3 = (PointF)paramList.get(44);
    localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
    f1 = localPointF2.x;
    f2 = localPointF2.x;
    f3 = localPointF2.y;
    localPointF2 = new PointF(f1 + f2, localPointF2.y + f3);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    paramList.add(new PointF(localPointF1.x - localPointF2.x - localPointF3.x, localPointF1.y - localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x + localPointF3.x, localPointF1.y - localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF3.x, localPointF1.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x + localPointF3.x, localPointF1.y + localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x, localPointF1.y + localPointF2.y));
    f1 = localPointF1.x;
    f2 = localPointF2.x;
    f3 = localPointF3.x;
    float f4 = localPointF1.y;
    paramList.add(new PointF(f1 + f2 - f3, localPointF2.y + f4 - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF3.x, localPointF1.y - localPointF3.y));
    paramList.get(3);
    paramList.get(15);
    paramList.get(65);
    paramList.get(66);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    paramList.get(2);
    paramList.get(16);
    paramList.get(39);
    paramList.get(49);
    paramList.get(57);
    paramList.get(61);
    paramList.get(35);
    paramList.get(45);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    paramList.get(37);
    localPointF1 = (PointF)paramList.get(44);
    i = 35;
    float f5;
    while (i < 39)
    {
      localPointF2 = (PointF)paramList.get(i);
      if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
      {
        paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
        i += 1;
      }
      else
      {
        f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
        f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
        f4 = localPointF1.x;
        f5 = localPointF1.y;
        if ((i != 35) || (f2 >= ((PointF)paramList.get(0)).x)) {
          break label2666;
        }
      }
    }
    label2659:
    label2666:
    for (f1 = ((PointF)paramList.get(0)).x;; f1 = f2)
    {
      paramList.add(new PointF(f1, f5 + (f2 - f4) * f3));
      break;
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      if (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
        }
        for (;;)
        {
          i += 1;
          break;
          f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
          paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
        }
      }
      localPointF3 = (PointF)paramList.get(j);
      localPointF1 = (PointF)paramList.get(j + 1);
      localPointF2 = (PointF)paramList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
      localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
          i += 1;
        }
        else
        {
          f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
          f4 = localPointF1.x;
          f5 = localPointF1.y;
          if ((i != 45) || (f2 <= ((PointF)paramList.get(18)).x)) {
            break label2659;
          }
        }
      }
      for (f1 = ((PointF)paramList.get(18)).x;; f1 = f2)
      {
        paramList.add(new PointF(f1, f5 + (f2 - f4) * f3));
        break;
        localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        j = paramList.size();
        i = 50;
        if (i < 53)
        {
          localPointF2 = (PointF)paramList.get(i);
          if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
            paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
          }
          for (;;)
          {
            i += 1;
            break;
            f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
            f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
            paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
          }
        }
        localPointF3 = (PointF)paramList.get(j);
        localPointF1 = (PointF)paramList.get(j + 1);
        localPointF2 = (PointF)paramList.get(j + 2);
        localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
        localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
        paramList.add(new PointF(localPointF3.x, localPointF3.y));
        paramList.add(new PointF(localPointF1.x, localPointF1.y));
        AppMethodBeat.o(83896);
        return paramList;
      }
    }
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList, float paramFloat)
  {
    AppMethodBeat.i(83898);
    if ((BaseUtils.isEmpty(paramList)) || (paramList.size() < 90))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(83898);
      return paramList;
    }
    if (paramList.size() > 97) {
      paramList.subList(97, paramList.size()).clear();
    }
    if ((paramList.size() != 90) && (paramList.size() != 97))
    {
      AppMethodBeat.o(83898);
      return paramList;
    }
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    if (paramList.size() == 90)
    {
      f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      localPointF2 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF2);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      localPointF4 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF4);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
      localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
      i = 2;
      double d2;
      double d3;
      double d4;
      while (i > 0)
      {
        d2 = Math.toRadians(i * 30.0F);
        PointF localPointF5 = new PointF();
        localPointF5.x = ((float)(localPointF3.x - (localPointF3.x - localPointF4.x) * Math.cos(d2)));
        d3 = localPointF4.y;
        d4 = localPointF4.y - localPointF3.y;
        localPointF5.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF5);
        i -= 1;
      }
      i = 3;
      while (i > 0)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF4 = new PointF();
        localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(d2)));
        d3 = localPointF2.y;
        d4 = localPointF2.y - localPointF3.y;
        localPointF4.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF4);
        i -= 1;
      }
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    PointF localPointF2 = (PointF)paramList.get(64);
    PointF localPointF3 = (PointF)paramList.get(54);
    PointF localPointF4 = (PointF)paramList.get(44);
    localPointF3 = new PointF(localPointF3.x - localPointF4.x, localPointF3.y - localPointF4.y);
    localPointF3 = new PointF(localPointF3.x * paramFloat, localPointF3.y * paramFloat);
    localPointF4 = new PointF(-localPointF3.y, localPointF3.x);
    paramList.add(new PointF(localPointF2.x - localPointF3.x - localPointF4.x, localPointF2.y - localPointF3.y - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x + localPointF4.x, localPointF2.y - localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF4.x, localPointF2.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x + localPointF4.x, localPointF2.y + localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x, localPointF2.y + localPointF3.y));
    paramFloat = localPointF2.x;
    f1 = localPointF3.x;
    f2 = localPointF4.x;
    f3 = localPointF2.y;
    paramList.add(new PointF(paramFloat + f1 - f2, localPointF3.y + f3 - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF4.x, localPointF2.y - localPointF4.y));
    paramList.get(3);
    paramList.get(15);
    paramList.get(65);
    paramList.get(66);
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    paramList.get(2);
    paramList.get(16);
    paramList.get(39);
    paramList.get(49);
    paramList.get(57);
    paramList.get(61);
    paramList.get(35);
    paramList.get(45);
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    paramList.get(37);
    localPointF2 = (PointF)paramList.get(44);
    int i = 35;
    while (i < 39)
    {
      localPointF3 = (PointF)paramList.get(i);
      if (Math.abs(localPointF3.x - localPointF2.x) < 1.0D)
      {
        paramList.add(new PointF(localPointF3.x, (float)(localPointF3.y + (localPointF3.y - localPointF2.y) * 0.7D)));
        i += 1;
      }
      else
      {
        f2 = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
        f1 = (float)(localPointF3.x + (localPointF3.x - localPointF2.x) * 0.7D);
        f3 = localPointF2.x;
        f4 = localPointF2.y;
        if ((i != 35) || (f1 >= ((PointF)paramList.get(0)).x)) {
          break label2915;
        }
      }
    }
    label2909:
    label2915:
    for (paramFloat = ((PointF)paramList.get(0)).x;; paramFloat = f1)
    {
      paramList.add(new PointF(paramFloat, f4 + (f1 - f3) * f2));
      break;
      localPointF3 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      int j = paramList.size();
      i = 40;
      if (i < 43)
      {
        localPointF3 = (PointF)paramList.get(i);
        if (Math.abs(localPointF3.x - localPointF2.x) < 1.0D) {
          paramList.add(new PointF(localPointF3.x, (float)(localPointF3.y + (localPointF3.y - localPointF2.y) * 1.2D)));
        }
        for (;;)
        {
          i += 1;
          break;
          paramFloat = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
          f1 = (float)(localPointF3.x + (localPointF3.x - localPointF2.x) * 1.2D);
          paramList.add(new PointF(f1, paramFloat * (f1 - localPointF2.x) + localPointF2.y));
        }
      }
      localPointF4 = (PointF)paramList.get(j);
      localPointF2 = (PointF)paramList.get(j + 1);
      localPointF3 = (PointF)paramList.get(j + 2);
      localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
      localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      localPointF2 = (PointF)paramList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF3 = (PointF)paramList.get(i);
        if (Math.abs(localPointF3.x - localPointF2.x) < 1.0D)
        {
          paramList.add(new PointF(localPointF3.x, (float)(localPointF3.y + (localPointF3.y - localPointF2.y) * 0.7D)));
          i += 1;
        }
        else
        {
          f2 = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
          f1 = (float)(localPointF3.x + (localPointF3.x - localPointF2.x) * 0.7D);
          f3 = localPointF2.x;
          f4 = localPointF2.y;
          if ((i != 45) || (f1 <= ((PointF)paramList.get(18)).x)) {
            break label2909;
          }
        }
      }
      for (paramFloat = ((PointF)paramList.get(18)).x;; paramFloat = f1)
      {
        paramList.add(new PointF(paramFloat, f4 + (f1 - f3) * f2));
        break;
        localPointF3 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF3.x, localPointF3.y));
        j = paramList.size();
        i = 50;
        if (i < 53)
        {
          localPointF3 = (PointF)paramList.get(i);
          if (Math.abs(localPointF3.x - localPointF2.x) < 1.0D) {
            paramList.add(new PointF(localPointF3.x, (float)(localPointF3.y + (localPointF3.y - localPointF2.y) * 1.2D)));
          }
          for (;;)
          {
            i += 1;
            break;
            paramFloat = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
            f1 = (float)(localPointF3.x + (localPointF3.x - localPointF2.x) * 1.2D);
            paramList.add(new PointF(f1, paramFloat * (f1 - localPointF2.x) + localPointF2.y));
          }
        }
        localPointF4 = (PointF)paramList.get(j);
        localPointF2 = (PointF)paramList.get(j + 1);
        localPointF3 = (PointF)paramList.get(j + 2);
        localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
        localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
        paramList.add(new PointF(localPointF4.x, localPointF4.y));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        localMatrix.reset();
        localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
        localMatrix.postRotate((float)Math.toDegrees(d1));
        localMatrix.postTranslate(localPointF1.x, localPointF1.y);
        paramList = AlgoUtils.mapPoints(paramList, localMatrix);
        AppMethodBeat.o(83898);
        return paramList;
      }
    }
  }
  
  public static List<PointF> getFullCoordsForFaceOffFilter(List<PointF> paramList, float paramFloat)
  {
    AppMethodBeat.i(83897);
    if ((BaseUtils.isEmpty(paramList)) || (paramList.size() < 90))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(83897);
      return paramList;
    }
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    PointF localPointF2 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF2);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    PointF localPointF4 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF4);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
    PointF localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
    int i = 2;
    double d2;
    double d3;
    double d4;
    while (i > 0)
    {
      d2 = Math.toRadians(i * 30.0F);
      localPointF5 = new PointF();
      localPointF5.x = ((float)(localPointF3.x - (localPointF3.x - localPointF4.x) * Math.cos(d2)));
      d3 = localPointF4.y;
      d4 = localPointF4.y - localPointF3.y;
      localPointF5.y = ((float)(d3 - Math.sin(d2) * d4));
      paramList.add(localPointF5);
      i -= 1;
    }
    i = 3;
    while (i > 0)
    {
      d2 = Math.toRadians(i * 30.0F);
      localPointF4 = new PointF();
      localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(d2)));
      d3 = localPointF2.y;
      d4 = localPointF2.y - localPointF3.y;
      localPointF4.y = ((float)(d3 - Math.sin(d2) * d4));
      paramList.add(localPointF4);
      i -= 1;
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    localPointF2 = (PointF)paramList.get(64);
    localPointF3 = (PointF)paramList.get(54);
    localPointF4 = (PointF)paramList.get(44);
    localPointF3 = new PointF(localPointF3.x - localPointF4.x, localPointF3.y - localPointF4.y);
    localPointF3 = new PointF(localPointF3.x * paramFloat, localPointF3.y * paramFloat);
    localPointF4 = new PointF(-localPointF3.y, localPointF3.x);
    paramList.add(new PointF(localPointF2.x - localPointF3.x - localPointF4.x, localPointF2.y - localPointF3.y - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x + localPointF4.x, localPointF2.y - localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF4.x, localPointF2.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x + localPointF4.x, localPointF2.y + localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x, localPointF2.y + localPointF3.y));
    paramFloat = localPointF2.x;
    f1 = localPointF3.x;
    f2 = localPointF4.x;
    f3 = localPointF2.y;
    paramList.add(new PointF(paramFloat + f1 - f2, localPointF3.y + f3 - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF4.x, localPointF2.y - localPointF4.y));
    paramList.get(3);
    paramList.get(15);
    paramList.get(65);
    paramList.get(66);
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    paramList.get(2);
    paramList.get(16);
    localPointF4 = (PointF)paramList.get(39);
    localPointF2 = (PointF)paramList.get(49);
    paramList.get(57);
    paramList.get(61);
    PointF localPointF5 = (PointF)paramList.get(35);
    localPointF3 = (PointF)paramList.get(45);
    PointF localPointF6 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF6.x, localPointF6.y));
    localPointF6 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF6.x, localPointF6.y));
    localPointF6 = (PointF)paramList.get(43);
    paramList.get(55);
    PointF localPointF7 = (PointF)paramList.get(41);
    PointF localPointF8 = (PointF)paramList.get(37);
    paramFloat = AlgoUtils.getDistance(localPointF5, localPointF4);
    AlgoUtils.getDistance(localPointF7, localPointF8);
    f2 = paramFloat / 50.0F;
    i = 35;
    if (i < 39)
    {
      localPointF4 = (PointF)paramList.get(i);
      f1 = (float)(Math.sin((2.0F - Math.abs(i - 37)) * 3.141592653589793D / 4.0D) * 0.3D);
      if (i == 35)
      {
        f1 = (localPointF4.y - localPointF6.y) / (localPointF4.x - localPointF6.x);
        paramFloat = localPointF4.x + (localPointF4.x - localPointF6.x) * 0.9F;
        f1 = (paramFloat - localPointF6.x) * f1 + localPointF6.y;
        label1791:
        if ((i != 35) || (paramFloat >= ((PointF)paramList.get(0)).x)) {
          break label2988;
        }
        paramFloat = ((PointF)paramList.get(0)).x;
      }
    }
    label2453:
    label2985:
    label2988:
    for (;;)
    {
      paramList.add(new PointF(paramFloat, f1));
      i += 1;
      break;
      f3 = (float)Math.toRadians(60.0F * (i - 37));
      paramFloat = (float)(localPointF4.x + 10.0F * f2 * (1.0F + f1) * Math.sin(0.0D + f3));
      f1 = (float)(localPointF4.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D + f3));
      break label1791;
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      int j = paramList.size();
      i = 40;
      while (i < 43)
      {
        localPointF4 = (PointF)paramList.get(i);
        paramFloat = (float)Math.toRadians(60.0F * (i - 41));
        f1 = (float)(Math.sin((3.0F - Math.abs(i - 41)) * 3.141592653589793D / 2.0D) * 0.3D);
        paramList.add(new PointF((float)(localPointF4.x - 16.0F * f2 * (1.0F + f1) * Math.sin(0.0D + paramFloat)), (float)(localPointF4.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D + paramFloat))));
        i += 1;
      }
      localPointF6 = (PointF)paramList.get(j);
      localPointF4 = (PointF)paramList.get(j + 1);
      localPointF5 = (PointF)paramList.get(j + 2);
      localPointF6 = AlgoUtils.middlePoint(localPointF6, localPointF4);
      localPointF4 = AlgoUtils.middlePoint(localPointF5, localPointF4);
      paramList.add(new PointF(localPointF6.x, localPointF6.y));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF5 = (PointF)paramList.get(51);
      localPointF6 = (PointF)paramList.get(47);
      localPointF4 = (PointF)paramList.get(54);
      paramList.get(63);
      paramFloat = AlgoUtils.getDistance(localPointF3, localPointF2);
      AlgoUtils.getDistance(localPointF5, localPointF6);
      f2 = paramFloat / 50.0F;
      i = 45;
      if (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        f1 = (float)(Math.sin((2.0F - Math.abs(i - 47)) * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f1 = (localPointF2.y - localPointF4.y) / (localPointF2.x - localPointF4.x);
          paramFloat = localPointF2.x + (localPointF2.x - localPointF4.x) * 0.9F;
          f1 = (paramFloat - localPointF4.x) * f1 + localPointF4.y;
          if ((i != 45) || (paramFloat <= ((PointF)paramList.get(18)).x)) {
            break label2985;
          }
          paramFloat = ((PointF)paramList.get(18)).x;
        }
      }
      for (;;)
      {
        paramList.add(new PointF(paramFloat, f1));
        i += 1;
        break;
        f3 = (float)Math.toRadians(60.0F * (i - 47));
        paramFloat = (float)(localPointF2.x + 10.0F * f2 * (1.0F + f1) * Math.sin(0.0D - f3));
        f1 = (float)(localPointF2.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - f3));
        break label2453;
        localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        j = paramList.size();
        i = 50;
        while (i < 53)
        {
          localPointF2 = (PointF)paramList.get(i);
          paramFloat = (float)Math.toRadians(60.0F * (i - 51));
          f1 = (float)(Math.sin((3.0F - Math.abs(i - 51)) * 3.141592653589793D / 2.0D) * 0.3D);
          paramList.add(new PointF((float)(localPointF2.x - 16.0F * f2 * (1.0F + f1) * Math.sin(0.0D - paramFloat)), (float)(localPointF2.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - paramFloat))));
          i += 1;
        }
        localPointF4 = (PointF)paramList.get(j);
        localPointF2 = (PointF)paramList.get(j + 1);
        localPointF3 = (PointF)paramList.get(j + 2);
        localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
        localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
        paramList.add(new PointF(localPointF4.x, localPointF4.y));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        localMatrix.reset();
        localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
        localMatrix.postRotate((float)Math.toDegrees(d1));
        localMatrix.postTranslate(localPointF1.x, localPointF1.y);
        paramList = AlgoUtils.mapPoints(paramList, localMatrix);
        AppMethodBeat.o(83897);
        return paramList;
      }
    }
  }
  
  public static Bitmap getGrayBitmap(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    AppMethodBeat.i(83905);
    Bitmap localBitmap = null;
    if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.NO_EYE)) {
      localBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_NO_EYE, 2147483647, 2147483647);
    }
    for (;;)
    {
      AppMethodBeat.o(83905);
      return localBitmap;
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.HAS_EYE)) {
        localBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_HAS_EYE, 2147483647, 2147483647);
      } else if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.CRAZY_FACE)) {
        localBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_CRAZY_FACE, 2147483647, 2147483647);
      } else if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP)) {
        localBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_CROP_HEAD_FACE, 2147483647, 2147483647);
      } else if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.FACE_SKIN)) {
        localBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), GRAY_FILE_FACE_SKIN, 2147483647, 2147483647);
      }
    }
  }
  
  public static List<PointF> getGrayCoords(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    AppMethodBeat.i(83906);
    switch (FaceOffUtil.1.$SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FEATURE_TYPE[paramFEATURE_TYPE.ordinal()])
    {
    default: 
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    }
    for (;;)
    {
      paramFEATURE_TYPE = loadTexCoords(paramFEATURE_TYPE);
      AppMethodBeat.o(83906);
      return paramFEATURE_TYPE;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
    }
  }
  
  public static List<PointF> getMaskCoords(List<Double> paramList)
  {
    AppMethodBeat.i(83907);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size() - 1)
    {
      double d1 = ((Double)paramList.get(i)).doubleValue();
      double d2 = ((Double)paramList.get(i + 1)).doubleValue();
      localArrayList.add(new PointF((float)d1, (float)d2));
      i += 2;
    }
    AppMethodBeat.o(83907);
    return localArrayList;
  }
  
  public static float[] initFaceLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83894);
    if ((BaseUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(83894);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 690)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      paramArrayOfFloat[j] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 1)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      j += 12;
      i += 3;
    }
    AppMethodBeat.o(83894);
    return paramArrayOfFloat;
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83890);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1380))
    {
      AppMethodBeat.o(83890);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 690)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
    AppMethodBeat.o(83890);
    return paramArrayOfFloat;
  }
  
  public static float[] initFacePositionsBaseOnFaceRect(List<PointF> paramList, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83891);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F) || (paramArrayOfFloat.length != 1380))
    {
      AppMethodBeat.o(83891);
      return new float[0];
    }
    int j = paramList.size();
    float f1 = ((PointF)paramList.get(64)).x;
    float f2 = ((PointF)paramList.get(64)).y;
    int i = 0;
    while (i < j)
    {
      ((PointF)paramList.get(i)).x -= f1;
      ((PointF)paramList.get(i)).y -= f2;
      i += 1;
    }
    PointF[] arrayOfPointF = new PointF[3];
    i = 0;
    j = 0;
    while (i < 690)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramFloat1 * 2.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramFloat2 * 2.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
    AppMethodBeat.o(83891);
    return paramArrayOfFloat;
  }
  
  public static float[] initFacePositionsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83893);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1104))
    {
      AppMethodBeat.o(83893);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 552)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
    AppMethodBeat.o(83893);
    return paramArrayOfFloat;
  }
  
  public static float[] initIrisLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83895);
    if ((BaseUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(83895);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 24)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(IrisMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(IrisMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(IrisMeshTriangles[(i + 2)]));
      paramArrayOfFloat[j] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 1)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      j += 12;
      i += 3;
    }
    AppMethodBeat.o(83895);
    return paramArrayOfFloat;
  }
  
  public static float[] initMaterialFaceTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83889);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1380))
    {
      AppMethodBeat.o(83889);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 690)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
    AppMethodBeat.o(83889);
    return paramArrayOfFloat;
  }
  
  public static float[] initMaterialFaceTexCoordsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83892);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1104))
    {
      AppMethodBeat.o(83892);
      return new float[0];
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    while (i < 552)
    {
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
    AppMethodBeat.o(83892);
    return paramArrayOfFloat;
  }
  
  public static List<PointF> loadTexCoords(String paramString)
  {
    AppMethodBeat.i(83887);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new ArrayList();
      AppMethodBeat.o(83887);
      return paramString;
    }
    paramString = loadTexCoords(paramString.substring(0, paramString.lastIndexOf(File.separator)), paramString.substring(paramString.lastIndexOf(File.separator) + 1));
    AppMethodBeat.o(83887);
    return paramString;
  }
  
  private static List<PointF> loadTexCoords(String paramString1, String paramString2)
  {
    AppMethodBeat.i(83888);
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(83888);
      return localArrayList;
    }
    paramString1 = FileUtils.load(VideoGlobalContext.getContext(), paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(83888);
      return localArrayList;
    }
    paramString1 = paramString1.trim().split("\\s+");
    int i = 0;
    try
    {
      while (i < paramString1.length / 2)
      {
        localArrayList.add(new PointF(Float.parseFloat(paramString1[(i * 2)]), Float.parseFloat(paramString1[(i * 2 + 1)])));
        i += 1;
      }
      AppMethodBeat.o(83888);
    }
    catch (NumberFormatException paramString1)
    {
      paramString1 = new ArrayList();
      AppMethodBeat.o(83888);
      return paramString1;
    }
    return localArrayList;
  }
  
  public static void scalePoints(List<PointF> paramList, double paramDouble)
  {
    AppMethodBeat.i(83908);
    if (paramList == null)
    {
      AppMethodBeat.o(83908);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localPointF.x = ((float)(localPointF.x * paramDouble));
      localPointF.y = ((float)(localPointF.y * paramDouble));
    }
    AppMethodBeat.o(83908);
  }
  
  public static void setNoEyeGrayImagePath(String paramString)
  {
    GRAY_FILE_HAS_EYE = paramString;
  }
  
  public static void setNoMouthGrayImagePath(String paramString)
  {
    GRAY_FILE_NO_EYE = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceOffUtil
 * JD-Core Version:    0.7.0.1
 */