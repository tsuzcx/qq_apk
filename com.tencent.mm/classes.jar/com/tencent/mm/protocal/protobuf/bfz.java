package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfz
  extends com.tencent.mm.cd.a
{
  public String SQE;
  public String SQF;
  public String SQG;
  public String SQH;
  public String SQI;
  public String SQJ;
  public String SQK;
  public String SQL;
  public String SQM;
  public String SQN;
  public String SQO;
  public String SQP;
  public String SQQ;
  public String SQR;
  public int objectType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.objectType);
      if (this.SQE != null) {
        paramVarArgs.f(2, this.SQE);
      }
      if (this.SQF != null) {
        paramVarArgs.f(3, this.SQF);
      }
      if (this.SQG != null) {
        paramVarArgs.f(4, this.SQG);
      }
      if (this.SQH != null) {
        paramVarArgs.f(5, this.SQH);
      }
      if (this.SQI != null) {
        paramVarArgs.f(6, this.SQI);
      }
      if (this.SQJ != null) {
        paramVarArgs.f(7, this.SQJ);
      }
      if (this.SQK != null) {
        paramVarArgs.f(8, this.SQK);
      }
      if (this.SQL != null) {
        paramVarArgs.f(9, this.SQL);
      }
      if (this.SQM != null) {
        paramVarArgs.f(10, this.SQM);
      }
      if (this.SQN != null) {
        paramVarArgs.f(11, this.SQN);
      }
      if (this.SQO != null) {
        paramVarArgs.f(12, this.SQO);
      }
      if (this.SQP != null) {
        paramVarArgs.f(13, this.SQP);
      }
      if (this.SQQ != null) {
        paramVarArgs.f(14, this.SQQ);
      }
      if (this.SQR != null) {
        paramVarArgs.f(15, this.SQR);
      }
      AppMethodBeat.o(200570);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.objectType) + 0;
      paramInt = i;
      if (this.SQE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SQE);
      }
      i = paramInt;
      if (this.SQF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SQF);
      }
      paramInt = i;
      if (this.SQG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SQG);
      }
      i = paramInt;
      if (this.SQH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SQH);
      }
      paramInt = i;
      if (this.SQI != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SQI);
      }
      i = paramInt;
      if (this.SQJ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SQJ);
      }
      paramInt = i;
      if (this.SQK != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SQK);
      }
      i = paramInt;
      if (this.SQL != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SQL);
      }
      paramInt = i;
      if (this.SQM != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SQM);
      }
      i = paramInt;
      if (this.SQN != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SQN);
      }
      paramInt = i;
      if (this.SQO != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SQO);
      }
      i = paramInt;
      if (this.SQP != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.SQP);
      }
      paramInt = i;
      if (this.SQQ != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SQQ);
      }
      i = paramInt;
      if (this.SQR != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.SQR);
      }
      AppMethodBeat.o(200570);
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
      AppMethodBeat.o(200570);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfz localbfz = (bfz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200570);
        return -1;
      case 1: 
        localbfz.objectType = locala.abFh.AK();
        AppMethodBeat.o(200570);
        return 0;
      case 2: 
        localbfz.SQE = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 3: 
        localbfz.SQF = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 4: 
        localbfz.SQG = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 5: 
        localbfz.SQH = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 6: 
        localbfz.SQI = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 7: 
        localbfz.SQJ = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 8: 
        localbfz.SQK = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 9: 
        localbfz.SQL = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 10: 
        localbfz.SQM = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 11: 
        localbfz.SQN = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 12: 
        localbfz.SQO = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 13: 
        localbfz.SQP = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      case 14: 
        localbfz.SQQ = locala.abFh.readString();
        AppMethodBeat.o(200570);
        return 0;
      }
      localbfz.SQR = locala.abFh.readString();
      AppMethodBeat.o(200570);
      return 0;
    }
    AppMethodBeat.o(200570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfz
 * JD-Core Version:    0.7.0.1
 */