package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.cd.a
{
  public long jDF;
  public String jDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.jDF);
      if (this.jDG != null) {
        paramVarArgs.f(2, this.jDG);
      }
      AppMethodBeat.o(249528);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.jDF) + 0;
      paramInt = i;
      if (this.jDG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jDG);
      }
      AppMethodBeat.o(249528);
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
      AppMethodBeat.o(249528);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(249528);
        return -1;
      case 1: 
        locala1.jDF = locala.abFh.AN();
        AppMethodBeat.o(249528);
        return 0;
      }
      locala1.jDG = locala.abFh.readString();
      AppMethodBeat.o(249528);
      return 0;
    }
    AppMethodBeat.o(249528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.a
 * JD-Core Version:    0.7.0.1
 */