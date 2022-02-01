package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class es
  extends com.tencent.mm.bw.a
{
  public String KIi;
  public String KIj;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50079);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(50079);
        throw paramVarArgs;
      }
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.KIi != null) {
        paramVarArgs.e(2, this.KIi);
      }
      if (this.KIj != null) {
        paramVarArgs.e(3, this.KIj);
      }
      AppMethodBeat.o(50079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.f(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KIi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KIi);
      }
      i = paramInt;
      if (this.KIj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KIj);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(50079);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50079);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        es locales = (es)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          locales.content = locala.UbS.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          locales.KIi = locala.UbS.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        locales.KIj = locala.UbS.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.es
 * JD-Core Version:    0.7.0.1
 */