package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class crn
  extends com.tencent.mm.cd.a
{
  public b TyB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TyB != null) {
        paramVarArgs.c(1, this.TyB);
      }
      AppMethodBeat.o(194155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TyB == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.b(1, this.TyB) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(194155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194155);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crn localcrn = (crn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194155);
          return -1;
        }
        localcrn.TyB = locala.abFh.iUw();
        AppMethodBeat.o(194155);
        return 0;
      }
      AppMethodBeat.o(194155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crn
 * JD-Core Version:    0.7.0.1
 */