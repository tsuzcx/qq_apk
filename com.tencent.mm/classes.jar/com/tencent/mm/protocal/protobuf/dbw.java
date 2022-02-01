package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbw
  extends com.tencent.mm.bw.a
{
  public int KEc;
  public int MGK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KEc);
      paramVarArgs.aM(2, this.MGK);
      AppMethodBeat.o(43125);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KEc);
      int i = g.a.a.b.b.a.bu(2, this.MGK);
      AppMethodBeat.o(43125);
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
      AppMethodBeat.o(43125);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dbw localdbw = (dbw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43125);
        return -1;
      case 1: 
        localdbw.KEc = locala.UbS.zi();
        AppMethodBeat.o(43125);
        return 0;
      }
      localdbw.MGK = locala.UbS.zi();
      AppMethodBeat.o(43125);
      return 0;
    }
    AppMethodBeat.o(43125);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbw
 * JD-Core Version:    0.7.0.1
 */