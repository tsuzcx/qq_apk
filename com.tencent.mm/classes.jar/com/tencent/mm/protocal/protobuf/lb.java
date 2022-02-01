package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class lb
  extends com.tencent.mm.bw.a
{
  public String KOS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KOS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Mac");
        AppMethodBeat.o(82388);
        throw paramVarArgs;
      }
      if (this.KOS != null) {
        paramVarArgs.e(1, this.KOS);
      }
      AppMethodBeat.o(82388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KOS == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.f(1, this.KOS) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(82388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KOS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Mac");
          AppMethodBeat.o(82388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82388);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        lb locallb = (lb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82388);
          return -1;
        }
        locallb.KOS = locala.UbS.readString();
        AppMethodBeat.o(82388);
        return 0;
      }
      AppMethodBeat.o(82388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lb
 * JD-Core Version:    0.7.0.1
 */