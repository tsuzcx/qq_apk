package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bzk
  extends com.tencent.mm.cd.a
{
  public String fAo;
  public String fHp;
  public String myd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152580);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152580);
        throw paramVarArgs;
      }
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      if (this.fHp != null) {
        paramVarArgs.f(2, this.fHp);
      }
      if (this.fAo != null) {
        paramVarArgs.f(3, this.fAo);
      }
      AppMethodBeat.o(152580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.myd == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.g(1, this.myd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fHp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fHp);
      }
      i = paramInt;
      if (this.fAo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fAo);
      }
      AppMethodBeat.o(152580);
      return i;
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
          AppMethodBeat.o(152580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152580);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzk localbzk = (bzk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152580);
          return -1;
        case 1: 
          localbzk.myd = locala.abFh.readString();
          AppMethodBeat.o(152580);
          return 0;
        case 2: 
          localbzk.fHp = locala.abFh.readString();
          AppMethodBeat.o(152580);
          return 0;
        }
        localbzk.fAo = locala.abFh.readString();
        AppMethodBeat.o(152580);
        return 0;
      }
      AppMethodBeat.o(152580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzk
 * JD-Core Version:    0.7.0.1
 */