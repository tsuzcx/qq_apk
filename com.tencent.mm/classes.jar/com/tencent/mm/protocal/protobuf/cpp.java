package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cpp
  extends com.tencent.mm.bv.a
{
  public int xYy;
  public b xYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5224);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xYy);
      if (this.xYz != null) {
        paramVarArgs.c(2, this.xYz);
      }
      AppMethodBeat.o(5224);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xYy) + 0;
      paramInt = i;
      if (this.xYz != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xYz);
      }
      AppMethodBeat.o(5224);
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
      AppMethodBeat.o(5224);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cpp localcpp = (cpp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5224);
        return -1;
      case 1: 
        localcpp.xYy = locala.CLY.sl();
        AppMethodBeat.o(5224);
        return 0;
      }
      localcpp.xYz = locala.CLY.eqS();
      AppMethodBeat.o(5224);
      return 0;
    }
    AppMethodBeat.o(5224);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpp
 * JD-Core Version:    0.7.0.1
 */