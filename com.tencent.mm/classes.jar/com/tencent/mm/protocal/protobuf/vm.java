package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vm
  extends com.tencent.mm.bx.a
{
  public String Zbj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125714);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zbj != null) {
        paramVarArgs.g(1, this.Zbj);
      }
      AppMethodBeat.o(125714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zbj == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zbj) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125714);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        vm localvm = (vm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125714);
          return -1;
        }
        localvm.Zbj = locala.ajGk.readString();
        AppMethodBeat.o(125714);
        return 0;
      }
      AppMethodBeat.o(125714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vm
 * JD-Core Version:    0.7.0.1
 */