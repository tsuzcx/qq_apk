package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezt
  extends com.tencent.mm.bw.a
{
  public long MDQ;
  public int NvS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32563);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NvS);
      paramVarArgs.bb(2, this.MDQ);
      AppMethodBeat.o(32563);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.NvS);
      int i = g.a.a.b.b.a.r(2, this.MDQ);
      AppMethodBeat.o(32563);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32563);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezt localezt = (ezt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32563);
        return -1;
      case 1: 
        localezt.NvS = locala.UbS.zi();
        AppMethodBeat.o(32563);
        return 0;
      }
      localezt.MDQ = locala.UbS.zl();
      AppMethodBeat.o(32563);
      return 0;
    }
    AppMethodBeat.o(32563);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezt
 * JD-Core Version:    0.7.0.1
 */