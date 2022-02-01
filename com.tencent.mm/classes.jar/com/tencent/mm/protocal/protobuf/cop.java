package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cop
  extends com.tencent.mm.bx.a
{
  public String hFb;
  public String hMM;
  public String psp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.psp == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.psp != null) {
        paramVarArgs.g(1, this.psp);
      }
      if (this.hMM != null) {
        paramVarArgs.g(2, this.hMM);
      }
      if (this.hFb != null) {
        paramVarArgs.g(3, this.hFb);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.psp == null) {
        break label378;
      }
    }
    label378:
    for (int i = i.a.a.b.b.a.h(1, this.psp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hMM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hMM);
      }
      i = paramInt;
      if (this.hFb != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hFb);
      }
      AppMethodBeat.o(152580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.psp == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cop localcop = (cop)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localcop.psp = locala.ajGk.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localcop.hMM = locala.ajGk.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localcop.hFb = locala.ajGk.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */