package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aog
  extends com.tencent.mm.bx.a
{
  public int Ctr;
  public String DpA;
  public String DpB;
  public String DpC;
  public String DpD;
  public String DpE;
  public int DpF;
  public int DpG;
  public int Dpr;
  public String Title;
  public String gKr;
  public String mAQ;
  public String sDZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dpr);
      if (this.DpA != null) {
        paramVarArgs.d(2, this.DpA);
      }
      if (this.DpB != null) {
        paramVarArgs.d(3, this.DpB);
      }
      paramVarArgs.aR(4, this.Ctr);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.gKr != null) {
        paramVarArgs.d(6, this.gKr);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(7, this.mAQ);
      }
      if (this.DpC != null) {
        paramVarArgs.d(8, this.DpC);
      }
      if (this.sDZ != null) {
        paramVarArgs.d(10, this.sDZ);
      }
      if (this.DpD != null) {
        paramVarArgs.d(11, this.DpD);
      }
      if (this.DpE != null) {
        paramVarArgs.d(12, this.DpE);
      }
      paramVarArgs.aR(13, this.DpF);
      paramVarArgs.aR(14, this.DpG);
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dpr) + 0;
      paramInt = i;
      if (this.DpA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DpA);
      }
      i = paramInt;
      if (this.DpB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DpB);
      }
      i += f.a.a.b.b.a.bA(4, this.Ctr);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gKr);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mAQ);
      }
      i = paramInt;
      if (this.DpC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DpC);
      }
      paramInt = i;
      if (this.sDZ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.sDZ);
      }
      i = paramInt;
      if (this.DpD != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DpD);
      }
      paramInt = i;
      if (this.DpE != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DpE);
      }
      i = f.a.a.b.b.a.bA(13, this.DpF);
      int j = f.a.a.b.b.a.bA(14, this.DpG);
      AppMethodBeat.o(152549);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aog localaog = (aog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localaog.Dpr = locala.KhF.xS();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localaog.DpA = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localaog.DpB = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localaog.Ctr = locala.KhF.xS();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localaog.Title = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localaog.gKr = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localaog.mAQ = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localaog.DpC = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localaog.sDZ = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localaog.DpD = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localaog.DpE = locala.KhF.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localaog.DpF = locala.KhF.xS();
        AppMethodBeat.o(152549);
        return 0;
      }
      localaog.DpG = locala.KhF.xS();
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aog
 * JD-Core Version:    0.7.0.1
 */