package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bmx
  extends com.tencent.mm.bx.a
{
  public String lyrics;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140930);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.lyrics == null)
      {
        paramVarArgs = new b("Not all required fields were included: lyrics");
        AppMethodBeat.o(140930);
        throw paramVarArgs;
      }
      if (this.lyrics != null) {
        paramVarArgs.d(1, this.lyrics);
      }
      paramVarArgs.aG(2, this.startTime);
      AppMethodBeat.o(140930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lyrics == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.lyrics) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.startTime);
      AppMethodBeat.o(140930);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmx localbmx = (bmx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(140930);
          return -1;
        case 1: 
          localbmx.lyrics = locala.KhF.readString();
          AppMethodBeat.o(140930);
          return 0;
        }
        localbmx.startTime = locala.KhF.xT();
        AppMethodBeat.o(140930);
        return 0;
      }
      AppMethodBeat.o(140930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */