package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class so
  extends com.tencent.mm.bx.a
{
  public int CLl;
  public String CUv;
  public String dyc;
  public int nrv;
  public String nvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      if (this.nvx != null) {
        paramVarArgs.d(2, this.nvx);
      }
      paramVarArgs.aR(3, this.nrv);
      paramVarArgs.aR(4, this.CLl);
      if (this.CUv != null) {
        paramVarArgs.d(5, this.CUv);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nvx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nvx);
      }
      i = i + f.a.a.b.b.a.bA(3, this.nrv) + f.a.a.b.b.a.bA(4, this.CLl);
      paramInt = i;
      if (this.CUv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CUv);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localso.dyc = locala.KhF.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localso.nvx = locala.KhF.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localso.nrv = locala.KhF.xS();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localso.CLl = locala.KhF.xS();
          AppMethodBeat.o(113981);
          return 0;
        }
        localso.CUv = locala.KhF.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */