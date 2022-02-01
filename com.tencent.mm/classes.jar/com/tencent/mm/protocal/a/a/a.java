package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.cd.a
{
  public int RCo;
  public int count;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCo);
      paramVarArgs.aY(2, this.value);
      paramVarArgs.aY(3, this.count);
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RCo);
      int i = g.a.a.b.b.a.bM(2, this.value);
      int j = g.a.a.b.b.a.bM(3, this.count);
      AppMethodBeat.o(143939);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143939);
        return -1;
      case 1: 
        locala1.RCo = locala.abFh.AK();
        AppMethodBeat.o(143939);
        return 0;
      case 2: 
        locala1.value = locala.abFh.AK();
        AppMethodBeat.o(143939);
        return 0;
      }
      locala1.count = locala.abFh.AK();
      AppMethodBeat.o(143939);
      return 0;
    }
    AppMethodBeat.o(143939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.a
 * JD-Core Version:    0.7.0.1
 */