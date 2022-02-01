package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pa
  extends com.tencent.mm.cd.a
{
  public String CMC;
  public int Height;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206576);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMC != null) {
        paramVarArgs.f(1, this.CMC);
      }
      paramVarArgs.aY(2, this.Width);
      paramVarArgs.aY(3, this.Height);
      AppMethodBeat.o(206576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMC == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMC) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Width);
      int j = g.a.a.b.b.a.bM(3, this.Height);
      AppMethodBeat.o(206576);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206576);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        pa localpa = (pa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206576);
          return -1;
        case 1: 
          localpa.CMC = locala.abFh.readString();
          AppMethodBeat.o(206576);
          return 0;
        case 2: 
          localpa.Width = locala.abFh.AK();
          AppMethodBeat.o(206576);
          return 0;
        }
        localpa.Height = locala.abFh.AK();
        AppMethodBeat.o(206576);
        return 0;
      }
      AppMethodBeat.o(206576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pa
 * JD-Core Version:    0.7.0.1
 */