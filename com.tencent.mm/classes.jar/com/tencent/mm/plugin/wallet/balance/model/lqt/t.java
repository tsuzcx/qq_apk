package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ddd;

public final class t
{
  public final ddd Htw;
  public final int sQn;
  
  public t(a parama)
  {
    this.Htw = parama.Htw;
    this.sQn = parama.sQn;
  }
  
  public static final class a
  {
    public ddd Htw;
    public int sQn = -1;
    
    public final t fMT()
    {
      AppMethodBeat.i(213849);
      t localt = new t(this);
      AppMethodBeat.o(213849);
      return localt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t
 * JD-Core Version:    0.7.0.1
 */