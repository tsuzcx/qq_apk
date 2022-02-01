package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.storage.au;
import i.a.a.b;

public class sa
  extends com.tencent.mm.bx.a
{
  public c MVg;
  public au contact;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6400);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(6400);
        throw paramVarArgs;
      }
      if (this.userName != null) {
        paramVarArgs.g(1, this.userName);
      }
      AppMethodBeat.o(6400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = i.a.a.b.b.a.h(1, this.userName) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(6400);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(6400);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6400);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        sa localsa = (sa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6400);
          return -1;
        }
        localsa.userName = locala.ajGk.readString();
        AppMethodBeat.o(6400);
        return 0;
      }
      AppMethodBeat.o(6400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */