package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwe
  extends com.tencent.mm.bx.a
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169093);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.left);
      paramVarArgs.aS(2, this.top);
      paramVarArgs.aS(3, this.right);
      paramVarArgs.aS(4, this.bottom);
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.left);
      int i = f.a.a.b.b.a.bz(2, this.top);
      int j = f.a.a.b.b.a.bz(3, this.right);
      int k = f.a.a.b.b.a.bz(4, this.bottom);
      AppMethodBeat.o(169093);
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
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwe localdwe = (dwe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169093);
        return -1;
      case 1: 
        localdwe.left = locala.NPN.zc();
        AppMethodBeat.o(169093);
        return 0;
      case 2: 
        localdwe.top = locala.NPN.zc();
        AppMethodBeat.o(169093);
        return 0;
      case 3: 
        localdwe.right = locala.NPN.zc();
        AppMethodBeat.o(169093);
        return 0;
      }
      localdwe.bottom = locala.NPN.zc();
      AppMethodBeat.o(169093);
      return 0;
    }
    AppMethodBeat.o(169093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwe
 * JD-Core Version:    0.7.0.1
 */