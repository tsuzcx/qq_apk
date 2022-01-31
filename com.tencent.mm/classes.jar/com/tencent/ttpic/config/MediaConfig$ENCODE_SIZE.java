package com.tencent.ttpic.config;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MediaConfig$ENCODE_SIZE
{
  public final int height;
  public final int width;
  
  static
  {
    AppMethodBeat.i(49802);
    HIGH = new ENCODE_SIZE("HIGH", 0, 720, 1280);
    MEDIUM = new ENCODE_SIZE("MEDIUM", 1, 576, 1024);
    LOW = new ENCODE_SIZE("LOW", 2, 432, 768);
    $VALUES = new ENCODE_SIZE[] { HIGH, MEDIUM, LOW };
    AppMethodBeat.o(49802);
  }
  
  private MediaConfig$ENCODE_SIZE(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.config.MediaConfig.ENCODE_SIZE
 * JD-Core Version:    0.7.0.1
 */