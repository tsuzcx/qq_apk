package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bie
  extends com.tencent.mm.bv.a
{
  public String nqY;
  public int xxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80133);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xxt);
      if (this.nqY != null) {
        paramVarArgs.e(2, this.nqY);
      }
      AppMethodBeat.o(80133);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xxt) + 0;
      paramInt = i;
      if (this.nqY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqY);
      }
      AppMethodBeat.o(80133);
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
      AppMethodBeat.o(80133);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bie localbie = (bie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80133);
        return -1;
      case 1: 
        localbie.xxt = locala.CLY.sl();
        AppMethodBeat.o(80133);
        return 0;
      }
      localbie.nqY = locala.CLY.readString();
      AppMethodBeat.o(80133);
      return 0;
    }
    AppMethodBeat.o(80133);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bie
 * JD-Core Version:    0.7.0.1
 */