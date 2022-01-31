package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acj
  extends com.tencent.mm.bv.a
{
  public int height;
  public int left;
  public int top;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141621);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.left);
      paramVarArgs.aO(2, this.top);
      paramVarArgs.aO(3, this.width);
      paramVarArgs.aO(4, this.height);
      AppMethodBeat.o(141621);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.left);
      int i = e.a.a.b.b.a.bl(2, this.top);
      int j = e.a.a.b.b.a.bl(3, this.width);
      int k = e.a.a.b.b.a.bl(4, this.height);
      AppMethodBeat.o(141621);
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
      AppMethodBeat.o(141621);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      acj localacj = (acj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(141621);
        return -1;
      case 1: 
        localacj.left = locala.CLY.sl();
        AppMethodBeat.o(141621);
        return 0;
      case 2: 
        localacj.top = locala.CLY.sl();
        AppMethodBeat.o(141621);
        return 0;
      case 3: 
        localacj.width = locala.CLY.sl();
        AppMethodBeat.o(141621);
        return 0;
      }
      localacj.height = locala.CLY.sl();
      AppMethodBeat.o(141621);
      return 0;
    }
    AppMethodBeat.o(141621);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acj
 * JD-Core Version:    0.7.0.1
 */