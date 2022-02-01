package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pe
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int Width;
  public String xIx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212249);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIx != null) {
        paramVarArgs.e(1, this.xIx);
      }
      paramVarArgs.aM(2, this.Width);
      paramVarArgs.aM(3, this.Height);
      AppMethodBeat.o(212249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIx == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.xIx) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Width);
      int j = g.a.a.b.b.a.bu(3, this.Height);
      AppMethodBeat.o(212249);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212249);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        pe localpe = (pe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212249);
          return -1;
        case 1: 
          localpe.xIx = locala.UbS.readString();
          AppMethodBeat.o(212249);
          return 0;
        case 2: 
          localpe.Width = locala.UbS.zi();
          AppMethodBeat.o(212249);
          return 0;
        }
        localpe.Height = locala.UbS.zi();
        AppMethodBeat.o(212249);
        return 0;
      }
      AppMethodBeat.o(212249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pe
 * JD-Core Version:    0.7.0.1
 */