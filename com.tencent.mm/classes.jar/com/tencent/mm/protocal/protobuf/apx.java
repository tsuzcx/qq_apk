package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apx
  extends com.tencent.mm.bw.a
{
  public int LAB;
  public int LBF;
  public int LBG;
  public int LBH;
  public int LBI;
  public int LBJ;
  public int LBK;
  public int LBL;
  public int count;
  public int jhQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.count);
      paramVarArgs.aM(2, this.LBF);
      paramVarArgs.aM(3, this.LBG);
      paramVarArgs.aM(4, this.LBH);
      paramVarArgs.aM(5, this.LBI);
      paramVarArgs.aM(7, this.LAB);
      paramVarArgs.aM(8, this.LBJ);
      paramVarArgs.aM(9, this.jhQ);
      paramVarArgs.aM(10, this.LBK);
      paramVarArgs.aM(11, this.LBL);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.count);
      int i = g.a.a.b.b.a.bu(2, this.LBF);
      int j = g.a.a.b.b.a.bu(3, this.LBG);
      int k = g.a.a.b.b.a.bu(4, this.LBH);
      int m = g.a.a.b.b.a.bu(5, this.LBI);
      int n = g.a.a.b.b.a.bu(7, this.LAB);
      int i1 = g.a.a.b.b.a.bu(8, this.LBJ);
      int i2 = g.a.a.b.b.a.bu(9, this.jhQ);
      int i3 = g.a.a.b.b.a.bu(10, this.LBK);
      int i4 = g.a.a.b.b.a.bu(11, this.LBL);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apx localapx = (apx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localapx.count = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localapx.LBF = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localapx.LBG = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localapx.LBH = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localapx.LBI = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localapx.LAB = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localapx.LBJ = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localapx.jhQ = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      case 10: 
        localapx.LBK = locala.UbS.zi();
        AppMethodBeat.o(168947);
        return 0;
      }
      localapx.LBL = locala.UbS.zi();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apx
 * JD-Core Version:    0.7.0.1
 */