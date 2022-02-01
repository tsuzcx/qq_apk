package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehi
  extends com.tencent.mm.cd.a
{
  public String fUL;
  public long seq;
  public int trS;
  public int update_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      paramVarArgs.aY(2, this.trS);
      paramVarArgs.aY(3, this.update_time);
      paramVarArgs.bm(4, this.seq);
      AppMethodBeat.o(114074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.g(1, this.fUL) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.trS);
      int j = g.a.a.b.b.a.bM(3, this.update_time);
      int k = g.a.a.b.b.a.p(4, this.seq);
      AppMethodBeat.o(114074);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114074);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehi localehi = (ehi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114074);
          return -1;
        case 1: 
          localehi.fUL = locala.abFh.readString();
          AppMethodBeat.o(114074);
          return 0;
        case 2: 
          localehi.trS = locala.abFh.AK();
          AppMethodBeat.o(114074);
          return 0;
        case 3: 
          localehi.update_time = locala.abFh.AK();
          AppMethodBeat.o(114074);
          return 0;
        }
        localehi.seq = locala.abFh.AN();
        AppMethodBeat.o(114074);
        return 0;
      }
      AppMethodBeat.o(114074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehi
 * JD-Core Version:    0.7.0.1
 */