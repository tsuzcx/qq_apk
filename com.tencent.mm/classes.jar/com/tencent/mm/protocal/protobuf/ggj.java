package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ggj
  extends com.tencent.mm.bx.a
{
  public int abAu;
  public String abvu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32546);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32546);
        throw paramVarArgs;
      }
      if (this.abvu != null) {
        paramVarArgs.g(1, this.abvu);
      }
      paramVarArgs.bS(2, this.abAu);
      AppMethodBeat.o(32546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abvu == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.abvu) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abAu);
      AppMethodBeat.o(32546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abvu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32546);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggj localggj = (ggj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32546);
          return -1;
        case 1: 
          localggj.abvu = locala.ajGk.readString();
          AppMethodBeat.o(32546);
          return 0;
        }
        localggj.abAu = locala.ajGk.aar();
        AppMethodBeat.o(32546);
        return 0;
      }
      AppMethodBeat.o(32546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggj
 * JD-Core Version:    0.7.0.1
 */