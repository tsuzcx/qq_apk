package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azu
  extends com.tencent.mm.bw.a
{
  public String LJA;
  public String LJB;
  public String LJC;
  public String LJD;
  public String LJE;
  public String LJF;
  public String LJG;
  public String LJH;
  public String LJI;
  public String LJJ;
  public String LJK;
  public String LJL;
  public String LJy;
  public String LJz;
  public int objectType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209619);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.objectType);
      if (this.LJy != null) {
        paramVarArgs.e(2, this.LJy);
      }
      if (this.LJz != null) {
        paramVarArgs.e(3, this.LJz);
      }
      if (this.LJA != null) {
        paramVarArgs.e(4, this.LJA);
      }
      if (this.LJB != null) {
        paramVarArgs.e(5, this.LJB);
      }
      if (this.LJC != null) {
        paramVarArgs.e(6, this.LJC);
      }
      if (this.LJD != null) {
        paramVarArgs.e(7, this.LJD);
      }
      if (this.LJE != null) {
        paramVarArgs.e(8, this.LJE);
      }
      if (this.LJF != null) {
        paramVarArgs.e(9, this.LJF);
      }
      if (this.LJG != null) {
        paramVarArgs.e(10, this.LJG);
      }
      if (this.LJH != null) {
        paramVarArgs.e(11, this.LJH);
      }
      if (this.LJI != null) {
        paramVarArgs.e(12, this.LJI);
      }
      if (this.LJJ != null) {
        paramVarArgs.e(13, this.LJJ);
      }
      if (this.LJK != null) {
        paramVarArgs.e(14, this.LJK);
      }
      if (this.LJL != null) {
        paramVarArgs.e(15, this.LJL);
      }
      AppMethodBeat.o(209619);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.objectType) + 0;
      paramInt = i;
      if (this.LJy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LJy);
      }
      i = paramInt;
      if (this.LJz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LJz);
      }
      paramInt = i;
      if (this.LJA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LJA);
      }
      i = paramInt;
      if (this.LJB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LJB);
      }
      paramInt = i;
      if (this.LJC != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LJC);
      }
      i = paramInt;
      if (this.LJD != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LJD);
      }
      paramInt = i;
      if (this.LJE != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LJE);
      }
      i = paramInt;
      if (this.LJF != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LJF);
      }
      paramInt = i;
      if (this.LJG != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LJG);
      }
      i = paramInt;
      if (this.LJH != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LJH);
      }
      paramInt = i;
      if (this.LJI != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LJI);
      }
      i = paramInt;
      if (this.LJJ != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.LJJ);
      }
      paramInt = i;
      if (this.LJK != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LJK);
      }
      i = paramInt;
      if (this.LJL != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.LJL);
      }
      AppMethodBeat.o(209619);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209619);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azu localazu = (azu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209619);
        return -1;
      case 1: 
        localazu.objectType = locala.UbS.zi();
        AppMethodBeat.o(209619);
        return 0;
      case 2: 
        localazu.LJy = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 3: 
        localazu.LJz = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 4: 
        localazu.LJA = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 5: 
        localazu.LJB = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 6: 
        localazu.LJC = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 7: 
        localazu.LJD = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 8: 
        localazu.LJE = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 9: 
        localazu.LJF = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 10: 
        localazu.LJG = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 11: 
        localazu.LJH = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 12: 
        localazu.LJI = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 13: 
        localazu.LJJ = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      case 14: 
        localazu.LJK = locala.UbS.readString();
        AppMethodBeat.o(209619);
        return 0;
      }
      localazu.LJL = locala.UbS.readString();
      AppMethodBeat.o(209619);
      return 0;
    }
    AppMethodBeat.o(209619);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azu
 * JD-Core Version:    0.7.0.1
 */