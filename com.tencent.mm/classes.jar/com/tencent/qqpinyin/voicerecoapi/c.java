package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private TRVADNative BhN;
  private int gbt;
  private int isQ;
  
  public c()
  {
    AppMethodBeat.i(35437);
    this.BhN = new TRVADNative();
    this.gbt = 500000;
    this.isQ = 10000000;
    AppMethodBeat.o(35437);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(35436);
    this.BhN = new TRVADNative();
    this.gbt = paramInt;
    this.isQ = 5000000;
    AppMethodBeat.o(35436);
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
        AppMethodBeat.i(35440);
        if (paramInt <= 0)
        {
          AppMethodBeat.o(35440);
          return;
        }
        switch (this.BhN.mfeSendData(paramArrayOfShort, paramInt))
        {
        case 1: 
          parama.BhO = 0;
        }
      }
      finally {}
      parama.BhS = ((int)d1);
      new StringBuilder("volumn��").append(parama.BhS);
      AppMethodBeat.o(35440);
      break;
      parama.BhO = 1;
      break label200;
      parama.BhO = 2;
      break label200;
      parama.BhO = 3;
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
  
  public final int dUg()
  {
    AppMethodBeat.i(35438);
    int j = this.BhN.mfeInit(this.gbt, this.isQ);
    int i = j;
    if (j == 0)
    {
      j = this.BhN.mfeOpen();
      i = j;
      if (j == 0)
      {
        j = this.BhN.mfeEnableNoiseDetection(true);
        i = j;
        if (j == 0) {
          i = this.BhN.mfeStart();
        }
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(35438);
      return 0;
    }
    AppMethodBeat.o(35438);
    return -1;
  }
  
  public final int stop()
  {
    AppMethodBeat.i(35439);
    int j = this.BhN.mfeStop();
    int i = j;
    if (j == 0)
    {
      j = this.BhN.mfeClose();
      i = j;
      if (j == 0) {
        i = this.BhN.mfeExit();
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(35439);
      return 0;
    }
    AppMethodBeat.o(35439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.c
 * JD-Core Version:    0.7.0.1
 */