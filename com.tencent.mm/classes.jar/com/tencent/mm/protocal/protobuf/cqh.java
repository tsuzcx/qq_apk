package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqh
  extends com.tencent.mm.cd.a
{
  public float ScO;
  public float ScP;
  public int Sxt;
  public String Sxu;
  public String Sxv;
  public int Sxw;
  public String TxS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.ScO);
      paramVarArgs.i(2, this.ScP);
      paramVarArgs.aY(3, this.Sxt);
      if (this.Sxu != null) {
        paramVarArgs.f(4, this.Sxu);
      }
      if (this.Sxv != null) {
        paramVarArgs.f(5, this.Sxv);
      }
      paramVarArgs.aY(6, this.Sxw);
      if (this.TxS != null) {
        paramVarArgs.f(7, this.TxS);
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 4 + 0 + (g.a.a.b.b.a.gL(2) + 4) + g.a.a.b.b.a.bM(3, this.Sxt);
      paramInt = i;
      if (this.Sxu != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sxu);
      }
      i = paramInt;
      if (this.Sxv != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sxv);
      }
      i += g.a.a.b.b.a.bM(6, this.Sxw);
      paramInt = i;
      if (this.TxS != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TxS);
      }
      AppMethodBeat.o(117875);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cqh localcqh = (cqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117875);
        return -1;
      case 1: 
        localcqh.ScO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(117875);
        return 0;
      case 2: 
        localcqh.ScP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(117875);
        return 0;
      case 3: 
        localcqh.Sxt = locala.abFh.AK();
        AppMethodBeat.o(117875);
        return 0;
      case 4: 
        localcqh.Sxu = locala.abFh.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 5: 
        localcqh.Sxv = locala.abFh.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 6: 
        localcqh.Sxw = locala.abFh.AK();
        AppMethodBeat.o(117875);
        return 0;
      }
      localcqh.TxS = locala.abFh.readString();
      AppMethodBeat.o(117875);
      return 0;
    }
    AppMethodBeat.o(117875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqh
 * JD-Core Version:    0.7.0.1
 */