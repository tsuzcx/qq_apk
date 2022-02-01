package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cww
  extends com.tencent.mm.bx.a
{
  public int CYi;
  public int DdZ;
  public int EoJ;
  public int EoK;
  public int EoL;
  public int EoM;
  public int EoN;
  public LinkedList<Integer> EoO;
  public int EoP;
  public int EoQ;
  public LinkedList<Integer> EoR;
  public int EoS;
  public int EoT;
  
  public cww()
  {
    AppMethodBeat.i(115853);
    this.EoO = new LinkedList();
    this.EoR = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DdZ);
      paramVarArgs.aR(2, this.EoJ);
      paramVarArgs.aR(3, this.CYi);
      paramVarArgs.aR(4, this.EoK);
      paramVarArgs.aR(5, this.EoL);
      paramVarArgs.aR(6, this.EoM);
      paramVarArgs.aR(7, this.EoN);
      paramVarArgs.e(8, 2, this.EoO);
      paramVarArgs.aR(9, this.EoP);
      paramVarArgs.aR(10, this.EoQ);
      paramVarArgs.e(11, 2, this.EoR);
      paramVarArgs.aR(12, this.EoS);
      paramVarArgs.aR(13, this.EoT);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DdZ);
      int i = f.a.a.b.b.a.bA(2, this.EoJ);
      int j = f.a.a.b.b.a.bA(3, this.CYi);
      int k = f.a.a.b.b.a.bA(4, this.EoK);
      int m = f.a.a.b.b.a.bA(5, this.EoL);
      int n = f.a.a.b.b.a.bA(6, this.EoM);
      int i1 = f.a.a.b.b.a.bA(7, this.EoN);
      int i2 = f.a.a.a.c(8, 2, this.EoO);
      int i3 = f.a.a.b.b.a.bA(9, this.EoP);
      int i4 = f.a.a.b.b.a.bA(10, this.EoQ);
      int i5 = f.a.a.a.c(11, 2, this.EoR);
      int i6 = f.a.a.b.b.a.bA(12, this.EoS);
      int i7 = f.a.a.b.b.a.bA(13, this.EoT);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EoO.clear();
      this.EoR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cww localcww = (cww)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localcww.DdZ = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localcww.EoJ = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localcww.CYi = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localcww.EoK = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localcww.EoL = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localcww.EoM = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localcww.EoN = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localcww.EoO.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localcww.EoP = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localcww.EoQ = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localcww.EoR.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localcww.EoS = locala.KhF.xS();
        AppMethodBeat.o(115854);
        return 0;
      }
      localcww.EoT = locala.KhF.xS();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cww
 * JD-Core Version:    0.7.0.1
 */