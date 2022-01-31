package com.tencent.ttpic;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTFaceAttr
{
  private List<BodyDetectResult> bodyDetectResult;
  private List<List<PointF>> bodyPoints;
  private int[] brightnessAdjustmentCurve;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private Pair<Integer, int[]> histogram;
  private h mCorrectFrame;
  private byte[] mData;
  private boolean mEnableDenoise;
  private Map<Integer, FaceActionCounter> mFaceActionCounter;
  private double mFaceDetectScale;
  private Map<PTExpression, Boolean> mFaceExpression;
  private List<PTFaceAttr.PTFace> mFaceInfos;
  private List<FaceStatus> mFaceStatusList;
  private float[] mHandAngles;
  private List<PointF> mHandPoints;
  private h mOrigFrame;
  private h mOrigLargeFrame;
  private int mRotation;
  private long mTimeStamp;
  private Set<Integer> mTriggeredExpression;
  
  public static PTFaceAttr genFaceAttr(List<List<PointF>> paramList1, List<List<PointF>> paramList2, List<float[]> paramList, Set<Integer> paramSet, List<PointF> paramList3, float[] paramArrayOfFloat, List<FaceStatus> paramList4, List<BodyDetectResult> paramList5, double paramDouble, byte[] paramArrayOfByte, boolean paramBoolean, h paramh1, h paramh2, h paramh3, int paramInt, int[] paramArrayOfInt, Map<Integer, FaceActionCounter> paramMap, Pair<Integer, int[]> paramPair, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    AppMethodBeat.i(81572);
    PTFaceAttr localPTFaceAttr = new PTFaceAttr();
    localPTFaceAttr.setTimeStamp(System.currentTimeMillis());
    localPTFaceAttr.setData(paramArrayOfByte);
    localPTFaceAttr.setRotation(paramInt);
    localPTFaceAttr.setTriggeredExpression(paramSet);
    localPTFaceAttr.setFaceDetector(paramVideoPreviewFaceOutlineDetector);
    paramArrayOfByte = new ArrayList();
    paramInt = 0;
    while (paramInt < paramList1.size())
    {
      paramVideoPreviewFaceOutlineDetector = new PTFaceAttr.PTFace();
      paramVideoPreviewFaceOutlineDetector.setFacePoints((List)paramList1.get(paramInt));
      paramVideoPreviewFaceOutlineDetector.setIrisPoints((List)paramList2.get(paramInt));
      paramVideoPreviewFaceOutlineDetector.setFaceAngle((float[])paramList.get(paramInt));
      paramArrayOfByte.add(paramVideoPreviewFaceOutlineDetector);
      paramInt += 1;
    }
    paramList2 = new HashMap();
    paramList1 = paramSet;
    if (paramSet == null)
    {
      paramList1 = new HashSet();
      paramList1.add(Integer.valueOf(1));
    }
    paramList = PTExpression.values();
    int i = paramList.length;
    paramInt = 0;
    if (paramInt < i)
    {
      paramSet = paramList[paramInt];
      if (paramList1.contains(Integer.valueOf(paramSet.value))) {
        paramList2.put(paramSet, Boolean.TRUE);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramList2.put(paramSet, Boolean.FALSE);
      }
    }
    paramList1 = new ArrayList();
    if ((paramList5 != null) && (!paramList5.isEmpty()))
    {
      paramList = paramList5.iterator();
      while (paramList.hasNext())
      {
        paramSet = (BodyDetectResult)paramList.next();
        if ((paramSet.bodyPoints != null) && (!paramSet.bodyPoints.isEmpty()))
        {
          paramVideoPreviewFaceOutlineDetector = new ArrayList();
          paramInt = 0;
          while (paramInt < paramSet.bodyPoints.size())
          {
            paramVideoPreviewFaceOutlineDetector.add(new PointF(((PointF)paramSet.bodyPoints.get(paramInt)).x, ((PointF)paramSet.bodyPoints.get(paramInt)).y));
            paramInt += 1;
          }
          paramList1.add(paramVideoPreviewFaceOutlineDetector);
        }
      }
    }
    localPTFaceAttr.setFaceInfos(paramArrayOfByte);
    localPTFaceAttr.setFaceExpression(paramList2);
    localPTFaceAttr.setHandPoints(paramList3);
    localPTFaceAttr.setHandAngles(paramArrayOfFloat);
    localPTFaceAttr.setBodyDetectResult(paramList5);
    localPTFaceAttr.setBodyPoints(paramList1);
    localPTFaceAttr.setFaceStatusList(paramList4);
    localPTFaceAttr.setFaceDetectScale(paramDouble);
    localPTFaceAttr.setEnableDenoise(paramBoolean);
    localPTFaceAttr.setOrigFrame(paramh1);
    localPTFaceAttr.setOrigLargeFrame(paramh2);
    localPTFaceAttr.setCorrectFrame(paramh3);
    localPTFaceAttr.setFaceActionCounter(paramMap);
    localPTFaceAttr.setHistogram(paramPair);
    if (paramArrayOfInt != null) {
      localPTFaceAttr.setBrightnessAdjustmentCurve(paramArrayOfInt);
    }
    AppMethodBeat.o(81572);
    return localPTFaceAttr;
  }
  
  public List<float[]> getAllFaceAngles()
  {
    AppMethodBeat.i(81571);
    if (this.mFaceInfos == null)
    {
      AppMethodBeat.o(81571);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mFaceInfos.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((PTFaceAttr.PTFace)localIterator.next()).getFaceAngle());
    }
    AppMethodBeat.o(81571);
    return localArrayList;
  }
  
  public List<List<PointF>> getAllFacePoints()
  {
    AppMethodBeat.i(81569);
    ArrayList localArrayList = new ArrayList();
    if (this.mFaceInfos == null)
    {
      AppMethodBeat.o(81569);
      return localArrayList;
    }
    Iterator localIterator = this.mFaceInfos.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((PTFaceAttr.PTFace)localIterator.next()).getFacePoints());
    }
    AppMethodBeat.o(81569);
    return localArrayList;
  }
  
  public List<List<PointF>> getAllIrisPoints()
  {
    AppMethodBeat.i(81570);
    if (this.mFaceInfos == null)
    {
      AppMethodBeat.o(81570);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mFaceInfos.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((PTFaceAttr.PTFace)localIterator.next()).getIrisPoints());
    }
    AppMethodBeat.o(81570);
    return localArrayList;
  }
  
  public List<BodyDetectResult> getBodyDetectResult()
  {
    return this.bodyDetectResult;
  }
  
  public List<List<PointF>> getBodyPoints()
  {
    return this.bodyPoints;
  }
  
  public int[] getBrightnessAdjustmentCurve()
  {
    return this.brightnessAdjustmentCurve;
  }
  
  public h getCorrectFrame()
  {
    return this.mCorrectFrame;
  }
  
  public byte[] getData()
  {
    return this.mData;
  }
  
  public Map<Integer, FaceActionCounter> getFaceActionCounter()
  {
    return this.mFaceActionCounter;
  }
  
  public int getFaceCount()
  {
    AppMethodBeat.i(81573);
    int i = this.mFaceInfos.size();
    AppMethodBeat.o(81573);
    return i;
  }
  
  public double getFaceDetectScale()
  {
    return this.mFaceDetectScale;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    return this.faceDetector;
  }
  
  public Map<PTExpression, Boolean> getFaceExpression()
  {
    return this.mFaceExpression;
  }
  
  public List<PTFaceAttr.PTFace> getFaceInfos()
  {
    return this.mFaceInfos;
  }
  
  public List<FaceStatus> getFaceStatusList()
  {
    return this.mFaceStatusList;
  }
  
  public float[] getHandAngles()
  {
    return this.mHandAngles;
  }
  
  public List<PointF> getHandPoints()
  {
    return this.mHandPoints;
  }
  
  public Pair<Integer, int[]> getHistogram()
  {
    return this.histogram;
  }
  
  public h getOrigFrame()
  {
    return this.mOrigFrame;
  }
  
  public h getOrigLargeFrame()
  {
    return this.mOrigLargeFrame;
  }
  
  public int getRotation()
  {
    return this.mRotation;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  public Set<Integer> getTriggeredExpression()
  {
    return this.mTriggeredExpression;
  }
  
  public boolean isEnableDenoise()
  {
    return this.mEnableDenoise;
  }
  
  public boolean isLandscape()
  {
    return (this.mRotation == 90) || (this.mRotation == 270);
  }
  
  public void setBodyDetectResult(List<BodyDetectResult> paramList)
  {
    this.bodyDetectResult = paramList;
  }
  
  public void setBodyPoints(List<List<PointF>> paramList)
  {
    this.bodyPoints = paramList;
  }
  
  public void setBrightnessAdjustmentCurve(int[] paramArrayOfInt)
  {
    this.brightnessAdjustmentCurve = paramArrayOfInt;
  }
  
  public void setCorrectFrame(h paramh)
  {
    this.mCorrectFrame = paramh;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public void setEnableDenoise(boolean paramBoolean)
  {
    this.mEnableDenoise = paramBoolean;
  }
  
  public void setFaceActionCounter(Map<Integer, FaceActionCounter> paramMap)
  {
    this.mFaceActionCounter = paramMap;
  }
  
  public void setFaceDetectScale(double paramDouble)
  {
    this.mFaceDetectScale = paramDouble;
  }
  
  public void setFaceDetector(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
  }
  
  public void setFaceExpression(Map<PTExpression, Boolean> paramMap)
  {
    this.mFaceExpression = paramMap;
  }
  
  public void setFaceInfos(List<PTFaceAttr.PTFace> paramList)
  {
    this.mFaceInfos = paramList;
  }
  
  public void setFaceStatusList(List<FaceStatus> paramList)
  {
    this.mFaceStatusList = paramList;
  }
  
  public void setHandAngles(float[] paramArrayOfFloat)
  {
    this.mHandAngles = paramArrayOfFloat;
  }
  
  public void setHandPoints(List<PointF> paramList)
  {
    this.mHandPoints = paramList;
  }
  
  public void setHistogram(Pair<Integer, int[]> paramPair)
  {
    this.histogram = paramPair;
  }
  
  public void setOrigFrame(h paramh)
  {
    this.mOrigFrame = paramh;
  }
  
  public void setOrigLargeFrame(h paramh)
  {
    this.mOrigLargeFrame = paramh;
  }
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
  }
  
  public void setTriggeredExpression(Set<Integer> paramSet)
  {
    this.mTriggeredExpression = paramSet;
  }
  
  public static enum PTExpression
  {
    public static final PTExpression[] ACTION_TRIGGER_TYPE;
    public PTExpression opposite;
    public final int value;
    
    static
    {
      AppMethodBeat.i(81567);
      UNKNOW = new PTExpression("UNKNOW", 0, 0);
      ALWAYS = new PTExpression("ALWAYS", 1, 1);
      FACE_DETECT = new PTExpression("FACE_DETECT", 2, 2);
      MOUTH_OPEN = new PTExpression("MOUTH_OPEN", 3, 3);
      EYEBROWS_RAISE = new PTExpression("EYEBROWS_RAISE", 4, 4);
      BLINK = new PTExpression("BLINK", 5, 5);
      HEAD_SHAKE = new PTExpression("HEAD_SHAKE", 6, 6);
      KISS = new PTExpression("KISS", 7, 7);
      BLINK_LEFT_EYE = new PTExpression("BLINK_LEFT_EYE", 8, 8);
      BLINK_RIGHT_EYE = new PTExpression("BLINK_RIGHT_EYE", 9, 9);
      HEAD_NOD = new PTExpression("HEAD_NOD", 10, 10);
      HEAD_SHAKE_NEW = new PTExpression("HEAD_SHAKE_NEW", 11, 11);
      TRY_CLICK_SCREEN = new PTExpression("TRY_CLICK_SCREEN", 12, 12);
      MV_PART_INDEX = new PTExpression("MV_PART_INDEX", 13, 13);
      FACE_NO_NOUTH = new PTExpression("FACE_NO_NOUTH", 14, 103, MOUTH_OPEN);
      FACE_NO_EYEBROWS = new PTExpression("FACE_NO_EYEBROWS", 15, 104, EYEBROWS_RAISE);
      FACE_NO_BLINK = new PTExpression("FACE_NO_BLINK", 16, 105, BLINK);
      FACE_NO_HEAD = new PTExpression("FACE_NO_HEAD", 17, 106, HEAD_SHAKE);
      FACE_NO_KISS = new PTExpression("FACE_NO_KISS", 18, 107, KISS);
      HAND_LABEL_HAND = new PTExpression("HAND_LABEL_HAND", 19, 200);
      HAND_LABEL_HEART = new PTExpression("HAND_LABEL_HEART", 20, 201);
      HAND_LABEL_PAPER = new PTExpression("HAND_LABEL_PAPER", 21, 202);
      HAND_LABEL_SCISSOR = new PTExpression("HAND_LABEL_SCISSOR", 22, 203);
      HAND_LABEL_FIST = new PTExpression("HAND_LABEL_FIST", 23, 204);
      HAND_LABEL_ONE = new PTExpression("HAND_LABEL_ONE", 24, 205);
      HAND_LABEL_LOVE = new PTExpression("HAND_LABEL_LOVE", 25, 206);
      HAND_LABEL_LIKE = new PTExpression("HAND_LABEL_LIKE", 26, 207);
      HAND_LABEL_OK = new PTExpression("HAND_LABEL_OK", 27, 208);
      HAND_LABEL_ROCK = new PTExpression("HAND_LABEL_ROCK", 28, 209);
      HAND_LABEL_SIX = new PTExpression("HAND_LABEL_SIX", 29, 210);
      HAND_LABEL_EIGHT = new PTExpression("HAND_LABEL_EIGHT", 30, 211);
      HAND_LABEL_LIFT = new PTExpression("HAND_LABEL_LIFT", 31, 212);
      HAND_LABEL_GOOD_FORTUNE = new PTExpression("HAND_LABEL_GOOD_FORTUNE", 32, 213);
      $VALUES = new PTExpression[] { UNKNOW, ALWAYS, FACE_DETECT, MOUTH_OPEN, EYEBROWS_RAISE, BLINK, HEAD_SHAKE, KISS, BLINK_LEFT_EYE, BLINK_RIGHT_EYE, HEAD_NOD, HEAD_SHAKE_NEW, TRY_CLICK_SCREEN, MV_PART_INDEX, FACE_NO_NOUTH, FACE_NO_EYEBROWS, FACE_NO_BLINK, FACE_NO_HEAD, FACE_NO_KISS, HAND_LABEL_HAND, HAND_LABEL_HEART, HAND_LABEL_PAPER, HAND_LABEL_SCISSOR, HAND_LABEL_FIST, HAND_LABEL_ONE, HAND_LABEL_LOVE, HAND_LABEL_LIKE, HAND_LABEL_OK, HAND_LABEL_ROCK, HAND_LABEL_SIX, HAND_LABEL_EIGHT, HAND_LABEL_LIFT, HAND_LABEL_GOOD_FORTUNE };
      ACTION_TRIGGER_TYPE = new PTExpression[] { MOUTH_OPEN, EYEBROWS_RAISE, BLINK, HEAD_SHAKE, KISS, BLINK_LEFT_EYE, BLINK_RIGHT_EYE, HEAD_NOD, HEAD_SHAKE_NEW, TRY_CLICK_SCREEN };
      AppMethodBeat.o(81567);
    }
    
    private PTExpression(int paramInt)
    {
      this.value = paramInt;
    }
    
    private PTExpression(int paramInt, PTExpression paramPTExpression)
    {
      this.value = paramInt;
      this.opposite = paramPTExpression;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.PTFaceAttr
 * JD-Core Version:    0.7.0.1
 */