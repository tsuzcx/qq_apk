package com.tencent.ttpic.util;

import com.tencent.filter.h;

public abstract interface OnSegmentReadyListener
{
  public abstract boolean needWait();
  
  public abstract void onTextureReady(h paramh, boolean paramBoolean);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.OnSegmentReadyListener
 * JD-Core Version:    0.7.0.1
 */