package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnd
  extends com.tencent.mm.bw.a
{
  public String Has;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Has != null) {
        paramVarArgs.d(1, this.Has);
      }
      AppMethodBeat.o(32317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Has == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = f.a.a.b.b.a.e(1, this.Has) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32317);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnd localbnd = (bnd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32317);
          return -1;
        }
        localbnd.Has = locala.OmT.readString();
        AppMethodBeat.o(32317);
        return 0;
      }
      AppMethodBeat.o(32317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnd
 * JD-Core Version:    0.7.0.1
 */