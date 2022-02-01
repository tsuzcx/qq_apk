package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btb
  extends com.tencent.mm.bx.a
{
  public int EVj;
  public int EVk;
  public int EVo;
  public int EVp;
  public int EVr;
  public int EVv;
  public int EVw;
  public int aaaM;
  public float aaaN;
  public int aaaO;
  public int aaaP;
  public float aaaQ;
  public int aaaR;
  public int aaaS;
  public int aaaT;
  public int aaaU;
  public boolean aaaV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184205);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.EVj);
      paramVarArgs.bS(2, this.EVk);
      paramVarArgs.bS(3, this.aaaM);
      paramVarArgs.l(4, this.aaaN);
      paramVarArgs.bS(5, this.aaaO);
      paramVarArgs.bS(6, this.aaaP);
      paramVarArgs.bS(7, this.EVo);
      paramVarArgs.bS(8, this.EVp);
      paramVarArgs.l(9, this.aaaQ);
      paramVarArgs.bS(10, this.EVr);
      paramVarArgs.bS(11, this.aaaR);
      paramVarArgs.bS(12, this.EVv);
      paramVarArgs.bS(13, this.EVw);
      paramVarArgs.bS(14, this.aaaS);
      paramVarArgs.bS(15, this.aaaT);
      paramVarArgs.bS(16, this.aaaU);
      paramVarArgs.di(17, this.aaaV);
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.EVj);
      int i = i.a.a.b.b.a.cJ(2, this.EVk);
      int j = i.a.a.b.b.a.cJ(3, this.aaaM);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.cJ(5, this.aaaO);
      int n = i.a.a.b.b.a.cJ(6, this.aaaP);
      int i1 = i.a.a.b.b.a.cJ(7, this.EVo);
      int i2 = i.a.a.b.b.a.cJ(8, this.EVp);
      int i3 = i.a.a.b.b.a.ko(9);
      int i4 = i.a.a.b.b.a.cJ(10, this.EVr);
      int i5 = i.a.a.b.b.a.cJ(11, this.aaaR);
      int i6 = i.a.a.b.b.a.cJ(12, this.EVv);
      int i7 = i.a.a.b.b.a.cJ(13, this.EVw);
      int i8 = i.a.a.b.b.a.cJ(14, this.aaaS);
      int i9 = i.a.a.b.b.a.cJ(15, this.aaaT);
      int i10 = i.a.a.b.b.a.cJ(16, this.aaaU);
      int i11 = i.a.a.b.b.a.ko(17);
      AppMethodBeat.o(184205);
      return paramInt + 0 + i + j + (k + 4) + m + n + i1 + i2 + (i3 + 4) + i4 + i5 + i6 + i7 + i8 + i9 + i10 + (i11 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184205);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      btb localbtb = (btb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184205);
        return -1;
      case 1: 
        localbtb.EVj = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 2: 
        localbtb.EVk = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 3: 
        localbtb.aaaM = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 4: 
        localbtb.aaaN = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(184205);
        return 0;
      case 5: 
        localbtb.aaaO = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 6: 
        localbtb.aaaP = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 7: 
        localbtb.EVo = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 8: 
        localbtb.EVp = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 9: 
        localbtb.aaaQ = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(184205);
        return 0;
      case 10: 
        localbtb.EVr = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 11: 
        localbtb.aaaR = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 12: 
        localbtb.EVv = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 13: 
        localbtb.EVw = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 14: 
        localbtb.aaaS = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 15: 
        localbtb.aaaT = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      case 16: 
        localbtb.aaaU = locala.ajGk.aar();
        AppMethodBeat.o(184205);
        return 0;
      }
      localbtb.aaaV = locala.ajGk.aai();
      AppMethodBeat.o(184205);
      return 0;
    }
    AppMethodBeat.o(184205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btb
 * JD-Core Version:    0.7.0.1
 */