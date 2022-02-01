package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eru
  extends com.tencent.mm.cd.a
{
  public String RKL;
  public String RVp;
  public int RVq;
  public String llI;
  public String title;
  public int tmL;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RKL != null) {
        paramVarArgs.f(1, this.RKL);
      }
      if (this.llI != null) {
        paramVarArgs.f(2, this.llI);
      }
      paramVarArgs.aY(3, this.weight);
      if (this.RVp != null) {
        paramVarArgs.f(4, this.RVp);
      }
      paramVarArgs.aY(5, this.tmL);
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      paramVarArgs.aY(7, this.RVq);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RKL == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = g.a.a.b.b.a.g(1, this.RKL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.llI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.llI);
      }
      i += g.a.a.b.b.a.bM(3, this.weight);
      paramInt = i;
      if (this.RVp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RVp);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.tmL);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.title);
      }
      i = g.a.a.b.b.a.bM(7, this.RVq);
      AppMethodBeat.o(124569);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eru localeru = (eru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localeru.RKL = locala.abFh.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localeru.llI = locala.abFh.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 3: 
          localeru.weight = locala.abFh.AK();
          AppMethodBeat.o(124569);
          return 0;
        case 4: 
          localeru.RVp = locala.abFh.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 5: 
          localeru.tmL = locala.abFh.AK();
          AppMethodBeat.o(124569);
          return 0;
        case 6: 
          localeru.title = locala.abFh.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localeru.RVq = locala.abFh.AK();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eru
 * JD-Core Version:    0.7.0.1
 */