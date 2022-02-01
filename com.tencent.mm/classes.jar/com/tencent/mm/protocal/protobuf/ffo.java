package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffo
  extends com.tencent.mm.cd.a
{
  public String Tsy;
  public long UGb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147787);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UGb);
      if (this.Tsy != null) {
        paramVarArgs.f(2, this.Tsy);
      }
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.UGb) + 0;
      paramInt = i;
      if (this.Tsy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tsy);
      }
      AppMethodBeat.o(147787);
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
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffo localffo = (ffo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147787);
        return -1;
      case 1: 
        localffo.UGb = locala.abFh.AN();
        AppMethodBeat.o(147787);
        return 0;
      }
      localffo.Tsy = locala.abFh.readString();
      AppMethodBeat.o(147787);
      return 0;
    }
    AppMethodBeat.o(147787);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffo
 * JD-Core Version:    0.7.0.1
 */