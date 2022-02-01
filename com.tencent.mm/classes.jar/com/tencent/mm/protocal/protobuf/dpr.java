package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dpr
  extends com.tencent.mm.bx.a
{
  public b EFA;
  public b EFB;
  public b EFC;
  public b EFD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFA != null) {
        paramVarArgs.c(1, this.EFA);
      }
      if (this.EFB != null) {
        paramVarArgs.c(2, this.EFB);
      }
      if (this.EFC != null) {
        paramVarArgs.c(3, this.EFC);
      }
      if (this.EFD != null) {
        paramVarArgs.c(4, this.EFD);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFA == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.b(1, this.EFA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EFB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EFB);
      }
      i = paramInt;
      if (this.EFC != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EFC);
      }
      paramInt = i;
      if (this.EFD != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EFD);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpr localdpr = (dpr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localdpr.EFA = locala.KhF.fMu();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localdpr.EFB = locala.KhF.fMu();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localdpr.EFC = locala.KhF.fMu();
          AppMethodBeat.o(91729);
          return 0;
        }
        localdpr.EFD = locala.KhF.fMu();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpr
 * JD-Core Version:    0.7.0.1
 */