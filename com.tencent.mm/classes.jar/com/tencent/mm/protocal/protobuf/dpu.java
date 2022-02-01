package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpu
  extends com.tencent.mm.bx.a
{
  public b EFJ;
  public b EFK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFJ != null) {
        paramVarArgs.c(1, this.EFJ);
      }
      if (this.EFK != null) {
        paramVarArgs.c(2, this.EFK);
      }
      AppMethodBeat.o(91732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFJ == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.b(1, this.EFJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EFK != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EFK);
      }
      AppMethodBeat.o(91732);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91732);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpu localdpu = (dpu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91732);
          return -1;
        case 1: 
          localdpu.EFJ = locala.KhF.fMu();
          AppMethodBeat.o(91732);
          return 0;
        }
        localdpu.EFK = locala.KhF.fMu();
        AppMethodBeat.o(91732);
        return 0;
      }
      AppMethodBeat.o(91732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpu
 * JD-Core Version:    0.7.0.1
 */