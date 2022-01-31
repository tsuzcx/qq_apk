package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzv
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b xLv;
  public com.tencent.mm.bv.b xop;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124362);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xLv == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(124362);
        throw paramVarArgs;
      }
      if (this.xop == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(124362);
        throw paramVarArgs;
      }
      if (this.xLv != null) {
        paramVarArgs.c(1, this.xLv);
      }
      if (this.xop != null) {
        paramVarArgs.c(2, this.xop);
      }
      AppMethodBeat.o(124362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xLv == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.b(1, this.xLv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xop != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.xop);
      }
      AppMethodBeat.o(124362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xLv == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(124362);
          throw paramVarArgs;
        }
        if (this.xop == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Value");
          AppMethodBeat.o(124362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124362);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bzv localbzv = (bzv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124362);
          return -1;
        case 1: 
          localbzv.xLv = locala.CLY.eqS();
          AppMethodBeat.o(124362);
          return 0;
        }
        localbzv.xop = locala.CLY.eqS();
        AppMethodBeat.o(124362);
        return 0;
      }
      AppMethodBeat.o(124362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzv
 * JD-Core Version:    0.7.0.1
 */