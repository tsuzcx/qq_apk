package com.tencent.mm.wear.app.f;

public final class c
  implements Runnable
{
  int adX;
  int aep;
  byte[] data;
  
  c(b paramb, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.aep = paramInt1;
    this.adX = paramInt2;
    this.data = paramArrayOfByte;
  }
  
  public final void run()
  {
    if (b.a(this.ahS) != null) {
      b.a(this.ahS).b(this.aep, this.adX, this.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.c
 * JD-Core Version:    0.7.0.1
 */