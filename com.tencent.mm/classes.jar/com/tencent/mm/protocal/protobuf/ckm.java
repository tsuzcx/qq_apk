package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ckm
  extends com.tencent.mm.bw.a
{
  public String lyrics;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140930);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lyrics == null)
      {
        paramVarArgs = new b("Not all required fields were included: lyrics");
        AppMethodBeat.o(140930);
        throw paramVarArgs;
      }
      if (this.lyrics != null) {
        paramVarArgs.e(1, this.lyrics);
      }
      paramVarArgs.bb(2, this.startTime);
      AppMethodBeat.o(140930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lyrics == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.lyrics) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.startTime);
      AppMethodBeat.o(140930);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckm localckm = (ckm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(140930);
          return -1;
        case 1: 
          localckm.lyrics = locala.UbS.readString();
          AppMethodBeat.o(140930);
          return 0;
        }
        localckm.startTime = locala.UbS.zl();
        AppMethodBeat.o(140930);
        return 0;
      }
      AppMethodBeat.o(140930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckm
 * JD-Core Version:    0.7.0.1
 */