package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bjl
  extends com.tencent.mm.bw.a
{
  public b EYB;
  public long dBN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.dBN);
      if (this.EYB != null) {
        paramVarArgs.c(2, this.EYB);
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.dBN) + 0;
      paramInt = i;
      if (this.EYB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EYB);
      }
      AppMethodBeat.o(116328);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bjl localbjl = (bjl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116328);
        return -1;
      case 1: 
        localbjl.dBN = locala.LVo.xG();
        AppMethodBeat.o(116328);
        return 0;
      }
      localbjl.EYB = locala.LVo.gfk();
      AppMethodBeat.o(116328);
      return 0;
    }
    AppMethodBeat.o(116328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjl
 * JD-Core Version:    0.7.0.1
 */