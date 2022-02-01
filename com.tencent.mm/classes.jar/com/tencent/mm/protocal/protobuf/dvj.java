package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvj
  extends com.tencent.mm.cd.a
{
  public int Ubn;
  public String llA;
  public String llB;
  public String llC;
  public String llD;
  public String llE;
  public String llF;
  public String llG;
  public String llH;
  public String llI;
  public String llJ;
  public boolean llK;
  public int llL;
  public String lly;
  public String llz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lly != null) {
        paramVarArgs.f(1, this.lly);
      }
      if (this.llz != null) {
        paramVarArgs.f(2, this.llz);
      }
      if (this.llA != null) {
        paramVarArgs.f(3, this.llA);
      }
      if (this.llB != null) {
        paramVarArgs.f(4, this.llB);
      }
      if (this.llC != null) {
        paramVarArgs.f(5, this.llC);
      }
      if (this.llD != null) {
        paramVarArgs.f(6, this.llD);
      }
      if (this.llE != null) {
        paramVarArgs.f(7, this.llE);
      }
      if (this.llF != null) {
        paramVarArgs.f(8, this.llF);
      }
      if (this.llG != null) {
        paramVarArgs.f(9, this.llG);
      }
      if (this.llH != null) {
        paramVarArgs.f(10, this.llH);
      }
      paramVarArgs.aY(11, this.Ubn);
      if (this.llI != null) {
        paramVarArgs.f(12, this.llI);
      }
      if (this.llJ != null) {
        paramVarArgs.f(13, this.llJ);
      }
      paramVarArgs.co(14, this.llK);
      paramVarArgs.aY(15, this.llL);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lly == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = g.a.a.b.b.a.g(1, this.lly) + 0;; i = 0)
    {
      paramInt = i;
      if (this.llz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.llz);
      }
      i = paramInt;
      if (this.llA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.llA);
      }
      paramInt = i;
      if (this.llB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.llB);
      }
      i = paramInt;
      if (this.llC != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.llC);
      }
      paramInt = i;
      if (this.llD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.llD);
      }
      i = paramInt;
      if (this.llE != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.llE);
      }
      paramInt = i;
      if (this.llF != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.llF);
      }
      i = paramInt;
      if (this.llG != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.llG);
      }
      paramInt = i;
      if (this.llH != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.llH);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.Ubn);
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.llI);
      }
      i = paramInt;
      if (this.llJ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.llJ);
      }
      paramInt = g.a.a.b.b.a.gL(14);
      int j = g.a.a.b.b.a.bM(15, this.llL);
      AppMethodBeat.o(169219);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dvj localdvj = (dvj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localdvj.lly = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localdvj.llz = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localdvj.llA = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localdvj.llB = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localdvj.llC = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localdvj.llD = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localdvj.llE = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localdvj.llF = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localdvj.llG = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localdvj.llH = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localdvj.Ubn = locala.abFh.AK();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localdvj.llI = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localdvj.llJ = locala.abFh.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localdvj.llK = locala.abFh.AB();
          AppMethodBeat.o(169219);
          return 0;
        }
        localdvj.llL = locala.abFh.AK();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvj
 * JD-Core Version:    0.7.0.1
 */