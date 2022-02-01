package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ot
  extends com.tencent.mm.bw.a
{
  public int EeF;
  public int EeG;
  public int EeH;
  public int drx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.drx);
      paramVarArgs.aR(2, this.EeF);
      paramVarArgs.aR(3, this.EeG);
      paramVarArgs.aR(4, this.EeH);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.drx);
      int i = f.a.a.b.b.a.bx(2, this.EeF);
      int j = f.a.a.b.b.a.bx(3, this.EeG);
      int k = f.a.a.b.b.a.bx(4, this.EeH);
      AppMethodBeat.o(91367);
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
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ot localot = (ot)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localot.drx = locala.LVo.xF();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localot.EeF = locala.LVo.xF();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localot.EeG = locala.LVo.xF();
        AppMethodBeat.o(91367);
        return 0;
      }
      localot.EeH = locala.LVo.xF();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ot
 * JD-Core Version:    0.7.0.1
 */