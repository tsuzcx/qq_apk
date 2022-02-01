package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsh
  extends com.tencent.mm.bw.a
{
  public int FZB;
  public int FZC;
  public int FZD;
  public int FZE;
  public int FZF;
  public int FZG;
  public int FZH;
  public int FZI;
  public int FZJ;
  public int FZK;
  public LinkedList<Integer> FZL;
  public int FZM;
  public LinkedList<Integer> FZN;
  public int FZO;
  public LinkedList<Integer> FZP;
  public String FZQ;
  public String FZR;
  
  public dsh()
  {
    AppMethodBeat.i(115892);
    this.FZL = new LinkedList();
    this.FZN = new LinkedList();
    this.FZP = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FZB);
      paramVarArgs.aR(2, this.FZC);
      paramVarArgs.aR(3, this.FZD);
      paramVarArgs.aR(4, this.FZE);
      paramVarArgs.aR(5, this.FZF);
      paramVarArgs.aR(6, this.FZG);
      paramVarArgs.aR(7, this.FZH);
      paramVarArgs.aR(8, this.FZI);
      paramVarArgs.aR(9, this.FZJ);
      paramVarArgs.aR(10, this.FZK);
      paramVarArgs.e(11, 2, this.FZL);
      paramVarArgs.aR(12, this.FZM);
      paramVarArgs.e(13, 2, this.FZN);
      paramVarArgs.aR(14, this.FZO);
      paramVarArgs.e(15, 2, this.FZP);
      if (this.FZQ != null) {
        paramVarArgs.d(16, this.FZQ);
      }
      if (this.FZR != null) {
        paramVarArgs.d(17, this.FZR);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FZB) + 0 + f.a.a.b.b.a.bx(2, this.FZC) + f.a.a.b.b.a.bx(3, this.FZD) + f.a.a.b.b.a.bx(4, this.FZE) + f.a.a.b.b.a.bx(5, this.FZF) + f.a.a.b.b.a.bx(6, this.FZG) + f.a.a.b.b.a.bx(7, this.FZH) + f.a.a.b.b.a.bx(8, this.FZI) + f.a.a.b.b.a.bx(9, this.FZJ) + f.a.a.b.b.a.bx(10, this.FZK) + f.a.a.a.c(11, 2, this.FZL) + f.a.a.b.b.a.bx(12, this.FZM) + f.a.a.a.c(13, 2, this.FZN) + f.a.a.b.b.a.bx(14, this.FZO) + f.a.a.a.c(15, 2, this.FZP);
      paramInt = i;
      if (this.FZQ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FZQ);
      }
      i = paramInt;
      if (this.FZR != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FZR);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FZL.clear();
      this.FZN.clear();
      this.FZP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dsh localdsh = (dsh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localdsh.FZB = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localdsh.FZC = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localdsh.FZD = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localdsh.FZE = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localdsh.FZF = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localdsh.FZG = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localdsh.FZH = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localdsh.FZI = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localdsh.FZJ = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localdsh.FZK = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localdsh.FZL.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localdsh.FZM = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localdsh.FZN.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localdsh.FZO = locala.LVo.xF();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localdsh.FZP.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localdsh.FZQ = locala.LVo.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localdsh.FZR = locala.LVo.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsh
 * JD-Core Version:    0.7.0.1
 */