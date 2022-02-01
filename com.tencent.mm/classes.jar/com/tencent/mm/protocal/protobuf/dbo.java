package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbo
  extends com.tencent.mm.bx.a
{
  public int Hrn;
  public int Hro;
  public int Hrp;
  public int Hrq;
  public int Hrr;
  public int Hrs;
  public int Hrt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hrn);
      paramVarArgs.aS(2, this.Hro);
      paramVarArgs.aS(3, this.Hrp);
      paramVarArgs.aS(4, this.Hrq);
      paramVarArgs.aS(5, this.Hrr);
      paramVarArgs.aS(6, this.Hrs);
      paramVarArgs.aS(7, this.Hrt);
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hrn);
      int i = f.a.a.b.b.a.bz(2, this.Hro);
      int j = f.a.a.b.b.a.bz(3, this.Hrp);
      int k = f.a.a.b.b.a.bz(4, this.Hrq);
      int m = f.a.a.b.b.a.bz(5, this.Hrr);
      int n = f.a.a.b.b.a.bz(6, this.Hrs);
      int i1 = f.a.a.b.b.a.bz(7, this.Hrt);
      AppMethodBeat.o(124550);
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
      AppMethodBeat.o(124550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbo localdbo = (dbo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124550);
        return -1;
      case 1: 
        localdbo.Hrn = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 2: 
        localdbo.Hro = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 3: 
        localdbo.Hrp = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 4: 
        localdbo.Hrq = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 5: 
        localdbo.Hrr = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      case 6: 
        localdbo.Hrs = locala.NPN.zc();
        AppMethodBeat.o(124550);
        return 0;
      }
      localdbo.Hrt = locala.NPN.zc();
      AppMethodBeat.o(124550);
      return 0;
    }
    AppMethodBeat.o(124550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */