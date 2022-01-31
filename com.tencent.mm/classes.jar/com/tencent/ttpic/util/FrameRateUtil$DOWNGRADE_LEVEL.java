package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.MediaConfig;

public enum FrameRateUtil$DOWNGRADE_LEVEL
{
  public int bps;
  public int value;
  public int width;
  
  static
  {
    AppMethodBeat.i(83920);
    HIGH = new DOWNGRADE_LEVEL("HIGH", 0, 0, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_HIGH, MediaConfig.BPS_HIGH);
    MEDIUM = new DOWNGRADE_LEVEL("MEDIUM", 1, 1, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM, MediaConfig.BPS_MEDIUM);
    LOW = new DOWNGRADE_LEVEL("LOW", 2, 2, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW, MediaConfig.BPS_LOW);
    $VALUES = new DOWNGRADE_LEVEL[] { HIGH, MEDIUM, LOW };
    AppMethodBeat.o(83920);
  }
  
  private FrameRateUtil$DOWNGRADE_LEVEL(int paramInt1, int paramInt2, int paramInt3)
  {
    this.value = paramInt1;
    this.width = paramInt2;
    this.bps = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtil.DOWNGRADE_LEVEL
 * JD-Core Version:    0.7.0.1
 */