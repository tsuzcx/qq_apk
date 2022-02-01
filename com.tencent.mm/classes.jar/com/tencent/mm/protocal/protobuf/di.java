package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class di
  extends com.tencent.mm.cd.a
{
  public String RIS;
  public long RIT;
  public String myd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.RIS == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152487);
        throw paramVarArgs;
      }
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      if (this.RIS != null) {
        paramVarArgs.f(2, this.RIS);
      }
      paramVarArgs.bm(3, this.RIT);
      AppMethodBeat.o(152487);
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
      if (this.RIS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RIS);
      }
      paramInt = g.a.a.b.b.a.p(3, this.RIT);
      AppMethodBeat.o(152487);
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
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        if (this.RIS == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152487);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152487);
          return -1;
        case 1: 
          localdi.myd = locala.abFh.readString();
          AppMethodBeat.o(152487);
          return 0;
        case 2: 
          localdi.RIS = locala.abFh.readString();
          AppMethodBeat.o(152487);
          return 0;
        }
        localdi.RIT = locala.abFh.AN();
        AppMethodBeat.o(152487);
        return 0;
      }
      AppMethodBeat.o(152487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.di
 * JD-Core Version:    0.7.0.1
 */