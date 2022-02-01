package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mr
  extends com.tencent.mm.bx.a
{
  public int FGA;
  public int FGB;
  public int FGC;
  public int FGD;
  public int FGz;
  public int FxI;
  public int enabled;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.enabled);
      paramVarArgs.aS(2, this.FGz);
      paramVarArgs.aS(3, this.FGA);
      paramVarArgs.aS(4, this.FGB);
      paramVarArgs.aS(5, this.FGC);
      paramVarArgs.aS(6, this.FGD);
      paramVarArgs.aS(7, this.FxI);
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.enabled);
      int i = f.a.a.b.b.a.bz(2, this.FGz);
      int j = f.a.a.b.b.a.bz(3, this.FGA);
      int k = f.a.a.b.b.a.bz(4, this.FGB);
      int m = f.a.a.b.b.a.bz(5, this.FGC);
      int n = f.a.a.b.b.a.bz(6, this.FGD);
      int i1 = f.a.a.b.b.a.bz(7, this.FxI);
      AppMethodBeat.o(103202);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mr localmr = (mr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103202);
        return -1;
      case 1: 
        localmr.enabled = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 2: 
        localmr.FGz = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 3: 
        localmr.FGA = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 4: 
        localmr.FGB = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 5: 
        localmr.FGC = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 6: 
        localmr.FGD = locala.NPN.zc();
        AppMethodBeat.o(103202);
        return 0;
      }
      localmr.FxI = locala.NPN.zc();
      AppMethodBeat.o(103202);
      return 0;
    }
    AppMethodBeat.o(103202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mr
 * JD-Core Version:    0.7.0.1
 */