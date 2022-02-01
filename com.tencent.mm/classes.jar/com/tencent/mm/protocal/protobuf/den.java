package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class den
  extends com.tencent.mm.cd.a
{
  public String CqQ;
  public int HlG;
  public int RYY;
  public int SmH;
  public int TMj;
  public int TMk;
  public String TMl;
  public int TMm;
  public String TMn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CqQ != null) {
        paramVarArgs.f(1, this.CqQ);
      }
      paramVarArgs.aY(2, this.TMj);
      paramVarArgs.aY(3, this.TMk);
      paramVarArgs.aY(4, this.RYY);
      if (this.TMl != null) {
        paramVarArgs.f(5, this.TMl);
      }
      paramVarArgs.aY(6, this.HlG);
      paramVarArgs.aY(7, this.TMm);
      paramVarArgs.aY(8, this.SmH);
      if (this.TMn != null) {
        paramVarArgs.f(9, this.TMn);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CqQ == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = g.a.a.b.b.a.g(1, this.CqQ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TMj) + g.a.a.b.b.a.bM(3, this.TMk) + g.a.a.b.b.a.bM(4, this.RYY);
      paramInt = i;
      if (this.TMl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TMl);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.HlG) + g.a.a.b.b.a.bM(7, this.TMm) + g.a.a.b.b.a.bM(8, this.SmH);
      paramInt = i;
      if (this.TMn != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TMn);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        den localden = (den)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localden.CqQ = locala.abFh.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localden.TMj = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localden.TMk = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localden.RYY = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localden.TMl = locala.abFh.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localden.HlG = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localden.TMm = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localden.SmH = locala.abFh.AK();
          AppMethodBeat.o(32360);
          return 0;
        }
        localden.TMn = locala.abFh.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.den
 * JD-Core Version:    0.7.0.1
 */