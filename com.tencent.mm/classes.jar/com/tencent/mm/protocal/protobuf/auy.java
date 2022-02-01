package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auy
  extends com.tencent.mm.bx.a
{
  public boolean ZFp;
  public String error_msg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257660);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZFp);
      if (this.error_msg != null) {
        paramVarArgs.g(2, this.error_msg);
      }
      AppMethodBeat.o(257660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.error_msg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.error_msg);
      }
      AppMethodBeat.o(257660);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257660);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      auy localauy = (auy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257660);
        return -1;
      case 1: 
        localauy.ZFp = locala.ajGk.aai();
        AppMethodBeat.o(257660);
        return 0;
      }
      localauy.error_msg = locala.ajGk.readString();
      AppMethodBeat.o(257660);
      return 0;
    }
    AppMethodBeat.o(257660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auy
 * JD-Core Version:    0.7.0.1
 */