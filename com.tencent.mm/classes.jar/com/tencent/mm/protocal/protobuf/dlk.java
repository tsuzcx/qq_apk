package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlk
  extends com.tencent.mm.cd.a
{
  public String RLN;
  public long TSv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLN != null) {
        paramVarArgs.f(1, this.RLN);
      }
      paramVarArgs.bm(2, this.TSv);
      AppMethodBeat.o(203504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RLN == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.RLN) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.TSv);
      AppMethodBeat.o(203504);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203504);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlk localdlk = (dlk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203504);
          return -1;
        case 1: 
          localdlk.RLN = locala.abFh.readString();
          AppMethodBeat.o(203504);
          return 0;
        }
        localdlk.TSv = locala.abFh.AN();
        AppMethodBeat.o(203504);
        return 0;
      }
      AppMethodBeat.o(203504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlk
 * JD-Core Version:    0.7.0.1
 */