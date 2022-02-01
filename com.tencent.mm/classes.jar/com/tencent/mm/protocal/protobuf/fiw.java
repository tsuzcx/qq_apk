package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fiw
  extends com.tencent.mm.cd.a
{
  public long UIx;
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
      paramVarArgs.bm(1, this.UIx);
      if (this.Username != null) {
        paramVarArgs.f(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.UIx) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Username);
      }
      AppMethodBeat.o(32515);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
      fiw localfiw = (fiw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32515);
        return -1;
      case 1: 
        localfiw.UIx = locala.abFh.AN();
        AppMethodBeat.o(32515);
        return 0;
      }
      localfiw.Username = locala.abFh.readString();
      AppMethodBeat.o(32515);
      return 0;
    }
    AppMethodBeat.o(32515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fiw
 * JD-Core Version:    0.7.0.1
 */