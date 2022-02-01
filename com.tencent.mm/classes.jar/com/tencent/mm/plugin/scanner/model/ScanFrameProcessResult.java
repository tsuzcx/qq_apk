package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanFrameProcessResult
{
  public byte[] bestImageData;
  public int height;
  public float maxX;
  public float maxY;
  public float minX;
  public float minY;
  public int result;
  public boolean shouldJump;
  public int width;
  
  public ScanFrameProcessResult()
  {
    AppMethodBeat.i(51650);
    this.result = 0;
    this.width = 0;
    this.height = 0;
    this.bestImageData = new byte[0];
    AppMethodBeat.o(51650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ScanFrameProcessResult
 * JD-Core Version:    0.7.0.1
 */