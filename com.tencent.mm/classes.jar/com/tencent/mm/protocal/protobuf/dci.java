package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dci
  extends com.tencent.mm.bw.a
{
  public int EqS;
  public int Exf;
  public int FLI;
  public int FLJ;
  public int FLK;
  public int FLL;
  public int FLM;
  public LinkedList<Integer> FLN;
  public int FLO;
  public int FLP;
  public LinkedList<Integer> FLQ;
  public int FLR;
  public int FLS;
  
  public dci()
  {
    AppMethodBeat.i(115853);
    this.FLN = new LinkedList();
    this.FLQ = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Exf);
      paramVarArgs.aR(2, this.FLI);
      paramVarArgs.aR(3, this.EqS);
      paramVarArgs.aR(4, this.FLJ);
      paramVarArgs.aR(5, this.FLK);
      paramVarArgs.aR(6, this.FLL);
      paramVarArgs.aR(7, this.FLM);
      paramVarArgs.e(8, 2, this.FLN);
      paramVarArgs.aR(9, this.FLO);
      paramVarArgs.aR(10, this.FLP);
      paramVarArgs.e(11, 2, this.FLQ);
      paramVarArgs.aR(12, this.FLR);
      paramVarArgs.aR(13, this.FLS);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Exf);
      int i = f.a.a.b.b.a.bx(2, this.FLI);
      int j = f.a.a.b.b.a.bx(3, this.EqS);
      int k = f.a.a.b.b.a.bx(4, this.FLJ);
      int m = f.a.a.b.b.a.bx(5, this.FLK);
      int n = f.a.a.b.b.a.bx(6, this.FLL);
      int i1 = f.a.a.b.b.a.bx(7, this.FLM);
      int i2 = f.a.a.a.c(8, 2, this.FLN);
      int i3 = f.a.a.b.b.a.bx(9, this.FLO);
      int i4 = f.a.a.b.b.a.bx(10, this.FLP);
      int i5 = f.a.a.a.c(11, 2, this.FLQ);
      int i6 = f.a.a.b.b.a.bx(12, this.FLR);
      int i7 = f.a.a.b.b.a.bx(13, this.FLS);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FLN.clear();
      this.FLQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dci localdci = (dci)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localdci.Exf = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localdci.FLI = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localdci.EqS = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localdci.FLJ = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localdci.FLK = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localdci.FLL = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localdci.FLM = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localdci.FLN.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localdci.FLO = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localdci.FLP = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localdci.FLQ.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localdci.FLR = locala.LVo.xF();
        AppMethodBeat.o(115854);
        return 0;
      }
      localdci.FLS = locala.LVo.xF();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dci
 * JD-Core Version:    0.7.0.1
 */