package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnv
  extends com.tencent.mm.bx.a
{
  public int ZRL;
  public String ZWt;
  public int time_limit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258521);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZWt != null) {
        paramVarArgs.g(1, this.ZWt);
      }
      paramVarArgs.bS(2, this.time_limit);
      paramVarArgs.bS(3, this.ZRL);
      AppMethodBeat.o(258521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZWt == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZWt) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.time_limit);
      int j = i.a.a.b.b.a.cJ(3, this.ZRL);
      AppMethodBeat.o(258521);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258521);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bnv localbnv = (bnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258521);
          return -1;
        case 1: 
          localbnv.ZWt = locala.ajGk.readString();
          AppMethodBeat.o(258521);
          return 0;
        case 2: 
          localbnv.time_limit = locala.ajGk.aar();
          AppMethodBeat.o(258521);
          return 0;
        }
        localbnv.ZRL = locala.ajGk.aar();
        AppMethodBeat.o(258521);
        return 0;
      }
      AppMethodBeat.o(258521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnv
 * JD-Core Version:    0.7.0.1
 */