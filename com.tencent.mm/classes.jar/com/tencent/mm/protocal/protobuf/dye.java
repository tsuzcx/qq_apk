package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dye
  extends com.tencent.mm.bx.a
{
  public int ZFI;
  public String hMM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152654);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      paramVarArgs.bS(2, this.ZFI);
      AppMethodBeat.o(152654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.hMM) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZFI);
      AppMethodBeat.o(152654);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152654);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dye localdye = (dye)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152654);
          return -1;
        case 1: 
          localdye.hMM = locala.ajGk.readString();
          AppMethodBeat.o(152654);
          return 0;
        }
        localdye.ZFI = locala.ajGk.aar();
        AppMethodBeat.o(152654);
        return 0;
      }
      AppMethodBeat.o(152654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dye
 * JD-Core Version:    0.7.0.1
 */