package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class my
  extends com.tencent.mm.bx.a
{
  public String FGP;
  public int FGQ;
  public String FGR;
  public int FGS;
  public int FGT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGP != null) {
        paramVarArgs.d(1, this.FGP);
      }
      paramVarArgs.aS(2, this.FGQ);
      if (this.FGR != null) {
        paramVarArgs.d(3, this.FGR);
      }
      paramVarArgs.aS(4, this.FGS);
      paramVarArgs.aS(5, this.FGT);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGP == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.FGP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FGQ);
      paramInt = i;
      if (this.FGR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FGR);
      }
      i = f.a.a.b.b.a.bz(4, this.FGS);
      int j = f.a.a.b.b.a.bz(5, this.FGT);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        my localmy = (my)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localmy.FGP = locala.NPN.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localmy.FGQ = locala.NPN.zc();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localmy.FGR = locala.NPN.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localmy.FGS = locala.NPN.zc();
          AppMethodBeat.o(124415);
          return 0;
        }
        localmy.FGT = locala.NPN.zc();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.my
 * JD-Core Version:    0.7.0.1
 */