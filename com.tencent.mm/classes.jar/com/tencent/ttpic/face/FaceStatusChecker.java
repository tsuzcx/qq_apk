package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.ValueRange;

public abstract interface FaceStatusChecker
{
  public abstract float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange);
  
  public abstract boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.ValueRange paramValueRange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.FaceStatusChecker
 * JD-Core Version:    0.7.0.1
 */