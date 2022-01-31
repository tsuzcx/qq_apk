package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctq
  extends com.tencent.mm.bv.a
{
  public boolean ycE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102394);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).aS(1, this.ycE);
      AppMethodBeat.o(102394);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      AppMethodBeat.o(102394);
      return paramInt + 1 + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102394);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ctq localctq = (ctq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102394);
        return -1;
      }
      localctq.ycE = locala.CLY.emu();
      AppMethodBeat.o(102394);
      return 0;
    }
    AppMethodBeat.o(102394);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */