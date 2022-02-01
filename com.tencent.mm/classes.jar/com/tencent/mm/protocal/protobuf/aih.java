package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aih
  extends com.tencent.mm.bw.a
{
  public int EDe = 0;
  public long endTime = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.startTime);
      paramVarArgs.aO(2, this.endTime);
      paramVarArgs.aR(3, this.EDe);
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.startTime);
      int i = f.a.a.b.b.a.p(2, this.endTime);
      int j = f.a.a.b.b.a.bx(3, this.EDe);
      AppMethodBeat.o(122489);
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
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aih localaih = (aih)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122489);
        return -1;
      case 1: 
        localaih.startTime = locala.LVo.xG();
        AppMethodBeat.o(122489);
        return 0;
      case 2: 
        localaih.endTime = locala.LVo.xG();
        AppMethodBeat.o(122489);
        return 0;
      }
      localaih.EDe = locala.LVo.xF();
      AppMethodBeat.o(122489);
      return 0;
    }
    AppMethodBeat.o(122489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aih
 * JD-Core Version:    0.7.0.1
 */