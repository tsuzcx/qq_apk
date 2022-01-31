package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cgn
  extends com.tencent.mm.bv.a
{
  public String content;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28658);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.type == null)
      {
        paramVarArgs = new b("Not all required fields were included: type");
        AppMethodBeat.o(28658);
        throw paramVarArgs;
      }
      if (this.type != null) {
        paramVarArgs.e(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      AppMethodBeat.o(28658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = e.a.a.b.b.a.f(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.content);
      }
      AppMethodBeat.o(28658);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.type == null)
        {
          paramVarArgs = new b("Not all required fields were included: type");
          AppMethodBeat.o(28658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28658);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cgn localcgn = (cgn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28658);
          return -1;
        case 1: 
          localcgn.type = locala.CLY.readString();
          AppMethodBeat.o(28658);
          return 0;
        }
        localcgn.content = locala.CLY.readString();
        AppMethodBeat.o(28658);
        return 0;
      }
      AppMethodBeat.o(28658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgn
 * JD-Core Version:    0.7.0.1
 */