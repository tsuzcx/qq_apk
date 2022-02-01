package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lr
  extends com.tencent.mm.bw.a
{
  public long KPp;
  public String KPq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KPp);
      if (this.KPq != null) {
        paramVarArgs.e(2, this.KPq);
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KPp) + 0;
      paramInt = i;
      if (this.KPq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KPq);
      }
      AppMethodBeat.o(110891);
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
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      lr locallr = (lr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110891);
        return -1;
      case 1: 
        locallr.KPp = locala.UbS.zl();
        AppMethodBeat.o(110891);
        return 0;
      }
      locallr.KPq = locala.UbS.readString();
      AppMethodBeat.o(110891);
      return 0;
    }
    AppMethodBeat.o(110891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lr
 * JD-Core Version:    0.7.0.1
 */