package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.cd.a
{
  public int RJd;
  public int RJe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207211);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RJd);
      paramVarArgs.aY(2, this.RJe);
      AppMethodBeat.o(207211);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RJd);
      int i = g.a.a.b.b.a.bM(2, this.RJe);
      AppMethodBeat.o(207211);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207211);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dr localdr = (dr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207211);
        return -1;
      case 1: 
        localdr.RJd = locala.abFh.AK();
        AppMethodBeat.o(207211);
        return 0;
      }
      localdr.RJe = locala.abFh.AK();
      AppMethodBeat.o(207211);
      return 0;
    }
    AppMethodBeat.o(207211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */