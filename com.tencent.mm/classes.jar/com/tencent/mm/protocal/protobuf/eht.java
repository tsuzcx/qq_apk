package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eht
  extends com.tencent.mm.cd.a
{
  public String UjM;
  public String UjN;
  public String UjO;
  public String UjP;
  public int UjQ;
  public String UjR;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.f(1, this.content);
      }
      if (this.UjM != null) {
        paramVarArgs.f(2, this.UjM);
      }
      if (this.UjN != null) {
        paramVarArgs.f(3, this.UjN);
      }
      if (this.UjO != null) {
        paramVarArgs.f(4, this.UjO);
      }
      if (this.UjP != null) {
        paramVarArgs.f(5, this.UjP);
      }
      paramVarArgs.aY(6, this.UjQ);
      paramVarArgs.aY(7, this.state);
      if (this.UjR != null) {
        paramVarArgs.f(8, this.UjR);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = g.a.a.b.b.a.g(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UjM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UjM);
      }
      i = paramInt;
      if (this.UjN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UjN);
      }
      paramInt = i;
      if (this.UjO != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UjO);
      }
      i = paramInt;
      if (this.UjP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UjP);
      }
      i = i + g.a.a.b.b.a.bM(6, this.UjQ) + g.a.a.b.b.a.bM(7, this.state);
      paramInt = i;
      if (this.UjR != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UjR);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eht localeht = (eht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localeht.content = locala.abFh.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localeht.UjM = locala.abFh.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localeht.UjN = locala.abFh.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localeht.UjO = locala.abFh.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localeht.UjP = locala.abFh.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localeht.UjQ = locala.abFh.AK();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localeht.state = locala.abFh.AK();
          AppMethodBeat.o(153299);
          return 0;
        }
        localeht.UjR = locala.abFh.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eht
 * JD-Core Version:    0.7.0.1
 */