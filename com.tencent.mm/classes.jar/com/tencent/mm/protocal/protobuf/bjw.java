package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjw
  extends com.tencent.mm.bx.a
{
  public long DVk;
  public boolean cancel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259871);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.DVk);
      paramVarArgs.di(2, this.cancel);
      AppMethodBeat.o(259871);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.DVk);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(259871);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259871);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bjw localbjw = (bjw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259871);
        return -1;
      case 1: 
        localbjw.DVk = locala.ajGk.aaw();
        AppMethodBeat.o(259871);
        return 0;
      }
      localbjw.cancel = locala.ajGk.aai();
      AppMethodBeat.o(259871);
      return 0;
    }
    AppMethodBeat.o(259871);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjw
 * JD-Core Version:    0.7.0.1
 */