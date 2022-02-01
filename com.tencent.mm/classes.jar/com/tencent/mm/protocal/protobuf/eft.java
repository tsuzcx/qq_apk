package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eft
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GLq;
  public int GQN;
  public int GQO;
  public String GQP;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLq);
      paramVarArgs.aS(2, this.FFN);
      paramVarArgs.aS(3, this.Scene);
      if (this.GQP != null) {
        paramVarArgs.d(4, this.GQP);
      }
      paramVarArgs.aS(5, this.GQO);
      paramVarArgs.aS(6, this.GQN);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GLq) + 0 + f.a.a.b.b.a.bz(2, this.FFN) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GQP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GQP);
      }
      i = f.a.a.b.b.a.bz(5, this.GQO);
      int j = f.a.a.b.b.a.bz(6, this.GQN);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eft localeft = (eft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localeft.GLq = locala.NPN.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localeft.FFN = locala.NPN.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localeft.Scene = locala.NPN.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localeft.GQP = locala.NPN.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localeft.GQO = locala.NPN.zc();
        AppMethodBeat.o(123683);
        return 0;
      }
      localeft.GQN = locala.NPN.zc();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eft
 * JD-Core Version:    0.7.0.1
 */