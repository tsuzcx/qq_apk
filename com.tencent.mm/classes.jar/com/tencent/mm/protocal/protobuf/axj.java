package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axj
  extends com.tencent.mm.bv.a
{
  public int wXX;
  public int xmF;
  public int xmG;
  public int xmH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80112);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wXX);
      paramVarArgs.aO(2, this.xmF);
      paramVarArgs.aO(3, this.xmG);
      paramVarArgs.aO(4, this.xmH);
      AppMethodBeat.o(80112);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wXX);
      int i = e.a.a.b.b.a.bl(2, this.xmF);
      int j = e.a.a.b.b.a.bl(3, this.xmG);
      int k = e.a.a.b.b.a.bl(4, this.xmH);
      AppMethodBeat.o(80112);
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
      AppMethodBeat.o(80112);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      axj localaxj = (axj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80112);
        return -1;
      case 1: 
        localaxj.wXX = locala.CLY.sl();
        AppMethodBeat.o(80112);
        return 0;
      case 2: 
        localaxj.xmF = locala.CLY.sl();
        AppMethodBeat.o(80112);
        return 0;
      case 3: 
        localaxj.xmG = locala.CLY.sl();
        AppMethodBeat.o(80112);
        return 0;
      }
      localaxj.xmH = locala.CLY.sl();
      AppMethodBeat.o(80112);
      return 0;
    }
    AppMethodBeat.o(80112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axj
 * JD-Core Version:    0.7.0.1
 */