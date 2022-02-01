package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class duy
  extends com.tencent.mm.cd.a
{
  public String KFu;
  public int KFw;
  public float KFy;
  public int KFz;
  public String SOz;
  public float ScO;
  public float ScP;
  public int TAA;
  public b TAB;
  public String TAC;
  public String TAy;
  public int TAz;
  public String country;
  public String mVA;
  public String poiName;
  public int score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.ScO);
      paramVarArgs.i(2, this.ScP);
      if (this.mVA != null) {
        paramVarArgs.f(3, this.mVA);
      }
      if (this.poiName != null) {
        paramVarArgs.f(4, this.poiName);
      }
      if (this.KFu != null) {
        paramVarArgs.f(5, this.KFu);
      }
      if (this.SOz != null) {
        paramVarArgs.f(6, this.SOz);
      }
      paramVarArgs.aY(7, this.KFw);
      if (this.TAy != null) {
        paramVarArgs.f(8, this.TAy);
      }
      paramVarArgs.aY(9, this.TAz);
      paramVarArgs.aY(10, this.TAA);
      paramVarArgs.aY(11, this.KFz);
      paramVarArgs.i(12, this.KFy);
      if (this.TAB != null) {
        paramVarArgs.c(13, this.TAB);
      }
      paramVarArgs.aY(14, this.score);
      if (this.TAC != null) {
        paramVarArgs.f(15, this.TAC);
      }
      if (this.country != null) {
        paramVarArgs.f(16, this.country);
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 4 + 0 + (g.a.a.b.b.a.gL(2) + 4);
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.mVA);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.poiName);
      }
      paramInt = i;
      if (this.KFu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.KFu);
      }
      i = paramInt;
      if (this.SOz != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SOz);
      }
      i += g.a.a.b.b.a.bM(7, this.KFw);
      paramInt = i;
      if (this.TAy != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TAy);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.TAz) + g.a.a.b.b.a.bM(10, this.TAA) + g.a.a.b.b.a.bM(11, this.KFz) + (g.a.a.b.b.a.gL(12) + 4);
      paramInt = i;
      if (this.TAB != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.TAB);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.score);
      paramInt = i;
      if (this.TAC != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TAC);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.country);
      }
      AppMethodBeat.o(101530);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      duy localduy = (duy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101530);
        return -1;
      case 1: 
        localduy.ScO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(101530);
        return 0;
      case 2: 
        localduy.ScP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(101530);
        return 0;
      case 3: 
        localduy.mVA = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 4: 
        localduy.poiName = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 5: 
        localduy.KFu = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 6: 
        localduy.SOz = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 7: 
        localduy.KFw = locala.abFh.AK();
        AppMethodBeat.o(101530);
        return 0;
      case 8: 
        localduy.TAy = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 9: 
        localduy.TAz = locala.abFh.AK();
        AppMethodBeat.o(101530);
        return 0;
      case 10: 
        localduy.TAA = locala.abFh.AK();
        AppMethodBeat.o(101530);
        return 0;
      case 11: 
        localduy.KFz = locala.abFh.AK();
        AppMethodBeat.o(101530);
        return 0;
      case 12: 
        localduy.KFy = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(101530);
        return 0;
      case 13: 
        localduy.TAB = locala.abFh.iUw();
        AppMethodBeat.o(101530);
        return 0;
      case 14: 
        localduy.score = locala.abFh.AK();
        AppMethodBeat.o(101530);
        return 0;
      case 15: 
        localduy.TAC = locala.abFh.readString();
        AppMethodBeat.o(101530);
        return 0;
      }
      localduy.country = locala.abFh.readString();
      AppMethodBeat.o(101530);
      return 0;
    }
    AppMethodBeat.o(101530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duy
 * JD-Core Version:    0.7.0.1
 */