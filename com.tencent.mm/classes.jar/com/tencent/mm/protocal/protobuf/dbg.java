package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbg
  extends com.tencent.mm.bv.a
{
  public int yhw;
  public int yhx;
  public int yhy;
  public int yhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115015);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yhw);
      paramVarArgs.aO(2, this.yhx);
      paramVarArgs.aO(3, this.yhy);
      paramVarArgs.aO(4, this.yhz);
      AppMethodBeat.o(115015);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.yhw);
      int i = e.a.a.b.b.a.bl(2, this.yhx);
      int j = e.a.a.b.b.a.bl(3, this.yhy);
      int k = e.a.a.b.b.a.bl(4, this.yhz);
      AppMethodBeat.o(115015);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(115015);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbg localdbg = (dbg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115015);
        return -1;
      case 1: 
        localdbg.yhw = locala.CLY.sl();
        AppMethodBeat.o(115015);
        return 0;
      case 2: 
        localdbg.yhx = locala.CLY.sl();
        AppMethodBeat.o(115015);
        return 0;
      case 3: 
        localdbg.yhy = locala.CLY.sl();
        AppMethodBeat.o(115015);
        return 0;
      }
      localdbg.yhz = locala.CLY.sl();
      AppMethodBeat.o(115015);
      return 0;
    }
    AppMethodBeat.o(115015);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbg
 * JD-Core Version:    0.7.0.1
 */