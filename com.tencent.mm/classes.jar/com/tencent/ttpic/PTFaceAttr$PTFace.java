package com.tencent.ttpic;

import android.graphics.PointF;
import java.util.List;
import java.util.Map;

public class PTFaceAttr$PTFace
{
  private Map<PTFaceAttr.PTExpression, Boolean> mExpressionRet;
  private float[] mFaceAngle = new float[3];
  private List<PointF> mFacePoints;
  
  public float[] getFaceAngle()
  {
    return this.mFaceAngle;
  }
  
  public List<PointF> getFacePoints()
  {
    return this.mFacePoints;
  }
  
  public void setFaceAngle(float[] paramArrayOfFloat)
  {
    this.mFaceAngle = paramArrayOfFloat;
  }
  
  public void setFacePoints(List<PointF> paramList)
  {
    this.mFacePoints = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.PTFaceAttr.PTFace
 * JD-Core Version:    0.7.0.1
 */