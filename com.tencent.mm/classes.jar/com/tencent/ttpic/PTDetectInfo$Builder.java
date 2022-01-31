package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo$Builder
{
  private List<PointF> bodyPoints;
  private Map<Integer, FaceActionCounter> faceActionCounter;
  private float[] faceAngles;
  private VideoPreviewFaceOutlineDetector faceDetector;
  private List<PointF> facePoints;
  private Map<Integer, HandActionCounter> handActionCounter;
  private List<PointF> handPoints;
  private float phoneAngle;
  private long timestamp;
  private Set<Integer> triggeredExpression;
  
  public Builder bodyPoints(List<PointF> paramList)
  {
    this.bodyPoints = paramList;
    return this;
  }
  
  public PTDetectInfo build()
  {
    AppMethodBeat.i(81563);
    PTDetectInfo localPTDetectInfo = new PTDetectInfo(this);
    AppMethodBeat.o(81563);
    return localPTDetectInfo;
  }
  
  public Builder faceActionCounter(Map<Integer, FaceActionCounter> paramMap)
  {
    this.faceActionCounter = paramMap;
    return this;
  }
  
  public Builder faceAngles(float[] paramArrayOfFloat)
  {
    this.faceAngles = paramArrayOfFloat;
    return this;
  }
  
  public Builder faceDetector(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.faceDetector = paramVideoPreviewFaceOutlineDetector;
    return this;
  }
  
  public Builder facePoints(List<PointF> paramList)
  {
    this.facePoints = paramList;
    return this;
  }
  
  public Builder handActionCounter(Map<Integer, HandActionCounter> paramMap)
  {
    this.handActionCounter = paramMap;
    return this;
  }
  
  public Builder handPoints(List<PointF> paramList)
  {
    this.handPoints = paramList;
    return this;
  }
  
  public Builder phoneAngle(float paramFloat)
  {
    this.phoneAngle = paramFloat;
    return this;
  }
  
  public Builder timestamp(long paramLong)
  {
    this.timestamp = paramLong;
    return this;
  }
  
  public Builder triggeredExpression(Set<Integer> paramSet)
  {
    this.triggeredExpression = paramSet;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.PTDetectInfo.Builder
 * JD-Core Version:    0.7.0.1
 */