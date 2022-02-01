package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atz
  extends com.tencent.mm.bw.a
{
  public String GKR;
  public String GKS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKR != null) {
        paramVarArgs.d(1, this.GKR);
      }
      if (this.GKS != null) {
        paramVarArgs.d(2, this.GKS);
      }
      AppMethodBeat.o(169383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKR == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GKR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GKS);
      }
      AppMethodBeat.o(169383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169383);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        atz localatz = (atz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169383);
          return -1;
        case 1: 
          localatz.GKR = locala.OmT.readString();
          AppMethodBeat.o(169383);
          return 0;
        }
        localatz.GKS = locala.OmT.readString();
        AppMethodBeat.o(169383);
        return 0;
      }
      AppMethodBeat.o(169383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atz
 * JD-Core Version:    0.7.0.1
 */