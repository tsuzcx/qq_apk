package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class evd
  extends com.tencent.mm.cd.a
{
  public int UwT;
  public int UwU;
  public String UwV;
  public b UwW;
  public int UwX;
  public int UwY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UwT);
      paramVarArgs.aY(2, this.UwU);
      if (this.UwV != null) {
        paramVarArgs.f(3, this.UwV);
      }
      if (this.UwW != null) {
        paramVarArgs.c(4, this.UwW);
      }
      paramVarArgs.aY(5, this.UwX);
      paramVarArgs.aY(6, this.UwY);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UwT) + 0 + g.a.a.b.b.a.bM(2, this.UwU);
      paramInt = i;
      if (this.UwV != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UwV);
      }
      i = paramInt;
      if (this.UwW != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.UwW);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.UwX);
      int j = g.a.a.b.b.a.bM(6, this.UwY);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      evd localevd = (evd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localevd.UwT = locala.abFh.AK();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localevd.UwU = locala.abFh.AK();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localevd.UwV = locala.abFh.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localevd.UwW = locala.abFh.iUw();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localevd.UwX = locala.abFh.AK();
        AppMethodBeat.o(82481);
        return 0;
      }
      localevd.UwY = locala.abFh.AK();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evd
 * JD-Core Version:    0.7.0.1
 */