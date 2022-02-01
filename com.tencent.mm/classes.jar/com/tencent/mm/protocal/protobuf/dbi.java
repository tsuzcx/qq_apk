package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbi
  extends com.tencent.mm.bx.a
{
  public long height;
  public long width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110902);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.width);
      paramVarArgs.bv(2, this.height);
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.width);
      int i = i.a.a.b.b.a.q(2, this.height);
      AppMethodBeat.o(110902);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbi localdbi = (dbi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110902);
        return -1;
      case 1: 
        localdbi.width = locala.ajGk.aaw();
        AppMethodBeat.o(110902);
        return 0;
      }
      localdbi.height = locala.ajGk.aaw();
      AppMethodBeat.o(110902);
      return 0;
    }
    AppMethodBeat.o(110902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbi
 * JD-Core Version:    0.7.0.1
 */