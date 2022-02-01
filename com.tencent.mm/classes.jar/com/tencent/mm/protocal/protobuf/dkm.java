package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkm
  extends com.tencent.mm.bx.a
{
  public int dmD;
  public String dmE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dmE != null) {
        paramVarArgs.d(1, this.dmE);
      }
      paramVarArgs.aR(2, this.dmD);
      AppMethodBeat.o(103210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dmE == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.dmE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.dmD);
      AppMethodBeat.o(103210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkm localdkm = (dkm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103210);
          return -1;
        case 1: 
          localdkm.dmE = locala.KhF.readString();
          AppMethodBeat.o(103210);
          return 0;
        }
        localdkm.dmD = locala.KhF.xS();
        AppMethodBeat.o(103210);
        return 0;
      }
      AppMethodBeat.o(103210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkm
 * JD-Core Version:    0.7.0.1
 */