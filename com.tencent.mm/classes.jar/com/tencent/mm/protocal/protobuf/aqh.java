package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqh
  extends com.tencent.mm.bx.a
{
  public int Gop;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gop);
      paramVarArgs.aS(2, this.action);
      AppMethodBeat.o(209346);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gop);
      int i = f.a.a.b.b.a.bz(2, this.action);
      AppMethodBeat.o(209346);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209346);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqh localaqh = (aqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209346);
        return -1;
      case 1: 
        localaqh.Gop = locala.NPN.zc();
        AppMethodBeat.o(209346);
        return 0;
      }
      localaqh.action = locala.NPN.zc();
      AppMethodBeat.o(209346);
      return 0;
    }
    AppMethodBeat.o(209346);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */