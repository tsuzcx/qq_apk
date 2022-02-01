package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acq
  extends com.tencent.mm.bw.a
{
  public int Lnt;
  public int Lnu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186794);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lnt);
      paramVarArgs.aM(2, this.Lnu);
      AppMethodBeat.o(186794);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lnt);
      int i = g.a.a.b.b.a.bu(2, this.Lnu);
      AppMethodBeat.o(186794);
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
      AppMethodBeat.o(186794);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acq localacq = (acq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(186794);
        return -1;
      case 1: 
        localacq.Lnt = locala.UbS.zi();
        AppMethodBeat.o(186794);
        return 0;
      }
      localacq.Lnu = locala.UbS.zi();
      AppMethodBeat.o(186794);
      return 0;
    }
    AppMethodBeat.o(186794);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */