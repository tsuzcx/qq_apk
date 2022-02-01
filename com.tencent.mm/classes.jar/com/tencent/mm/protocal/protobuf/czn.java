package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czn
  extends com.tencent.mm.bx.a
{
  public String aaEU;
  public String aaEV;
  public String mOI;
  public long startTime;
  public String vXL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258981);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaEU != null) {
        paramVarArgs.g(1, this.aaEU);
      }
      if (this.mOI != null) {
        paramVarArgs.g(2, this.mOI);
      }
      if (this.aaEV != null) {
        paramVarArgs.g(3, this.aaEV);
      }
      if (this.vXL != null) {
        paramVarArgs.g(5, this.vXL);
      }
      paramVarArgs.bv(6, this.startTime);
      AppMethodBeat.o(258981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaEU == null) {
        break label442;
      }
    }
    label442:
    for (int i = i.a.a.b.b.a.h(1, this.aaEU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mOI);
      }
      i = paramInt;
      if (this.aaEV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaEV);
      }
      paramInt = i;
      if (this.vXL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.vXL);
      }
      i = i.a.a.b.b.a.q(6, this.startTime);
      AppMethodBeat.o(258981);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258981);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        czn localczn = (czn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        default: 
          AppMethodBeat.o(258981);
          return -1;
        case 1: 
          localczn.aaEU = locala.ajGk.readString();
          AppMethodBeat.o(258981);
          return 0;
        case 2: 
          localczn.mOI = locala.ajGk.readString();
          AppMethodBeat.o(258981);
          return 0;
        case 3: 
          localczn.aaEV = locala.ajGk.readString();
          AppMethodBeat.o(258981);
          return 0;
        case 5: 
          localczn.vXL = locala.ajGk.readString();
          AppMethodBeat.o(258981);
          return 0;
        }
        localczn.startTime = locala.ajGk.aaw();
        AppMethodBeat.o(258981);
        return 0;
      }
      AppMethodBeat.o(258981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czn
 * JD-Core Version:    0.7.0.1
 */