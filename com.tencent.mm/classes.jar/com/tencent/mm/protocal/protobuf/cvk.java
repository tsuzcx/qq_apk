package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cvk
  extends com.tencent.mm.bv.a
{
  public b ydO;
  public b ydP;
  public b ydQ;
  public b ydR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56997);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydO != null) {
        paramVarArgs.c(1, this.ydO);
      }
      if (this.ydP != null) {
        paramVarArgs.c(2, this.ydP);
      }
      if (this.ydQ != null) {
        paramVarArgs.c(3, this.ydQ);
      }
      if (this.ydR != null) {
        paramVarArgs.c(4, this.ydR);
      }
      AppMethodBeat.o(56997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydO == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.b(1, this.ydO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ydP != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.ydP);
      }
      i = paramInt;
      if (this.ydQ != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.ydQ);
      }
      paramInt = i;
      if (this.ydR != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.ydR);
      }
      AppMethodBeat.o(56997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56997);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cvk localcvk = (cvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56997);
          return -1;
        case 1: 
          localcvk.ydO = locala.CLY.eqS();
          AppMethodBeat.o(56997);
          return 0;
        case 2: 
          localcvk.ydP = locala.CLY.eqS();
          AppMethodBeat.o(56997);
          return 0;
        case 3: 
          localcvk.ydQ = locala.CLY.eqS();
          AppMethodBeat.o(56997);
          return 0;
        }
        localcvk.ydR = locala.CLY.eqS();
        AppMethodBeat.o(56997);
        return 0;
      }
      AppMethodBeat.o(56997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvk
 * JD-Core Version:    0.7.0.1
 */