package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwv
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GLq;
  public int GQN;
  public int GQO;
  public String GQP;
  public int GQQ;
  public int Scene;
  public String duW;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aS(3, this.GLq);
      paramVarArgs.aS(4, this.FFN);
      paramVarArgs.aS(5, this.Scene);
      paramVarArgs.aS(6, this.GQN);
      paramVarArgs.aS(7, this.GQO);
      if (this.GQP != null) {
        paramVarArgs.d(8, this.GQP);
      }
      paramVarArgs.aS(9, this.GQQ);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GLq) + f.a.a.b.b.a.bz(4, this.FFN) + f.a.a.b.b.a.bz(5, this.Scene) + f.a.a.b.b.a.bz(6, this.GQN) + f.a.a.b.b.a.bz(7, this.GQO);
      paramInt = i;
      if (this.GQP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GQP);
      }
      i = f.a.a.b.b.a.bz(9, this.GQQ);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwv localbwv = (bwv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localbwv.duW = locala.NPN.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localbwv.username = locala.NPN.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localbwv.GLq = locala.NPN.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localbwv.FFN = locala.NPN.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localbwv.Scene = locala.NPN.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localbwv.GQN = locala.NPN.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localbwv.GQO = locala.NPN.zc();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localbwv.GQP = locala.NPN.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localbwv.GQQ = locala.NPN.zc();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwv
 * JD-Core Version:    0.7.0.1
 */