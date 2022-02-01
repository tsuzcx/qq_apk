package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czj
  extends com.tencent.mm.bw.a
{
  public int FID;
  public int FIE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FID);
      paramVarArgs.aR(2, this.FIE);
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FID);
      int i = f.a.a.b.b.a.bx(2, this.FIE);
      AppMethodBeat.o(134259);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(134259);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      czj localczj = (czj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134259);
        return -1;
      case 1: 
        localczj.FID = locala.LVo.xF();
        AppMethodBeat.o(134259);
        return 0;
      }
      localczj.FIE = locala.LVo.xF();
      AppMethodBeat.o(134259);
      return 0;
    }
    AppMethodBeat.o(134259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */