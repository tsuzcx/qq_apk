package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ggf
  extends com.tencent.mm.bx.a
{
  public String Username;
  public long abmO;
  public boolean accV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32540);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32540);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      paramVarArgs.bv(2, this.abmO);
      paramVarArgs.di(3, this.accV);
      AppMethodBeat.o(32540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label359;
      }
    }
    label359:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abmO);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(32540);
      return paramInt + i + (j + 1);
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
          AppMethodBeat.o(32540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32540);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggf localggf = (ggf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32540);
          return -1;
        case 1: 
          localggf.Username = locala.ajGk.readString();
          AppMethodBeat.o(32540);
          return 0;
        case 2: 
          localggf.abmO = locala.ajGk.aaw();
          AppMethodBeat.o(32540);
          return 0;
        }
        localggf.accV = locala.ajGk.aai();
        AppMethodBeat.o(32540);
        return 0;
      }
      AppMethodBeat.o(32540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggf
 * JD-Core Version:    0.7.0.1
 */