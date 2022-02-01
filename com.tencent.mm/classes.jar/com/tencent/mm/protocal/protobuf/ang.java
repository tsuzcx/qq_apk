package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ang
  extends com.tencent.mm.bw.a
{
  public long EGo;
  public int crashCount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EGo);
      paramVarArgs.aR(2, this.crashCount);
      AppMethodBeat.o(195103);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.EGo);
      int i = f.a.a.b.b.a.bx(2, this.crashCount);
      AppMethodBeat.o(195103);
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
      AppMethodBeat.o(195103);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ang localang = (ang)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195103);
        return -1;
      case 1: 
        localang.EGo = locala.LVo.xG();
        AppMethodBeat.o(195103);
        return 0;
      }
      localang.crashCount = locala.LVo.xF();
      AppMethodBeat.o(195103);
      return 0;
    }
    AppMethodBeat.o(195103);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */