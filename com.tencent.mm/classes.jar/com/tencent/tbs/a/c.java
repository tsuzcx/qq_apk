package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    LSN = new c("VERBOSE", 0, 2);
    LSM = new c("DEBUG", 1, 3);
    LSO = new c("INFO", 2, 4);
    LSP = new c("WARN", 3, 5);
    LSQ = new c("ERROR", 4, 6);
    LSR = new c("ALL", 5, -2147483648);
    LSS = new c("NONE", 6, 2147483647);
    LST = new c[] { LSN, LSM, LSO, LSP, LSQ, LSR, LSS };
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
      if (paramc.h < LSN.h) {
        paramc = "V-" + (LSN.h - paramc.h);
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
      paramc = "E+" + (paramc.h - LSQ.h);
    }
  }
  
  public static c agR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return LSS;
    case 2: 
      return LSN;
    case 3: 
      return LSM;
    case 4: 
      return LSO;
    case 5: 
      return LSP;
    }
    return LSQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */