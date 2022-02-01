package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvq
  extends com.tencent.mm.bw.a
{
  public long Flp;
  public long Flq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Flp);
      paramVarArgs.aO(2, this.Flq);
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Flp);
      int i = f.a.a.b.b.a.p(2, this.Flq);
      AppMethodBeat.o(134247);
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
      AppMethodBeat.o(134247);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvq localbvq = (bvq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134247);
        return -1;
      case 1: 
        localbvq.Flp = locala.LVo.xG();
        AppMethodBeat.o(134247);
        return 0;
      }
      localbvq.Flq = locala.LVo.xG();
      AppMethodBeat.o(134247);
      return 0;
    }
    AppMethodBeat.o(134247);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvq
 * JD-Core Version:    0.7.0.1
 */