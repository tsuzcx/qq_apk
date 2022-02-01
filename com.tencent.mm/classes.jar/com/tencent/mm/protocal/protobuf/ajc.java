package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajc
  extends com.tencent.mm.cd.a
{
  public long aYz;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204344);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.start);
      paramVarArgs.bm(2, this.aYz);
      AppMethodBeat.o(204344);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.start);
      int i = g.a.a.b.b.a.p(2, this.aYz);
      AppMethodBeat.o(204344);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(204344);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ajc localajc = (ajc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(204344);
        return -1;
      case 1: 
        localajc.start = locala.abFh.AN();
        AppMethodBeat.o(204344);
        return 0;
      }
      localajc.aYz = locala.abFh.AN();
      AppMethodBeat.o(204344);
      return 0;
    }
    AppMethodBeat.o(204344);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajc
 * JD-Core Version:    0.7.0.1
 */