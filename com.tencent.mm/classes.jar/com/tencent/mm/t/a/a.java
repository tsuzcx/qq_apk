package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public long gTg;
  public String gTh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.gTg);
      if (this.gTh != null) {
        paramVarArgs.e(2, this.gTh);
      }
      AppMethodBeat.o(194673);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.gTg) + 0;
      paramInt = i;
      if (this.gTh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.gTh);
      }
      AppMethodBeat.o(194673);
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
      AppMethodBeat.o(194673);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194673);
        return -1;
      case 1: 
        locala1.gTg = locala.UbS.zl();
        AppMethodBeat.o(194673);
        return 0;
      }
      locala1.gTh = locala.UbS.readString();
      AppMethodBeat.o(194673);
      return 0;
    }
    AppMethodBeat.o(194673);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.a
 * JD-Core Version:    0.7.0.1
 */