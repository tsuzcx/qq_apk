package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbv
  extends com.tencent.mm.bx.a
{
  public String ZGM;
  public String aale;
  public int aalf;
  public int aalg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258097);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZGM != null) {
        paramVarArgs.g(1, this.ZGM);
      }
      if (this.aale != null) {
        paramVarArgs.g(2, this.aale);
      }
      paramVarArgs.bS(3, this.aalf);
      paramVarArgs.bS(4, this.aalg);
      AppMethodBeat.o(258097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZGM == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZGM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aale != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aale);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aalf);
      int j = i.a.a.b.b.a.cJ(4, this.aalg);
      AppMethodBeat.o(258097);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258097);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbv localcbv = (cbv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258097);
          return -1;
        case 1: 
          localcbv.ZGM = locala.ajGk.readString();
          AppMethodBeat.o(258097);
          return 0;
        case 2: 
          localcbv.aale = locala.ajGk.readString();
          AppMethodBeat.o(258097);
          return 0;
        case 3: 
          localcbv.aalf = locala.ajGk.aar();
          AppMethodBeat.o(258097);
          return 0;
        }
        localcbv.aalg = locala.ajGk.aar();
        AppMethodBeat.o(258097);
        return 0;
      }
      AppMethodBeat.o(258097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */