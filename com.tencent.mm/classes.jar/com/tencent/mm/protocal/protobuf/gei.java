package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gei
  extends com.tencent.mm.bx.a
{
  public b acbW;
  public b acbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91732);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbW != null) {
        paramVarArgs.d(1, this.acbW);
      }
      if (this.acbX != null) {
        paramVarArgs.d(2, this.acbX);
      }
      AppMethodBeat.o(91732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbW == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.c(1, this.acbW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acbX != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.acbX);
      }
      AppMethodBeat.o(91732);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91732);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gei localgei = (gei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91732);
          return -1;
        case 1: 
          localgei.acbW = locala.ajGk.kFX();
          AppMethodBeat.o(91732);
          return 0;
        }
        localgei.acbX = locala.ajGk.kFX();
        AppMethodBeat.o(91732);
        return 0;
      }
      AppMethodBeat.o(91732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gei
 * JD-Core Version:    0.7.0.1
 */