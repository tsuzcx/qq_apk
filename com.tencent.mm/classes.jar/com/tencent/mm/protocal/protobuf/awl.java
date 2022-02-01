package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awl
  extends com.tencent.mm.cd.a
{
  public String SJe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229584);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SJe != null) {
        paramVarArgs.f(1, this.SJe);
      }
      AppMethodBeat.o(229584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SJe == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.SJe) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(229584);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229584);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        awl localawl = (awl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(229584);
          return -1;
        }
        localawl.SJe = locala.abFh.readString();
        AppMethodBeat.o(229584);
        return 0;
      }
      AppMethodBeat.o(229584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awl
 * JD-Core Version:    0.7.0.1
 */