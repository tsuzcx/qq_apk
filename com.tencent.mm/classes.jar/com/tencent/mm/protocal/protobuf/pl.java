package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pl
  extends com.tencent.mm.bv.a
{
  public int wGX;
  public String wGY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134423);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wGX);
      if (this.wGY != null) {
        paramVarArgs.e(2, this.wGY);
      }
      AppMethodBeat.o(134423);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wGX) + 0;
      paramInt = i;
      if (this.wGY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wGY);
      }
      AppMethodBeat.o(134423);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(134423);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      pl localpl = (pl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134423);
        return -1;
      case 1: 
        localpl.wGX = locala.CLY.sl();
        AppMethodBeat.o(134423);
        return 0;
      }
      localpl.wGY = locala.CLY.readString();
      AppMethodBeat.o(134423);
      return 0;
    }
    AppMethodBeat.o(134423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */