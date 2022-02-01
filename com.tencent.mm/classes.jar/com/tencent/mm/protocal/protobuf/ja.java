package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ja
  extends com.tencent.mm.cd.a
{
  public int channel;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91361);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid == null)
      {
        paramVarArgs = new b("Not all required fields were included: uuid");
        AppMethodBeat.o(91361);
        throw paramVarArgs;
      }
      if (this.uuid != null) {
        paramVarArgs.f(1, this.uuid);
      }
      paramVarArgs.aY(2, this.channel);
      AppMethodBeat.o(91361);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.channel);
      AppMethodBeat.o(91361);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.uuid == null)
        {
          paramVarArgs = new b("Not all required fields were included: uuid");
          AppMethodBeat.o(91361);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91361);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ja localja = (ja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91361);
          return -1;
        case 1: 
          localja.uuid = locala.abFh.readString();
          AppMethodBeat.o(91361);
          return 0;
        }
        localja.channel = locala.abFh.AK();
        AppMethodBeat.o(91361);
        return 0;
      }
      AppMethodBeat.o(91361);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ja
 * JD-Core Version:    0.7.0.1
 */