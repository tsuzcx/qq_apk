package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
  extends com.tencent.mm.cd.a
{
  public String RFn;
  public String RFo;
  public String RFp;
  public int RFq;
  public int tpK;
  public String ugh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200191);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFn != null) {
        paramVarArgs.f(1, this.RFn);
      }
      if (this.RFo != null) {
        paramVarArgs.f(2, this.RFo);
      }
      if (this.RFp != null) {
        paramVarArgs.f(3, this.RFp);
      }
      paramVarArgs.aY(4, this.tpK);
      if (this.ugh != null) {
        paramVarArgs.f(5, this.ugh);
      }
      paramVarArgs.aY(6, this.RFq);
      AppMethodBeat.o(200191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFn == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.g(1, this.RFn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RFo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RFo);
      }
      i = paramInt;
      if (this.RFp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RFp);
      }
      i += g.a.a.b.b.a.bM(4, this.tpK);
      paramInt = i;
      if (this.ugh != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ugh);
      }
      i = g.a.a.b.b.a.bM(6, this.RFq);
      AppMethodBeat.o(200191);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200191);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200191);
          return -1;
        case 1: 
          localax.RFn = locala.abFh.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 2: 
          localax.RFo = locala.abFh.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 3: 
          localax.RFp = locala.abFh.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 4: 
          localax.tpK = locala.abFh.AK();
          AppMethodBeat.o(200191);
          return 0;
        case 5: 
          localax.ugh = locala.abFh.readString();
          AppMethodBeat.o(200191);
          return 0;
        }
        localax.RFq = locala.abFh.AK();
        AppMethodBeat.o(200191);
        return 0;
      }
      AppMethodBeat.o(200191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */