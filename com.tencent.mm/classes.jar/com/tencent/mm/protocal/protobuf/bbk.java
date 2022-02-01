package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbk
  extends com.tencent.mm.bw.a
{
  public int dLS;
  public long iVn;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dLS);
      paramVarArgs.bb(2, this.iVn);
      paramVarArgs.aM(3, this.source);
      AppMethodBeat.o(209650);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.dLS);
      int i = g.a.a.b.b.a.r(2, this.iVn);
      int j = g.a.a.b.b.a.bu(3, this.source);
      AppMethodBeat.o(209650);
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
      AppMethodBeat.o(209650);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbk localbbk = (bbk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209650);
        return -1;
      case 1: 
        localbbk.dLS = locala.UbS.zi();
        AppMethodBeat.o(209650);
        return 0;
      case 2: 
        localbbk.iVn = locala.UbS.zl();
        AppMethodBeat.o(209650);
        return 0;
      }
      localbbk.source = locala.UbS.zi();
      AppMethodBeat.o(209650);
      return 0;
    }
    AppMethodBeat.o(209650);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbk
 * JD-Core Version:    0.7.0.1
 */