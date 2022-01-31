package com.tencent.ttpic.filter;

import android.graphics.PointF;
import java.util.List;

class VideoFilterList$FaceData
{
  public float mFaceAngle;
  public List<PointF> mFacePoints;
  public float mPhoneAngle;
  public long mTimeStamp;
  
  private VideoFilterList$FaceData(VideoFilterList paramVideoFilterList) {}
  
  public void init(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    this.mFacePoints = paramList;
    this.mFaceAngle = paramFloat1;
    this.mPhoneAngle = paramFloat2;
    this.mTimeStamp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterList.FaceData
 * JD-Core Version:    0.7.0.1
 */