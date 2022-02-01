package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejk
  extends com.tencent.mm.bx.a
{
  public String data;
  public String wum;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114056);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wum != null) {
        paramVarArgs.g(1, this.wum);
      }
      if (this.data != null) {
        paramVarArgs.g(2, this.data);
      }
      AppMethodBeat.o(114056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wum == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.wum) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.data != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.data);
      }
      AppMethodBeat.o(114056);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114056);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ejk localejk = (ejk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114056);
          return -1;
        case 1: 
          localejk.wum = locala.ajGk.readString();
          AppMethodBeat.o(114056);
          return 0;
        }
        localejk.data = locala.ajGk.readString();
        AppMethodBeat.o(114056);
        return 0;
      }
      AppMethodBeat.o(114056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejk
 * JD-Core Version:    0.7.0.1
 */