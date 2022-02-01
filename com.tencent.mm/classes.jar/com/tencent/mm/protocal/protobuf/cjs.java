package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjs
  extends com.tencent.mm.cd.a
{
  public String IiN;
  public String IiO;
  public int IiP;
  public String id;
  public long timestamp;
  public String tol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.IiN != null) {
        paramVarArgs.f(2, this.IiN);
      }
      if (this.IiO != null) {
        paramVarArgs.f(3, this.IiO);
      }
      if (this.tol != null) {
        paramVarArgs.f(4, this.tol);
      }
      paramVarArgs.bm(6, this.timestamp);
      paramVarArgs.aY(5, this.IiP);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.g(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IiN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.IiN);
      }
      i = paramInt;
      if (this.IiO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.IiO);
      }
      paramInt = i;
      if (this.tol != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tol);
      }
      i = g.a.a.b.b.a.p(6, this.timestamp);
      int j = g.a.a.b.b.a.bM(5, this.IiP);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjs localcjs = (cjs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localcjs.id = locala.abFh.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localcjs.IiN = locala.abFh.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localcjs.IiO = locala.abFh.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localcjs.tol = locala.abFh.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localcjs.timestamp = locala.abFh.AN();
          AppMethodBeat.o(72499);
          return 0;
        }
        localcjs.IiP = locala.abFh.AK();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjs
 * JD-Core Version:    0.7.0.1
 */