package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eho
  extends com.tencent.mm.cd.a
{
  public String MD5;
  public String URL;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.URL != null) {
        paramVarArgs.f(1, this.URL);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.URL == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.g(1, this.URL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MD5);
      }
      AppMethodBeat.o(32453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32453);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eho localeho = (eho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32453);
          return -1;
        case 1: 
          localeho.URL = locala.abFh.readString();
          AppMethodBeat.o(32453);
          return 0;
        case 2: 
          localeho.fwr = locala.abFh.readString();
          AppMethodBeat.o(32453);
          return 0;
        }
        localeho.MD5 = locala.abFh.readString();
        AppMethodBeat.o(32453);
        return 0;
      }
      AppMethodBeat.o(32453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eho
 * JD-Core Version:    0.7.0.1
 */