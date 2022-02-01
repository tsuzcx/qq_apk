package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkz
  extends com.tencent.mm.bx.a
{
  public String HzL;
  public String HzM;
  public String iAA;
  public String iAB;
  public String iAC;
  public String iAD;
  public String iAE;
  public String iAF;
  public String iAG;
  public String iAH;
  public String iAI;
  public String iAy;
  public String iAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iAy != null) {
        paramVarArgs.d(1, this.iAy);
      }
      if (this.iAz != null) {
        paramVarArgs.d(2, this.iAz);
      }
      if (this.iAA != null) {
        paramVarArgs.d(3, this.iAA);
      }
      if (this.iAB != null) {
        paramVarArgs.d(4, this.iAB);
      }
      if (this.iAC != null) {
        paramVarArgs.d(5, this.iAC);
      }
      if (this.iAD != null) {
        paramVarArgs.d(6, this.iAD);
      }
      if (this.iAE != null) {
        paramVarArgs.d(7, this.iAE);
      }
      if (this.iAF != null) {
        paramVarArgs.d(8, this.iAF);
      }
      if (this.iAG != null) {
        paramVarArgs.d(9, this.iAG);
      }
      if (this.iAH != null) {
        paramVarArgs.d(10, this.iAH);
      }
      if (this.iAI != null) {
        paramVarArgs.d(11, this.iAI);
      }
      if (this.HzL != null) {
        paramVarArgs.d(12, this.HzL);
      }
      if (this.HzM != null) {
        paramVarArgs.d(13, this.HzM);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iAy == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.iAy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iAz);
      }
      i = paramInt;
      if (this.iAA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iAA);
      }
      paramInt = i;
      if (this.iAB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iAB);
      }
      i = paramInt;
      if (this.iAC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iAC);
      }
      paramInt = i;
      if (this.iAD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iAD);
      }
      i = paramInt;
      if (this.iAE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iAE);
      }
      paramInt = i;
      if (this.iAF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iAF);
      }
      i = paramInt;
      if (this.iAG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iAG);
      }
      paramInt = i;
      if (this.iAH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iAH);
      }
      i = paramInt;
      if (this.iAI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.iAI);
      }
      paramInt = i;
      if (this.HzL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HzL);
      }
      i = paramInt;
      if (this.HzM != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HzM);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkz localdkz = (dkz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localdkz.iAy = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localdkz.iAz = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localdkz.iAA = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localdkz.iAB = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localdkz.iAC = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localdkz.iAD = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localdkz.iAE = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localdkz.iAF = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localdkz.iAG = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localdkz.iAH = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localdkz.iAI = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localdkz.HzL = locala.NPN.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localdkz.HzM = locala.NPN.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */