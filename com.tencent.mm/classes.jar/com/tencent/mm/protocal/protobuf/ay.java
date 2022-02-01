package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bx.a
{
  public int YBO;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.bS(2, this.YBO);
      AppMethodBeat.o(72415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YBO);
      AppMethodBeat.o(72415);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72415);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72415);
          return -1;
        case 1: 
          localay.title = locala.ajGk.readString();
          AppMethodBeat.o(72415);
          return 0;
        }
        localay.YBO = locala.ajGk.aar();
        AppMethodBeat.o(72415);
        return 0;
      }
      AppMethodBeat.o(72415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */