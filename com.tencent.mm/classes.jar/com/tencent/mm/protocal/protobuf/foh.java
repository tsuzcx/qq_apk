package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class foh
  extends com.tencent.mm.cd.a
{
  public String UMv;
  public int UMw;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UMv != null) {
        paramVarArgs.f(1, this.UMv);
      }
      paramVarArgs.aY(2, this.scene);
      paramVarArgs.aY(3, this.UMw);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UMv == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.UMv) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.scene);
      int j = g.a.a.b.b.a.bM(3, this.UMw);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        foh localfoh = (foh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localfoh.UMv = locala.abFh.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localfoh.scene = locala.abFh.AK();
          AppMethodBeat.o(123704);
          return 0;
        }
        localfoh.UMw = locala.abFh.AK();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foh
 * JD-Core Version:    0.7.0.1
 */