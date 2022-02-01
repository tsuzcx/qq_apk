package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bun
  extends com.tencent.mm.bx.a
{
  public long aacf;
  public String aacg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259215);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aacf);
      if (this.aacg != null) {
        paramVarArgs.g(2, this.aacg);
      }
      AppMethodBeat.o(259215);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aacf) + 0;
      paramInt = i;
      if (this.aacg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aacg);
      }
      AppMethodBeat.o(259215);
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
      AppMethodBeat.o(259215);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bun localbun = (bun)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259215);
        return -1;
      case 1: 
        localbun.aacf = locala.ajGk.aaw();
        AppMethodBeat.o(259215);
        return 0;
      }
      localbun.aacg = locala.ajGk.readString();
      AppMethodBeat.o(259215);
      return 0;
    }
    AppMethodBeat.o(259215);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bun
 * JD-Core Version:    0.7.0.1
 */