package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ql
  extends com.tencent.mm.bw.a
{
  public int KXn;
  public int KXo;
  public int KXp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103204);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXn);
      paramVarArgs.aM(2, this.KXo);
      paramVarArgs.aM(3, this.KXp);
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KXn);
      int i = g.a.a.b.b.a.bu(2, this.KXo);
      int j = g.a.a.b.b.a.bu(3, this.KXp);
      AppMethodBeat.o(103204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ql localql = (ql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103204);
        return -1;
      case 1: 
        localql.KXn = locala.UbS.zi();
        AppMethodBeat.o(103204);
        return 0;
      case 2: 
        localql.KXo = locala.UbS.zi();
        AppMethodBeat.o(103204);
        return 0;
      }
      localql.KXp = locala.UbS.zi();
      AppMethodBeat.o(103204);
      return 0;
    }
    AppMethodBeat.o(103204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ql
 * JD-Core Version:    0.7.0.1
 */