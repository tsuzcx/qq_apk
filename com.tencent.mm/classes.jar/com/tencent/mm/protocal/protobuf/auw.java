package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auw
  extends com.tencent.mm.bw.a
{
  public int LFG;
  public int LFL;
  public String Lmn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LFG);
      paramVarArgs.aM(102, this.LFL);
      if (this.Lmn != null) {
        paramVarArgs.e(103, this.Lmn);
      }
      AppMethodBeat.o(209489);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LFG) + 0 + g.a.a.b.b.a.bu(102, this.LFL);
      paramInt = i;
      if (this.Lmn != null) {
        paramInt = i + g.a.a.b.b.a.f(103, this.Lmn);
      }
      AppMethodBeat.o(209489);
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
      AppMethodBeat.o(209489);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      auw localauw = (auw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209489);
        return -1;
      case 1: 
        localauw.LFG = locala.UbS.zi();
        AppMethodBeat.o(209489);
        return 0;
      case 102: 
        localauw.LFL = locala.UbS.zi();
        AppMethodBeat.o(209489);
        return 0;
      }
      localauw.Lmn = locala.UbS.readString();
      AppMethodBeat.o(209489);
      return 0;
    }
    AppMethodBeat.o(209489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */