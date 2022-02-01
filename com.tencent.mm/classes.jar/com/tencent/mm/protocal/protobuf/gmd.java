package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gmd
  extends com.tencent.mm.bx.a
{
  public String achs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260175);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achs != null) {
        paramVarArgs.g(1, this.achs);
      }
      AppMethodBeat.o(260175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achs == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.achs) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(260175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260175);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gmd localgmd = (gmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260175);
          return -1;
        }
        localgmd.achs = locala.ajGk.readString();
        AppMethodBeat.o(260175);
        return 0;
      }
      AppMethodBeat.o(260175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmd
 * JD-Core Version:    0.7.0.1
 */