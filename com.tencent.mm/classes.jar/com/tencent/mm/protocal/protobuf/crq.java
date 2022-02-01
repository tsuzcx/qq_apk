package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crq
  extends com.tencent.mm.bw.a
{
  public String AbG;
  public long Jrc;
  public String MwC;
  public boolean MwD;
  public String MwE;
  public boolean MwF;
  public boolean MwG;
  public int MwH;
  public String lcm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208704);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwC != null) {
        paramVarArgs.e(1, this.MwC);
      }
      if (this.lcm != null) {
        paramVarArgs.e(2, this.lcm);
      }
      paramVarArgs.cc(3, this.MwD);
      if (this.MwE != null) {
        paramVarArgs.e(4, this.MwE);
      }
      if (this.AbG != null) {
        paramVarArgs.e(5, this.AbG);
      }
      paramVarArgs.cc(6, this.MwF);
      paramVarArgs.cc(7, this.MwG);
      paramVarArgs.aM(8, this.MwH);
      paramVarArgs.bb(9, this.Jrc);
      AppMethodBeat.o(208704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwC == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.b.b.a.f(1, this.MwC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lcm != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.lcm);
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.MwE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MwE);
      }
      i = paramInt;
      if (this.AbG != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.AbG);
      }
      paramInt = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      int k = g.a.a.b.b.a.bu(8, this.MwH);
      int m = g.a.a.b.b.a.r(9, this.Jrc);
      AppMethodBeat.o(208704);
      return i + (paramInt + 1) + (j + 1) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208704);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crq localcrq = (crq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208704);
          return -1;
        case 1: 
          localcrq.MwC = locala.UbS.readString();
          AppMethodBeat.o(208704);
          return 0;
        case 2: 
          localcrq.lcm = locala.UbS.readString();
          AppMethodBeat.o(208704);
          return 0;
        case 3: 
          localcrq.MwD = locala.UbS.yZ();
          AppMethodBeat.o(208704);
          return 0;
        case 4: 
          localcrq.MwE = locala.UbS.readString();
          AppMethodBeat.o(208704);
          return 0;
        case 5: 
          localcrq.AbG = locala.UbS.readString();
          AppMethodBeat.o(208704);
          return 0;
        case 6: 
          localcrq.MwF = locala.UbS.yZ();
          AppMethodBeat.o(208704);
          return 0;
        case 7: 
          localcrq.MwG = locala.UbS.yZ();
          AppMethodBeat.o(208704);
          return 0;
        case 8: 
          localcrq.MwH = locala.UbS.zi();
          AppMethodBeat.o(208704);
          return 0;
        }
        localcrq.Jrc = locala.UbS.zl();
        AppMethodBeat.o(208704);
        return 0;
      }
      AppMethodBeat.o(208704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crq
 * JD-Core Version:    0.7.0.1
 */