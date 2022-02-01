package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blc
  extends com.tencent.mm.bw.a
{
  public long aQX;
  public long aQY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.aQX);
      paramVarArgs.aO(2, this.aQY);
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.aQX);
      int i = f.a.a.b.b.a.p(2, this.aQY);
      AppMethodBeat.o(110902);
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
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      blc localblc = (blc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110902);
        return -1;
      case 1: 
        localblc.aQX = locala.LVo.xG();
        AppMethodBeat.o(110902);
        return 0;
      }
      localblc.aQY = locala.LVo.xG();
      AppMethodBeat.o(110902);
      return 0;
    }
    AppMethodBeat.o(110902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blc
 * JD-Core Version:    0.7.0.1
 */