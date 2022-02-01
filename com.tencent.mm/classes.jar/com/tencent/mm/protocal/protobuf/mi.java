package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mi
  extends com.tencent.mm.bx.a
{
  public long YNE;
  public String debug_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110891);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNE);
      if (this.debug_info != null) {
        paramVarArgs.g(2, this.debug_info);
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YNE) + 0;
      paramInt = i;
      if (this.debug_info != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.debug_info);
      }
      AppMethodBeat.o(110891);
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
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      mi localmi = (mi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110891);
        return -1;
      case 1: 
        localmi.YNE = locala.ajGk.aaw();
        AppMethodBeat.o(110891);
        return 0;
      }
      localmi.debug_info = locala.ajGk.readString();
      AppMethodBeat.o(110891);
      return 0;
    }
    AppMethodBeat.o(110891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */