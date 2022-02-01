package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    ahzE = new c("VERBOSE", 0, 2);
    ahzD = new c("DEBUG", 1, 3);
    ahzF = new c("INFO", 2, 4);
    ahzG = new c("WARN", 3, 5);
    ahzH = new c("ERROR", 4, 6);
    ahzI = new c("ALL", 5, -2147483648);
    ahzJ = new c("NONE", 6, 2147483647);
    ahzK = new c[] { ahzE, ahzD, ahzF, ahzG, ahzH, ahzI, ahzJ };
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
      if (paramc.h < ahzE.h) {
        paramc = "V-" + (ahzE.h - paramc.h);
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
      paramc = "E+" + (paramc.h - ahzH.h);
    }
  }
  
  public static c aHm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ahzJ;
    case 2: 
      return ahzE;
    case 3: 
      return ahzD;
    case 4: 
      return ahzF;
    case 5: 
      return ahzG;
    }
    return ahzH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */