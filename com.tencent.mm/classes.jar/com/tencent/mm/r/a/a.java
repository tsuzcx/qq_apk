package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public long mdA;
  public String mdB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231406);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mdA);
      if (this.mdB != null) {
        paramVarArgs.g(2, this.mdB);
      }
      AppMethodBeat.o(231406);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.mdA) + 0;
      paramInt = i;
      if (this.mdB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mdB);
      }
      AppMethodBeat.o(231406);
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
      AppMethodBeat.o(231406);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(231406);
        return -1;
      case 1: 
        locala1.mdA = locala.ajGk.aaw();
        AppMethodBeat.o(231406);
        return 0;
      }
      locala1.mdB = locala.ajGk.readString();
      AppMethodBeat.o(231406);
      return 0;
    }
    AppMethodBeat.o(231406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.a
 * JD-Core Version:    0.7.0.1
 */