package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efc
  extends com.tencent.mm.cd.a
{
  public String UiC;
  public String UiD;
  public String Uiw;
  public String fFe;
  public String wmA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wmA != null) {
        paramVarArgs.f(1, this.wmA);
      }
      if (this.Uiw != null) {
        paramVarArgs.f(2, this.Uiw);
      }
      if (this.fFe != null) {
        paramVarArgs.f(3, this.fFe);
      }
      if (this.UiC != null) {
        paramVarArgs.f(4, this.UiC);
      }
      if (this.UiD != null) {
        paramVarArgs.f(5, this.UiD);
      }
      AppMethodBeat.o(122529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmA == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.wmA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uiw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uiw);
      }
      i = paramInt;
      if (this.fFe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fFe);
      }
      paramInt = i;
      if (this.UiC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UiC);
      }
      i = paramInt;
      if (this.UiD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UiD);
      }
      AppMethodBeat.o(122529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122529);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        efc localefc = (efc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122529);
          return -1;
        case 1: 
          localefc.wmA = locala.abFh.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 2: 
          localefc.Uiw = locala.abFh.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 3: 
          localefc.fFe = locala.abFh.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 4: 
          localefc.UiC = locala.abFh.readString();
          AppMethodBeat.o(122529);
          return 0;
        }
        localefc.UiD = locala.abFh.readString();
        AppMethodBeat.o(122529);
        return 0;
      }
      AppMethodBeat.o(122529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efc
 * JD-Core Version:    0.7.0.1
 */