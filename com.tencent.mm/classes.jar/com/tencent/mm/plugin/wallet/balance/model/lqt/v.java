package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.efh;

public final class v
{
  public final efh UZK;
  public final int ybL;
  
  public v(a parama)
  {
    this.UZK = parama.UZK;
    this.ybL = parama.ybL;
  }
  
  public static final class a
  {
    public efh UZK;
    public int ybL = -1;
    
    public final v iev()
    {
      AppMethodBeat.i(316188);
      v localv = new v(this);
      AppMethodBeat.o(316188);
      return localv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */