package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mg
  extends com.tencent.mm.cd.a
{
  public int RRS;
  public String RRT;
  public int RRU;
  public int RRV;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      paramVarArgs.aY(2, this.RRS);
      if (this.RRT != null) {
        paramVarArgs.f(3, this.RRT);
      }
      paramVarArgs.aY(4, this.RRU);
      paramVarArgs.aY(5, this.RRV);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RRS);
      paramInt = i;
      if (this.RRT != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RRT);
      }
      i = g.a.a.b.b.a.bM(4, this.RRU);
      int j = g.a.a.b.b.a.bM(5, this.RRV);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mg localmg = (mg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          localmg.UserName = locala.abFh.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          localmg.RRS = locala.abFh.AK();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          localmg.RRT = locala.abFh.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          localmg.RRU = locala.abFh.AK();
          AppMethodBeat.o(124393);
          return 0;
        }
        localmg.RRV = locala.abFh.AK();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mg
 * JD-Core Version:    0.7.0.1
 */