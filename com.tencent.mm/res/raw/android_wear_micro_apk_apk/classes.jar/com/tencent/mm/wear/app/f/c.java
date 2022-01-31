package com.tencent.mm.wear.app.f;

public final class c
  implements Runnable
{
  int aaO;
  int aaw;
  byte[] data;
  
  c(b paramb, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.aaO = paramInt1;
    this.aaw = paramInt2;
    this.data = paramArrayOfByte;
  }
  
  public final void run()
  {
    if (b.a(this.aeq) != null) {
      b.a(this.aeq).b(this.aaO, this.aaw, this.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.c
 * JD-Core Version:    0.7.0.1
 */