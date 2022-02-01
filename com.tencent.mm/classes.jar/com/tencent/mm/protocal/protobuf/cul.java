package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cul
  extends com.tencent.mm.cd.a
{
  public int TCc;
  public int TCd;
  public int TCe;
  public int TCf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TCc);
      paramVarArgs.aY(2, this.TCd);
      paramVarArgs.aY(3, this.TCe);
      paramVarArgs.aY(4, this.TCf);
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TCc);
      int i = g.a.a.b.b.a.bM(2, this.TCd);
      int j = g.a.a.b.b.a.bM(3, this.TCe);
      int k = g.a.a.b.b.a.bM(4, this.TCf);
      AppMethodBeat.o(169923);
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
      AppMethodBeat.o(169923);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cul localcul = (cul)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169923);
        return -1;
      case 1: 
        localcul.TCc = locala.abFh.AK();
        AppMethodBeat.o(169923);
        return 0;
      case 2: 
        localcul.TCd = locala.abFh.AK();
        AppMethodBeat.o(169923);
        return 0;
      case 3: 
        localcul.TCe = locala.abFh.AK();
        AppMethodBeat.o(169923);
        return 0;
      }
      localcul.TCf = locala.abFh.AK();
      AppMethodBeat.o(169923);
      return 0;
    }
    AppMethodBeat.o(169923);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cul
 * JD-Core Version:    0.7.0.1
 */