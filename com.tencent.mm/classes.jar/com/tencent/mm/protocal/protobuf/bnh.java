package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnh
  extends com.tencent.mm.bx.a
{
  public long GHm;
  public int GHn;
  public long GHo;
  public int GHp;
  public long GHq;
  public int GHr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GHm);
      paramVarArgs.aS(2, this.GHn);
      paramVarArgs.aY(3, this.GHo);
      paramVarArgs.aS(4, this.GHp);
      paramVarArgs.aY(5, this.GHq);
      paramVarArgs.aS(6, this.GHr);
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GHm);
      int i = f.a.a.b.b.a.bz(2, this.GHn);
      int j = f.a.a.b.b.a.p(3, this.GHo);
      int k = f.a.a.b.b.a.bz(4, this.GHp);
      int m = f.a.a.b.b.a.p(5, this.GHq);
      int n = f.a.a.b.b.a.bz(6, this.GHr);
      AppMethodBeat.o(115845);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(115845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnh localbnh = (bnh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115845);
        return -1;
      case 1: 
        localbnh.GHm = locala.NPN.zd();
        AppMethodBeat.o(115845);
        return 0;
      case 2: 
        localbnh.GHn = locala.NPN.zc();
        AppMethodBeat.o(115845);
        return 0;
      case 3: 
        localbnh.GHo = locala.NPN.zd();
        AppMethodBeat.o(115845);
        return 0;
      case 4: 
        localbnh.GHp = locala.NPN.zc();
        AppMethodBeat.o(115845);
        return 0;
      case 5: 
        localbnh.GHq = locala.NPN.zd();
        AppMethodBeat.o(115845);
        return 0;
      }
      localbnh.GHr = locala.NPN.zc();
      AppMethodBeat.o(115845);
      return 0;
    }
    AppMethodBeat.o(115845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnh
 * JD-Core Version:    0.7.0.1
 */