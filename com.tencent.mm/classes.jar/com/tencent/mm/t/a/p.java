package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bw.a
{
  public String gTT;
  public String gTU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.gTT != null) {
        paramVarArgs.e(1, this.gTT);
      }
      if (this.gTU != null) {
        paramVarArgs.e(2, this.gTU);
      }
      AppMethodBeat.o(194688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gTT == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.gTT) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gTU != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.gTU);
      }
      AppMethodBeat.o(194688);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194688);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194688);
          return -1;
        case 1: 
          localp.gTT = locala.UbS.readString();
          AppMethodBeat.o(194688);
          return 0;
        }
        localp.gTU = locala.UbS.readString();
        AppMethodBeat.o(194688);
        return 0;
      }
      AppMethodBeat.o(194688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.t.a.p
 * JD-Core Version:    0.7.0.1
 */