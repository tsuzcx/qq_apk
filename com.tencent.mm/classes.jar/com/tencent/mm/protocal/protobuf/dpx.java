package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpx
  extends com.tencent.mm.bx.a
{
  public b EFL;
  public b EFM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91736);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFL != null) {
        paramVarArgs.c(1, this.EFL);
      }
      if (this.EFM != null) {
        paramVarArgs.c(2, this.EFM);
      }
      AppMethodBeat.o(91736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFL == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.EFL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EFM != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EFM);
      }
      AppMethodBeat.o(91736);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91736);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpx localdpx = (dpx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91736);
          return -1;
        case 1: 
          localdpx.EFL = locala.KhF.fMu();
          AppMethodBeat.o(91736);
          return 0;
        }
        localdpx.EFM = locala.KhF.fMu();
        AppMethodBeat.o(91736);
        return 0;
      }
      AppMethodBeat.o(91736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpx
 * JD-Core Version:    0.7.0.1
 */