package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class np
  extends com.tencent.mm.bx.a
{
  public String YPE;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258574);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      if (this.YPE != null) {
        paramVarArgs.g(3, this.YPE);
      }
      AppMethodBeat.o(258574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.path);
      }
      i = paramInt;
      if (this.YPE != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YPE);
      }
      AppMethodBeat.o(258574);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258574);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        np localnp = (np)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258574);
          return -1;
        case 1: 
          localnp.username = locala.ajGk.readString();
          AppMethodBeat.o(258574);
          return 0;
        case 2: 
          localnp.path = locala.ajGk.readString();
          AppMethodBeat.o(258574);
          return 0;
        }
        localnp.YPE = locala.ajGk.readString();
        AppMethodBeat.o(258574);
        return 0;
      }
      AppMethodBeat.o(258574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.np
 * JD-Core Version:    0.7.0.1
 */