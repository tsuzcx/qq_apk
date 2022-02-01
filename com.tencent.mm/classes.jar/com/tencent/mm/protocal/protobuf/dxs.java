package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxs
  extends com.tencent.mm.bw.a
{
  public int DTQ;
  public long DUK;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.DTQ);
      paramVarArgs.aO(3, this.DUK);
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Ret);
      int i = f.a.a.b.b.a.bx(2, this.DTQ);
      int j = f.a.a.b.b.a.p(3, this.DUK);
      AppMethodBeat.o(32561);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dxs localdxs = (dxs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32561);
        return -1;
      case 1: 
        localdxs.Ret = locala.LVo.xF();
        AppMethodBeat.o(32561);
        return 0;
      case 2: 
        localdxs.DTQ = locala.LVo.xF();
        AppMethodBeat.o(32561);
        return 0;
      }
      localdxs.DUK = locala.LVo.xG();
      AppMethodBeat.o(32561);
      return 0;
    }
    AppMethodBeat.o(32561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxs
 * JD-Core Version:    0.7.0.1
 */