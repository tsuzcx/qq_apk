package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bis
  extends com.tencent.mm.cd.a
{
  public String STa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205209);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.STa != null) {
        paramVarArgs.f(1, this.STa);
      }
      AppMethodBeat.o(205209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.STa == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.g(1, this.STa) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(205209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205209);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bis localbis = (bis)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205209);
          return -1;
        }
        localbis.STa = locala.abFh.readString();
        AppMethodBeat.o(205209);
        return 0;
      }
      AppMethodBeat.o(205209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bis
 * JD-Core Version:    0.7.0.1
 */