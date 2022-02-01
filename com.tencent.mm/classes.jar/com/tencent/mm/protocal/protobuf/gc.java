package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gc
  extends com.tencent.mm.bx.a
{
  public boolean YHK;
  public boolean YHL;
  public int YHM;
  public int YHN;
  public int YHO;
  public int YHP;
  public int YHQ;
  public boolean YHR;
  public boolean YHS;
  public boolean YHT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.YHK);
      paramVarArgs.di(2, this.YHL);
      paramVarArgs.bS(3, this.YHM);
      paramVarArgs.bS(4, this.YHN);
      paramVarArgs.bS(5, this.YHO);
      paramVarArgs.bS(6, this.YHP);
      paramVarArgs.bS(7, this.YHQ);
      paramVarArgs.di(8, this.YHR);
      paramVarArgs.di(9, this.YHS);
      paramVarArgs.di(10, this.YHT);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.YHM);
      int k = i.a.a.b.b.a.cJ(4, this.YHN);
      int m = i.a.a.b.b.a.cJ(5, this.YHO);
      int n = i.a.a.b.b.a.cJ(6, this.YHP);
      int i1 = i.a.a.b.b.a.cJ(7, this.YHQ);
      int i2 = i.a.a.b.b.a.ko(8);
      int i3 = i.a.a.b.b.a.ko(9);
      int i4 = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(124386);
      return paramInt + 1 + 0 + (i + 1) + j + k + m + n + i1 + (i2 + 1) + (i3 + 1) + (i4 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gc localgc = (gc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localgc.YHK = locala.ajGk.aai();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localgc.YHL = locala.ajGk.aai();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localgc.YHM = locala.ajGk.aar();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localgc.YHN = locala.ajGk.aar();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localgc.YHO = locala.ajGk.aar();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localgc.YHP = locala.ajGk.aar();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localgc.YHQ = locala.ajGk.aar();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localgc.YHR = locala.ajGk.aai();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localgc.YHS = locala.ajGk.aai();
        AppMethodBeat.o(124386);
        return 0;
      }
      localgc.YHT = locala.ajGk.aai();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */