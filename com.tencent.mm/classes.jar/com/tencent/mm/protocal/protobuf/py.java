package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class py
  extends com.tencent.mm.bx.a
{
  public int FLe;
  public int FLf;
  public int FLg;
  public int dDp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dDp);
      paramVarArgs.aS(2, this.FLe);
      paramVarArgs.aS(3, this.FLf);
      paramVarArgs.aS(4, this.FLg);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.dDp);
      int i = f.a.a.b.b.a.bz(2, this.FLe);
      int j = f.a.a.b.b.a.bz(3, this.FLf);
      int k = f.a.a.b.b.a.bz(4, this.FLg);
      AppMethodBeat.o(91367);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      py localpy = (py)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localpy.dDp = locala.NPN.zc();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localpy.FLe = locala.NPN.zc();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localpy.FLf = locala.NPN.zc();
        AppMethodBeat.o(91367);
        return 0;
      }
      localpy.FLg = locala.NPN.zc();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */