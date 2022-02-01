package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xn
  extends com.tencent.mm.cd.a
{
  public String SjH;
  public String SjI;
  public String SjJ;
  public int SjK;
  public String SjL;
  public String SjM;
  public String SjN;
  public String SjO;
  public String SjP;
  public String SjQ;
  public String SjR;
  public String SjS;
  public int SjT;
  public String SjU;
  public String SjV;
  public String SjW;
  public String UserName;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.SjH != null) {
        paramVarArgs.f(3, this.SjH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(4, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(5, this.SjJ);
      }
      paramVarArgs.aY(6, this.SjK);
      if (this.SjL != null) {
        paramVarArgs.f(7, this.SjL);
      }
      if (this.SjM != null) {
        paramVarArgs.f(9, this.SjM);
      }
      if (this.SjN != null) {
        paramVarArgs.f(10, this.SjN);
      }
      if (this.SjO != null) {
        paramVarArgs.f(11, this.SjO);
      }
      if (this.SjP != null) {
        paramVarArgs.f(12, this.SjP);
      }
      if (this.SjQ != null) {
        paramVarArgs.f(13, this.SjQ);
      }
      if (this.SjR != null) {
        paramVarArgs.f(14, this.SjR);
      }
      if (this.SjS != null) {
        paramVarArgs.f(15, this.SjS);
      }
      paramVarArgs.aY(16, this.SjT);
      if (this.SjU != null) {
        paramVarArgs.f(17, this.SjU);
      }
      if (this.SjV != null) {
        paramVarArgs.f(18, this.SjV);
      }
      if (this.SjW != null) {
        paramVarArgs.f(19, this.SjW);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.SjH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SjH);
      }
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SjJ);
      }
      i += g.a.a.b.b.a.bM(6, this.SjK);
      paramInt = i;
      if (this.SjL != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SjL);
      }
      i = paramInt;
      if (this.SjM != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SjM);
      }
      paramInt = i;
      if (this.SjN != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SjN);
      }
      i = paramInt;
      if (this.SjO != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SjO);
      }
      paramInt = i;
      if (this.SjP != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SjP);
      }
      i = paramInt;
      if (this.SjQ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.SjQ);
      }
      paramInt = i;
      if (this.SjR != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SjR);
      }
      i = paramInt;
      if (this.SjS != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.SjS);
      }
      i += g.a.a.b.b.a.bM(16, this.SjT);
      paramInt = i;
      if (this.SjU != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SjU);
      }
      i = paramInt;
      if (this.SjV != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.SjV);
      }
      paramInt = i;
      if (this.SjW != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.SjW);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        xn localxn = (xn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localxn.UserName = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localxn.rWI = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localxn.SjH = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localxn.SjI = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localxn.SjJ = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localxn.SjK = locala.abFh.AK();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localxn.SjL = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 9: 
          localxn.SjM = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localxn.SjN = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 11: 
          localxn.SjO = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 12: 
          localxn.SjP = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 13: 
          localxn.SjQ = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 14: 
          localxn.SjR = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 15: 
          localxn.SjS = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 16: 
          localxn.SjT = locala.abFh.AK();
          AppMethodBeat.o(43087);
          return 0;
        case 17: 
          localxn.SjU = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 18: 
          localxn.SjV = locala.abFh.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localxn.SjW = locala.abFh.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xn
 * JD-Core Version:    0.7.0.1
 */