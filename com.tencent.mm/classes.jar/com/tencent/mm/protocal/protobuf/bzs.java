package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzs
  extends com.tencent.mm.bx.a
{
  public boolean AXf;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32212);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.di(2, this.AXf);
      AppMethodBeat.o(32212);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label262;
      }
    }
    label262:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(32212);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32212);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bzs localbzs = (bzs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32212);
          return -1;
        case 1: 
          localbzs.username = locala.ajGk.readString();
          AppMethodBeat.o(32212);
          return 0;
        }
        localbzs.AXf = locala.ajGk.aai();
        AppMethodBeat.o(32212);
        return 0;
      }
      AppMethodBeat.o(32212);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */