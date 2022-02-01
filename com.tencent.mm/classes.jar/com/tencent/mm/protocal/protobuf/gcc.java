package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gcc
  extends com.tencent.mm.bx.a
{
  public String aaGI;
  public b acam;
  public String method;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257714);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.method != null) {
        paramVarArgs.g(1, this.method);
      }
      if (this.aaGI != null) {
        paramVarArgs.g(2, this.aaGI);
      }
      if (this.acam != null) {
        paramVarArgs.d(3, this.acam);
      }
      AppMethodBeat.o(257714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.method == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.method) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaGI);
      }
      i = paramInt;
      if (this.acam != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.acam);
      }
      AppMethodBeat.o(257714);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257714);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gcc localgcc = (gcc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257714);
          return -1;
        case 1: 
          localgcc.method = locala.ajGk.readString();
          AppMethodBeat.o(257714);
          return 0;
        case 2: 
          localgcc.aaGI = locala.ajGk.readString();
          AppMethodBeat.o(257714);
          return 0;
        }
        localgcc.acam = locala.ajGk.kFX();
        AppMethodBeat.o(257714);
        return 0;
      }
      AppMethodBeat.o(257714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcc
 * JD-Core Version:    0.7.0.1
 */