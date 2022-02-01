package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
  extends com.tencent.mm.bw.a
{
  public String BcW;
  public String content;
  public String dHx;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.dHx != null) {
        paramVarArgs.e(2, this.dHx);
      }
      if (this.BcW != null) {
        paramVarArgs.e(3, this.BcW);
      }
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      AppMethodBeat.o(32101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label404;
      }
    }
    label404:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dHx);
      }
      i = paramInt;
      if (this.BcW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.BcW);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.content);
      }
      AppMethodBeat.o(32101);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32101);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32101);
          return -1;
        case 1: 
          localaq.username = locala.UbS.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 2: 
          localaq.dHx = locala.UbS.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 3: 
          localaq.BcW = locala.UbS.readString();
          AppMethodBeat.o(32101);
          return 0;
        }
        localaq.content = locala.UbS.readString();
        AppMethodBeat.o(32101);
        return 0;
      }
      AppMethodBeat.o(32101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aq
 * JD-Core Version:    0.7.0.1
 */