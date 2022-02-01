package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkj
  extends com.tencent.mm.bx.a
{
  public int ZnB;
  public int abLl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259404);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZnB);
      paramVarArgs.bS(2, this.abLl);
      AppMethodBeat.o(259404);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZnB);
      int i = i.a.a.b.b.a.cJ(2, this.abLl);
      AppMethodBeat.o(259404);
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
      AppMethodBeat.o(259404);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fkj localfkj = (fkj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259404);
        return -1;
      case 1: 
        localfkj.ZnB = locala.ajGk.aar();
        AppMethodBeat.o(259404);
        return 0;
      }
      localfkj.abLl = locala.ajGk.aar();
      AppMethodBeat.o(259404);
      return 0;
    }
    AppMethodBeat.o(259404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkj
 * JD-Core Version:    0.7.0.1
 */