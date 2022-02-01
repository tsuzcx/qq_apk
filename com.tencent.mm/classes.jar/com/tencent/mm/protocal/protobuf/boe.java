package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boe
  extends com.tencent.mm.bw.a
{
  public int FdH;
  public int wTD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.wTD);
      paramVarArgs.aR(2, this.FdH);
      AppMethodBeat.o(133175);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.wTD);
      int i = f.a.a.b.b.a.bx(2, this.FdH);
      AppMethodBeat.o(133175);
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
      AppMethodBeat.o(133175);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      boe localboe = (boe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133175);
        return -1;
      case 1: 
        localboe.wTD = locala.LVo.xF();
        AppMethodBeat.o(133175);
        return 0;
      }
      localboe.FdH = locala.LVo.xF();
      AppMethodBeat.o(133175);
      return 0;
    }
    AppMethodBeat.o(133175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boe
 * JD-Core Version:    0.7.0.1
 */