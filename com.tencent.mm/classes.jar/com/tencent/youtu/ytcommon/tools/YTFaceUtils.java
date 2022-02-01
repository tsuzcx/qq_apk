package com.tencent.youtu.ytcommon.tools;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;

public class YTFaceUtils
{
  private static final String TAG = "FaceUtils";
  
  public static Rect getFaceScreen(YTFaceTrack.FaceStatus paramFaceStatus)
  {
    int i = 0;
    AppMethodBeat.i(73375);
    float f3 = paramFaceStatus.xys[0];
    float f4 = paramFaceStatus.xys[0];
    float f2 = paramFaceStatus.xys[1];
    float f1 = paramFaceStatus.xys[1];
    if (i < 180)
    {
      if (f3 < paramFaceStatus.xys[i])
      {
        label57:
        if (f4 <= paramFaceStatus.xys[i]) {
          break label120;
        }
        label70:
        i += 1;
        if (f2 >= paramFaceStatus.xys[i]) {
          break label132;
        }
        label88:
        if (f1 <= paramFaceStatus.xys[i]) {
          break label143;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f3 = paramFaceStatus.xys[i];
        break label57;
        label120:
        f4 = paramFaceStatus.xys[i];
        break label70;
        label132:
        f2 = paramFaceStatus.xys[i];
        break label88;
        label143:
        f1 = paramFaceStatus.xys[i];
      }
    }
    paramFaceStatus = new Rect((int)f3, (int)f2, (int)f4, (int)f1);
    AppMethodBeat.o(73375);
    return paramFaceStatus;
  }
  
  public static int shelterJudge(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(73376);
    if (paramArrayOfFloat == null)
    {
      YTLogger.i("FaceUtils", "[YTFaceTraceInterface.blockJudge] input pointsVis is null.");
      AppMethodBeat.o(73376);
      return -1;
    }
    if (paramArrayOfFloat.length != 90)
    {
      YTLogger.i("FaceUtils", "[YTFaceTraceInterface.blockJudge] input pointsVis.length != 90. current pointsVis.length: " + paramArrayOfFloat.length);
      AppMethodBeat.o(73376);
      return -2;
    }
    int i = 33;
    int k;
    for (int j = 0; i <= 45; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4)
    {
      AppMethodBeat.o(73376);
      return 5;
    }
    i = 46;
    for (j = 0; i <= 67; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 4)
    {
      AppMethodBeat.o(73376);
      return 3;
    }
    j = 9;
    for (i = 0; j <= 16; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 25;
    while (j <= 32)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[89] < 0.7F) {
      j = i + 1;
    }
    if (j >= 4)
    {
      AppMethodBeat.o(73376);
      return 6;
    }
    j = 1;
    for (i = 0; j <= 8; i = k)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
    }
    j = 17;
    while (j <= 24)
    {
      k = i;
      if (paramArrayOfFloat[(j - 1)] < 0.7F) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    j = i;
    if (paramArrayOfFloat[88] < 0.7F) {
      j = i + 1;
    }
    if (j >= 4)
    {
      AppMethodBeat.o(73376);
      return 7;
    }
    i = 68;
    for (j = 0; i < 74; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3)
    {
      AppMethodBeat.o(73376);
      return 1;
    }
    i = 82;
    for (j = 0; i <= 88; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3)
    {
      AppMethodBeat.o(73376);
      return 4;
    }
    i = 75;
    for (j = 0; i <= 81; j = k)
    {
      k = j;
      if (paramArrayOfFloat[(i - 1)] < 0.7F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 3)
    {
      AppMethodBeat.o(73376);
      return 2;
    }
    AppMethodBeat.o(73376);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTFaceUtils
 * JD-Core Version:    0.7.0.1
 */