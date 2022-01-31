package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum ParticleEmitter$kParticleTypes
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(83608);
    kParticleTypeGravity = new kParticleTypes("kParticleTypeGravity", 0, 0);
    kParticleTypeRadial = new kParticleTypes("kParticleTypeRadial", 1, 1);
    $VALUES = new kParticleTypes[] { kParticleTypeGravity, kParticleTypeRadial };
    AppMethodBeat.o(83608);
  }
  
  private ParticleEmitter$kParticleTypes(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter.kParticleTypes
 * JD-Core Version:    0.7.0.1
 */