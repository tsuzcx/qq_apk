package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class eka
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
    AppMethodBeat.i(209445);
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
      AppMethodBeat.o(209445);
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
      AppMethodBeat.o(209445);
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
      AppMethodBeat.o(209445);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eka localeka = (eka)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209445);
        return -1;
      case 1: 
        localeka.ScO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(209445);
        return 0;
      case 2: 
        localeka.ScP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(209445);
        return 0;
      case 3: 
        localeka.mVA = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      case 4: 
        localeka.poiName = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      case 5: 
        localeka.KFu = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      case 6: 
        localeka.SOz = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      case 7: 
        localeka.KFw = locala.abFh.AK();
        AppMethodBeat.o(209445);
        return 0;
      case 8: 
        localeka.TAy = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      case 9: 
        localeka.TAz = locala.abFh.AK();
        AppMethodBeat.o(209445);
        return 0;
      case 10: 
        localeka.TAA = locala.abFh.AK();
        AppMethodBeat.o(209445);
        return 0;
      case 11: 
        localeka.KFz = locala.abFh.AK();
        AppMethodBeat.o(209445);
        return 0;
      case 12: 
        localeka.KFy = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(209445);
        return 0;
      case 13: 
        localeka.TAB = locala.abFh.iUw();
        AppMethodBeat.o(209445);
        return 0;
      case 14: 
        localeka.score = locala.abFh.AK();
        AppMethodBeat.o(209445);
        return 0;
      case 15: 
        localeka.TAC = locala.abFh.readString();
        AppMethodBeat.o(209445);
        return 0;
      }
      localeka.country = locala.abFh.readString();
      AppMethodBeat.o(209445);
      return 0;
    }
    AppMethodBeat.o(209445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eka
 * JD-Core Version:    0.7.0.1
 */