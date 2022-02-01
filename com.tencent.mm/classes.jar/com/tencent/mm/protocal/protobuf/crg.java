package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class crg
  extends com.tencent.mm.bw.a
{
  public double Mww;
  public long Mwx;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117880);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(117880);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.e(2, this.Mww);
      paramVarArgs.bb(3, this.Mwx);
      AppMethodBeat.o(117880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.r(3, this.Mwx);
      AppMethodBeat.o(117880);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(117880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117880);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crg localcrg = (crg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117880);
          return -1;
        case 1: 
          localcrg.Username = locala.UbS.readString();
          AppMethodBeat.o(117880);
          return 0;
        case 2: 
          localcrg.Mww = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(117880);
          return 0;
        }
        localcrg.Mwx = locala.UbS.zl();
        AppMethodBeat.o(117880);
        return 0;
      }
      AppMethodBeat.o(117880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crg
 * JD-Core Version:    0.7.0.1
 */