package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class rx
  extends com.tencent.mm.bw.a
{
  public long KZn;
  public b KZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43084);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KZn);
      if (this.KZo != null) {
        paramVarArgs.c(2, this.KZo);
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KZn) + 0;
      paramInt = i;
      if (this.KZo != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KZo);
      }
      AppMethodBeat.o(43084);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      rx localrx = (rx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43084);
        return -1;
      case 1: 
        localrx.KZn = locala.UbS.zl();
        AppMethodBeat.o(43084);
        return 0;
      }
      localrx.KZo = locala.UbS.hPo();
      AppMethodBeat.o(43084);
      return 0;
    }
    AppMethodBeat.o(43084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rx
 * JD-Core Version:    0.7.0.1
 */