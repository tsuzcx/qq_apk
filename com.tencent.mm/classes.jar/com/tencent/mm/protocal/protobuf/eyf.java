package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eyf
  extends com.tencent.mm.bw.a
{
  public long Nvn;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32515);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Nvn);
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Nvn) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return paramInt;
    }
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
        AppMethodBeat.o(32515);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eyf localeyf = (eyf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32515);
        return -1;
      case 1: 
        localeyf.Nvn = locala.UbS.zl();
        AppMethodBeat.o(32515);
        return 0;
      }
      localeyf.Username = locala.UbS.readString();
      AppMethodBeat.o(32515);
      return 0;
    }
    AppMethodBeat.o(32515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyf
 * JD-Core Version:    0.7.0.1
 */