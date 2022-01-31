package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxd
  extends com.tencent.mm.bv.a
{
  public int Timestamp;
  public int nrS;
  public int xKe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124345);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xKe);
      paramVarArgs.aO(2, this.Timestamp);
      paramVarArgs.aO(3, this.nrS);
      AppMethodBeat.o(124345);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xKe);
      int i = e.a.a.b.b.a.bl(2, this.Timestamp);
      int j = e.a.a.b.b.a.bl(3, this.nrS);
      AppMethodBeat.o(124345);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124345);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bxd localbxd = (bxd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124345);
        return -1;
      case 1: 
        localbxd.xKe = locala.CLY.sl();
        AppMethodBeat.o(124345);
        return 0;
      case 2: 
        localbxd.Timestamp = locala.CLY.sl();
        AppMethodBeat.o(124345);
        return 0;
      }
      localbxd.nrS = locala.CLY.sl();
      AppMethodBeat.o(124345);
      return 0;
    }
    AppMethodBeat.o(124345);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxd
 * JD-Core Version:    0.7.0.1
 */