package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chg
  extends com.tencent.mm.bx.a
{
  public boolean HaG = false;
  public String HaH;
  public boolean HaI;
  public int aHQ = 0;
  public String dtL = "";
  public String dyV = "";
  public int dyx = -1;
  public long endTime = 0L;
  public long seq = 0L;
  public String ssn = "";
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyV != null) {
        paramVarArgs.d(1, this.dyV);
      }
      paramVarArgs.bt(2, this.HaG);
      paramVarArgs.aY(3, this.seq);
      paramVarArgs.aY(4, this.startTime);
      paramVarArgs.aY(5, this.endTime);
      paramVarArgs.aS(6, this.dyx);
      if (this.dtL != null) {
        paramVarArgs.d(7, this.dtL);
      }
      paramVarArgs.aS(8, this.aHQ);
      if (this.HaH != null) {
        paramVarArgs.d(9, this.HaH);
      }
      paramVarArgs.bt(10, this.HaI);
      if (this.ssn != null) {
        paramVarArgs.d(11, this.ssn);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyV == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.p(3, this.seq) + f.a.a.b.b.a.p(4, this.startTime) + f.a.a.b.b.a.p(5, this.endTime) + f.a.a.b.b.a.bz(6, this.dyx);
      paramInt = i;
      if (this.dtL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dtL);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.aHQ);
      paramInt = i;
      if (this.HaH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HaH);
      }
      i = paramInt + f.a.a.b.b.a.alV(10);
      paramInt = i;
      if (this.ssn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ssn);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chg localchg = (chg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localchg.dyV = locala.NPN.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localchg.HaG = locala.NPN.grw();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localchg.seq = locala.NPN.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localchg.startTime = locala.NPN.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localchg.endTime = locala.NPN.zd();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localchg.dyx = locala.NPN.zc();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localchg.dtL = locala.NPN.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localchg.aHQ = locala.NPN.zc();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localchg.HaH = locala.NPN.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localchg.HaI = locala.NPN.grw();
          AppMethodBeat.o(122521);
          return 0;
        }
        localchg.ssn = locala.NPN.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chg
 * JD-Core Version:    0.7.0.1
 */