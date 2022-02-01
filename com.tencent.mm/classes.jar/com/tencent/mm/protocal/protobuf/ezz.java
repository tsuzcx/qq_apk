package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezz
  extends com.tencent.mm.cd.a
{
  public long RIT;
  public String myd;
  public String mym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.mym == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_ticket");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      if (this.mym != null) {
        paramVarArgs.f(2, this.mym);
      }
      paramVarArgs.bm(3, this.RIT);
      AppMethodBeat.o(152721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.myd == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.b.b.a.g(1, this.myd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mym != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.mym);
      }
      paramInt = g.a.a.b.b.a.p(3, this.RIT);
      AppMethodBeat.o(152721);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.myd == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        if (this.mym == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_ticket");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152721);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezz localezz = (ezz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152721);
          return -1;
        case 1: 
          localezz.myd = locala.abFh.readString();
          AppMethodBeat.o(152721);
          return 0;
        case 2: 
          localezz.mym = locala.abFh.readString();
          AppMethodBeat.o(152721);
          return 0;
        }
        localezz.RIT = locala.abFh.AN();
        AppMethodBeat.o(152721);
        return 0;
      }
      AppMethodBeat.o(152721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezz
 * JD-Core Version:    0.7.0.1
 */