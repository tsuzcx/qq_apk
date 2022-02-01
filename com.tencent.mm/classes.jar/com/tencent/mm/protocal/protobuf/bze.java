package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bze
  extends com.tencent.mm.cd.a
{
  public String mye;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152574);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mye != null) {
        paramVarArgs.f(1, this.mye);
      }
      AppMethodBeat.o(152574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mye == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.mye) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152574);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152574);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bze localbze = (bze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152574);
          return -1;
        }
        localbze.mye = locala.abFh.readString();
        AppMethodBeat.o(152574);
        return 0;
      }
      AppMethodBeat.o(152574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bze
 * JD-Core Version:    0.7.0.1
 */