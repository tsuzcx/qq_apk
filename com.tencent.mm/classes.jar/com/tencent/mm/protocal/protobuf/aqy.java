package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqy
  extends com.tencent.mm.bx.a
{
  public String qXj;
  public String qXu;
  public int rTD;
  public String sessionId;
  public int ssv;
  public long tcj;
  public String tck;
  public int tcl;
  public int tcm;
  public int tcn;
  public String tco;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209352);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.qXu != null) {
        paramVarArgs.d(2, this.qXu);
      }
      if (this.qXj != null) {
        paramVarArgs.d(3, this.qXj);
      }
      if (this.tck != null) {
        paramVarArgs.d(4, this.tck);
      }
      paramVarArgs.aS(5, this.ssv);
      paramVarArgs.aS(6, this.rTD);
      paramVarArgs.aY(7, this.tcj);
      paramVarArgs.aS(8, this.tcl);
      paramVarArgs.aS(9, this.tcm);
      if (this.tco != null) {
        paramVarArgs.d(10, this.tco);
      }
      paramVarArgs.aS(11, this.tcn);
      AppMethodBeat.o(209352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.b.b.a.e(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qXu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qXu);
      }
      i = paramInt;
      if (this.qXj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qXj);
      }
      paramInt = i;
      if (this.tck != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tck);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ssv) + f.a.a.b.b.a.bz(6, this.rTD) + f.a.a.b.b.a.p(7, this.tcj) + f.a.a.b.b.a.bz(8, this.tcl) + f.a.a.b.b.a.bz(9, this.tcm);
      paramInt = i;
      if (this.tco != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tco);
      }
      i = f.a.a.b.b.a.bz(11, this.tcn);
      AppMethodBeat.o(209352);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209352);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqy localaqy = (aqy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209352);
          return -1;
        case 1: 
          localaqy.sessionId = locala.NPN.readString();
          AppMethodBeat.o(209352);
          return 0;
        case 2: 
          localaqy.qXu = locala.NPN.readString();
          AppMethodBeat.o(209352);
          return 0;
        case 3: 
          localaqy.qXj = locala.NPN.readString();
          AppMethodBeat.o(209352);
          return 0;
        case 4: 
          localaqy.tck = locala.NPN.readString();
          AppMethodBeat.o(209352);
          return 0;
        case 5: 
          localaqy.ssv = locala.NPN.zc();
          AppMethodBeat.o(209352);
          return 0;
        case 6: 
          localaqy.rTD = locala.NPN.zc();
          AppMethodBeat.o(209352);
          return 0;
        case 7: 
          localaqy.tcj = locala.NPN.zd();
          AppMethodBeat.o(209352);
          return 0;
        case 8: 
          localaqy.tcl = locala.NPN.zc();
          AppMethodBeat.o(209352);
          return 0;
        case 9: 
          localaqy.tcm = locala.NPN.zc();
          AppMethodBeat.o(209352);
          return 0;
        case 10: 
          localaqy.tco = locala.NPN.readString();
          AppMethodBeat.o(209352);
          return 0;
        }
        localaqy.tcn = locala.NPN.zc();
        AppMethodBeat.o(209352);
        return 0;
      }
      AppMethodBeat.o(209352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqy
 * JD-Core Version:    0.7.0.1
 */