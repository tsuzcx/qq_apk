package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crr
  extends com.tencent.mm.bw.a
{
  public long MwI;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MwI);
      paramVarArgs.bb(2, this.duration);
      AppMethodBeat.o(208705);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.MwI);
      int i = g.a.a.b.b.a.r(2, this.duration);
      AppMethodBeat.o(208705);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(208705);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crr localcrr = (crr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208705);
        return -1;
      case 1: 
        localcrr.MwI = locala.UbS.zl();
        AppMethodBeat.o(208705);
        return 0;
      }
      localcrr.duration = locala.UbS.zl();
      AppMethodBeat.o(208705);
      return 0;
    }
    AppMethodBeat.o(208705);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crr
 * JD-Core Version:    0.7.0.1
 */