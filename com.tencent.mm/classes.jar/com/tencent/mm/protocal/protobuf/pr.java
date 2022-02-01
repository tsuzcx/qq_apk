package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pr
  extends com.tencent.mm.bx.a
{
  public int FKM;
  public int FKN;
  public int FKO;
  public String FKP;
  public int FKQ;
  public int FKR;
  public int FKS;
  public String FKT;
  public String duW;
  public String plf;
  public int ySZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      paramVarArgs.aS(2, this.FKM);
      paramVarArgs.aS(3, this.FKN);
      if (this.plf != null) {
        paramVarArgs.d(4, this.plf);
      }
      paramVarArgs.aS(5, this.FKO);
      if (this.FKP != null) {
        paramVarArgs.d(6, this.FKP);
      }
      paramVarArgs.aS(7, this.FKQ);
      paramVarArgs.aS(8, this.FKR);
      paramVarArgs.aS(9, this.FKS);
      if (this.FKT != null) {
        paramVarArgs.d(10, this.FKT);
      }
      paramVarArgs.aS(15, this.ySZ);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FKM) + f.a.a.b.b.a.bz(3, this.FKN);
      paramInt = i;
      if (this.plf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.plf);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FKO);
      paramInt = i;
      if (this.FKP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FKP);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FKQ) + f.a.a.b.b.a.bz(8, this.FKR) + f.a.a.b.b.a.bz(9, this.FKS);
      paramInt = i;
      if (this.FKT != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FKT);
      }
      i = f.a.a.b.b.a.bz(15, this.ySZ);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pr localpr = (pr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(117838);
          return -1;
        case 1: 
          localpr.duW = locala.NPN.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localpr.FKM = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localpr.FKN = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localpr.plf = locala.NPN.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localpr.FKO = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localpr.FKP = locala.NPN.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localpr.FKQ = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localpr.FKR = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localpr.FKS = locala.NPN.zc();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localpr.FKT = locala.NPN.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localpr.ySZ = locala.NPN.zc();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */