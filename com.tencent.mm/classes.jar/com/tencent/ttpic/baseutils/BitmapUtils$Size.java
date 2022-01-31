package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BitmapUtils$Size
{
  public int height;
  public int width;
  
  public BitmapUtils$Size(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(49598);
    String str = "Size{width=" + this.width + ", height=" + this.height + '}';
    AppMethodBeat.o(49598);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BitmapUtils.Size
 * JD-Core Version:    0.7.0.1
 */