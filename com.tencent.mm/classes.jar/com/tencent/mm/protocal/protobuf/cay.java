package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cay
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
      paramVarArgs.aG(1, this.x);
      paramVarArgs.aG(2, this.y);
      AppMethodBeat.o(110909);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.x);
      int i = f.a.a.b.b.a.q(2, this.y);
      AppMethodBeat.o(110909);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110909);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cay localcay = (cay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110909);
        return -1;
      case 1: 
        localcay.x = locala.KhF.xT();
        AppMethodBeat.o(110909);
        return 0;
      }
      localcay.y = locala.KhF.xT();
      AppMethodBeat.o(110909);
      return 0;
    }
    AppMethodBeat.o(110909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cay
 * JD-Core Version:    0.7.0.1
 */