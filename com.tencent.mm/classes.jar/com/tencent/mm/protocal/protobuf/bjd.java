package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjd
  extends com.tencent.mm.bx.a
{
  public boolean ZSO;
  public boolean ZSP;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260127);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZSO);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.di(3, this.ZSP);
      AppMethodBeat.o(260127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(260127);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260127);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bjd localbjd = (bjd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260127);
        return -1;
      case 1: 
        localbjd.ZSO = locala.ajGk.aai();
        AppMethodBeat.o(260127);
        return 0;
      case 2: 
        localbjd.wording = locala.ajGk.readString();
        AppMethodBeat.o(260127);
        return 0;
      }
      localbjd.ZSP = locala.ajGk.aai();
      AppMethodBeat.o(260127);
      return 0;
    }
    AppMethodBeat.o(260127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjd
 * JD-Core Version:    0.7.0.1
 */