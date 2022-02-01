package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class qf
  extends com.tencent.mm.cd.a
{
  public b RYA;
  public b RYB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYA != null) {
        paramVarArgs.c(1, this.RYA);
      }
      if (this.RYB != null) {
        paramVarArgs.c(2, this.RYB);
      }
      AppMethodBeat.o(205521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.RYA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYB != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RYB);
      }
      AppMethodBeat.o(205521);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205521);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qf localqf = (qf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205521);
          return -1;
        case 1: 
          localqf.RYA = locala.abFh.iUw();
          AppMethodBeat.o(205521);
          return 0;
        }
        localqf.RYB = locala.abFh.iUw();
        AppMethodBeat.o(205521);
        return 0;
      }
      AppMethodBeat.o(205521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */