package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mp
  extends com.tencent.mm.bw.a
{
  public long KQT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168934);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).bb(1, this.KQT);
      AppMethodBeat.o(168934);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.KQT);
      AppMethodBeat.o(168934);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(168934);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      mp localmp = (mp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168934);
        return -1;
      }
      localmp.KQT = locala.UbS.zl();
      AppMethodBeat.o(168934);
      return 0;
    }
    AppMethodBeat.o(168934);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mp
 * JD-Core Version:    0.7.0.1
 */