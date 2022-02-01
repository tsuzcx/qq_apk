package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int FoM;
  public int FpA;
  public int Fpv;
  public int Fpw;
  public int Fpx;
  public int Fpy;
  public int Fpz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FoM);
      paramVarArgs.aS(2, this.Fpv);
      paramVarArgs.aS(3, this.Fpw);
      paramVarArgs.aS(4, this.Fpx);
      paramVarArgs.aS(5, this.Fpy);
      paramVarArgs.aS(6, this.Fpz);
      paramVarArgs.aS(7, this.FpA);
      paramVarArgs.aS(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FoM);
      int i = f.a.a.b.b.a.bz(2, this.Fpv);
      int j = f.a.a.b.b.a.bz(3, this.Fpw);
      int k = f.a.a.b.b.a.bz(4, this.Fpx);
      int m = f.a.a.b.b.a.bz(5, this.Fpy);
      int n = f.a.a.b.b.a.bz(6, this.Fpz);
      int i1 = f.a.a.b.b.a.bz(7, this.FpA);
      int i2 = f.a.a.b.b.a.bz(8, this.type);
      AppMethodBeat.o(143958);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localn.FoM = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.Fpv = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.Fpw = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.Fpx = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.Fpy = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.Fpz = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.FpA = locala.NPN.zc();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.NPN.zc();
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