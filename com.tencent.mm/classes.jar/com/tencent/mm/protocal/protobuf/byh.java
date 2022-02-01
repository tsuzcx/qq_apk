package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byh
  extends com.tencent.mm.bw.a
{
  public int Fnw;
  public long Fnx;
  public long Fny;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117883);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fnw);
      paramVarArgs.aO(2, this.Fnx);
      paramVarArgs.aO(3, this.Fny);
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fnw);
      int i = f.a.a.b.b.a.p(2, this.Fnx);
      int j = f.a.a.b.b.a.p(3, this.Fny);
      AppMethodBeat.o(117883);
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
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byh localbyh = (byh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117883);
        return -1;
      case 1: 
        localbyh.Fnw = locala.LVo.xF();
        AppMethodBeat.o(117883);
        return 0;
      case 2: 
        localbyh.Fnx = locala.LVo.xG();
        AppMethodBeat.o(117883);
        return 0;
      }
      localbyh.Fny = locala.LVo.xG();
      AppMethodBeat.o(117883);
      return 0;
    }
    AppMethodBeat.o(117883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byh
 * JD-Core Version:    0.7.0.1
 */