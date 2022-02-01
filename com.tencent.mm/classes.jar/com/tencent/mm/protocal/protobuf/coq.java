package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class coq
  extends com.tencent.mm.cd.a
{
  public int SsM;
  public int TwA;
  public int TwB;
  public int Twy;
  public b Twz;
  public int rVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Twy);
      if (this.Twz != null) {
        paramVarArgs.c(2, this.Twz);
      }
      paramVarArgs.aY(3, this.TwA);
      paramVarArgs.aY(4, this.SsM);
      paramVarArgs.aY(5, this.rVx);
      paramVarArgs.aY(6, this.TwB);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Twy) + 0;
      paramInt = i;
      if (this.Twz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Twz);
      }
      i = g.a.a.b.b.a.bM(3, this.TwA);
      int j = g.a.a.b.b.a.bM(4, this.SsM);
      int k = g.a.a.b.b.a.bM(5, this.rVx);
      int m = g.a.a.b.b.a.bM(6, this.TwB);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      coq localcoq = (coq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localcoq.Twy = locala.abFh.AK();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localcoq.Twz = locala.abFh.iUw();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localcoq.TwA = locala.abFh.AK();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localcoq.SsM = locala.abFh.AK();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localcoq.rVx = locala.abFh.AK();
        AppMethodBeat.o(143982);
        return 0;
      }
      localcoq.TwB = locala.abFh.AK();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coq
 * JD-Core Version:    0.7.0.1
 */