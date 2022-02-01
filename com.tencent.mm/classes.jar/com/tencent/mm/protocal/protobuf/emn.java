package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class emn
  extends com.tencent.mm.bx.a
{
  public long abqQ;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257387);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      paramVarArgs.bv(2, this.abqQ);
      AppMethodBeat.o(257387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.content) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abqQ);
      AppMethodBeat.o(257387);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257387);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        emn localemn = (emn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257387);
          return -1;
        case 1: 
          localemn.content = locala.ajGk.readString();
          AppMethodBeat.o(257387);
          return 0;
        }
        localemn.abqQ = locala.ajGk.aaw();
        AppMethodBeat.o(257387);
        return 0;
      }
      AppMethodBeat.o(257387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emn
 * JD-Core Version:    0.7.0.1
 */