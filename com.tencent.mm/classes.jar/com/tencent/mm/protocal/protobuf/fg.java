package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fg
  extends com.tencent.mm.bv.a
{
  public int pIx;
  public int pIy;
  public int pIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28321);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pIx);
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIz);
      AppMethodBeat.o(28321);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.pIx);
      int i = e.a.a.b.b.a.bl(2, this.pIy);
      int j = e.a.a.b.b.a.bl(3, this.pIz);
      AppMethodBeat.o(28321);
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
      AppMethodBeat.o(28321);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      fg localfg = (fg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28321);
        return -1;
      case 1: 
        localfg.pIx = locala.CLY.sl();
        AppMethodBeat.o(28321);
        return 0;
      case 2: 
        localfg.pIy = locala.CLY.sl();
        AppMethodBeat.o(28321);
        return 0;
      }
      localfg.pIz = locala.CLY.sl();
      AppMethodBeat.o(28321);
      return 0;
    }
    AppMethodBeat.o(28321);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fg
 * JD-Core Version:    0.7.0.1
 */