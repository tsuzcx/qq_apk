package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzf
  extends com.tencent.mm.bx.a
{
  public boolean aais;
  public boolean aait;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257728);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aais);
      paramVarArgs.di(2, this.aait);
      AppMethodBeat.o(257728);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(257728);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257728);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bzf localbzf = (bzf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257728);
        return -1;
      case 1: 
        localbzf.aais = locala.ajGk.aai();
        AppMethodBeat.o(257728);
        return 0;
      }
      localbzf.aait = locala.ajGk.aai();
      AppMethodBeat.o(257728);
      return 0;
    }
    AppMethodBeat.o(257728);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzf
 * JD-Core Version:    0.7.0.1
 */