package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fr
  extends com.tencent.mm.bx.a
{
  public String FxR;
  public int FxS;
  public int FxT;
  public long FxU;
  public int FxV;
  public long hDP;
  public int idx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FxR != null) {
        paramVarArgs.d(1, this.FxR);
      }
      paramVarArgs.aY(2, this.hDP);
      paramVarArgs.aS(3, this.idx);
      paramVarArgs.aS(4, this.FxS);
      paramVarArgs.aS(5, this.FxT);
      paramVarArgs.aY(6, this.FxU);
      paramVarArgs.aS(7, this.FxV);
      if (this.url != null) {
        paramVarArgs.d(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FxR == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.FxR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.hDP) + f.a.a.b.b.a.bz(3, this.idx) + f.a.a.b.b.a.bz(4, this.FxS) + f.a.a.b.b.a.bz(5, this.FxT) + f.a.a.b.b.a.p(6, this.FxU) + f.a.a.b.b.a.bz(7, this.FxV);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localfr.FxR = locala.NPN.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localfr.hDP = locala.NPN.zd();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localfr.idx = locala.NPN.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localfr.FxS = locala.NPN.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localfr.FxT = locala.NPN.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localfr.FxU = locala.NPN.zd();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localfr.FxV = locala.NPN.zc();
          AppMethodBeat.o(124388);
          return 0;
        }
        localfr.url = locala.NPN.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */