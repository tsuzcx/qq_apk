package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$TRANSITION
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84128);
    PARTICLE_COUNT_MAX = new TRANSITION("PARTICLE_COUNT_MAX", 0, "particleCountMax");
    LIFE = new TRANSITION("LIFE", 1, "life");
    EMISSION_MODE = new TRANSITION("EMISSION_MODE", 2, "emissionMode");
    PARTICLE_ALWAYS_UPDATE = new TRANSITION("PARTICLE_ALWAYS_UPDATE", 3, "particleAlwaysUpdate");
    EMISSION_RATE = new TRANSITION("EMISSION_RATE", 4, "emissionRate");
    SCALE = new TRANSITION("SCALE", 5, "scale");
    ROTATE = new TRANSITION("ROTATE", 6, "rotate");
    POSITION_X = new TRANSITION("POSITION_X", 7, "positionX");
    POSITION_Y = new TRANSITION("POSITION_Y", 8, "positionY");
    P0 = new TRANSITION("P0", 9, "p0");
    P1 = new TRANSITION("P1", 10, "p1");
    P2 = new TRANSITION("P2", 11, "p2");
    REPEAT_COUNT = new TRANSITION("REPEAT_COUNT", 12, "repeatCount");
    MIN_UPDATE_INTERVAL = new TRANSITION("MIN_UPDATE_INTERVAL", 13, "minUpdateInterval");
    CLEAR_MODE = new TRANSITION("CLEAR_MODE", 14, "clearMode");
    $VALUES = new TRANSITION[] { PARTICLE_COUNT_MAX, LIFE, EMISSION_MODE, PARTICLE_ALWAYS_UPDATE, EMISSION_RATE, SCALE, ROTATE, POSITION_X, POSITION_Y, P0, P1, P2, REPEAT_COUNT, MIN_UPDATE_INTERVAL, CLEAR_MODE };
    AppMethodBeat.o(84128);
  }
  
  private VideoMaterialUtil$TRANSITION(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.TRANSITION
 * JD-Core Version:    0.7.0.1
 */