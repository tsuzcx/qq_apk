package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int FHT;
  public int FHU;
  public int FHV;
  public int FHW;
  public int FHX;
  public int FHY;
  public int FHk;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHk);
      paramVarArgs.aS(2, this.FHT);
      paramVarArgs.aS(3, this.FHU);
      paramVarArgs.aS(4, this.FHV);
      paramVarArgs.aS(5, this.FHW);
      paramVarArgs.aS(6, this.FHX);
      paramVarArgs.aS(7, this.FHY);
      paramVarArgs.aS(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FHk);
      int i = f.a.a.b.b.a.bz(2, this.FHT);
      int j = f.a.a.b.b.a.bz(3, this.FHU);
      int k = f.a.a.b.b.a.bz(4, this.FHV);
      int m = f.a.a.b.b.a.bz(5, this.FHW);
      int n = f.a.a.b.b.a.bz(6, this.FHX);
      int i1 = f.a.a.b.b.a.bz(7, this.FHY);
      int i2 = f.a.a.b.b.a.bz(8, this.type);
      AppMethodBeat.o(143958);
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
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143958);
        return -1;
      case 1: 
        localn.FHk = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.FHT = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.FHU = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.FHV = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.FHW = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.FHX = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.FHY = locala.OmT.zc();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.OmT.zc();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */