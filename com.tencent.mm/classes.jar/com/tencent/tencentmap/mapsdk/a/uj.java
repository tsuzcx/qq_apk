package com.tencent.tencentmap.mapsdk.a;

public abstract class uj
  extends sk
{
  public uj(int paramInt) {}
  
  protected static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    paramInt1 = i;
    if (i * paramInt2 < 0) {
      paramInt1 = i + paramInt2;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uj
 * JD-Core Version:    0.7.0.1
 */