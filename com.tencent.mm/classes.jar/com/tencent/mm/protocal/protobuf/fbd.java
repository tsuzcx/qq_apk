package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbd
  extends com.tencent.mm.cd.a
{
  public String RVH;
  public int SnQ;
  public String TKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SnQ);
      if (this.RVH != null) {
        paramVarArgs.f(2, this.RVH);
      }
      if (this.TKR != null) {
        paramVarArgs.f(3, this.TKR);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SnQ) + 0;
      paramInt = i;
      if (this.RVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RVH);
      }
      i = paramInt;
      if (this.TKR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TKR);
      }
      AppMethodBeat.o(176156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fbd localfbd = (fbd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localfbd.SnQ = locala.abFh.AK();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localfbd.RVH = locala.abFh.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localfbd.TKR = locala.abFh.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbd
 * JD-Core Version:    0.7.0.1
 */