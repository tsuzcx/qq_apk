package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
  extends com.tencent.mm.bx.a
{
  public String MUO;
  public String content;
  public String hFb;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32101);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.hFb != null) {
        paramVarArgs.g(2, this.hFb);
      }
      if (this.MUO != null) {
        paramVarArgs.g(3, this.MUO);
      }
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      AppMethodBeat.o(32101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label400;
      }
    }
    label400:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hFb);
      }
      i = paramInt;
      if (this.MUO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MUO);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      AppMethodBeat.o(32101);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32101);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32101);
          return -1;
        case 1: 
          localaq.username = locala.ajGk.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 2: 
          localaq.hFb = locala.ajGk.readString();
          AppMethodBeat.o(32101);
          return 0;
        case 3: 
          localaq.MUO = locala.ajGk.readString();
          AppMethodBeat.o(32101);
          return 0;
        }
        localaq.content = locala.ajGk.readString();
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