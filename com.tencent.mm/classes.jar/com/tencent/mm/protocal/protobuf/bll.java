package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bll
  extends com.tencent.mm.cd.a
{
  public int SWy;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.percent);
      paramVarArgs.aY(3, this.SWy);
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.type);
      int i = g.a.a.b.b.a.bM(2, this.percent);
      int j = g.a.a.b.b.a.bM(3, this.SWy);
      AppMethodBeat.o(184213);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bll localbll = (bll)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184213);
        return -1;
      case 1: 
        localbll.type = locala.abFh.AK();
        AppMethodBeat.o(184213);
        return 0;
      case 2: 
        localbll.percent = locala.abFh.AK();
        AppMethodBeat.o(184213);
        return 0;
      }
      localbll.SWy = locala.abFh.AK();
      AppMethodBeat.o(184213);
      return 0;
    }
    AppMethodBeat.o(184213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bll
 * JD-Core Version:    0.7.0.1
 */