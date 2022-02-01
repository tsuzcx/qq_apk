package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecx
  extends com.tencent.mm.bw.a
{
  public int lCq;
  public int qwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.qwL);
      paramVarArgs.aM(2, this.lCq);
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.qwL);
      int i = g.a.a.b.b.a.bu(2, this.lCq);
      AppMethodBeat.o(116817);
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
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ecx localecx = (ecx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116817);
        return -1;
      case 1: 
        localecx.qwL = locala.UbS.zi();
        AppMethodBeat.o(116817);
        return 0;
      }
      localecx.lCq = locala.UbS.zi();
      AppMethodBeat.o(116817);
      return 0;
    }
    AppMethodBeat.o(116817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecx
 * JD-Core Version:    0.7.0.1
 */