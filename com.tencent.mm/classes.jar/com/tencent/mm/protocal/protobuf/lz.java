package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lz
  extends com.tencent.mm.bw.a
{
  public int FXi;
  public String FXj;
  public int FXk;
  public int FXl;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      paramVarArgs.aS(2, this.FXi);
      if (this.FXj != null) {
        paramVarArgs.d(3, this.FXj);
      }
      paramVarArgs.aS(4, this.FXk);
      paramVarArgs.aS(5, this.FXl);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FXi);
      paramInt = i;
      if (this.FXj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FXj);
      }
      i = f.a.a.b.b.a.bz(4, this.FXk);
      int j = f.a.a.b.b.a.bz(5, this.FXl);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          locallz.nIJ = locala.OmT.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          locallz.FXi = locala.OmT.zc();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          locallz.FXj = locala.OmT.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          locallz.FXk = locala.OmT.zc();
          AppMethodBeat.o(124393);
          return 0;
        }
        locallz.FXl = locala.OmT.zc();
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