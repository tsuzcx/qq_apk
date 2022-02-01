package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flf
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int YFu;
  public String YQI;
  public String YQK;
  public String YQM;
  public String YQN;
  public String YQO;
  public String YQV;
  public int YQW;
  public int YQX;
  public int YQY;
  public String YVC;
  public int YVD;
  public long YVz;
  public String hAP;
  public int nUA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFu);
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.YQI != null) {
        paramVarArgs.g(3, this.YQI);
      }
      if (this.YQK != null) {
        paramVarArgs.g(6, this.YQK);
      }
      if (this.YQM != null) {
        paramVarArgs.g(8, this.YQM);
      }
      if (this.YQN != null) {
        paramVarArgs.g(9, this.YQN);
      }
      if (this.YQO != null) {
        paramVarArgs.g(10, this.YQO);
      }
      paramVarArgs.bS(11, this.nUA);
      if (this.YQV != null) {
        paramVarArgs.g(15, this.YQV);
      }
      paramVarArgs.bS(16, this.YQW);
      paramVarArgs.bS(17, this.YQX);
      paramVarArgs.bS(18, this.YQY);
      paramVarArgs.bS(19, this.CreateTime);
      paramVarArgs.bv(20, this.YVz);
      if (this.YVC != null) {
        paramVarArgs.g(21, this.YVC);
      }
      paramVarArgs.bS(22, this.YVD);
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YFu) + 0;
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.YQI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YQI);
      }
      paramInt = i;
      if (this.YQK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YQK);
      }
      i = paramInt;
      if (this.YQM != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YQM);
      }
      paramInt = i;
      if (this.YQN != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YQN);
      }
      i = paramInt;
      if (this.YQO != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YQO);
      }
      i += i.a.a.b.b.a.cJ(11, this.nUA);
      paramInt = i;
      if (this.YQV != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YQV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.YQW) + i.a.a.b.b.a.cJ(17, this.YQX) + i.a.a.b.b.a.cJ(18, this.YQY) + i.a.a.b.b.a.cJ(19, this.CreateTime) + i.a.a.b.b.a.q(20, this.YVz);
      paramInt = i;
      if (this.YVC != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YVC);
      }
      i = i.a.a.b.b.a.cJ(22, this.YVD);
      AppMethodBeat.o(124558);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flf localflf = (flf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localflf.YFu = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localflf.hAP = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localflf.YQI = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localflf.YQK = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localflf.YQM = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localflf.YQN = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localflf.YQO = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localflf.nUA = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localflf.YQV = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localflf.YQW = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localflf.YQX = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localflf.YQY = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localflf.CreateTime = locala.ajGk.aar();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localflf.YVz = locala.ajGk.aaw();
        AppMethodBeat.o(124558);
        return 0;
      case 21: 
        localflf.YVC = locala.ajGk.readString();
        AppMethodBeat.o(124558);
        return 0;
      }
      localflf.YVD = locala.ajGk.aar();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flf
 * JD-Core Version:    0.7.0.1
 */