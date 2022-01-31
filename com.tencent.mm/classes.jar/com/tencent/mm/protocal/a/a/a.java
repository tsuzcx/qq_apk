package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bv.a
{
  public int count;
  public int value;
  public int wjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72815);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wjb);
      paramVarArgs.aO(2, this.value);
      paramVarArgs.aO(3, this.count);
      AppMethodBeat.o(72815);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wjb);
      int i = e.a.a.b.b.a.bl(2, this.value);
      int j = e.a.a.b.b.a.bl(3, this.count);
      AppMethodBeat.o(72815);
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
      AppMethodBeat.o(72815);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72815);
        return -1;
      case 1: 
        locala1.wjb = locala.CLY.sl();
        AppMethodBeat.o(72815);
        return 0;
      case 2: 
        locala1.value = locala.CLY.sl();
        AppMethodBeat.o(72815);
        return 0;
      }
      locala1.count = locala.CLY.sl();
      AppMethodBeat.o(72815);
      return 0;
    }
    AppMethodBeat.o(72815);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.a
 * JD-Core Version:    0.7.0.1
 */