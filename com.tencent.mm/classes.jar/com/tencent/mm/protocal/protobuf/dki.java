package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dki
  extends com.tencent.mm.bx.a
{
  public String lyrics;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140930);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.lyrics == null)
      {
        paramVarArgs = new b("Not all required fields were included: lyrics");
        AppMethodBeat.o(140930);
        throw paramVarArgs;
      }
      if (this.lyrics != null) {
        paramVarArgs.g(1, this.lyrics);
      }
      paramVarArgs.bv(2, this.startTime);
      AppMethodBeat.o(140930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lyrics == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.lyrics) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.startTime);
      AppMethodBeat.o(140930);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.lyrics == null)
        {
          paramVarArgs = new b("Not all required fields were included: lyrics");
          AppMethodBeat.o(140930);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140930);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dki localdki = (dki)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(140930);
          return -1;
        case 1: 
          localdki.lyrics = locala.ajGk.readString();
          AppMethodBeat.o(140930);
          return 0;
        }
        localdki.startTime = locala.ajGk.aaw();
        AppMethodBeat.o(140930);
        return 0;
      }
      AppMethodBeat.o(140930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dki
 * JD-Core Version:    0.7.0.1
 */