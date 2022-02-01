package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ded
  extends com.tencent.mm.bw.a
{
  public long FMS;
  public int FNL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FMS);
      paramVarArgs.aR(2, this.FNL);
      AppMethodBeat.o(118459);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FMS);
      int i = f.a.a.b.b.a.bx(2, this.FNL);
      AppMethodBeat.o(118459);
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
      AppMethodBeat.o(118459);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ded localded = (ded)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118459);
        return -1;
      case 1: 
        localded.FMS = locala.LVo.xG();
        AppMethodBeat.o(118459);
        return 0;
      }
      localded.FNL = locala.LVo.xF();
      AppMethodBeat.o(118459);
      return 0;
    }
    AppMethodBeat.o(118459);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ded
 * JD-Core Version:    0.7.0.1
 */