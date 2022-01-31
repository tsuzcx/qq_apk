package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dcc
  extends com.tencent.mm.bv.a
{
  public int score;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28774);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(28774);
        throw paramVarArgs;
      }
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.aO(2, this.score);
      AppMethodBeat.o(28774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.score);
      AppMethodBeat.o(28774);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(28774);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28774);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dcc localdcc = (dcc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28774);
          return -1;
        case 1: 
          localdcc.title = locala.CLY.readString();
          AppMethodBeat.o(28774);
          return 0;
        }
        localdcc.score = locala.CLY.sl();
        AppMethodBeat.o(28774);
        return 0;
      }
      AppMethodBeat.o(28774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcc
 * JD-Core Version:    0.7.0.1
 */