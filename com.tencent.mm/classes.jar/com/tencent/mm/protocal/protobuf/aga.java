package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aga
  extends com.tencent.mm.bx.a
{
  public String UZz;
  public long ZoQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259655);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UZz != null) {
        paramVarArgs.g(1, this.UZz);
      }
      paramVarArgs.bv(2, this.ZoQ);
      AppMethodBeat.o(259655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UZz == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.UZz) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ZoQ);
      AppMethodBeat.o(259655);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259655);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aga localaga = (aga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259655);
          return -1;
        case 1: 
          localaga.UZz = locala.ajGk.readString();
          AppMethodBeat.o(259655);
          return 0;
        }
        localaga.ZoQ = locala.ajGk.aaw();
        AppMethodBeat.o(259655);
        return 0;
      }
      AppMethodBeat.o(259655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aga
 * JD-Core Version:    0.7.0.1
 */