package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhf
  extends com.tencent.mm.bw.a
{
  public long FQw;
  public long FQx;
  public int FQy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FQw);
      paramVarArgs.aO(2, this.FQx);
      paramVarArgs.aR(3, this.FQy);
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FQw);
      int i = f.a.a.b.b.a.p(2, this.FQx);
      int j = f.a.a.b.b.a.bx(3, this.FQy);
      AppMethodBeat.o(125848);
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
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhf localdhf = (dhf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125848);
        return -1;
      case 1: 
        localdhf.FQw = locala.LVo.xG();
        AppMethodBeat.o(125848);
        return 0;
      case 2: 
        localdhf.FQx = locala.LVo.xG();
        AppMethodBeat.o(125848);
        return 0;
      }
      localdhf.FQy = locala.LVo.xF();
      AppMethodBeat.o(125848);
      return 0;
    }
    AppMethodBeat.o(125848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhf
 * JD-Core Version:    0.7.0.1
 */