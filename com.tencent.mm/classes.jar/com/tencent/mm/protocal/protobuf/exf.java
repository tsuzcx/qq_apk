package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exf
  extends com.tencent.mm.bw.a
{
  public String LPg;
  public int LPy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200237);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LPy);
      if (this.LPg != null) {
        paramVarArgs.e(2, this.LPg);
      }
      AppMethodBeat.o(200237);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LPy) + 0;
      paramInt = i;
      if (this.LPg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LPg);
      }
      AppMethodBeat.o(200237);
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
      AppMethodBeat.o(200237);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      exf localexf = (exf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200237);
        return -1;
      case 1: 
        localexf.LPy = locala.UbS.zi();
        AppMethodBeat.o(200237);
        return 0;
      }
      localexf.LPg = locala.UbS.readString();
      AppMethodBeat.o(200237);
      return 0;
    }
    AppMethodBeat.o(200237);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exf
 * JD-Core Version:    0.7.0.1
 */