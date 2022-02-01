package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvq
  extends com.tencent.mm.bx.a
{
  public int DSS;
  public String hNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152642);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNI != null) {
        paramVarArgs.d(1, this.hNI);
      }
      paramVarArgs.aR(2, this.DSS);
      AppMethodBeat.o(152642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNI == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DSS);
      AppMethodBeat.o(152642);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152642);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvq localbvq = (bvq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152642);
          return -1;
        case 1: 
          localbvq.hNI = locala.KhF.readString();
          AppMethodBeat.o(152642);
          return 0;
        }
        localbvq.DSS = locala.KhF.xS();
        AppMethodBeat.o(152642);
        return 0;
      }
      AppMethodBeat.o(152642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvq
 * JD-Core Version:    0.7.0.1
 */