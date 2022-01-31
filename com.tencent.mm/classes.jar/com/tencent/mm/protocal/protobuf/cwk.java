package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwk
  extends com.tencent.mm.bv.a
{
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94637);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      AppMethodBeat.o(94637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.path);
      }
      AppMethodBeat.o(94637);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94637);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwk localcwk = (cwk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94637);
          return -1;
        case 1: 
          localcwk.username = locala.CLY.readString();
          AppMethodBeat.o(94637);
          return 0;
        }
        localcwk.path = locala.CLY.readString();
        AppMethodBeat.o(94637);
        return 0;
      }
      AppMethodBeat.o(94637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwk
 * JD-Core Version:    0.7.0.1
 */