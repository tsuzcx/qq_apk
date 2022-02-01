package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpr
  extends com.tencent.mm.bx.a
{
  public long GKo;
  public int GKp;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.key);
      paramVarArgs.aY(2, this.GKo);
      paramVarArgs.aS(3, this.length);
      paramVarArgs.aS(4, this.GKp);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.key);
      int i = f.a.a.b.b.a.p(2, this.GKo);
      int j = f.a.a.b.b.a.bz(3, this.length);
      int k = f.a.a.b.b.a.bz(4, this.GKp);
      AppMethodBeat.o(111786);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpr localbpr = (bpr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localbpr.key = locala.NPN.zc();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localbpr.GKo = locala.NPN.zd();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localbpr.length = locala.NPN.zc();
        AppMethodBeat.o(111786);
        return 0;
      }
      localbpr.GKp = locala.NPN.zc();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpr
 * JD-Core Version:    0.7.0.1
 */