package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gh
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public String pIB;
  public String wsA;
  public int wsB;
  public long wsC;
  public int wsD;
  public long wsE;
  public long wsF;
  public int wsG;
  public long wsH;
  public double wsI;
  public int wsJ;
  public long wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(54936);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wsz);
      if (this.pIB != null) {
        paramVarArgs.e(2, this.pIB);
      }
      if (this.wsA != null) {
        paramVarArgs.e(3, this.wsA);
      }
      paramVarArgs.aO(4, this.wsB);
      paramVarArgs.am(5, this.wsC);
      paramVarArgs.aO(6, this.wsD);
      paramVarArgs.aO(7, this.jJS);
      paramVarArgs.am(8, this.wsE);
      paramVarArgs.am(9, this.wsF);
      paramVarArgs.aO(10, this.wsG);
      paramVarArgs.am(11, this.wsH);
      paramVarArgs.f(12, this.wsI);
      paramVarArgs.aO(13, this.wsJ);
      AppMethodBeat.o(54936);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wsz) + 0;
      paramInt = i;
      if (this.pIB != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pIB);
      }
      i = paramInt;
      if (this.wsA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wsA);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wsB);
      int j = e.a.a.b.b.a.p(5, this.wsC);
      int k = e.a.a.b.b.a.bl(6, this.wsD);
      int m = e.a.a.b.b.a.bl(7, this.jJS);
      int n = e.a.a.b.b.a.p(8, this.wsE);
      int i1 = e.a.a.b.b.a.p(9, this.wsF);
      int i2 = e.a.a.b.b.a.bl(10, this.wsG);
      int i3 = e.a.a.b.b.a.p(11, this.wsH);
      int i4 = e.a.a.b.b.a.eW(12);
      int i5 = e.a.a.b.b.a.bl(13, this.wsJ);
      AppMethodBeat.o(54936);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(54936);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      gh localgh = (gh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(54936);
        return -1;
      case 1: 
        localgh.wsz = locala.CLY.sm();
        AppMethodBeat.o(54936);
        return 0;
      case 2: 
        localgh.pIB = locala.CLY.readString();
        AppMethodBeat.o(54936);
        return 0;
      case 3: 
        localgh.wsA = locala.CLY.readString();
        AppMethodBeat.o(54936);
        return 0;
      case 4: 
        localgh.wsB = locala.CLY.sl();
        AppMethodBeat.o(54936);
        return 0;
      case 5: 
        localgh.wsC = locala.CLY.sm();
        AppMethodBeat.o(54936);
        return 0;
      case 6: 
        localgh.wsD = locala.CLY.sl();
        AppMethodBeat.o(54936);
        return 0;
      case 7: 
        localgh.jJS = locala.CLY.sl();
        AppMethodBeat.o(54936);
        return 0;
      case 8: 
        localgh.wsE = locala.CLY.sm();
        AppMethodBeat.o(54936);
        return 0;
      case 9: 
        localgh.wsF = locala.CLY.sm();
        AppMethodBeat.o(54936);
        return 0;
      case 10: 
        localgh.wsG = locala.CLY.sl();
        AppMethodBeat.o(54936);
        return 0;
      case 11: 
        localgh.wsH = locala.CLY.sm();
        AppMethodBeat.o(54936);
        return 0;
      case 12: 
        localgh.wsI = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(54936);
        return 0;
      }
      localgh.wsJ = locala.CLY.sl();
      AppMethodBeat.o(54936);
      return 0;
    }
    AppMethodBeat.o(54936);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gh
 * JD-Core Version:    0.7.0.1
 */