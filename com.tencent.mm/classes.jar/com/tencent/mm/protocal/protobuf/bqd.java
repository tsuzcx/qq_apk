package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqd
  extends com.tencent.mm.bx.a
{
  public String Cxb;
  public int vJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138183);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxb != null) {
        paramVarArgs.d(1, this.Cxb);
      }
      paramVarArgs.aR(2, this.vJA);
      AppMethodBeat.o(138183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxb == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Cxb) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.vJA);
      AppMethodBeat.o(138183);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(138183);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqd localbqd = (bqd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138183);
          return -1;
        case 1: 
          localbqd.Cxb = locala.KhF.readString();
          AppMethodBeat.o(138183);
          return 0;
        }
        localbqd.vJA = locala.KhF.xS();
        AppMethodBeat.o(138183);
        return 0;
      }
      AppMethodBeat.o(138183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqd
 * JD-Core Version:    0.7.0.1
 */