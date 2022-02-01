package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buy
  extends com.tencent.mm.bx.a
{
  public int GPh;
  public int GPi;
  public int GPj;
  public int GPk;
  public int GPl;
  public int GPm;
  public int GPn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GPh);
      paramVarArgs.aS(2, this.GPi);
      paramVarArgs.aS(3, this.GPj);
      paramVarArgs.aS(4, this.GPk);
      paramVarArgs.aS(5, this.GPl);
      paramVarArgs.aS(6, this.GPm);
      paramVarArgs.aS(7, this.GPn);
      AppMethodBeat.o(211972);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GPh);
      int i = f.a.a.b.b.a.bz(2, this.GPi);
      int j = f.a.a.b.b.a.bz(3, this.GPj);
      int k = f.a.a.b.b.a.bz(4, this.GPk);
      int m = f.a.a.b.b.a.bz(5, this.GPl);
      int n = f.a.a.b.b.a.bz(6, this.GPm);
      int i1 = f.a.a.b.b.a.bz(7, this.GPn);
      AppMethodBeat.o(211972);
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
      AppMethodBeat.o(211972);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buy localbuy = (buy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211972);
        return -1;
      case 1: 
        localbuy.GPh = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      case 2: 
        localbuy.GPi = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      case 3: 
        localbuy.GPj = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      case 4: 
        localbuy.GPk = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      case 5: 
        localbuy.GPl = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      case 6: 
        localbuy.GPm = locala.NPN.zc();
        AppMethodBeat.o(211972);
        return 0;
      }
      localbuy.GPn = locala.NPN.zc();
      AppMethodBeat.o(211972);
      return 0;
    }
    AppMethodBeat.o(211972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buy
 * JD-Core Version:    0.7.0.1
 */