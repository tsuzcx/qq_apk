package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fhu
  extends com.tencent.mm.bx.a
{
  public String content;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.type == null)
      {
        paramVarArgs = new b("Not all required fields were included: type");
        AppMethodBeat.o(32456);
        throw paramVarArgs;
      }
      if (this.type != null) {
        paramVarArgs.g(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.g(2, this.content);
      }
      AppMethodBeat.o(32456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label330;
      }
    }
    label330:
    for (paramInt = i.a.a.b.b.a.h(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.content);
      }
      AppMethodBeat.o(32456);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fhu localfhu = (fhu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32456);
          return -1;
        case 1: 
          localfhu.type = locala.ajGk.readString();
          AppMethodBeat.o(32456);
          return 0;
        }
        localfhu.content = locala.ajGk.readString();
        AppMethodBeat.o(32456);
        return 0;
      }
      AppMethodBeat.o(32456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhu
 * JD-Core Version:    0.7.0.1
 */