package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class djl
  extends com.tencent.mm.bx.a
{
  public String chatroomName;
  public int hSm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259902);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroomName == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroomName");
        AppMethodBeat.o(259902);
        throw paramVarArgs;
      }
      if (this.chatroomName != null) {
        paramVarArgs.g(1, this.chatroomName);
      }
      paramVarArgs.bS(2, this.hSm);
      AppMethodBeat.o(259902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroomName == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.chatroomName) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.hSm);
      AppMethodBeat.o(259902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroomName == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroomName");
          AppMethodBeat.o(259902);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259902);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        djl localdjl = (djl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259902);
          return -1;
        case 1: 
          localdjl.chatroomName = locala.ajGk.readString();
          AppMethodBeat.o(259902);
          return 0;
        }
        localdjl.hSm = locala.ajGk.aar();
        AppMethodBeat.o(259902);
        return 0;
      }
      AppMethodBeat.o(259902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djl
 * JD-Core Version:    0.7.0.1
 */