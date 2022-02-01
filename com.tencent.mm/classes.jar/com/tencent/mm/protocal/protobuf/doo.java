package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class doo
  extends com.tencent.mm.bw.a
{
  public int FWj;
  public b FWk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FWj);
      if (this.FWk != null) {
        paramVarArgs.c(2, this.FWk);
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FWj) + 0;
      paramInt = i;
      if (this.FWk != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FWk);
      }
      AppMethodBeat.o(115856);
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
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      doo localdoo = (doo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115856);
        return -1;
      case 1: 
        localdoo.FWj = locala.LVo.xF();
        AppMethodBeat.o(115856);
        return 0;
      }
      localdoo.FWk = locala.LVo.gfk();
      AppMethodBeat.o(115856);
      return 0;
    }
    AppMethodBeat.o(115856);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doo
 * JD-Core Version:    0.7.0.1
 */