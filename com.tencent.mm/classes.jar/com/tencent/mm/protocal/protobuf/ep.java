package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ep
  extends com.tencent.mm.cd.a
{
  public String RJy;
  public String RJz;
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
        paramVarArgs.f(1, this.content);
      }
      if (this.RJy != null) {
        paramVarArgs.f(2, this.RJy);
      }
      if (this.RJz != null) {
        paramVarArgs.f(3, this.RJz);
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
    for (int i = g.a.a.b.b.a.g(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJy);
      }
      i = paramInt;
      if (this.RJz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RJz);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        ep localep = (ep)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          localep.content = locala.abFh.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          localep.RJy = locala.abFh.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        localep.RJz = locala.abFh.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ep
 * JD-Core Version:    0.7.0.1
 */