package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Particle
{
  public float angle;
  public Vector4 color;
  public float degreesPerSecond;
  public Vector4 deltaColor;
  public Vector2 direction;
  public float particleSize;
  public float particleSizeDelta;
  public Vector2 position;
  public float radialAcceleration;
  public float radius;
  public float radiusDelta;
  public float rotation;
  public float rotationDelta;
  public Vector2 startPos;
  public float tangentialAcceleration;
  public float timeToLive;
  
  public Particle()
  {
    AppMethodBeat.i(83604);
    this.position = new Vector2();
    this.direction = new Vector2();
    this.startPos = new Vector2();
    this.color = new Vector4();
    this.deltaColor = new Vector4();
    AppMethodBeat.o(83604);
  }
  
  public void copy(Particle paramParticle)
  {
    AppMethodBeat.i(83605);
    this.position.copy(paramParticle.position);
    this.direction.copy(paramParticle.direction);
    this.startPos.copy(paramParticle.startPos);
    this.color.copy(paramParticle.color);
    this.deltaColor.copy(paramParticle.deltaColor);
    this.rotation = paramParticle.rotation;
    this.rotationDelta = paramParticle.rotationDelta;
    this.radialAcceleration = paramParticle.radialAcceleration;
    this.tangentialAcceleration = paramParticle.tangentialAcceleration;
    this.radius = paramParticle.radius;
    this.radiusDelta = paramParticle.radiusDelta;
    this.angle = paramParticle.angle;
    this.degreesPerSecond = paramParticle.degreesPerSecond;
    this.particleSize = paramParticle.particleSize;
    this.particleSizeDelta = paramParticle.particleSizeDelta;
    this.timeToLive = paramParticle.timeToLive;
    AppMethodBeat.o(83605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.particle.Particle
 * JD-Core Version:    0.7.0.1
 */