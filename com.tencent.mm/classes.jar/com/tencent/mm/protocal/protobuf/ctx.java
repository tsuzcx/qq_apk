package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctx
  extends com.tencent.mm.bw.a
{
  public String Mzh;
  public int dRq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dRq);
      if (this.Mzh != null) {
        paramVarArgs.e(2, this.Mzh);
      }
      AppMethodBeat.o(208710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dRq) + 0;
      paramInt = i;
      if (this.Mzh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mzh);
      }
      AppMethodBeat.o(208710);
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
      AppMethodBeat.o(208710);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ctx localctx = (ctx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208710);
        return -1;
      case 1: 
        localctx.dRq = locala.UbS.zi();
        AppMethodBeat.o(208710);
        return 0;
      }
      localctx.Mzh = locala.UbS.readString();
      AppMethodBeat.o(208710);
      return 0;
    }
    AppMethodBeat.o(208710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctx
 * JD-Core Version:    0.7.0.1
 */