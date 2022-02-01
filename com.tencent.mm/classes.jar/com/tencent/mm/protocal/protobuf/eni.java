package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eni
  extends com.tencent.mm.bx.a
{
  public String abrS;
  public String abrT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260027);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abrS != null) {
        paramVarArgs.g(1, this.abrS);
      }
      if (this.abrT != null) {
        paramVarArgs.g(2, this.abrT);
      }
      AppMethodBeat.o(260027);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abrS == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abrS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abrT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abrT);
      }
      AppMethodBeat.o(260027);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260027);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eni localeni = (eni)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260027);
          return -1;
        case 1: 
          localeni.abrS = locala.ajGk.readString();
          AppMethodBeat.o(260027);
          return 0;
        }
        localeni.abrT = locala.ajGk.readString();
        AppMethodBeat.o(260027);
        return 0;
      }
      AppMethodBeat.o(260027);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eni
 * JD-Core Version:    0.7.0.1
 */