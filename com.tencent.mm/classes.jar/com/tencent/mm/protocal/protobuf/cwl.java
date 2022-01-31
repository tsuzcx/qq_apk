package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwl
  extends com.tencent.mm.bv.a
{
  public String Username;
  public long yeA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28716);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(28716);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.yeA);
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      AppMethodBeat.o(28716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.yeA) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Username);
      }
      AppMethodBeat.o(28716);
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
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(28716);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28716);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cwl localcwl = (cwl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28716);
        return -1;
      case 1: 
        localcwl.yeA = locala.CLY.sm();
        AppMethodBeat.o(28716);
        return 0;
      }
      localcwl.Username = locala.CLY.readString();
      AppMethodBeat.o(28716);
      return 0;
    }
    AppMethodBeat.o(28716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwl
 * JD-Core Version:    0.7.0.1
 */