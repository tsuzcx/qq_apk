package com.tencent.tbs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  int h;
  
  static
  {
    AppMethodBeat.i(174266);
    abTt = new c("VERBOSE", 0, 2);
    abTs = new c("DEBUG", 1, 3);
    abTu = new c("INFO", 2, 4);
    abTv = new c("WARN", 3, 5);
    abTw = new c("ERROR", 4, 6);
    abTx = new c("ALL", 5, -2147483648);
    abTy = new c("NONE", 6, 2147483647);
    abTz = new c[] { abTt, abTs, abTu, abTv, abTw, abTx, abTy };
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
      if (paramc.h < abTt.h) {
        paramc = "V-" + (abTt.h - paramc.h);
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
      paramc = "E+" + (paramc.h - abTw.h);
    }
  }
  
  public static c aGq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return abTy;
    case 2: 
      return abTt;
    case 3: 
      return abTs;
    case 4: 
      return abTu;
    case 5: 
      return abTv;
    }
    return abTw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.c
 * JD-Core Version:    0.7.0.1
 */