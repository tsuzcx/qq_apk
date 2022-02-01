package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    MpK = new c("VERBOSE", 0, 2);
    MpJ = new c("DEBUG", 1, 3);
    MpL = new c("INFO", 2, 4);
    MpM = new c("WARN", 3, 5);
    MpN = new c("ERROR", 4, 6);
    MpO = new c("ALL", 5, -2147483648);
    MpP = new c("NONE", 6, 2147483647);
    MpQ = new c[] { MpK, MpJ, MpL, MpM, MpN, MpO, MpP };
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
      if (paramc.h < MpK.h) {
        paramc = "V-" + (MpK.h - paramc.h);
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
      paramc = "E+" + (paramc.h - MpN.h);
    }
  }
  
  public static c ahA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return MpP;
    case 2: 
      return MpK;
    case 3: 
      return MpJ;
    case 4: 
      return MpL;
    case 5: 
      return MpM;
    }
    return MpN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */