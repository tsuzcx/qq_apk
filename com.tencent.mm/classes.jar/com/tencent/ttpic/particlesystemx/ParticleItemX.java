package com.tencent.ttpic.particlesystemx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.particlesystem2d.Particle;

public class ParticleItemX
{
  private static final String TAG;
  public float emitterX;
  public float emitterY;
  public Particle[] particles;
  public float screenRatioScale = 1.0F;
  
  static
  {
    AppMethodBeat.i(83660);
    TAG = ParticleItemX.class.getSimpleName();
    AppMethodBeat.o(83660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.particlesystemx.ParticleItemX
 * JD-Core Version:    0.7.0.1
 */