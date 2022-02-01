package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class biy
  extends com.tencent.mm.bx.a
{
  public boolean ZSH;
  public String ZSI;
  public String ZSJ;
  public String ZsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260200);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZsC != null) {
        paramVarArgs.g(1, this.ZsC);
      }
      paramVarArgs.di(2, this.ZSH);
      if (this.ZSI != null) {
        paramVarArgs.g(3, this.ZSI);
      }
      if (this.ZSJ != null) {
        paramVarArgs.g(4, this.ZSJ);
      }
      AppMethodBeat.o(260200);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZsC == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZsC) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.ZSI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZSI);
      }
      i = paramInt;
      if (this.ZSJ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZSJ);
      }
      AppMethodBeat.o(260200);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260200);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        biy localbiy = (biy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260200);
          return -1;
        case 1: 
          localbiy.ZsC = locala.ajGk.readString();
          AppMethodBeat.o(260200);
          return 0;
        case 2: 
          localbiy.ZSH = locala.ajGk.aai();
          AppMethodBeat.o(260200);
          return 0;
        case 3: 
          localbiy.ZSI = locala.ajGk.readString();
          AppMethodBeat.o(260200);
          return 0;
        }
        localbiy.ZSJ = locala.ajGk.readString();
        AppMethodBeat.o(260200);
        return 0;
      }
      AppMethodBeat.o(260200);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biy
 * JD-Core Version:    0.7.0.1
 */