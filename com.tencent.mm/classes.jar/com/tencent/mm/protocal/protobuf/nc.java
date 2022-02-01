package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class nc
  extends com.tencent.mm.bx.a
{
  public b CKM;
  public int CKN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124442);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CKM != null) {
        paramVarArgs.c(1, this.CKM);
      }
      paramVarArgs.aR(2, this.CKN);
      AppMethodBeat.o(124442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CKM == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.b(1, this.CKM) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CKN);
      AppMethodBeat.o(124442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124442);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nc localnc = (nc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124442);
          return -1;
        case 1: 
          localnc.CKM = locala.KhF.fMu();
          AppMethodBeat.o(124442);
          return 0;
        }
        localnc.CKN = locala.KhF.xS();
        AppMethodBeat.o(124442);
        return 0;
      }
      AppMethodBeat.o(124442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nc
 * JD-Core Version:    0.7.0.1
 */