package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffb
  extends com.tencent.mm.bw.a
{
  public int NAq;
  public boolean NAr;
  public boolean NAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.NAq);
      paramVarArgs.cc(2, this.NAr);
      paramVarArgs.cc(3, this.NAs);
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.NAq);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(123713);
      return paramInt + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffb localffb = (ffb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123713);
        return -1;
      case 1: 
        localffb.NAq = locala.UbS.zi();
        AppMethodBeat.o(123713);
        return 0;
      case 2: 
        localffb.NAr = locala.UbS.yZ();
        AppMethodBeat.o(123713);
        return 0;
      }
      localffb.NAs = locala.UbS.yZ();
      AppMethodBeat.o(123713);
      return 0;
    }
    AppMethodBeat.o(123713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffb
 * JD-Core Version:    0.7.0.1
 */