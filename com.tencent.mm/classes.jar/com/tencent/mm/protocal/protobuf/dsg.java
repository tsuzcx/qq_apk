package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dsg
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public long MKf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117911);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(117911);
        throw paramVarArgs;
      }
      if (this.KXA != null) {
        paramVarArgs.e(1, this.KXA);
      }
      paramVarArgs.bb(2, this.MKf);
      AppMethodBeat.o(117911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXA == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.KXA) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.MKf);
      AppMethodBeat.o(117911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KXA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(117911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117911);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsg localdsg = (dsg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117911);
          return -1;
        case 1: 
          localdsg.KXA = locala.UbS.readString();
          AppMethodBeat.o(117911);
          return 0;
        }
        localdsg.MKf = locala.UbS.zl();
        AppMethodBeat.o(117911);
        return 0;
      }
      AppMethodBeat.o(117911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsg
 * JD-Core Version:    0.7.0.1
 */