package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bml
  extends com.tencent.mm.bx.a
{
  public String GGQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGQ != null) {
        paramVarArgs.d(1, this.GGQ);
      }
      AppMethodBeat.o(32317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGQ == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = f.a.a.b.b.a.e(1, this.GGQ) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32317);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bml localbml = (bml)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32317);
          return -1;
        }
        localbml.GGQ = locala.NPN.readString();
        AppMethodBeat.o(32317);
        return 0;
      }
      AppMethodBeat.o(32317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bml
 * JD-Core Version:    0.7.0.1
 */