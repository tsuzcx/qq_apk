package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lz
  extends com.tencent.mm.bx.a
{
  public int FEN;
  public String FEO;
  public int FEP;
  public int FEQ;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      paramVarArgs.aS(2, this.FEN);
      if (this.FEO != null) {
        paramVarArgs.d(3, this.FEO);
      }
      paramVarArgs.aS(4, this.FEP);
      paramVarArgs.aS(5, this.FEQ);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FEN);
      paramInt = i;
      if (this.FEO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FEO);
      }
      i = f.a.a.b.b.a.bz(4, this.FEP);
      int j = f.a.a.b.b.a.bz(5, this.FEQ);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        lz locallz = (lz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          locallz.nDo = locala.NPN.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          locallz.FEN = locala.NPN.zc();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          locallz.FEO = locala.NPN.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          locallz.FEP = locala.NPN.zc();
          AppMethodBeat.o(124393);
          return 0;
        }
        locallz.FEQ = locala.NPN.zc();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lz
 * JD-Core Version:    0.7.0.1
 */