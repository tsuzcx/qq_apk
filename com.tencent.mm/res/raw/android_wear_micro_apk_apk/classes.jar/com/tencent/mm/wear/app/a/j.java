package com.tencent.mm.wear.app.a;

public final class j
  implements Runnable
{
  int adX;
  int aep;
  byte[] aes;
  
  j(i parami, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.adX = paramInt1;
    this.aep = paramInt2;
    this.aes = paramArrayOfByte;
  }
  
  public final void run()
  {
    if (i.b(this.aer) != null) {
      i.b(this.aer).a(this.adX, this.aep, this.aes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.j
 * JD-Core Version:    0.7.0.1
 */