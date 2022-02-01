package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctx
  extends com.tencent.mm.bx.a
{
  public int ElE;
  public int ElF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ElE);
      paramVarArgs.aR(2, this.ElF);
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.ElE);
      int i = f.a.a.b.b.a.bA(2, this.ElF);
      AppMethodBeat.o(134259);
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
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ctx localctx = (ctx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134259);
        return -1;
      case 1: 
        localctx.ElE = locala.KhF.xS();
        AppMethodBeat.o(134259);
        return 0;
      }
      localctx.ElF = locala.KhF.xS();
      AppMethodBeat.o(134259);
      return 0;
    }
    AppMethodBeat.o(134259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctx
 * JD-Core Version:    0.7.0.1
 */