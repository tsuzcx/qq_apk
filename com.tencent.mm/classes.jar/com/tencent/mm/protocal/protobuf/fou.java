package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fou
  extends com.tencent.mm.cd.a
{
  public String TnS;
  public String TnT;
  public String UMR;
  public String fJj;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UMR != null) {
        paramVarArgs.f(1, this.UMR);
      }
      paramVarArgs.aY(2, this.version);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.fJj != null) {
        paramVarArgs.f(4, this.fJj);
      }
      if (this.TnS != null) {
        paramVarArgs.f(5, this.TnS);
      }
      if (this.TnT != null) {
        paramVarArgs.f(6, this.TnT);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UMR == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.UMR) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = paramInt;
      if (this.fJj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.fJj);
      }
      paramInt = i;
      if (this.TnS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TnS);
      }
      i = paramInt;
      if (this.TnT != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TnT);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fou localfou = (fou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localfou.UMR = locala.abFh.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localfou.version = locala.abFh.AK();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localfou.url = locala.abFh.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localfou.fJj = locala.abFh.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localfou.TnS = locala.abFh.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localfou.TnT = locala.abFh.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fou
 * JD-Core Version:    0.7.0.1
 */