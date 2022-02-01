package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public String jDH;
  public String jDI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jDH != null) {
        paramVarArgs.f(1, this.jDH);
      }
      if (this.jDI != null) {
        paramVarArgs.f(2, this.jDI);
      }
      AppMethodBeat.o(249641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jDH == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.jDH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jDI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jDI);
      }
      AppMethodBeat.o(249641);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249641);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(249641);
          return -1;
        case 1: 
          localb.jDH = locala.abFh.readString();
          AppMethodBeat.o(249641);
          return 0;
        }
        localb.jDI = locala.abFh.readString();
        AppMethodBeat.o(249641);
        return 0;
      }
      AppMethodBeat.o(249641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.b
 * JD-Core Version:    0.7.0.1
 */