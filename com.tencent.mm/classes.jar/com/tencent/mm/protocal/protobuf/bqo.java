package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqo
  extends com.tencent.mm.bx.a
{
  public int ZYx;
  public int ZYy;
  public String oUw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257611);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oUw != null) {
        paramVarArgs.g(1, this.oUw);
      }
      paramVarArgs.bS(2, this.ZYx);
      paramVarArgs.bS(3, this.ZYy);
      AppMethodBeat.o(257611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUw == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.oUw) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZYx);
      int j = i.a.a.b.b.a.cJ(3, this.ZYy);
      AppMethodBeat.o(257611);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257611);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bqo localbqo = (bqo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257611);
          return -1;
        case 1: 
          localbqo.oUw = locala.ajGk.readString();
          AppMethodBeat.o(257611);
          return 0;
        case 2: 
          localbqo.ZYx = locala.ajGk.aar();
          AppMethodBeat.o(257611);
          return 0;
        }
        localbqo.ZYy = locala.ajGk.aar();
        AppMethodBeat.o(257611);
        return 0;
      }
      AppMethodBeat.o(257611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqo
 * JD-Core Version:    0.7.0.1
 */