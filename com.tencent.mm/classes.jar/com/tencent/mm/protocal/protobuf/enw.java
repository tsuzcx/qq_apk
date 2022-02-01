package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class enw
  extends com.tencent.mm.bx.a
{
  public String ReU;
  public int ReW;
  public float ReY;
  public int ReZ;
  public String ZWG;
  public float ZaG;
  public float ZaH;
  public String aaPM;
  public int aaPN;
  public int aaPO;
  public b aaPP;
  public String aaPQ;
  public String country;
  public String pSh;
  public String poiName;
  public int score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.ZaG);
      paramVarArgs.l(2, this.ZaH);
      if (this.pSh != null) {
        paramVarArgs.g(3, this.pSh);
      }
      if (this.poiName != null) {
        paramVarArgs.g(4, this.poiName);
      }
      if (this.ReU != null) {
        paramVarArgs.g(5, this.ReU);
      }
      if (this.ZWG != null) {
        paramVarArgs.g(6, this.ZWG);
      }
      paramVarArgs.bS(7, this.ReW);
      if (this.aaPM != null) {
        paramVarArgs.g(8, this.aaPM);
      }
      paramVarArgs.bS(9, this.aaPN);
      paramVarArgs.bS(10, this.aaPO);
      paramVarArgs.bS(11, this.ReZ);
      paramVarArgs.l(12, this.ReY);
      if (this.aaPP != null) {
        paramVarArgs.d(13, this.aaPP);
      }
      paramVarArgs.bS(14, this.score);
      if (this.aaPQ != null) {
        paramVarArgs.g(15, this.aaPQ);
      }
      if (this.country != null) {
        paramVarArgs.g(16, this.country);
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4);
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.pSh);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.poiName);
      }
      paramInt = i;
      if (this.ReU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ReU);
      }
      i = paramInt;
      if (this.ZWG != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZWG);
      }
      i += i.a.a.b.b.a.cJ(7, this.ReW);
      paramInt = i;
      if (this.aaPM != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaPM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aaPN) + i.a.a.b.b.a.cJ(10, this.aaPO) + i.a.a.b.b.a.cJ(11, this.ReZ) + (i.a.a.b.b.a.ko(12) + 4);
      paramInt = i;
      if (this.aaPP != null) {
        paramInt = i + i.a.a.b.b.a.c(13, this.aaPP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.score);
      paramInt = i;
      if (this.aaPQ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaPQ);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.country);
      }
      AppMethodBeat.o(101530);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(101530);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      enw localenw = (enw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101530);
        return -1;
      case 1: 
        localenw.ZaG = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(101530);
        return 0;
      case 2: 
        localenw.ZaH = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(101530);
        return 0;
      case 3: 
        localenw.pSh = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 4: 
        localenw.poiName = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 5: 
        localenw.ReU = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 6: 
        localenw.ZWG = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 7: 
        localenw.ReW = locala.ajGk.aar();
        AppMethodBeat.o(101530);
        return 0;
      case 8: 
        localenw.aaPM = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      case 9: 
        localenw.aaPN = locala.ajGk.aar();
        AppMethodBeat.o(101530);
        return 0;
      case 10: 
        localenw.aaPO = locala.ajGk.aar();
        AppMethodBeat.o(101530);
        return 0;
      case 11: 
        localenw.ReZ = locala.ajGk.aar();
        AppMethodBeat.o(101530);
        return 0;
      case 12: 
        localenw.ReY = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(101530);
        return 0;
      case 13: 
        localenw.aaPP = locala.ajGk.kFX();
        AppMethodBeat.o(101530);
        return 0;
      case 14: 
        localenw.score = locala.ajGk.aar();
        AppMethodBeat.o(101530);
        return 0;
      case 15: 
        localenw.aaPQ = locala.ajGk.readString();
        AppMethodBeat.o(101530);
        return 0;
      }
      localenw.country = locala.ajGk.readString();
      AppMethodBeat.o(101530);
      return 0;
    }
    AppMethodBeat.o(101530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enw
 * JD-Core Version:    0.7.0.1
 */