package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjd
  extends com.tencent.mm.bx.a
{
  public String vFa;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258258);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vFa != null) {
        paramVarArgs.g(1, this.vFa);
      }
      paramVarArgs.bS(2, this.weight);
      AppMethodBeat.o(258258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFa == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.vFa) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.weight);
      AppMethodBeat.o(258258);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258258);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjd localgjd = (gjd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258258);
          return -1;
        case 1: 
          localgjd.vFa = locala.ajGk.readString();
          AppMethodBeat.o(258258);
          return 0;
        }
        localgjd.weight = locala.ajGk.aar();
        AppMethodBeat.o(258258);
        return 0;
      }
      AppMethodBeat.o(258258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjd
 * JD-Core Version:    0.7.0.1
 */