package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afj
  extends com.tencent.mm.bx.a
{
  public int ZnH;
  public int ZnI;
  public int ZnJ;
  public int ZnK;
  public long ZnL;
  public long ZnM;
  public int ZnN;
  public int wUT;
  public int wUU;
  public int wUV;
  public int wUW;
  public int wUX;
  public int wUY;
  public int wUZ;
  public int wVa;
  public int wVb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.wUT);
      paramVarArgs.bS(2, this.ZnH);
      paramVarArgs.bS(3, this.wUU);
      paramVarArgs.bS(4, this.wUV);
      paramVarArgs.bS(5, this.wUW);
      paramVarArgs.bS(6, this.ZnI);
      paramVarArgs.bS(7, this.wUX);
      paramVarArgs.bS(8, this.wUY);
      paramVarArgs.bS(9, this.ZnJ);
      paramVarArgs.bS(10, this.ZnK);
      paramVarArgs.bS(11, this.wUZ);
      paramVarArgs.bS(12, this.wVa);
      paramVarArgs.bS(13, this.wVb);
      paramVarArgs.bv(14, this.ZnL);
      paramVarArgs.bv(15, this.ZnM);
      paramVarArgs.bS(16, this.ZnN);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.wUT);
      int i = i.a.a.b.b.a.cJ(2, this.ZnH);
      int j = i.a.a.b.b.a.cJ(3, this.wUU);
      int k = i.a.a.b.b.a.cJ(4, this.wUV);
      int m = i.a.a.b.b.a.cJ(5, this.wUW);
      int n = i.a.a.b.b.a.cJ(6, this.ZnI);
      int i1 = i.a.a.b.b.a.cJ(7, this.wUX);
      int i2 = i.a.a.b.b.a.cJ(8, this.wUY);
      int i3 = i.a.a.b.b.a.cJ(9, this.ZnJ);
      int i4 = i.a.a.b.b.a.cJ(10, this.ZnK);
      int i5 = i.a.a.b.b.a.cJ(11, this.wUZ);
      int i6 = i.a.a.b.b.a.cJ(12, this.wVa);
      int i7 = i.a.a.b.b.a.cJ(13, this.wVb);
      int i8 = i.a.a.b.b.a.q(14, this.ZnL);
      int i9 = i.a.a.b.b.a.q(15, this.ZnM);
      int i10 = i.a.a.b.b.a.cJ(16, this.ZnN);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afj localafj = (afj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localafj.wUT = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localafj.ZnH = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localafj.wUU = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localafj.wUV = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localafj.wUW = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localafj.ZnI = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localafj.wUX = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localafj.wUY = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localafj.ZnJ = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localafj.ZnK = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localafj.wUZ = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localafj.wVa = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 13: 
        localafj.wVb = locala.ajGk.aar();
        AppMethodBeat.o(90959);
        return 0;
      case 14: 
        localafj.ZnL = locala.ajGk.aaw();
        AppMethodBeat.o(90959);
        return 0;
      case 15: 
        localafj.ZnM = locala.ajGk.aaw();
        AppMethodBeat.o(90959);
        return 0;
      }
      localafj.ZnN = locala.ajGk.aar();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afj
 * JD-Core Version:    0.7.0.1
 */