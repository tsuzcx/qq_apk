package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends com.tencent.mm.bx.a
{
  public long Tqa;
  public String mdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289954);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Tqa);
      if (this.mdD != null) {
        paramVarArgs.g(2, this.mdD);
      }
      AppMethodBeat.o(289954);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Tqa) + 0;
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mdD);
      }
      AppMethodBeat.o(289954);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(289954);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      av localav = (av)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(289954);
        return -1;
      case 1: 
        localav.Tqa = locala.ajGk.aaw();
        AppMethodBeat.o(289954);
        return 0;
      }
      localav.mdD = locala.ajGk.readString();
      AppMethodBeat.o(289954);
      return 0;
    }
    AppMethodBeat.o(289954);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.av
 * JD-Core Version:    0.7.0.1
 */