package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdk
  extends com.tencent.mm.bv.a
{
  public String qEF;
  public int qEG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114978);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qEF != null) {
        paramVarArgs.e(1, this.qEF);
      }
      paramVarArgs.aO(2, this.qEG);
      AppMethodBeat.o(114978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qEF == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.qEF) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.qEG);
      AppMethodBeat.o(114978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114978);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bdk localbdk = (bdk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114978);
          return -1;
        case 1: 
          localbdk.qEF = locala.CLY.readString();
          AppMethodBeat.o(114978);
          return 0;
        }
        localbdk.qEG = locala.CLY.sl();
        AppMethodBeat.o(114978);
        return 0;
      }
      AppMethodBeat.o(114978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdk
 * JD-Core Version:    0.7.0.1
 */