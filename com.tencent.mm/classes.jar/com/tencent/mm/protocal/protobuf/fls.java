package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fls
  extends com.tencent.mm.cd.a
{
  public String GTv;
  public int GUa;
  public int UKH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GTv != null) {
        paramVarArgs.f(1, this.GTv);
      }
      paramVarArgs.aY(2, this.UKH);
      paramVarArgs.aY(3, this.GUa);
      AppMethodBeat.o(196323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GTv == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.GTv) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.UKH);
      int j = g.a.a.b.b.a.bM(3, this.GUa);
      AppMethodBeat.o(196323);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(196323);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fls localfls = (fls)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196323);
          return -1;
        case 1: 
          localfls.GTv = locala.abFh.readString();
          AppMethodBeat.o(196323);
          return 0;
        case 2: 
          localfls.UKH = locala.abFh.AK();
          AppMethodBeat.o(196323);
          return 0;
        }
        localfls.GUa = locala.abFh.AK();
        AppMethodBeat.o(196323);
        return 0;
      }
      AppMethodBeat.o(196323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fls
 * JD-Core Version:    0.7.0.1
 */