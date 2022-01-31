package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avy
  extends com.tencent.mm.bv.a
{
  public int xll;
  public int xlm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10195);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xll);
      paramVarArgs.aO(2, this.xlm);
      AppMethodBeat.o(10195);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xll);
      int i = e.a.a.b.b.a.bl(2, this.xlm);
      AppMethodBeat.o(10195);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(10195);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      avy localavy = (avy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(10195);
        return -1;
      case 1: 
        localavy.xll = locala.CLY.sl();
        AppMethodBeat.o(10195);
        return 0;
      }
      localavy.xlm = locala.CLY.sl();
      AppMethodBeat.o(10195);
      return 0;
    }
    AppMethodBeat.o(10195);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */