package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cle
  extends com.tencent.mm.cd.a
{
  public int TsM;
  public int dataType;
  public int lZN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210865);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TsM);
      paramVarArgs.aY(2, this.lZN);
      paramVarArgs.aY(3, this.dataType);
      AppMethodBeat.o(210865);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TsM);
      int i = g.a.a.b.b.a.bM(2, this.lZN);
      int j = g.a.a.b.b.a.bM(3, this.dataType);
      AppMethodBeat.o(210865);
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
      AppMethodBeat.o(210865);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cle localcle = (cle)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210865);
        return -1;
      case 1: 
        localcle.TsM = locala.abFh.AK();
        AppMethodBeat.o(210865);
        return 0;
      case 2: 
        localcle.lZN = locala.abFh.AK();
        AppMethodBeat.o(210865);
        return 0;
      }
      localcle.dataType = locala.abFh.AK();
      AppMethodBeat.o(210865);
      return 0;
    }
    AppMethodBeat.o(210865);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cle
 * JD-Core Version:    0.7.0.1
 */