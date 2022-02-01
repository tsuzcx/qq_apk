package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exz
  extends com.tencent.mm.bw.a
{
  public long Nvg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91737);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).bb(1, this.Nvg);
      AppMethodBeat.o(91737);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Nvg);
      AppMethodBeat.o(91737);
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
      AppMethodBeat.o(91737);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      exz localexz = (exz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91737);
        return -1;
      }
      localexz.Nvg = locala.UbS.zl();
      AppMethodBeat.o(91737);
      return 0;
    }
    AppMethodBeat.o(91737);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exz
 * JD-Core Version:    0.7.0.1
 */