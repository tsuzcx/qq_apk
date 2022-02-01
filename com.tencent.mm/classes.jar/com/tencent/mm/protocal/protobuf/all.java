package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class all
  extends com.tencent.mm.cd.a
{
  public int SvO;
  public int SvP;
  public int SvQ;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253887);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvO);
      paramVarArgs.aY(2, this.SvP);
      paramVarArgs.aY(3, this.SvQ);
      paramVarArgs.aY(4, this.count);
      AppMethodBeat.o(253887);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SvO);
      int i = g.a.a.b.b.a.bM(2, this.SvP);
      int j = g.a.a.b.b.a.bM(3, this.SvQ);
      int k = g.a.a.b.b.a.bM(4, this.count);
      AppMethodBeat.o(253887);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(253887);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      all localall = (all)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(253887);
        return -1;
      case 1: 
        localall.SvO = locala.abFh.AK();
        AppMethodBeat.o(253887);
        return 0;
      case 2: 
        localall.SvP = locala.abFh.AK();
        AppMethodBeat.o(253887);
        return 0;
      case 3: 
        localall.SvQ = locala.abFh.AK();
        AppMethodBeat.o(253887);
        return 0;
      }
      localall.count = locala.abFh.AK();
      AppMethodBeat.o(253887);
      return 0;
    }
    AppMethodBeat.o(253887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.all
 * JD-Core Version:    0.7.0.1
 */