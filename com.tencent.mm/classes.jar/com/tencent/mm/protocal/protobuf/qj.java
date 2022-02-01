package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class qj
  extends com.tencent.mm.bw.a
{
  public b KXl;
  public b KXm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212266);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXl != null) {
        paramVarArgs.c(1, this.KXl);
      }
      if (this.KXm != null) {
        paramVarArgs.c(2, this.KXm);
      }
      AppMethodBeat.o(212266);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.b(1, this.KXl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXm != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KXm);
      }
      AppMethodBeat.o(212266);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212266);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qj localqj = (qj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212266);
          return -1;
        case 1: 
          localqj.KXl = locala.UbS.hPo();
          AppMethodBeat.o(212266);
          return 0;
        }
        localqj.KXm = locala.UbS.hPo();
        AppMethodBeat.o(212266);
        return 0;
      }
      AppMethodBeat.o(212266);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qj
 * JD-Core Version:    0.7.0.1
 */