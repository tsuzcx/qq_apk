package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqi
  extends com.tencent.mm.bx.a
{
  public int Fzq;
  public String GKI;
  public String GKJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKI != null) {
        paramVarArgs.d(1, this.GKI);
      }
      paramVarArgs.aS(2, this.Fzq);
      if (this.GKJ != null) {
        paramVarArgs.d(3, this.GKJ);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKI == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GKI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Fzq);
      paramInt = i;
      if (this.GKJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GKJ);
      }
      AppMethodBeat.o(82432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqi localbqi = (bqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localbqi.GKI = locala.NPN.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localbqi.Fzq = locala.NPN.zc();
          AppMethodBeat.o(82432);
          return 0;
        }
        localbqi.GKJ = locala.NPN.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqi
 * JD-Core Version:    0.7.0.1
 */