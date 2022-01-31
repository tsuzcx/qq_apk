package com.tencent.qqpinyin.voicerecoapi;

public final class c
{
  private int eLM;
  private int gRb;
  private TRVADNative wKm = new TRVADNative();
  
  public c()
  {
    this.eLM = 500000;
    this.gRb = 10000000;
  }
  
  public c(int paramInt)
  {
    this.eLM = paramInt;
    this.gRb = 5000000;
  }
  
  public final void a(short[] paramArrayOfShort, int paramInt, c.a parama)
  {
    double d1 = 26.0D;
    if (paramInt <= 0) {
      return;
    }
    for (;;)
    {
      label55:
      label56:
      try
      {
        switch (this.wKm.mfeSendData(paramArrayOfShort, paramInt))
        {
        case 1: 
          parama.wKn = 0;
        }
      }
      finally {}
      parama.wKr = ((int)d1);
      new StringBuilder("volumn��").append(parama.wKr);
      break;
      parama.wKn = 1;
      break label183;
      parama.wKn = 2;
      break label183;
      parama.wKn = 3;
      int j;
      int i;
      label183:
      do
      {
        double d2 = j;
        double d3 = Math.sqrt(paramArrayOfShort[i] * paramArrayOfShort[i]);
        j = (int)(d2 + d3 / paramInt);
        i += 1;
        continue;
        if (j > 16383) {
          break label56;
        }
        d1 = 26.0D * ((j - 100.0D) / 32667.0D);
        break label56;
        break;
        i = 0;
        j = 0;
      } while (i < paramInt);
      if (j >= 100) {
        break label55;
      }
      d1 = 0.0D;
    }
  }
  
  public final int start()
  {
    int j = this.wKm.mfeInit(this.eLM, this.gRb);
    int i = j;
    if (j == 0)
    {
      j = this.wKm.mfeOpen();
      i = j;
      if (j == 0)
      {
        j = this.wKm.mfeEnableNoiseDetection(true);
        i = j;
        if (j == 0) {
          i = this.wKm.mfeStart();
        }
      }
    }
    if (i == 0) {
      return 0;
    }
    return -1;
  }
  
  public final int stop()
  {
    int j = this.wKm.mfeStop();
    int i = j;
    if (j == 0)
    {
      j = this.wKm.mfeClose();
      i = j;
      if (j == 0) {
        i = this.wKm.mfeExit();
      }
    }
    if (i == 0) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.c
 * JD-Core Version:    0.7.0.1
 */