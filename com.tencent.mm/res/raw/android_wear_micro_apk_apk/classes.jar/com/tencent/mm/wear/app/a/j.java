package com.tencent.mm.wear.app.a;

public final class j
  implements Runnable
{
  int aaO;
  byte[] aaR;
  int aaw;
  
  j(i parami, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.aaw = paramInt1;
    this.aaO = paramInt2;
    this.aaR = paramArrayOfByte;
  }
  
  public final void run()
  {
    if (i.b(this.aaQ) != null) {
      i.b(this.aaQ).a(this.aaw, this.aaO, this.aaR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.j
 * JD-Core Version:    0.7.0.1
 */