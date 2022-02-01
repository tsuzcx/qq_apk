package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    JYS = new c("VERBOSE", 0, 2);
    JYR = new c("DEBUG", 1, 3);
    JYT = new c("INFO", 2, 4);
    JYU = new c("WARN", 3, 5);
    JYV = new c("ERROR", 4, 6);
    JYW = new c("ALL", 5, -2147483648);
    JYX = new c("NONE", 6, 2147483647);
    JYY = new c[] { JYS, JYR, JYT, JYU, JYV, JYW, JYX };
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
      if (paramc.h < JYS.h) {
        paramc = "V-" + (JYS.h - paramc.h);
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
      paramc = "E+" + (paramc.h - JYV.h);
    }
  }
  
  public static c aer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return JYX;
    case 2: 
      return JYS;
    case 3: 
      return JYR;
    case 4: 
      return JYT;
    case 5: 
      return JYU;
    }
    return JYV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */