package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyh
  extends com.tencent.mm.bw.a
{
  public boolean MDe = false;
  public String MDf;
  public boolean MDg;
  public int aHK = 0;
  public String dMl = "";
  public String dRM = "";
  public int dRq = -1;
  public long endTime = 0L;
  public String kvy = "";
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dRM != null) {
        paramVarArgs.e(1, this.dRM);
      }
      paramVarArgs.cc(2, this.MDe);
      paramVarArgs.bb(3, this.seq);
      paramVarArgs.bb(4, this.startTime);
      paramVarArgs.bb(5, this.endTime);
      paramVarArgs.aM(6, this.dRq);
      if (this.dMl != null) {
        paramVarArgs.e(7, this.dMl);
      }
      paramVarArgs.aM(8, this.aHK);
      if (this.MDf != null) {
        paramVarArgs.e(9, this.MDf);
      }
      paramVarArgs.cc(10, this.MDg);
      if (this.kvy != null) {
        paramVarArgs.e(11, this.kvy);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dRM == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = g.a.a.b.b.a.f(1, this.dRM) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.b.b.a.r(3, this.seq) + g.a.a.b.b.a.r(4, this.startTime) + g.a.a.b.b.a.r(5, this.endTime) + g.a.a.b.b.a.bu(6, this.dRq);
      paramInt = i;
      if (this.dMl != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dMl);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.aHK);
      paramInt = i;
      if (this.MDf != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MDf);
      }
      i = paramInt + (g.a.a.b.b.a.fS(10) + 1);
      paramInt = i;
      if (this.kvy != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.kvy);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cyh localcyh = (cyh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localcyh.dRM = locala.UbS.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localcyh.MDe = locala.UbS.yZ();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localcyh.seq = locala.UbS.zl();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localcyh.startTime = locala.UbS.zl();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localcyh.endTime = locala.UbS.zl();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localcyh.dRq = locala.UbS.zi();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localcyh.dMl = locala.UbS.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localcyh.aHK = locala.UbS.zi();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localcyh.MDf = locala.UbS.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localcyh.MDg = locala.UbS.yZ();
          AppMethodBeat.o(122521);
          return 0;
        }
        localcyh.kvy = locala.UbS.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyh
 * JD-Core Version:    0.7.0.1
 */