package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czj
  extends com.tencent.mm.bx.a
{
  public String aaEI;
  public String aaEJ;
  public String aaEK;
  public String aaEL;
  public String aaEM;
  public String aaEN;
  public String aaEO;
  public String aaEP;
  public String aaEQ;
  public String aaER;
  public String aaES;
  public String nBe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaEI != null) {
        paramVarArgs.g(1, this.aaEI);
      }
      if (this.aaEJ != null) {
        paramVarArgs.g(2, this.aaEJ);
      }
      if (this.nBe != null) {
        paramVarArgs.g(3, this.nBe);
      }
      if (this.aaEK != null) {
        paramVarArgs.g(4, this.aaEK);
      }
      if (this.aaEL != null) {
        paramVarArgs.g(5, this.aaEL);
      }
      if (this.aaEM != null) {
        paramVarArgs.g(6, this.aaEM);
      }
      if (this.aaEN != null) {
        paramVarArgs.g(7, this.aaEN);
      }
      if (this.aaEO != null) {
        paramVarArgs.g(8, this.aaEO);
      }
      if (this.aaEP != null) {
        paramVarArgs.g(9, this.aaEP);
      }
      if (this.aaEQ != null) {
        paramVarArgs.g(10, this.aaEQ);
      }
      if (this.aaER != null) {
        paramVarArgs.g(11, this.aaER);
      }
      if (this.aaES != null) {
        paramVarArgs.g(12, this.aaES);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaEI == null) {
        break label886;
      }
    }
    label886:
    for (int i = i.a.a.b.b.a.h(1, this.aaEI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaEJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaEJ);
      }
      i = paramInt;
      if (this.nBe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nBe);
      }
      paramInt = i;
      if (this.aaEK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaEK);
      }
      i = paramInt;
      if (this.aaEL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaEL);
      }
      paramInt = i;
      if (this.aaEM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaEM);
      }
      i = paramInt;
      if (this.aaEN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaEN);
      }
      paramInt = i;
      if (this.aaEO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaEO);
      }
      i = paramInt;
      if (this.aaEP != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaEP);
      }
      paramInt = i;
      if (this.aaEQ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaEQ);
      }
      i = paramInt;
      if (this.aaER != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aaER);
      }
      paramInt = i;
      if (this.aaES != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaES);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        czj localczj = (czj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localczj.aaEI = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localczj.aaEJ = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localczj.nBe = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localczj.aaEK = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localczj.aaEL = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localczj.aaEM = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localczj.aaEN = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 8: 
          localczj.aaEO = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 9: 
          localczj.aaEP = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 10: 
          localczj.aaEQ = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 11: 
          localczj.aaER = locala.ajGk.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localczj.aaES = locala.ajGk.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */