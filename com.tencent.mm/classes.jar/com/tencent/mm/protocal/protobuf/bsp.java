package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsp
  extends com.tencent.mm.bv.a
{
  public int xGe;
  public int xGf;
  public int xGg;
  public int xGh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108898);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xGe);
      paramVarArgs.aO(2, this.xGf);
      paramVarArgs.aO(3, this.xGg);
      paramVarArgs.aO(4, this.xGh);
      AppMethodBeat.o(108898);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xGe);
      int i = e.a.a.b.b.a.bl(2, this.xGf);
      int j = e.a.a.b.b.a.bl(3, this.xGg);
      int k = e.a.a.b.b.a.bl(4, this.xGh);
      AppMethodBeat.o(108898);
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
      AppMethodBeat.o(108898);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bsp localbsp = (bsp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108898);
        return -1;
      case 1: 
        localbsp.xGe = locala.CLY.sl();
        AppMethodBeat.o(108898);
        return 0;
      case 2: 
        localbsp.xGf = locala.CLY.sl();
        AppMethodBeat.o(108898);
        return 0;
      case 3: 
        localbsp.xGg = locala.CLY.sl();
        AppMethodBeat.o(108898);
        return 0;
      }
      localbsp.xGh = locala.CLY.sl();
      AppMethodBeat.o(108898);
      return 0;
    }
    AppMethodBeat.o(108898);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */