package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgu
  extends com.tencent.mm.bx.a
{
  public int ZkT;
  public int Zvz;
  public int abGP;
  public int abGQ;
  public int abGR;
  public int abGS;
  public int abGT;
  public LinkedList<Integer> abGU;
  public int abGV;
  public int abGW;
  public LinkedList<Integer> abGX;
  public int abGY;
  public int abGZ;
  
  public fgu()
  {
    AppMethodBeat.i(115853);
    this.abGU = new LinkedList();
    this.abGX = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zvz);
      paramVarArgs.bS(2, this.abGP);
      paramVarArgs.bS(3, this.ZkT);
      paramVarArgs.bS(4, this.abGQ);
      paramVarArgs.bS(5, this.abGR);
      paramVarArgs.bS(6, this.abGS);
      paramVarArgs.bS(7, this.abGT);
      paramVarArgs.e(8, 2, this.abGU);
      paramVarArgs.bS(9, this.abGV);
      paramVarArgs.bS(10, this.abGW);
      paramVarArgs.e(11, 2, this.abGX);
      paramVarArgs.bS(12, this.abGY);
      paramVarArgs.bS(13, this.abGZ);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Zvz);
      int i = i.a.a.b.b.a.cJ(2, this.abGP);
      int j = i.a.a.b.b.a.cJ(3, this.ZkT);
      int k = i.a.a.b.b.a.cJ(4, this.abGQ);
      int m = i.a.a.b.b.a.cJ(5, this.abGR);
      int n = i.a.a.b.b.a.cJ(6, this.abGS);
      int i1 = i.a.a.b.b.a.cJ(7, this.abGT);
      int i2 = i.a.a.a.c(8, 2, this.abGU);
      int i3 = i.a.a.b.b.a.cJ(9, this.abGV);
      int i4 = i.a.a.b.b.a.cJ(10, this.abGW);
      int i5 = i.a.a.a.c(11, 2, this.abGX);
      int i6 = i.a.a.b.b.a.cJ(12, this.abGY);
      int i7 = i.a.a.b.b.a.cJ(13, this.abGZ);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abGU.clear();
      this.abGX.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fgu localfgu = (fgu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localfgu.Zvz = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localfgu.abGP = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localfgu.ZkT = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localfgu.abGQ = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localfgu.abGR = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localfgu.abGS = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localfgu.abGT = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localfgu.abGU.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localfgu.abGV = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localfgu.abGW = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localfgu.abGX.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localfgu.abGY = locala.ajGk.aar();
        AppMethodBeat.o(115854);
        return 0;
      }
      localfgu.abGZ = locala.ajGk.aar();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgu
 * JD-Core Version:    0.7.0.1
 */