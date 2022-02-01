package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clr
  extends com.tencent.mm.cd.a
{
  public long Tti;
  public long Ttj;
  public long Ttk;
  public boolean Ttl;
  public long Ttm;
  public long Ttn;
  public long Tto;
  public boolean Ttp;
  public long Ttq;
  public long Ttr;
  public long Tts;
  public long Ttt;
  public int Ttu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Tti);
      paramVarArgs.bm(2, this.Ttj);
      paramVarArgs.bm(3, this.Ttk);
      paramVarArgs.co(4, this.Ttl);
      paramVarArgs.bm(5, this.Ttm);
      paramVarArgs.bm(6, this.Ttn);
      paramVarArgs.bm(7, this.Tto);
      paramVarArgs.co(8, this.Ttp);
      paramVarArgs.bm(9, this.Ttq);
      paramVarArgs.bm(10, this.Ttr);
      paramVarArgs.bm(11, this.Tts);
      paramVarArgs.bm(12, this.Ttt);
      paramVarArgs.aY(13, this.Ttu);
      AppMethodBeat.o(212939);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.Tti);
      int i = g.a.a.b.b.a.p(2, this.Ttj);
      int j = g.a.a.b.b.a.p(3, this.Ttk);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.p(5, this.Ttm);
      int n = g.a.a.b.b.a.p(6, this.Ttn);
      int i1 = g.a.a.b.b.a.p(7, this.Tto);
      int i2 = g.a.a.b.b.a.gL(8);
      int i3 = g.a.a.b.b.a.p(9, this.Ttq);
      int i4 = g.a.a.b.b.a.p(10, this.Ttr);
      int i5 = g.a.a.b.b.a.p(11, this.Tts);
      int i6 = g.a.a.b.b.a.p(12, this.Ttt);
      int i7 = g.a.a.b.b.a.bM(13, this.Ttu);
      AppMethodBeat.o(212939);
      return paramInt + 0 + i + j + (k + 1) + m + n + i1 + (i2 + 1) + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(212939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clr localclr = (clr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212939);
        return -1;
      case 1: 
        localclr.Tti = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 2: 
        localclr.Ttj = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 3: 
        localclr.Ttk = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 4: 
        localclr.Ttl = locala.abFh.AB();
        AppMethodBeat.o(212939);
        return 0;
      case 5: 
        localclr.Ttm = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 6: 
        localclr.Ttn = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 7: 
        localclr.Tto = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 8: 
        localclr.Ttp = locala.abFh.AB();
        AppMethodBeat.o(212939);
        return 0;
      case 9: 
        localclr.Ttq = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 10: 
        localclr.Ttr = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 11: 
        localclr.Tts = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      case 12: 
        localclr.Ttt = locala.abFh.AN();
        AppMethodBeat.o(212939);
        return 0;
      }
      localclr.Ttu = locala.abFh.AK();
      AppMethodBeat.o(212939);
      return 0;
    }
    AppMethodBeat.o(212939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clr
 * JD-Core Version:    0.7.0.1
 */