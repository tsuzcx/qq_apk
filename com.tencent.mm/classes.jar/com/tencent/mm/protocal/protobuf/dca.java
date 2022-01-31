package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dca
  extends com.tencent.mm.bv.a
{
  public int timestamp;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28772);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(28772);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.timestamp);
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      AppMethodBeat.o(28772);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.timestamp) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.username);
      }
      AppMethodBeat.o(28772);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(28772);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28772);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dca localdca = (dca)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28772);
        return -1;
      case 1: 
        localdca.timestamp = locala.CLY.sl();
        AppMethodBeat.o(28772);
        return 0;
      }
      localdca.username = locala.CLY.readString();
      AppMethodBeat.o(28772);
      return 0;
    }
    AppMethodBeat.o(28772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dca
 * JD-Core Version:    0.7.0.1
 */