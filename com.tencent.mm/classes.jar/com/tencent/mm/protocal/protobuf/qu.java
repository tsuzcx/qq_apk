package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qu
  extends com.tencent.mm.bw.a
{
  public int Doa;
  public int KXC;
  public int KXD;
  public int KXE;
  public String KXF;
  public int KXG;
  public int KXH;
  public int KXI;
  public String KXJ;
  public String dNI;
  public String qHp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      paramVarArgs.aM(2, this.KXC);
      paramVarArgs.aM(3, this.KXD);
      if (this.qHp != null) {
        paramVarArgs.e(4, this.qHp);
      }
      paramVarArgs.aM(5, this.KXE);
      if (this.KXF != null) {
        paramVarArgs.e(6, this.KXF);
      }
      paramVarArgs.aM(7, this.KXG);
      paramVarArgs.aM(8, this.KXH);
      paramVarArgs.aM(9, this.KXI);
      if (this.KXJ != null) {
        paramVarArgs.e(10, this.KXJ);
      }
      paramVarArgs.aM(15, this.Doa);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KXC) + g.a.a.b.b.a.bu(3, this.KXD);
      paramInt = i;
      if (this.qHp != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qHp);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KXE);
      paramInt = i;
      if (this.KXF != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KXF);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.KXG) + g.a.a.b.b.a.bu(8, this.KXH) + g.a.a.b.b.a.bu(9, this.KXI);
      paramInt = i;
      if (this.KXJ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KXJ);
      }
      i = g.a.a.b.b.a.bu(15, this.Doa);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qu localqu = (qu)paramVarArgs[1];
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
          localqu.dNI = locala.UbS.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localqu.KXC = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localqu.KXD = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localqu.qHp = locala.UbS.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localqu.KXE = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localqu.KXF = locala.UbS.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localqu.KXG = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localqu.KXH = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localqu.KXI = locala.UbS.zi();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localqu.KXJ = locala.UbS.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localqu.Doa = locala.UbS.zi();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qu
 * JD-Core Version:    0.7.0.1
 */