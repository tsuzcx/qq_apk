package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class arc
  extends com.tencent.mm.bw.a
{
  public int LCO;
  public int LCP;
  public int LCQ;
  public int LCR;
  public int LCS;
  public int LCT;
  public int LCU;
  public b LCV;
  public int pullType;
  public int scene;
  public int vff;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.scene);
      paramVarArgs.aM(2, this.LCO);
      paramVarArgs.aM(3, this.pullType);
      paramVarArgs.aM(4, this.vff);
      paramVarArgs.aM(5, this.LCP);
      paramVarArgs.aM(6, this.LCQ);
      paramVarArgs.aM(7, this.LCR);
      paramVarArgs.aM(8, this.LCS);
      paramVarArgs.aM(9, this.LCT);
      paramVarArgs.aM(10, this.LCU);
      if (this.LCV != null) {
        paramVarArgs.c(11, this.LCV);
      }
      AppMethodBeat.o(209388);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.scene) + 0 + g.a.a.b.b.a.bu(2, this.LCO) + g.a.a.b.b.a.bu(3, this.pullType) + g.a.a.b.b.a.bu(4, this.vff) + g.a.a.b.b.a.bu(5, this.LCP) + g.a.a.b.b.a.bu(6, this.LCQ) + g.a.a.b.b.a.bu(7, this.LCR) + g.a.a.b.b.a.bu(8, this.LCS) + g.a.a.b.b.a.bu(9, this.LCT) + g.a.a.b.b.a.bu(10, this.LCU);
      paramInt = i;
      if (this.LCV != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.LCV);
      }
      AppMethodBeat.o(209388);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209388);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      arc localarc = (arc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209388);
        return -1;
      case 1: 
        localarc.scene = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 2: 
        localarc.LCO = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 3: 
        localarc.pullType = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 4: 
        localarc.vff = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 5: 
        localarc.LCP = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 6: 
        localarc.LCQ = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 7: 
        localarc.LCR = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 8: 
        localarc.LCS = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 9: 
        localarc.LCT = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      case 10: 
        localarc.LCU = locala.UbS.zi();
        AppMethodBeat.o(209388);
        return 0;
      }
      localarc.LCV = locala.UbS.hPo();
      AppMethodBeat.o(209388);
      return 0;
    }
    AppMethodBeat.o(209388);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arc
 * JD-Core Version:    0.7.0.1
 */