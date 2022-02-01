package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ans
  extends com.tencent.mm.bw.a
{
  public String Lhy;
  public long LyO;
  public long LyP;
  public long LyQ;
  public String LyR;
  public long LyS;
  public String LyT;
  public String LyU;
  public String LyV;
  public String LyW;
  public String LyX;
  public String LyY;
  public int LyZ;
  public String Lza;
  public int Lzb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91460);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LyO);
      paramVarArgs.bb(2, this.LyP);
      paramVarArgs.bb(3, this.LyQ);
      if (this.LyR != null) {
        paramVarArgs.e(4, this.LyR);
      }
      paramVarArgs.bb(5, this.LyS);
      if (this.LyT != null) {
        paramVarArgs.e(6, this.LyT);
      }
      if (this.LyU != null) {
        paramVarArgs.e(7, this.LyU);
      }
      if (this.LyV != null) {
        paramVarArgs.e(8, this.LyV);
      }
      if (this.LyW != null) {
        paramVarArgs.e(9, this.LyW);
      }
      if (this.LyX != null) {
        paramVarArgs.e(10, this.LyX);
      }
      if (this.LyY != null) {
        paramVarArgs.e(11, this.LyY);
      }
      paramVarArgs.aM(12, this.LyZ);
      if (this.Lza != null) {
        paramVarArgs.e(13, this.Lza);
      }
      paramVarArgs.aM(14, this.Lzb);
      if (this.Lhy != null) {
        paramVarArgs.e(15, this.Lhy);
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LyO) + 0 + g.a.a.b.b.a.r(2, this.LyP) + g.a.a.b.b.a.r(3, this.LyQ);
      paramInt = i;
      if (this.LyR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LyR);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.LyS);
      paramInt = i;
      if (this.LyT != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LyT);
      }
      i = paramInt;
      if (this.LyU != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LyU);
      }
      paramInt = i;
      if (this.LyV != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LyV);
      }
      i = paramInt;
      if (this.LyW != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LyW);
      }
      paramInt = i;
      if (this.LyX != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LyX);
      }
      i = paramInt;
      if (this.LyY != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LyY);
      }
      i += g.a.a.b.b.a.bu(12, this.LyZ);
      paramInt = i;
      if (this.Lza != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Lza);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.Lzb);
      paramInt = i;
      if (this.Lhy != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Lhy);
      }
      AppMethodBeat.o(91460);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91460);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ans localans = (ans)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91460);
        return -1;
      case 1: 
        localans.LyO = locala.UbS.zl();
        AppMethodBeat.o(91460);
        return 0;
      case 2: 
        localans.LyP = locala.UbS.zl();
        AppMethodBeat.o(91460);
        return 0;
      case 3: 
        localans.LyQ = locala.UbS.zl();
        AppMethodBeat.o(91460);
        return 0;
      case 4: 
        localans.LyR = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 5: 
        localans.LyS = locala.UbS.zl();
        AppMethodBeat.o(91460);
        return 0;
      case 6: 
        localans.LyT = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 7: 
        localans.LyU = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 8: 
        localans.LyV = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 9: 
        localans.LyW = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 10: 
        localans.LyX = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 11: 
        localans.LyY = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 12: 
        localans.LyZ = locala.UbS.zi();
        AppMethodBeat.o(91460);
        return 0;
      case 13: 
        localans.Lza = locala.UbS.readString();
        AppMethodBeat.o(91460);
        return 0;
      case 14: 
        localans.Lzb = locala.UbS.zi();
        AppMethodBeat.o(91460);
        return 0;
      }
      localans.Lhy = locala.UbS.readString();
      AppMethodBeat.o(91460);
      return 0;
    }
    AppMethodBeat.o(91460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ans
 * JD-Core Version:    0.7.0.1
 */