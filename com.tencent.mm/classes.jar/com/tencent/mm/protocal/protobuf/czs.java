package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czs
  extends com.tencent.mm.cd.a
{
  public String TnI;
  public String TnS;
  public String TnT;
  public String fJj;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TnI != null) {
        paramVarArgs.f(1, this.TnI);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.fJj != null) {
        paramVarArgs.f(3, this.fJj);
      }
      if (this.TnS != null) {
        paramVarArgs.f(4, this.TnS);
      }
      if (this.TnT != null) {
        paramVarArgs.f(5, this.TnT);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TnI == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.TnI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.fJj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fJj);
      }
      paramInt = i;
      if (this.TnS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TnS);
      }
      i = paramInt;
      if (this.TnT != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TnT);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czs localczs = (czs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localczs.TnI = locala.abFh.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localczs.url = locala.abFh.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localczs.fJj = locala.abFh.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localczs.TnS = locala.abFh.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localczs.TnT = locala.abFh.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czs
 * JD-Core Version:    0.7.0.1
 */