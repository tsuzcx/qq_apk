package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String dNI;
  public String gTi;
  public String gTj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.gTi != null) {
        paramVarArgs.e(2, this.gTi);
      }
      if (this.gTj != null) {
        paramVarArgs.e(3, this.gTj);
      }
      AppMethodBeat.o(194674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gTi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.gTi);
      }
      i = paramInt;
      if (this.gTj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.gTj);
      }
      AppMethodBeat.o(194674);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194674);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194674);
          return -1;
        case 1: 
          localb.dNI = locala.UbS.readString();
          AppMethodBeat.o(194674);
          return 0;
        case 2: 
          localb.gTi = locala.UbS.readString();
          AppMethodBeat.o(194674);
          return 0;
        }
        localb.gTj = locala.UbS.readString();
        AppMethodBeat.o(194674);
        return 0;
      }
      AppMethodBeat.o(194674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.t.a.b
 * JD-Core Version:    0.7.0.1
 */