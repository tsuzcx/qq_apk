package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esq
  extends com.tencent.mm.bw.a
{
  public int MKe;
  public int NgB;
  public String NgC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115860);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NgB);
      paramVarArgs.aM(2, this.MKe);
      if (this.NgC != null) {
        paramVarArgs.e(3, this.NgC);
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.NgB) + 0 + g.a.a.b.b.a.bu(2, this.MKe);
      paramInt = i;
      if (this.NgC != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NgC);
      }
      AppMethodBeat.o(115860);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      esq localesq = (esq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115860);
        return -1;
      case 1: 
        localesq.NgB = locala.UbS.zi();
        AppMethodBeat.o(115860);
        return 0;
      case 2: 
        localesq.MKe = locala.UbS.zi();
        AppMethodBeat.o(115860);
        return 0;
      }
      localesq.NgC = locala.UbS.readString();
      AppMethodBeat.o(115860);
      return 0;
    }
    AppMethodBeat.o(115860);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esq
 * JD-Core Version:    0.7.0.1
 */