package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public int Fpl;
  public int Fpm;
  public int Fpn;
  public int Fpo;
  public int Fpp;
  public int Fpq;
  public int Fpr;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Fpl);
      paramVarArgs.aS(2, this.action);
      paramVarArgs.aS(3, this.Fpm);
      paramVarArgs.aS(4, this.Fpn);
      paramVarArgs.aS(5, this.Fpo);
      paramVarArgs.aS(6, this.Fpp);
      paramVarArgs.aS(7, this.Fpq);
      paramVarArgs.aS(8, this.Fpr);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Fpl);
      int i = f.a.a.b.b.a.bz(2, this.action);
      int j = f.a.a.b.b.a.bz(3, this.Fpm);
      int k = f.a.a.b.b.a.bz(4, this.Fpn);
      int m = f.a.a.b.b.a.bz(5, this.Fpo);
      int n = f.a.a.b.b.a.bz(6, this.Fpp);
      int i1 = f.a.a.b.b.a.bz(7, this.Fpq);
      int i2 = f.a.a.b.b.a.bz(8, this.Fpr);
      AppMethodBeat.o(143955);
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
        locall.Fpl = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.Fpm = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.Fpn = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.Fpo = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.Fpp = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.Fpq = locala.NPN.zc();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.Fpr = locala.NPN.zc();
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