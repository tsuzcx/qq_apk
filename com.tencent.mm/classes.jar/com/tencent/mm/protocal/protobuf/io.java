package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class io
  extends com.tencent.mm.bx.a
{
  public String YKk;
  public String YKl;
  public int YKm;
  public long YKn;
  public int YKo;
  public long YKp;
  public long YKq;
  public long YKt;
  public double YKu;
  public int YKv;
  public long YKx;
  public int YKy;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87873);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YKx);
      if (this.YKk != null) {
        paramVarArgs.g(2, this.YKk);
      }
      if (this.YKl != null) {
        paramVarArgs.g(3, this.YKl);
      }
      paramVarArgs.bS(4, this.YKm);
      paramVarArgs.bv(5, this.YKn);
      paramVarArgs.bS(6, this.YKo);
      paramVarArgs.bS(7, this.vhk);
      paramVarArgs.bv(8, this.YKp);
      paramVarArgs.bv(9, this.YKq);
      paramVarArgs.bS(10, this.YKy);
      paramVarArgs.bv(11, this.YKt);
      paramVarArgs.d(12, this.YKu);
      paramVarArgs.bS(13, this.YKv);
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YKx) + 0;
      paramInt = i;
      if (this.YKk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YKk);
      }
      i = paramInt;
      if (this.YKl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YKl);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YKm);
      int j = i.a.a.b.b.a.q(5, this.YKn);
      int k = i.a.a.b.b.a.cJ(6, this.YKo);
      int m = i.a.a.b.b.a.cJ(7, this.vhk);
      int n = i.a.a.b.b.a.q(8, this.YKp);
      int i1 = i.a.a.b.b.a.q(9, this.YKq);
      int i2 = i.a.a.b.b.a.cJ(10, this.YKy);
      int i3 = i.a.a.b.b.a.q(11, this.YKt);
      int i4 = i.a.a.b.b.a.ko(12);
      int i5 = i.a.a.b.b.a.cJ(13, this.YKv);
      AppMethodBeat.o(87873);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 8) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(87873);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      io localio = (io)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(87873);
        return -1;
      case 1: 
        localio.YKx = locala.ajGk.aaw();
        AppMethodBeat.o(87873);
        return 0;
      case 2: 
        localio.YKk = locala.ajGk.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 3: 
        localio.YKl = locala.ajGk.readString();
        AppMethodBeat.o(87873);
        return 0;
      case 4: 
        localio.YKm = locala.ajGk.aar();
        AppMethodBeat.o(87873);
        return 0;
      case 5: 
        localio.YKn = locala.ajGk.aaw();
        AppMethodBeat.o(87873);
        return 0;
      case 6: 
        localio.YKo = locala.ajGk.aar();
        AppMethodBeat.o(87873);
        return 0;
      case 7: 
        localio.vhk = locala.ajGk.aar();
        AppMethodBeat.o(87873);
        return 0;
      case 8: 
        localio.YKp = locala.ajGk.aaw();
        AppMethodBeat.o(87873);
        return 0;
      case 9: 
        localio.YKq = locala.ajGk.aaw();
        AppMethodBeat.o(87873);
        return 0;
      case 10: 
        localio.YKy = locala.ajGk.aar();
        AppMethodBeat.o(87873);
        return 0;
      case 11: 
        localio.YKt = locala.ajGk.aaw();
        AppMethodBeat.o(87873);
        return 0;
      case 12: 
        localio.YKu = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(87873);
        return 0;
      }
      localio.YKv = locala.ajGk.aar();
      AppMethodBeat.o(87873);
      return 0;
    }
    AppMethodBeat.o(87873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.io
 * JD-Core Version:    0.7.0.1
 */