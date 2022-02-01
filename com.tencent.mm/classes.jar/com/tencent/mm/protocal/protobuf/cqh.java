package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqh
  extends com.tencent.mm.bw.a
{
  public int DkK;
  public int FDv;
  public int FDx;
  public int FvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FvC);
      paramVarArgs.aR(2, this.FDx);
      paramVarArgs.aR(3, this.FDv);
      paramVarArgs.aR(4, this.DkK);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FvC);
      int i = f.a.a.b.b.a.bx(2, this.FDx);
      int j = f.a.a.b.b.a.bx(3, this.FDv);
      int k = f.a.a.b.b.a.bx(4, this.DkK);
      AppMethodBeat.o(152672);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cqh localcqh = (cqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localcqh.FvC = locala.LVo.xF();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localcqh.FDx = locala.LVo.xF();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localcqh.FDv = locala.LVo.xF();
        AppMethodBeat.o(152672);
        return 0;
      }
      localcqh.DkK = locala.LVo.xF();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqh
 * JD-Core Version:    0.7.0.1
 */