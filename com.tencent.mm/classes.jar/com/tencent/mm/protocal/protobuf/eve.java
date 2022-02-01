package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eve
  extends com.tencent.mm.bw.a
{
  public String MiI;
  public long Nte;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Nte);
      if (this.MiI != null) {
        paramVarArgs.e(2, this.MiI);
      }
      AppMethodBeat.o(147788);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.Nte) + 0;
      paramInt = i;
      if (this.MiI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MiI);
      }
      AppMethodBeat.o(147788);
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
      AppMethodBeat.o(147788);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eve localeve = (eve)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147788);
        return -1;
      case 1: 
        localeve.Nte = locala.UbS.zl();
        AppMethodBeat.o(147788);
        return 0;
      }
      localeve.MiI = locala.UbS.readString();
      AppMethodBeat.o(147788);
      return 0;
    }
    AppMethodBeat.o(147788);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eve
 * JD-Core Version:    0.7.0.1
 */