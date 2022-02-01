package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glj
  extends com.tencent.mm.bx.a
{
  public boolean acgS;
  public boolean acgT;
  public int acgU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50120);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.acgS);
      paramVarArgs.di(2, this.acgT);
      paramVarArgs.bS(3, this.acgU);
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.acgU);
      AppMethodBeat.o(50120);
      return paramInt + 1 + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glj localglj = (glj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50120);
        return -1;
      case 1: 
        localglj.acgS = locala.ajGk.aai();
        AppMethodBeat.o(50120);
        return 0;
      case 2: 
        localglj.acgT = locala.ajGk.aai();
        AppMethodBeat.o(50120);
        return 0;
      }
      localglj.acgU = locala.ajGk.aar();
      AppMethodBeat.o(50120);
      return 0;
    }
    AppMethodBeat.o(50120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glj
 * JD-Core Version:    0.7.0.1
 */