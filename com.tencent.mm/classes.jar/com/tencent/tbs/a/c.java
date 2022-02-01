package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    RSh = new c("VERBOSE", 0, 2);
    RSg = new c("DEBUG", 1, 3);
    RSi = new c("INFO", 2, 4);
    RSj = new c("WARN", 3, 5);
    RSk = new c("ERROR", 4, 6);
    RSl = new c("ALL", 5, -2147483648);
    RSm = new c("NONE", 6, 2147483647);
    RSn = new c[] { RSh, RSg, RSi, RSj, RSk, RSl, RSm };
    AppMethodBeat.o(174266);
  }
  
  private c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public static String a(c paramc)
  {
    AppMethodBeat.i(174265);
    switch (1.a[paramc.ordinal()])
    {
    default: 
      if (paramc.h < RSh.h) {
        paramc = "V-" + (RSh.h - paramc.h);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(174265);
      return paramc;
      paramc = "V";
      continue;
      paramc = "D";
      continue;
      paramc = "I";
      continue;
      paramc = "W";
      continue;
      paramc = "E";
      continue;
      paramc = "E+" + (paramc.h - RSk.h);
    }
  }
  
  public static c aqN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return RSm;
    case 2: 
      return RSh;
    case 3: 
      return RSg;
    case 4: 
      return RSi;
    case 5: 
      return RSj;
    }
    return RSk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */