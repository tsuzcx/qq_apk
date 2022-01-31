package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class chj
  extends com.tencent.mm.bv.a
{
  public float boo;
  public String country;
  public String eSM;
  public String gwR;
  public String rIe;
  public int rIg;
  public int rIi;
  public int score;
  public float wDh;
  public float wDi;
  public String xpN;
  public String xpO;
  public int xpP;
  public int xpQ;
  public b xpR;
  public String xpS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56524);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.wDh);
      paramVarArgs.q(2, this.wDi);
      if (this.gwR != null) {
        paramVarArgs.e(3, this.gwR);
      }
      if (this.eSM != null) {
        paramVarArgs.e(4, this.eSM);
      }
      if (this.rIe != null) {
        paramVarArgs.e(5, this.rIe);
      }
      if (this.xpN != null) {
        paramVarArgs.e(6, this.xpN);
      }
      paramVarArgs.aO(7, this.rIg);
      if (this.xpO != null) {
        paramVarArgs.e(8, this.xpO);
      }
      paramVarArgs.aO(9, this.xpP);
      paramVarArgs.aO(10, this.xpQ);
      paramVarArgs.aO(11, this.rIi);
      paramVarArgs.q(12, this.boo);
      if (this.xpR != null) {
        paramVarArgs.c(13, this.xpR);
      }
      paramVarArgs.aO(14, this.score);
      if (this.xpS != null) {
        paramVarArgs.e(15, this.xpS);
      }
      if (this.country != null) {
        paramVarArgs.e(16, this.country);
      }
      AppMethodBeat.o(56524);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 4 + 0 + (e.a.a.b.b.a.eW(2) + 4);
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.gwR);
      }
      i = paramInt;
      if (this.eSM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.eSM);
      }
      paramInt = i;
      if (this.rIe != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.rIe);
      }
      i = paramInt;
      if (this.xpN != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xpN);
      }
      i += e.a.a.b.b.a.bl(7, this.rIg);
      paramInt = i;
      if (this.xpO != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xpO);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xpP) + e.a.a.b.b.a.bl(10, this.xpQ) + e.a.a.b.b.a.bl(11, this.rIi) + (e.a.a.b.b.a.eW(12) + 4);
      paramInt = i;
      if (this.xpR != null) {
        paramInt = i + e.a.a.b.b.a.b(13, this.xpR);
      }
      i = paramInt + e.a.a.b.b.a.bl(14, this.score);
      paramInt = i;
      if (this.xpS != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.xpS);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.country);
      }
      AppMethodBeat.o(56524);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56524);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      chj localchj = (chj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56524);
        return -1;
      case 1: 
        localchj.wDh = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(56524);
        return 0;
      case 2: 
        localchj.wDi = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(56524);
        return 0;
      case 3: 
        localchj.gwR = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      case 4: 
        localchj.eSM = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      case 5: 
        localchj.rIe = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      case 6: 
        localchj.xpN = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      case 7: 
        localchj.rIg = locala.CLY.sl();
        AppMethodBeat.o(56524);
        return 0;
      case 8: 
        localchj.xpO = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      case 9: 
        localchj.xpP = locala.CLY.sl();
        AppMethodBeat.o(56524);
        return 0;
      case 10: 
        localchj.xpQ = locala.CLY.sl();
        AppMethodBeat.o(56524);
        return 0;
      case 11: 
        localchj.rIi = locala.CLY.sl();
        AppMethodBeat.o(56524);
        return 0;
      case 12: 
        localchj.boo = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(56524);
        return 0;
      case 13: 
        localchj.xpR = locala.CLY.eqS();
        AppMethodBeat.o(56524);
        return 0;
      case 14: 
        localchj.score = locala.CLY.sl();
        AppMethodBeat.o(56524);
        return 0;
      case 15: 
        localchj.xpS = locala.CLY.readString();
        AppMethodBeat.o(56524);
        return 0;
      }
      localchj.country = locala.CLY.readString();
      AppMethodBeat.o(56524);
      return 0;
    }
    AppMethodBeat.o(56524);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chj
 * JD-Core Version:    0.7.0.1
 */