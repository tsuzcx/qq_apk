package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class or
  extends com.tencent.mm.bx.a
{
  public String YRR;
  public int ver;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRR != null) {
        paramVarArgs.g(1, this.YRR);
      }
      if (this.wwH != null) {
        paramVarArgs.g(2, this.wwH);
      }
      paramVarArgs.bS(3, this.ver);
      AppMethodBeat.o(124418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRR == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wwH != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wwH);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ver);
      AppMethodBeat.o(124418);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124418);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        or localor = (or)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124418);
          return -1;
        case 1: 
          localor.YRR = locala.ajGk.readString();
          AppMethodBeat.o(124418);
          return 0;
        case 2: 
          localor.wwH = locala.ajGk.readString();
          AppMethodBeat.o(124418);
          return 0;
        }
        localor.ver = locala.ajGk.aar();
        AppMethodBeat.o(124418);
        return 0;
      }
      AppMethodBeat.o(124418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.or
 * JD-Core Version:    0.7.0.1
 */