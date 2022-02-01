package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gq
  extends com.tencent.mm.bx.a
{
  public int YIo;
  public String muA;
  public String muE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      paramVarArgs.bS(2, this.YIo);
      if (this.muE != null) {
        paramVarArgs.g(3, this.muE);
      }
      AppMethodBeat.o(152494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.muA) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIo);
      paramInt = i;
      if (this.muE != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.muE);
      }
      AppMethodBeat.o(152494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152494);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gq localgq = (gq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152494);
          return -1;
        case 1: 
          localgq.muA = locala.ajGk.readString();
          AppMethodBeat.o(152494);
          return 0;
        case 2: 
          localgq.YIo = locala.ajGk.aar();
          AppMethodBeat.o(152494);
          return 0;
        }
        localgq.muE = locala.ajGk.readString();
        AppMethodBeat.o(152494);
        return 0;
      }
      AppMethodBeat.o(152494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gq
 * JD-Core Version:    0.7.0.1
 */