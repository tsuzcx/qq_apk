package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvr
  extends com.tencent.mm.bx.a
{
  public int Enu;
  public int Env;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125813);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Enu);
      paramVarArgs.aR(2, this.Env);
      AppMethodBeat.o(125813);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Enu);
      int i = f.a.a.b.b.a.bA(2, this.Env);
      AppMethodBeat.o(125813);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125813);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cvr localcvr = (cvr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125813);
        return -1;
      case 1: 
        localcvr.Enu = locala.KhF.xS();
        AppMethodBeat.o(125813);
        return 0;
      }
      localcvr.Env = locala.KhF.xS();
      AppMethodBeat.o(125813);
      return 0;
    }
    AppMethodBeat.o(125813);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvr
 * JD-Core Version:    0.7.0.1
 */