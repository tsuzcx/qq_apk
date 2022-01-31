package com.tencent.ttpic.util;

import com.tencent.filter.h;

public abstract interface OnTextureReadyListener
{
  public abstract boolean needWait();
  
  public abstract void onTextureReady(h paramh, boolean paramBoolean1, boolean paramBoolean2, double paramDouble);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.OnTextureReadyListener
 * JD-Core Version:    0.7.0.1
 */