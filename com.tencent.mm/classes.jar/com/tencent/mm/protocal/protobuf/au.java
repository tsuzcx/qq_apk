package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bx.a
{
  public int CuF;
  public String CuG;
  public String CuH;
  public int CuI;
  public int CuJ;
  public String CuK;
  public int CuL;
  public String CuM;
  public String CuN;
  public int CuO;
  public String CuP;
  public String ijR;
  public String mAQ;
  public String mBV;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      paramVarArgs.aR(3, this.CuF);
      if (this.CuG != null) {
        paramVarArgs.d(4, this.CuG);
      }
      if (this.CuH != null) {
        paramVarArgs.d(5, this.CuH);
      }
      if (this.ijR != null) {
        paramVarArgs.d(6, this.ijR);
      }
      paramVarArgs.aR(8, this.mBi);
      paramVarArgs.aR(9, this.CuI);
      paramVarArgs.aR(10, this.CuJ);
      if (this.CuK != null) {
        paramVarArgs.d(11, this.CuK);
      }
      paramVarArgs.aR(12, this.CuL);
      if (this.CuM != null) {
        paramVarArgs.d(13, this.CuM);
      }
      if (this.CuN != null) {
        paramVarArgs.d(14, this.CuN);
      }
      paramVarArgs.aR(15, this.CuO);
      if (this.CuP != null) {
        paramVarArgs.d(16, this.CuP);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mBV);
      }
      i += f.a.a.b.b.a.bA(3, this.CuF);
      paramInt = i;
      if (this.CuG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CuG);
      }
      i = paramInt;
      if (this.CuH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CuH);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ijR);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.mBi) + f.a.a.b.b.a.bA(9, this.CuI) + f.a.a.b.b.a.bA(10, this.CuJ);
      paramInt = i;
      if (this.CuK != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CuK);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CuL);
      paramInt = i;
      if (this.CuM != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CuM);
      }
      i = paramInt;
      if (this.CuN != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CuN);
      }
      i += f.a.a.b.b.a.bA(15, this.CuO);
      paramInt = i;
      if (this.CuP != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CuP);
      }
      AppMethodBeat.o(133142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localau.mAQ = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localau.mBV = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localau.CuF = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localau.CuG = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localau.CuH = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localau.ijR = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localau.mBi = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localau.CuI = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localau.CuJ = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localau.CuK = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localau.CuL = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localau.CuM = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localau.CuN = locala.KhF.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localau.CuO = locala.KhF.xS();
          AppMethodBeat.o(133142);
          return 0;
        }
        localau.CuP = locala.KhF.readString();
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */