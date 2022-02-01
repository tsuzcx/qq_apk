package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bfo
  extends com.tencent.mm.bx.a
{
  public b CEi;
  public b CEk;
  public b DCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CEk != null) {
        paramVarArgs.c(1, this.CEk);
      }
      if (this.CEi != null) {
        paramVarArgs.c(2, this.CEi);
      }
      if (this.DCW != null) {
        paramVarArgs.c(3, this.DCW);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CEk == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.b(1, this.CEk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CEi != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CEi);
      }
      i = paramInt;
      if (this.DCW != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.DCW);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfo localbfo = (bfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localbfo.CEk = locala.KhF.fMu();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localbfo.CEi = locala.KhF.fMu();
          AppMethodBeat.o(32321);
          return 0;
        }
        localbfo.DCW = locala.KhF.fMu();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfo
 * JD-Core Version:    0.7.0.1
 */