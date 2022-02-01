package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dme
  extends com.tencent.mm.cd.a
{
  public String CQT;
  public String URL;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.URL != null) {
        paramVarArgs.f(2, this.URL);
      }
      if (this.CQT != null) {
        paramVarArgs.f(3, this.CQT);
      }
      AppMethodBeat.o(199472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.URL);
      }
      i = paramInt;
      if (this.CQT != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CQT);
      }
      AppMethodBeat.o(199472);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199472);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dme localdme = (dme)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199472);
          return -1;
        case 1: 
          localdme.fwr = locala.abFh.readString();
          AppMethodBeat.o(199472);
          return 0;
        case 2: 
          localdme.URL = locala.abFh.readString();
          AppMethodBeat.o(199472);
          return 0;
        }
        localdme.CQT = locala.abFh.readString();
        AppMethodBeat.o(199472);
        return 0;
      }
      AppMethodBeat.o(199472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dme
 * JD-Core Version:    0.7.0.1
 */