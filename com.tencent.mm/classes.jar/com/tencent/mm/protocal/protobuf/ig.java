package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ig
  extends com.tencent.mm.bx.a
{
  public String YJR;
  public String YJS;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YJR != null) {
        paramVarArgs.g(1, this.YJR);
      }
      if (this.YJS != null) {
        paramVarArgs.g(2, this.YJS);
      }
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YJR == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.YJR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YJS);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAk);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ig localig = (ig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localig.YJR = locala.ajGk.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localig.YJS = locala.ajGk.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localig.hAk = locala.ajGk.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ig
 * JD-Core Version:    0.7.0.1
 */