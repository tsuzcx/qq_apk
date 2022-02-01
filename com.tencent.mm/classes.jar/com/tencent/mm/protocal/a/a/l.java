package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public int FHJ;
  public int FHK;
  public int FHL;
  public int FHM;
  public int FHN;
  public int FHO;
  public int FHP;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHJ);
      paramVarArgs.aS(2, this.action);
      paramVarArgs.aS(3, this.FHK);
      paramVarArgs.aS(4, this.FHL);
      paramVarArgs.aS(5, this.FHM);
      paramVarArgs.aS(6, this.FHN);
      paramVarArgs.aS(7, this.FHO);
      paramVarArgs.aS(8, this.FHP);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FHJ);
      int i = f.a.a.b.b.a.bz(2, this.action);
      int j = f.a.a.b.b.a.bz(3, this.FHK);
      int k = f.a.a.b.b.a.bz(4, this.FHL);
      int m = f.a.a.b.b.a.bz(5, this.FHM);
      int n = f.a.a.b.b.a.bz(6, this.FHN);
      int i1 = f.a.a.b.b.a.bz(7, this.FHO);
      int i2 = f.a.a.b.b.a.bz(8, this.FHP);
      AppMethodBeat.o(143955);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.FHJ = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.FHK = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.FHL = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.FHM = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.FHN = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.FHO = locala.OmT.zc();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.FHP = locala.OmT.zc();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */