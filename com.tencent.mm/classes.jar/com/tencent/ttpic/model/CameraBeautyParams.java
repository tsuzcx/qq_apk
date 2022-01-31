package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraBeautyParams
  implements Serializable
{
  public static final int RESHAPE_FILTER_ID_EYEBROW_ANGLE = 23;
  public static final int RESHAPE_FILTER_ID_EYEBROW_DISTANCE = 21;
  public static final int RESHAPE_FILTER_ID_EYEBROW_HEIGHT = 20;
  public static final int RESHAPE_FILTER_ID_EYES_ANGLE = 5;
  public static final int RESHAPE_FILTER_ID_EYES_DISTANCE = 6;
  public static final int RESHAPE_FILTER_ID_EYES_HEIGHT = 3;
  public static final int RESHAPE_FILTER_ID_EYES_SIZE = 4;
  public static final int RESHAPE_FILTER_ID_EYES_WIDTH = 2;
  public static final int RESHAPE_FILTER_ID_FACEOFF = 0;
  public static final int RESHAPE_FILTER_ID_FACE_JAW = 17;
  public static final int RESHAPE_FILTER_ID_FACE_SMILE = 16;
  public static final int RESHAPE_FILTER_ID_FACE_V = 19;
  public static final int RESHAPE_FILTER_ID_FACE_WIDTH = 18;
  public static final int RESHAPE_FILTER_ID_FOREHEAD_HEIGHT = 22;
  public static final int RESHAPE_FILTER_ID_LIPS_HEIGHT = 13;
  public static final int RESHAPE_FILTER_ID_LIPS_POSITION = 15;
  public static final int RESHAPE_FILTER_ID_LIPS_SIZE = 12;
  public static final int RESHAPE_FILTER_ID_LIPS_WIDTH = 14;
  public static final int RESHAPE_FILTER_ID_NOSE_BRIDGE_WIDTH = 9;
  public static final int RESHAPE_FILTER_ID_NOSE_OUTLINE_WIDTH = 8;
  public static final int RESHAPE_FILTER_ID_NOSE_POSITION = 10;
  public static final int RESHAPE_FILTER_ID_NOSE_SIZE = 7;
  public static final int RESHAPE_FILTER_ID_NOSE_TIP_SIZE = 11;
  public static final int RESHAPE_FILTER_ID_TOTAL = 1;
  public static List<Integer> RESHAPE_OTHER_FACE_PARAM;
  public static final int[] RESHAPE_WHOLE_FACE_PARAM;
  public float[] mProgress;
  public Map<String, Object> param;
  
  static
  {
    AppMethodBeat.i(83460);
    RESHAPE_WHOLE_FACE_PARAM = new int[] { 16, 17, 18, 19, 22 };
    RESHAPE_OTHER_FACE_PARAM = new ArrayList();
    int i = 0;
    while (i < 24)
    {
      if (!isInWholeFaceParam(i)) {
        RESHAPE_OTHER_FACE_PARAM.add(Integer.valueOf(i));
      }
      i += 1;
    }
    AppMethodBeat.o(83460);
  }
  
  public CameraBeautyParams()
  {
    AppMethodBeat.i(83454);
    this.mProgress = new float[24];
    this.param = new HashMap();
    AppMethodBeat.o(83454);
  }
  
  private static boolean isInWholeFaceParam(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = RESHAPE_WHOLE_FACE_PARAM;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean needRender()
  {
    AppMethodBeat.i(83459);
    if ((needRenderEyeNoseLips()) || (needRenderWholeFace()))
    {
      AppMethodBeat.o(83459);
      return true;
    }
    AppMethodBeat.o(83459);
    return false;
  }
  
  public boolean needRenderEyeNoseLips()
  {
    AppMethodBeat.i(83458);
    Iterator localIterator = RESHAPE_OTHER_FACE_PARAM.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (Math.abs(this.mProgress[i]) > 0.001D)
      {
        AppMethodBeat.o(83458);
        return true;
      }
    }
    AppMethodBeat.o(83458);
    return false;
  }
  
  public boolean needRenderWholeFace()
  {
    AppMethodBeat.i(83457);
    int[] arrayOfInt = RESHAPE_WHOLE_FACE_PARAM;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (Math.abs(this.mProgress[k]) > 0.001D)
      {
        AppMethodBeat.o(83457);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(83457);
    return false;
  }
  
  public void setParam(int paramInt, float paramFloat)
  {
    if (paramInt == BeautyRealConfig.TYPE.FOREHEAD.value) {
      this.mProgress[22] = paramFloat;
    }
    do
    {
      return;
      if (paramInt == BeautyRealConfig.TYPE.EYE.value)
      {
        this.mProgress[4] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.EYE_DISTANCE.value)
      {
        this.mProgress[6] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.EYE_ANGLE.value)
      {
        this.mProgress[5] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.MOUTH_SHAPE.value)
      {
        this.mProgress[12] = (-paramFloat);
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.CHIN.value)
      {
        this.mProgress[17] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.FACE_THIN.value)
      {
        this.mProgress[18] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.FACE_V.value)
      {
        this.mProgress[19] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.NOSE_WING.value)
      {
        this.mProgress[8] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.NOSE_POSITION.value)
      {
        this.mProgress[10] = paramFloat;
        return;
      }
      if (paramInt == BeautyRealConfig.TYPE.LIPS_THICKNESS.value)
      {
        this.mProgress[13] = paramFloat;
        return;
      }
    } while (paramInt != BeautyRealConfig.TYPE.LIPS_WIDTH.value);
    this.mProgress[14] = paramFloat;
  }
  
  public void updateReshapeParams()
  {
    AppMethodBeat.i(83455);
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
    this.param.put("faceWidth", Float.valueOf(this.mProgress[18]));
    this.param.put("faceWidth2", Float.valueOf(this.mProgress[19]));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
    AppMethodBeat.o(83455);
  }
  
  public void updateReshapeParams4()
  {
    AppMethodBeat.i(83456);
    this.param.clear();
    this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
    this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
    this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
    this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
    this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
    this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
    this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
    this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
    this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
    this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
    this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
    this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
    this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
    this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
    this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
    this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
    this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
    this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
    this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
    this.param.put("faceWidth", Float.valueOf(this.mProgress[18]));
    this.param.put("faceWidth2", Float.valueOf(this.mProgress[19]));
    this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
    AppMethodBeat.o(83456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraBeautyParams
 * JD-Core Version:    0.7.0.1
 */