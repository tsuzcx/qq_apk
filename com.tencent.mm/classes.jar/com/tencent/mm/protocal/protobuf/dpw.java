package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpw
  extends com.tencent.mm.bx.a
{
  public b EFA;
  public b EFK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91735);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFA != null) {
        paramVarArgs.c(1, this.EFA);
      }
      if (this.EFK != null) {
        paramVarArgs.c(2, this.EFK);
      }
      AppMethodBeat.o(91735);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.EFA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EFK != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EFK);
      }
      AppMethodBeat.o(91735);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91735);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpw localdpw = (dpw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91735);
          return -1;
        case 1: 
          localdpw.EFA = locala.KhF.fMu();
          AppMethodBeat.o(91735);
          return 0;
        }
        localdpw.EFK = locala.KhF.fMu();
        AppMethodBeat.o(91735);
        return 0;
      }
      AppMethodBeat.o(91735);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpw
 * JD-Core Version:    0.7.0.1
 */