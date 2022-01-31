package com.tencent.ttpic.particle;

public class ParticleConfig
{
  public ParticleConfig.ParticleEmitterConfigBean particleEmitterConfig;
  
  public ParticleConfig.ParticleEmitterConfigBean getParticleEmitterConfig()
  {
    return this.particleEmitterConfig;
  }
  
  public void setParticleEmitterConfig(ParticleConfig.ParticleEmitterConfigBean paramParticleEmitterConfigBean)
  {
    this.particleEmitterConfig = paramParticleEmitterConfigBean;
  }
  
  public static class ParticleEmitterConfigBean$MaxRadiusBean
  {
    public float value;
    
    public float getValue()
    {
      return this.value;
    }
    
    public void setValue(float paramFloat)
    {
      this.value = paramFloat;
    }
  }
  
  public static class ParticleEmitterConfigBean$ParticleLifespanVarianceBean
  {
    public float value;
    
    public float getValue()
    {
      return this.value;
    }
    
    public void setValue(float paramFloat)
    {
      this.value = paramFloat;
    }
  }
  
  public static class ParticleEmitterConfigBean$SourcePositionVarianceBean
  {
    public float x;
    public float y;
    
    public float getX()
    {
      return this.x;
    }
    
    public float getY()
    {
      return this.y;
    }
    
    public void setX(float paramFloat)
    {
      this.x = paramFloat;
    }
    
    public void setY(float paramFloat)
    {
      this.y = paramFloat;
    }
  }
  
  public static class ParticleEmitterConfigBean$SpeedVarianceBean
  {
    public float value;
    
    public float getValue()
    {
      return this.value;
    }
    
    public void setValue(float paramFloat)
    {
      this.value = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleConfig
 * JD-Core Version:    0.7.0.1
 */