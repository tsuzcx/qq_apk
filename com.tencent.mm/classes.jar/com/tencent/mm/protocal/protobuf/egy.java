package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egy
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GLq;
  public int GQN;
  public int GQO;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLq);
      paramVarArgs.aS(2, this.FFN);
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(5, this.GQO);
      paramVarArgs.aS(6, this.GQN);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GLq);
      int i = f.a.a.b.b.a.bz(2, this.FFN);
      int j = f.a.a.b.b.a.bz(3, this.Scene);
      int k = f.a.a.b.b.a.bz(5, this.GQO);
      int m = f.a.a.b.b.a.bz(6, this.GQN);
      AppMethodBeat.o(50118);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      egy localegy = (egy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localegy.GLq = locala.NPN.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localegy.FFN = locala.NPN.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localegy.Scene = locala.NPN.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localegy.GQO = locala.NPN.zc();
        AppMethodBeat.o(50118);
        return 0;
      }
      localegy.GQN = locala.NPN.zc();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egy
 * JD-Core Version:    0.7.0.1
 */