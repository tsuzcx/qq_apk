package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ago
  extends com.tencent.mm.bw.a
{
  public String FZl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(104761);
        throw paramVarArgs;
      }
      if (this.FZl != null) {
        paramVarArgs.d(1, this.FZl);
      }
      AppMethodBeat.o(104761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZl == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZl) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(104761);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104761);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ago localago = (ago)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104761);
          return -1;
        }
        localago.FZl = locala.OmT.readString();
        AppMethodBeat.o(104761);
        return 0;
      }
      AppMethodBeat.o(104761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ago
 * JD-Core Version:    0.7.0.1
 */