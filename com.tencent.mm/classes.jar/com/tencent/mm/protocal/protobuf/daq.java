package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daq
  extends com.tencent.mm.bx.a
{
  public String CHJ;
  public String CHL;
  public String CHN;
  public String CHO;
  public String CHP;
  public String CHW;
  public int CHX;
  public int CHY;
  public int CHZ;
  public int CreateTime;
  public int Cxm;
  public long Ess;
  public String Est;
  public String Title;
  public int gKq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Cxm);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.CHJ != null) {
        paramVarArgs.d(3, this.CHJ);
      }
      if (this.CHL != null) {
        paramVarArgs.d(6, this.CHL);
      }
      if (this.CHN != null) {
        paramVarArgs.d(8, this.CHN);
      }
      if (this.CHO != null) {
        paramVarArgs.d(9, this.CHO);
      }
      if (this.CHP != null) {
        paramVarArgs.d(10, this.CHP);
      }
      paramVarArgs.aR(11, this.gKq);
      if (this.CHW != null) {
        paramVarArgs.d(15, this.CHW);
      }
      paramVarArgs.aR(16, this.CHX);
      paramVarArgs.aR(17, this.CHY);
      paramVarArgs.aR(18, this.CHZ);
      paramVarArgs.aR(19, this.CreateTime);
      paramVarArgs.aG(20, this.Ess);
      if (this.Est != null) {
        paramVarArgs.d(21, this.Est);
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Cxm) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.CHJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CHJ);
      }
      paramInt = i;
      if (this.CHL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CHL);
      }
      i = paramInt;
      if (this.CHN != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CHN);
      }
      paramInt = i;
      if (this.CHO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CHO);
      }
      i = paramInt;
      if (this.CHP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CHP);
      }
      i += f.a.a.b.b.a.bA(11, this.gKq);
      paramInt = i;
      if (this.CHW != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CHW);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.CHX) + f.a.a.b.b.a.bA(17, this.CHY) + f.a.a.b.b.a.bA(18, this.CHZ) + f.a.a.b.b.a.bA(19, this.CreateTime) + f.a.a.b.b.a.q(20, this.Ess);
      paramInt = i;
      if (this.Est != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Est);
      }
      AppMethodBeat.o(124558);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      daq localdaq = (daq)paramVarArgs[1];
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
        localdaq.Cxm = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localdaq.Title = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localdaq.CHJ = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localdaq.CHL = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localdaq.CHN = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localdaq.CHO = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localdaq.CHP = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localdaq.gKq = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localdaq.CHW = locala.KhF.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localdaq.CHX = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localdaq.CHY = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localdaq.CHZ = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localdaq.CreateTime = locala.KhF.xS();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localdaq.Ess = locala.KhF.xT();
        AppMethodBeat.o(124558);
        return 0;
      }
      localdaq.Est = locala.KhF.readString();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daq
 * JD-Core Version:    0.7.0.1
 */