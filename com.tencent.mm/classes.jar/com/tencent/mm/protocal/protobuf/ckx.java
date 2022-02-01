package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckx
  extends com.tencent.mm.bx.a
{
  public long x;
  public long y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110909);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.x);
      paramVarArgs.aY(2, this.y);
      AppMethodBeat.o(110909);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.x);
      int i = f.a.a.b.b.a.p(2, this.y);
      AppMethodBeat.o(110909);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110909);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ckx localckx = (ckx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110909);
        return -1;
      case 1: 
        localckx.x = locala.NPN.zd();
        AppMethodBeat.o(110909);
        return 0;
      }
      localckx.y = locala.NPN.zd();
      AppMethodBeat.o(110909);
      return 0;
    }
    AppMethodBeat.o(110909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckx
 * JD-Core Version:    0.7.0.1
 */