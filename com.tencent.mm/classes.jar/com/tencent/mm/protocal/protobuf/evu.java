package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class evu
  extends com.tencent.mm.cd.a
{
  public String UjM;
  public int UjQ;
  public String UjS;
  public String content;
  public int fwx;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UjS != null) {
        paramVarArgs.f(1, this.UjS);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      if (this.UjM != null) {
        paramVarArgs.f(4, this.UjM);
      }
      paramVarArgs.aY(5, this.UjQ);
      paramVarArgs.aY(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UjS == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.g(1, this.UjS) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.content);
      }
      i = paramInt;
      if (this.UjM != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UjM);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.UjQ);
      int j = g.a.a.b.b.a.bM(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evu localevu = (evu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localevu.UjS = locala.abFh.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localevu.fwx = locala.abFh.AK();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localevu.content = locala.abFh.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localevu.UjM = locala.abFh.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localevu.UjQ = locala.abFh.AK();
          AppMethodBeat.o(153308);
          return 0;
        }
        localevu.state = locala.abFh.AK();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evu
 * JD-Core Version:    0.7.0.1
 */