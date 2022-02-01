package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ers
  extends com.tencent.mm.cd.a
{
  public long UtM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261444);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).bm(1, this.UtM);
      AppMethodBeat.o(261444);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.UtM);
      AppMethodBeat.o(261444);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(261444);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ers localers = (ers)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(261444);
        return -1;
      }
      localers.UtM = locala.abFh.AN();
      AppMethodBeat.o(261444);
      return 0;
    }
    AppMethodBeat.o(261444);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ers
 * JD-Core Version:    0.7.0.1
 */