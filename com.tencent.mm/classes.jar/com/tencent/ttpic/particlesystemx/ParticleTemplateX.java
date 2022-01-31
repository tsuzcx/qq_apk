package com.tencent.ttpic.particlesystemx;

public class ParticleTemplateX
{
  double mEmitRate;
  String mIdx = "0";
  String mLife = "0";
  int mMaxCount;
  String mP0 = "0";
  String mP1 = "0";
  String mP2 = "0";
  String mPosX = "0";
  String mPosY = "0";
  String mRotate = "0";
  String mScale = "0";
  
  ParticleTemplateX(int paramInt, double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.mMaxCount = paramInt;
    this.mEmitRate = paramDouble;
    this.mLife = paramString1;
    this.mPosX = paramString2;
    this.mPosY = paramString3;
    this.mScale = paramString4;
    this.mRotate = paramString5;
    this.mP0 = paramString6;
    this.mP1 = paramString7;
    this.mP2 = paramString8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.particlesystemx.ParticleTemplateX
 * JD-Core Version:    0.7.0.1
 */