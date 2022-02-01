package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhk
  extends com.tencent.mm.bx.a
{
  public int HvR;
  public int HvS;
  public long HvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HvR);
      paramVarArgs.aS(2, this.HvS);
      paramVarArgs.aY(3, this.HvT);
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HvR);
      int i = f.a.a.b.b.a.bz(2, this.HvS);
      int j = f.a.a.b.b.a.p(3, this.HvT);
      AppMethodBeat.o(125839);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhk localdhk = (dhk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125839);
        return -1;
      case 1: 
        localdhk.HvR = locala.NPN.zc();
        AppMethodBeat.o(125839);
        return 0;
      case 2: 
        localdhk.HvS = locala.NPN.zc();
        AppMethodBeat.o(125839);
        return 0;
      }
      localdhk.HvT = locala.NPN.zd();
      AppMethodBeat.o(125839);
      return 0;
    }
    AppMethodBeat.o(125839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhk
 * JD-Core Version:    0.7.0.1
 */