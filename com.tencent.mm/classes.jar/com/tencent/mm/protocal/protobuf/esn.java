package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esn
  extends com.tencent.mm.bx.a
{
  public String hMM;
  public String hSC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152677);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      if (this.hSC != null) {
        paramVarArgs.g(2, this.hSC);
      }
      AppMethodBeat.o(152677);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.hMM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hSC != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hSC);
      }
      AppMethodBeat.o(152677);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152677);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        esn localesn = (esn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152677);
          return -1;
        case 1: 
          localesn.hMM = locala.ajGk.readString();
          AppMethodBeat.o(152677);
          return 0;
        }
        localesn.hSC = locala.ajGk.readString();
        AppMethodBeat.o(152677);
        return 0;
      }
      AppMethodBeat.o(152677);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esn
 * JD-Core Version:    0.7.0.1
 */