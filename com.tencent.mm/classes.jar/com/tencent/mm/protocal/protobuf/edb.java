package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class edb
  extends com.tencent.mm.cd.a
{
  public b SpW;
  public int Uhw;
  public int Uhx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Uhw);
      paramVarArgs.aY(2, this.Uhx);
      if (this.SpW != null) {
        paramVarArgs.c(3, this.SpW);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Uhw) + 0 + g.a.a.b.b.a.bM(2, this.Uhx);
      paramInt = i;
      if (this.SpW != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SpW);
      }
      AppMethodBeat.o(149128);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      edb localedb = (edb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localedb.Uhw = locala.abFh.AK();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localedb.Uhx = locala.abFh.AK();
        AppMethodBeat.o(149128);
        return 0;
      }
      localedb.SpW = locala.abFh.iUw();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edb
 * JD-Core Version:    0.7.0.1
 */