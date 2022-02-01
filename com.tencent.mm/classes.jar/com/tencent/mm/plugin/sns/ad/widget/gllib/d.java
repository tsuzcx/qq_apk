package com.tencent.mm.plugin.sns.ad.widget.gllib;

public final class d
{
  public static float[] c(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramInt == 0) {
      return new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    }
    if (paramInt == 1)
    {
      if (paramFloat1 * 1.0F / paramFloat2 > paramFloat3 * 1.0F / paramFloat4)
      {
        paramFloat1 = paramFloat4 * 1.0F * paramFloat1 / paramFloat3;
        paramFloat3 = (paramFloat1 - paramFloat2) / 2.0F;
        paramFloat2 = paramFloat3 / paramFloat1;
        paramFloat1 = (paramFloat1 - paramFloat3) / paramFloat1;
        return new float[] { 0.0F, paramFloat2, 0.0F, paramFloat1, 1.0F, paramFloat2, 1.0F, paramFloat1 };
      }
      paramFloat2 = paramFloat3 * 1.0F * paramFloat2 / paramFloat4;
      paramFloat3 = (paramFloat2 - paramFloat1) / 2.0F;
      paramFloat1 = paramFloat3 / paramFloat2;
      paramFloat2 = (paramFloat2 - paramFloat3) / paramFloat2;
      return new float[] { paramFloat1, 0.0F, paramFloat1, 1.0F, paramFloat2, 0.0F, paramFloat2, 1.0F };
    }
    if (paramInt == 2)
    {
      if (paramFloat1 * 1.0F / paramFloat2 > paramFloat3 * 1.0F / paramFloat4)
      {
        paramFloat1 = paramFloat2 / (paramFloat4 * 1.0F * paramFloat1 / paramFloat3);
        return new float[] { 0.0F, 0.0F, 0.0F, paramFloat1, 1.0F, 0.0F, 1.0F, paramFloat1 };
      }
      paramFloat1 /= paramFloat3 * 1.0F * paramFloat2 / paramFloat4;
      return new float[] { 0.0F, 0.0F, 0.0F, 1.0F, paramFloat1, 0.0F, paramFloat1, 1.0F };
    }
    return new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.gllib.d
 * JD-Core Version:    0.7.0.1
 */