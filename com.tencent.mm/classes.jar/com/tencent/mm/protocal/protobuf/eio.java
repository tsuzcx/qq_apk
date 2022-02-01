package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eio
  extends com.tencent.mm.cd.a
{
  public String GIM;
  public String ThumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91692);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ThumbUrl != null) {
        paramVarArgs.f(1, this.ThumbUrl);
      }
      if (this.GIM != null) {
        paramVarArgs.f(2, this.GIM);
      }
      AppMethodBeat.o(91692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ThumbUrl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.ThumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GIM != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.GIM);
      }
      AppMethodBeat.o(91692);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91692);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eio localeio = (eio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91692);
          return -1;
        case 1: 
          localeio.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(91692);
          return 0;
        }
        localeio.GIM = locala.abFh.readString();
        AppMethodBeat.o(91692);
        return 0;
      }
      AppMethodBeat.o(91692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eio
 * JD-Core Version:    0.7.0.1
 */