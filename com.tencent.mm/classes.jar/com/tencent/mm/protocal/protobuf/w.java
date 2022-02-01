package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bw.a
{
  public long KBF;
  public String KBL;
  public String KBN;
  public long KBO;
  public int KBP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KBN != null) {
        paramVarArgs.e(1, this.KBN);
      }
      paramVarArgs.bb(2, this.KBF);
      paramVarArgs.bb(3, this.KBO);
      paramVarArgs.aM(4, this.KBP);
      if (this.KBL != null) {
        paramVarArgs.e(5, this.KBL);
      }
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KBN == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.f(1, this.KBN) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KBF) + g.a.a.b.b.a.r(3, this.KBO) + g.a.a.b.b.a.bu(4, this.KBP);
      paramInt = i;
      if (this.KBL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KBL);
      }
      AppMethodBeat.o(91332);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localw.KBN = locala.UbS.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localw.KBF = locala.UbS.zl();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localw.KBO = locala.UbS.zl();
          AppMethodBeat.o(91332);
          return 0;
        case 4: 
          localw.KBP = locala.UbS.zi();
          AppMethodBeat.o(91332);
          return 0;
        }
        localw.KBL = locala.UbS.readString();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.w
 * JD-Core Version:    0.7.0.1
 */