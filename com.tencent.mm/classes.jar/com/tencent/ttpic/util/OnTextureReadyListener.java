package com.tencent.ttpic.util;

import com.tencent.filter.h;
import com.tencent.ttpic.filter.VideoFilterList;

public abstract interface OnTextureReadyListener
{
  public abstract void justGetImageData(boolean paramBoolean);
  
  public abstract boolean needWait();
  
  public abstract void onTextureReady(h paramh, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, VideoFilterList paramVideoFilterList, int paramInt);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.OnTextureReadyListener
 * JD-Core Version:    0.7.0.1
 */