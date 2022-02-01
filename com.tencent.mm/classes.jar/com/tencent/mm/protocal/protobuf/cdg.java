package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdg
  extends com.tencent.mm.bx.a
{
  public String aanB;
  public long aanC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152555);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aanB != null) {
        paramVarArgs.g(1, this.aanB);
      }
      paramVarArgs.bv(2, this.aanC);
      AppMethodBeat.o(152555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aanB == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.aanB) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.aanC);
      AppMethodBeat.o(152555);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152555);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152555);
          return -1;
        case 1: 
          localcdg.aanB = locala.ajGk.readString();
          AppMethodBeat.o(152555);
          return 0;
        }
        localcdg.aanC = locala.ajGk.aaw();
        AppMethodBeat.o(152555);
        return 0;
      }
      AppMethodBeat.o(152555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */