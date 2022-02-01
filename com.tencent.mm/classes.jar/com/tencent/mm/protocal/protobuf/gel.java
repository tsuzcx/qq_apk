package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gel
  extends com.tencent.mm.bx.a
{
  public b acbY;
  public b acbZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91736);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbY != null) {
        paramVarArgs.d(1, this.acbY);
      }
      if (this.acbZ != null) {
        paramVarArgs.d(2, this.acbZ);
      }
      AppMethodBeat.o(91736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbY == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.c(1, this.acbY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acbZ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.acbZ);
      }
      AppMethodBeat.o(91736);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91736);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gel localgel = (gel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91736);
          return -1;
        case 1: 
          localgel.acbY = locala.ajGk.kFX();
          AppMethodBeat.o(91736);
          return 0;
        }
        localgel.acbZ = locala.ajGk.kFX();
        AppMethodBeat.o(91736);
        return 0;
      }
      AppMethodBeat.o(91736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gel
 * JD-Core Version:    0.7.0.1
 */