package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class gfy
  extends com.tencent.mm.bx.a
{
  public String Username;
  public boolean accO;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32532);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.yts == null)
      {
        paramVarArgs = new b("Not all required fields were included: Language");
        AppMethodBeat.o(32532);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.yts != null) {
        paramVarArgs.g(2, this.yts);
      }
      paramVarArgs.di(3, this.accO);
      AppMethodBeat.o(32532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label423;
      }
    }
    label423:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.yts);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(32532);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        if (this.yts == null)
        {
          paramVarArgs = new b("Not all required fields were included: Language");
          AppMethodBeat.o(32532);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32532);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfy localgfy = (gfy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32532);
          return -1;
        case 1: 
          localgfy.Username = locala.ajGk.readString();
          AppMethodBeat.o(32532);
          return 0;
        case 2: 
          localgfy.yts = locala.ajGk.readString();
          AppMethodBeat.o(32532);
          return 0;
        }
        localgfy.accO = locala.ajGk.aai();
        AppMethodBeat.o(32532);
        return 0;
      }
      AppMethodBeat.o(32532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfy
 * JD-Core Version:    0.7.0.1
 */