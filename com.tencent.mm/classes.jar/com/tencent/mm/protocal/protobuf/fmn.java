package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmn
  extends com.tencent.mm.cd.a
{
  public int ULj;
  public int ULk;
  public int ULl;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.version);
      paramVarArgs.aY(2, this.ULj);
      paramVarArgs.aY(3, this.ULk);
      paramVarArgs.aY(4, this.ULl);
      AppMethodBeat.o(250417);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.version);
      int i = g.a.a.b.b.a.bM(2, this.ULj);
      int j = g.a.a.b.b.a.bM(3, this.ULk);
      int k = g.a.a.b.b.a.bM(4, this.ULl);
      AppMethodBeat.o(250417);
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
      AppMethodBeat.o(250417);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fmn localfmn = (fmn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(250417);
        return -1;
      case 1: 
        localfmn.version = locala.abFh.AK();
        AppMethodBeat.o(250417);
        return 0;
      case 2: 
        localfmn.ULj = locala.abFh.AK();
        AppMethodBeat.o(250417);
        return 0;
      case 3: 
        localfmn.ULk = locala.abFh.AK();
        AppMethodBeat.o(250417);
        return 0;
      }
      localfmn.ULl = locala.abFh.AK();
      AppMethodBeat.o(250417);
      return 0;
    }
    AppMethodBeat.o(250417);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmn
 * JD-Core Version:    0.7.0.1
 */