package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eph
  extends com.tencent.mm.cd.a
{
  public String TBB;
  public int UrF;
  public int Urx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TBB != null) {
        paramVarArgs.f(1, this.TBB);
      }
      paramVarArgs.aY(2, this.Urx);
      paramVarArgs.aY(3, this.UrF);
      AppMethodBeat.o(152709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TBB == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.TBB) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Urx);
      int j = g.a.a.b.b.a.bM(3, this.UrF);
      AppMethodBeat.o(152709);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152709);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eph localeph = (eph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152709);
          return -1;
        case 1: 
          localeph.TBB = locala.abFh.readString();
          AppMethodBeat.o(152709);
          return 0;
        case 2: 
          localeph.Urx = locala.abFh.AK();
          AppMethodBeat.o(152709);
          return 0;
        }
        localeph.UrF = locala.abFh.AK();
        AppMethodBeat.o(152709);
        return 0;
      }
      AppMethodBeat.o(152709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eph
 * JD-Core Version:    0.7.0.1
 */