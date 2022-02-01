package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daa
  extends com.tencent.mm.bx.a
{
  public String ErY;
  public String ErZ;
  public String hGC;
  public String hGD;
  public String hGE;
  public String hGF;
  public String hGG;
  public String hGH;
  public String hGI;
  public String hGJ;
  public String hGK;
  public String hGL;
  public String hGM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hGC != null) {
        paramVarArgs.d(1, this.hGC);
      }
      if (this.hGD != null) {
        paramVarArgs.d(2, this.hGD);
      }
      if (this.hGE != null) {
        paramVarArgs.d(3, this.hGE);
      }
      if (this.hGF != null) {
        paramVarArgs.d(4, this.hGF);
      }
      if (this.hGG != null) {
        paramVarArgs.d(5, this.hGG);
      }
      if (this.hGH != null) {
        paramVarArgs.d(6, this.hGH);
      }
      if (this.hGI != null) {
        paramVarArgs.d(7, this.hGI);
      }
      if (this.hGJ != null) {
        paramVarArgs.d(8, this.hGJ);
      }
      if (this.hGK != null) {
        paramVarArgs.d(9, this.hGK);
      }
      if (this.hGL != null) {
        paramVarArgs.d(10, this.hGL);
      }
      if (this.hGM != null) {
        paramVarArgs.d(11, this.hGM);
      }
      if (this.ErY != null) {
        paramVarArgs.d(12, this.ErY);
      }
      if (this.ErZ != null) {
        paramVarArgs.d(13, this.ErZ);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hGC == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.hGC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hGD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hGD);
      }
      i = paramInt;
      if (this.hGE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hGE);
      }
      paramInt = i;
      if (this.hGF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hGF);
      }
      i = paramInt;
      if (this.hGG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hGG);
      }
      paramInt = i;
      if (this.hGH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hGH);
      }
      i = paramInt;
      if (this.hGI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hGI);
      }
      paramInt = i;
      if (this.hGJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hGJ);
      }
      i = paramInt;
      if (this.hGK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hGK);
      }
      paramInt = i;
      if (this.hGL != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hGL);
      }
      i = paramInt;
      if (this.hGM != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hGM);
      }
      paramInt = i;
      if (this.ErY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ErY);
      }
      i = paramInt;
      if (this.ErZ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ErZ);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        daa localdaa = (daa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localdaa.hGC = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localdaa.hGD = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localdaa.hGE = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localdaa.hGF = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localdaa.hGG = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localdaa.hGH = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localdaa.hGI = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localdaa.hGJ = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localdaa.hGK = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localdaa.hGL = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localdaa.hGM = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localdaa.ErY = locala.KhF.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localdaa.ErZ = locala.KhF.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */