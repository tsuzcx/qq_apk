package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;

public final class r$c
  implements e<bhf, com.tencent.mm.vending.j.c<Integer, Integer>>
{
  public r$c(r paramr) {}
  
  public final String HY()
  {
    return "Vending.UI";
  }
  
  public final com.tencent.mm.vending.g.c<bhf> gu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45272);
    com.tencent.mm.vending.g.c localc = f.A(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).c(this);
    AppMethodBeat.o(45272);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.r.c
 * JD-Core Version:    0.7.0.1
 */