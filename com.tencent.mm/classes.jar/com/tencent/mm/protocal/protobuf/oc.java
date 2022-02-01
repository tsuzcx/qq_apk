package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oc
  extends com.tencent.mm.cd.a
{
  public String RKL;
  public String RVp;
  public int RVq;
  public String title;
  public int tmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RKL != null) {
        paramVarArgs.f(1, this.RKL);
      }
      if (this.RVp != null) {
        paramVarArgs.f(2, this.RVp);
      }
      paramVarArgs.aY(3, this.tmL);
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      paramVarArgs.aY(5, this.RVq);
      AppMethodBeat.o(207257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RKL == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.RKL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RVp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RVp);
      }
      i += g.a.a.b.b.a.bM(3, this.tmL);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.title);
      }
      i = g.a.a.b.b.a.bM(5, this.RVq);
      AppMethodBeat.o(207257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207257);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        oc localoc = (oc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207257);
          return -1;
        case 1: 
          localoc.RKL = locala.abFh.readString();
          AppMethodBeat.o(207257);
          return 0;
        case 2: 
          localoc.RVp = locala.abFh.readString();
          AppMethodBeat.o(207257);
          return 0;
        case 3: 
          localoc.tmL = locala.abFh.AK();
          AppMethodBeat.o(207257);
          return 0;
        case 4: 
          localoc.title = locala.abFh.readString();
          AppMethodBeat.o(207257);
          return 0;
        }
        localoc.RVq = locala.abFh.AK();
        AppMethodBeat.o(207257);
        return 0;
      }
      AppMethodBeat.o(207257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oc
 * JD-Core Version:    0.7.0.1
 */