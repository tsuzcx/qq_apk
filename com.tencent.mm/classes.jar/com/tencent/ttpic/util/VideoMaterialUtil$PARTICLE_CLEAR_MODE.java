package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$PARTICLE_CLEAR_MODE
{
  public int value;
  
  static
  {
    AppMethodBeat.i(84116);
    DO_NOT_CLEAR = new PARTICLE_CLEAR_MODE("DO_NOT_CLEAR", 0, 0);
    CLEAR_ALL = new PARTICLE_CLEAR_MODE("CLEAR_ALL", 1, 1);
    $VALUES = new PARTICLE_CLEAR_MODE[] { DO_NOT_CLEAR, CLEAR_ALL };
    AppMethodBeat.o(84116);
  }
  
  private VideoMaterialUtil$PARTICLE_CLEAR_MODE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.PARTICLE_CLEAR_MODE
 * JD-Core Version:    0.7.0.1
 */