package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvs
  extends com.tencent.mm.bw.a
{
  public int HiJ;
  public int HiK;
  public int HiL;
  public int HiM;
  public int HiN;
  public int HiO;
  public int HiP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HiJ);
      paramVarArgs.aS(2, this.HiK);
      paramVarArgs.aS(3, this.HiL);
      paramVarArgs.aS(4, this.HiM);
      paramVarArgs.aS(5, this.HiN);
      paramVarArgs.aS(6, this.HiO);
      paramVarArgs.aS(7, this.HiP);
      AppMethodBeat.o(215590);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HiJ);
      int i = f.a.a.b.b.a.bz(2, this.HiK);
      int j = f.a.a.b.b.a.bz(3, this.HiL);
      int k = f.a.a.b.b.a.bz(4, this.HiM);
      int m = f.a.a.b.b.a.bz(5, this.HiN);
      int n = f.a.a.b.b.a.bz(6, this.HiO);
      int i1 = f.a.a.b.b.a.bz(7, this.HiP);
      AppMethodBeat.o(215590);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(215590);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvs localbvs = (bvs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215590);
        return -1;
      case 1: 
        localbvs.HiJ = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      case 2: 
        localbvs.HiK = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      case 3: 
        localbvs.HiL = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      case 4: 
        localbvs.HiM = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      case 5: 
        localbvs.HiN = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      case 6: 
        localbvs.HiO = locala.OmT.zc();
        AppMethodBeat.o(215590);
        return 0;
      }
      localbvs.HiP = locala.OmT.zc();
      AppMethodBeat.o(215590);
      return 0;
    }
    AppMethodBeat.o(215590);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvs
 * JD-Core Version:    0.7.0.1
 */