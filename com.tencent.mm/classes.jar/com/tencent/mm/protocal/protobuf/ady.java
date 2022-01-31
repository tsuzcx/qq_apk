package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ady
  extends com.tencent.mm.bv.a
{
  public String username;
  public boolean wWQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28408);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aS(2, this.wWQ);
      AppMethodBeat.o(28408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(28408);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28408);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ady localady = (ady)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28408);
          return -1;
        case 1: 
          localady.username = locala.CLY.readString();
          AppMethodBeat.o(28408);
          return 0;
        }
        localady.wWQ = locala.CLY.emu();
        AppMethodBeat.o(28408);
        return 0;
      }
      AppMethodBeat.o(28408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ady
 * JD-Core Version:    0.7.0.1
 */