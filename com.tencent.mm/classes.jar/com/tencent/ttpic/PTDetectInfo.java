package com.tencent.ttpic;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTDetectInfo
{
  public List<PointF> bodyPoints;
  public Map<Integer, FaceActionCounter> faceActionCounter;
  public float[] faceAngles;
  public VideoPreviewFaceOutlineDetector faceDetector;
  public List<PointF> facePoints;
  public Map<Integer, HandActionCounter> handActionCounter;
  public List<PointF> handPoints;
  public float phoneAngle;
  public long timestamp;
  public Set<Integer> triggeredExpression;
  
  private PTDetectInfo() {}
  
  public PTDetectInfo(PTDetectInfo.Builder paramBuilder)
  {
    AppMethodBeat.i(81564);
    this.facePoints = PTDetectInfo.Builder.access$000(paramBuilder);
    this.faceAngles = PTDetectInfo.Builder.access$100(paramBuilder);
    this.faceActionCounter = PTDetectInfo.Builder.access$200(paramBuilder);
    this.handPoints = PTDetectInfo.Builder.access$300(paramBuilder);
    this.handActionCounter = PTDetectInfo.Builder.access$400(paramBuilder);
    this.triggeredExpression = PTDetectInfo.Builder.access$500(paramBuilder);
    this.bodyPoints = PTDetectInfo.Builder.access$600(paramBuilder);
    this.phoneAngle = PTDetectInfo.Builder.access$700(paramBuilder);
    this.timestamp = PTDetectInfo.Builder.access$800(paramBuilder);
    this.faceDetector = PTDetectInfo.Builder.access$900(paramBuilder);
    AppMethodBeat.o(81564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.PTDetectInfo
 * JD-Core Version:    0.7.0.1
 */