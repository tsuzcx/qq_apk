package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqb
  extends com.tencent.mm.bw.a
{
  public int KJS;
  public String Lru;
  public int NnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152724);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KJS);
      if (this.Lru != null) {
        paramVarArgs.e(2, this.Lru);
      }
      paramVarArgs.aM(3, this.NnE);
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KJS) + 0;
      paramInt = i;
      if (this.Lru != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lru);
      }
      i = g.a.a.b.b.a.bu(3, this.NnE);
      AppMethodBeat.o(152724);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqb localeqb = (eqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152724);
        return -1;
      case 1: 
        localeqb.KJS = locala.UbS.zi();
        AppMethodBeat.o(152724);
        return 0;
      case 2: 
        localeqb.Lru = locala.UbS.readString();
        AppMethodBeat.o(152724);
        return 0;
      }
      localeqb.NnE = locala.UbS.zi();
      AppMethodBeat.o(152724);
      return 0;
    }
    AppMethodBeat.o(152724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqb
 * JD-Core Version:    0.7.0.1
 */