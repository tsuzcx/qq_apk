package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ns
  extends com.tencent.mm.bw.a
{
  public String KTg;
  public int KTh;
  public String KTi;
  public int KTj;
  public int KTk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTg != null) {
        paramVarArgs.e(1, this.KTg);
      }
      paramVarArgs.aM(2, this.KTh);
      if (this.KTi != null) {
        paramVarArgs.e(3, this.KTi);
      }
      paramVarArgs.aM(4, this.KTj);
      paramVarArgs.aM(5, this.KTk);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTg == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.f(1, this.KTg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KTh);
      paramInt = i;
      if (this.KTi != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KTi);
      }
      i = g.a.a.b.b.a.bu(4, this.KTj);
      int j = g.a.a.b.b.a.bu(5, this.KTk);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ns localns = (ns)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localns.KTg = locala.UbS.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localns.KTh = locala.UbS.zi();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localns.KTi = locala.UbS.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localns.KTj = locala.UbS.zi();
          AppMethodBeat.o(124415);
          return 0;
        }
        localns.KTk = locala.UbS.zi();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ns
 * JD-Core Version:    0.7.0.1
 */