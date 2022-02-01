package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public int FoM;
  public int count;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FoM);
      paramVarArgs.aS(2, this.value);
      paramVarArgs.aS(3, this.count);
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FoM);
      int i = f.a.a.b.b.a.bz(2, this.value);
      int j = f.a.a.b.b.a.bz(3, this.count);
      AppMethodBeat.o(143939);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143939);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143939);
        return -1;
      case 1: 
        locala1.FoM = locala.NPN.zc();
        AppMethodBeat.o(143939);
        return 0;
      case 2: 
        locala1.value = locala.NPN.zc();
        AppMethodBeat.o(143939);
        return 0;
      }
      locala1.count = locala.NPN.zc();
      AppMethodBeat.o(143939);
      return 0;
    }
    AppMethodBeat.o(143939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.a
 * JD-Core Version:    0.7.0.1
 */