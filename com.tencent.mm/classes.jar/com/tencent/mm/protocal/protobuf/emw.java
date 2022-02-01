package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class emw
  extends com.tencent.mm.cd.a
{
  public String content;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.type == null)
      {
        paramVarArgs = new b("Not all required fields were included: type");
        AppMethodBeat.o(32456);
        throw paramVarArgs;
      }
      if (this.type != null) {
        paramVarArgs.f(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      AppMethodBeat.o(32456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.g(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.content);
      }
      AppMethodBeat.o(32456);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.type == null)
        {
          paramVarArgs = new b("Not all required fields were included: type");
          AppMethodBeat.o(32456);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        emw localemw = (emw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32456);
          return -1;
        case 1: 
          localemw.type = locala.abFh.readString();
          AppMethodBeat.o(32456);
          return 0;
        }
        localemw.content = locala.abFh.readString();
        AppMethodBeat.o(32456);
        return 0;
      }
      AppMethodBeat.o(32456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emw
 * JD-Core Version:    0.7.0.1
 */