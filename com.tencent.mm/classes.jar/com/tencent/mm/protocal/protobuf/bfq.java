package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bfq
  extends com.tencent.mm.bx.a
{
  public b CEi;
  public b CEk;
  public int fVE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CEk != null) {
        paramVarArgs.c(1, this.CEk);
      }
      if (this.CEi != null) {
        paramVarArgs.c(2, this.CEi);
      }
      paramVarArgs.aR(3, this.fVE);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CEk == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.b(1, this.CEk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CEi != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.CEi);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.fVE);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfq localbfq = (bfq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localbfq.CEk = locala.KhF.fMu();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localbfq.CEi = locala.KhF.fMu();
          AppMethodBeat.o(124514);
          return 0;
        }
        localbfq.fVE = locala.KhF.xS();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfq
 * JD-Core Version:    0.7.0.1
 */