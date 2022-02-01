package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private TRVADNative RKJ;
  private int jwi;
  private int mTimeout;
  
  public c()
  {
    AppMethodBeat.i(87690);
    this.RKJ = new TRVADNative();
    this.jwi = 500000;
    this.mTimeout = 10000000;
    AppMethodBeat.o(87690);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(87689);
    this.RKJ = new TRVADNative();
    this.jwi = paramInt;
    this.mTimeout = 5000000;
    AppMethodBeat.o(87689);
  }
  
  public final void a(short[] paramArrayOfShort, int paramInt, c.a parama)
  {
    double d1 = 26.0D;
    for (;;)
    {
      label67:
      label68:
      try
      {
        AppMethodBeat.i(87693);
        if (paramInt <= 0)
        {
          AppMethodBeat.o(87693);
          return;
        }
        switch (this.RKJ.mfeSendData(paramArrayOfShort, paramInt))
        {
        case 1: 
          parama.RKK = 0;
        }
      }
      finally {}
      parama.RKO = ((int)d1);
      new StringBuilder("volumn：").append(parama.RKO);
      AppMethodBeat.o(87693);
      break;
      parama.RKK = 1;
      break label200;
      parama.RKK = 2;
      break label200;
      parama.RKK = 3;
      int j;
      int i;
      label200:
      do
      {
        double d2 = j;
        double d3 = Math.sqrt(paramArrayOfShort[i] * paramArrayOfShort[i]);
        j = (int)(d2 + d3 / paramInt);
        i += 1;
        continue;
        if (j > 16383) {
          break label68;
        }
        d1 = 26.0D * ((j - 100.0D) / 32667.0D);
        break label68;
        break;
        i = 0;
        j = 0;
      } while (i < paramInt);
      if (j >= 100) {
        break label67;
      }
      d1 = 0.0D;
    }
  }
  
  public final int hkt()
  {
    AppMethodBeat.i(87691);
    int j = this.RKJ.mfeInit(this.jwi, this.mTimeout);
    int i = j;
    if (j == 0)
    {
      j = this.RKJ.mfeOpen();
      i = j;
      if (j == 0)
      {
        j = this.RKJ.mfeEnableNoiseDetection(true);
        i = j;
        if (j == 0) {
          i = this.RKJ.mfeStart();
        }
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(87691);
      return 0;
    }
    AppMethodBeat.o(87691);
    return -1;
  }
  
  public final int stop()
  {
    AppMethodBeat.i(87692);
    int j = this.RKJ.mfeStop();
    int i = j;
    if (j == 0)
    {
      j = this.RKJ.mfeClose();
      i = j;
      if (j == 0) {
        i = this.RKJ.mfeExit();
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(87692);
      return 0;
    }
    AppMethodBeat.o(87692);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.c
 * JD-Core Version:    0.7.0.1
 */