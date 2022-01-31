package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgl
  extends com.tencent.mm.bv.a
{
  public int xvJ;
  public long xvK;
  public long xvL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124332);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xvJ);
      paramVarArgs.am(2, this.xvK);
      paramVarArgs.am(3, this.xvL);
      AppMethodBeat.o(124332);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xvJ);
      int i = e.a.a.b.b.a.p(2, this.xvK);
      int j = e.a.a.b.b.a.p(3, this.xvL);
      AppMethodBeat.o(124332);
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
      AppMethodBeat.o(124332);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bgl localbgl = (bgl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124332);
        return -1;
      case 1: 
        localbgl.xvJ = locala.CLY.sl();
        AppMethodBeat.o(124332);
        return 0;
      case 2: 
        localbgl.xvK = locala.CLY.sm();
        AppMethodBeat.o(124332);
        return 0;
      }
      localbgl.xvL = locala.CLY.sm();
      AppMethodBeat.o(124332);
      return 0;
    }
    AppMethodBeat.o(124332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgl
 * JD-Core Version:    0.7.0.1
 */