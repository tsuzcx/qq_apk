package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckx
  extends com.tencent.mm.cd.a
{
  public int Tsv;
  public long Tsw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213895);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Tsv);
      paramVarArgs.bm(2, this.Tsw);
      AppMethodBeat.o(213895);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Tsv);
      int i = g.a.a.b.b.a.p(2, this.Tsw);
      AppMethodBeat.o(213895);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(213895);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ckx localckx = (ckx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(213895);
        return -1;
      case 1: 
        localckx.Tsv = locala.abFh.AK();
        AppMethodBeat.o(213895);
        return 0;
      }
      localckx.Tsw = locala.abFh.AN();
      AppMethodBeat.o(213895);
      return 0;
    }
    AppMethodBeat.o(213895);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckx
 * JD-Core Version:    0.7.0.1
 */