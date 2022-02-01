package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    Ixj = new c("VERBOSE", 0, 2);
    Ixi = new c("DEBUG", 1, 3);
    Ixk = new c("INFO", 2, 4);
    Ixl = new c("WARN", 3, 5);
    Ixm = new c("ERROR", 4, 6);
    Ixn = new c("ALL", 5, -2147483648);
    Ixo = new c("NONE", 6, 2147483647);
    Ixp = new c[] { Ixj, Ixi, Ixk, Ixl, Ixm, Ixn, Ixo };
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
      if (paramc.h < Ixj.h) {
        paramc = "V-" + (Ixj.h - paramc.h);
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
      paramc = "E+" + (paramc.h - Ixm.h);
    }
  }
  
  public static c abY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Ixo;
    case 2: 
      return Ixj;
    case 3: 
      return Ixi;
    case 4: 
      return Ixk;
    case 5: 
      return Ixl;
    }
    return Ixm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */