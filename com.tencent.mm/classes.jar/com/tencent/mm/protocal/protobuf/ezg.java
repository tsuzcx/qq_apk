package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezg
  extends com.tencent.mm.cd.a
{
  public String Srm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Srm != null) {
        paramVarArgs.f(1, this.Srm);
      }
      AppMethodBeat.o(187827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Srm == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.Srm) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(187827);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(187827);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezg localezg = (ezg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187827);
          return -1;
        }
        localezg.Srm = locala.abFh.readString();
        AppMethodBeat.o(187827);
        return 0;
      }
      AppMethodBeat.o(187827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezg
 * JD-Core Version:    0.7.0.1
 */