package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gly
  extends com.tencent.mm.bx.a
{
  public String aauG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257464);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aauG != null) {
        paramVarArgs.g(1, this.aauG);
      }
      AppMethodBeat.o(257464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aauG == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.aauG) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(257464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257464);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gly localgly = (gly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257464);
          return -1;
        }
        localgly.aauG = locala.ajGk.readString();
        AppMethodBeat.o(257464);
        return 0;
      }
      AppMethodBeat.o(257464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gly
 * JD-Core Version:    0.7.0.1
 */