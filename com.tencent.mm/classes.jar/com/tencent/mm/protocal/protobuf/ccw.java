package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccw
  extends com.tencent.mm.bv.a
{
  public boolean xNk = false;
  public boolean xNl = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102390);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xNk);
      paramVarArgs.aS(2, this.xNl);
      AppMethodBeat.o(102390);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(102390);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102390);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ccw localccw = (ccw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102390);
        return -1;
      case 1: 
        localccw.xNk = locala.CLY.emu();
        AppMethodBeat.o(102390);
        return 0;
      }
      localccw.xNl = locala.CLY.emu();
      AppMethodBeat.o(102390);
      return 0;
    }
    AppMethodBeat.o(102390);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccw
 * JD-Core Version:    0.7.0.1
 */