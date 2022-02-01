package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cjo
  extends com.tencent.mm.bw.a
{
  public String chatroomName;
  public int dTg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroomName == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroomName");
        AppMethodBeat.o(194545);
        throw paramVarArgs;
      }
      if (this.chatroomName != null) {
        paramVarArgs.e(1, this.chatroomName);
      }
      paramVarArgs.aM(2, this.dTg);
      AppMethodBeat.o(194545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroomName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.chatroomName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.dTg);
      AppMethodBeat.o(194545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.chatroomName == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroomName");
          AppMethodBeat.o(194545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194545);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjo localcjo = (cjo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194545);
          return -1;
        case 1: 
          localcjo.chatroomName = locala.UbS.readString();
          AppMethodBeat.o(194545);
          return 0;
        }
        localcjo.dTg = locala.UbS.zi();
        AppMethodBeat.o(194545);
        return 0;
      }
      AppMethodBeat.o(194545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */