package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bin
  extends com.tencent.mm.bx.a
{
  public int ZRL;
  public String ZRa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257337);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZRa != null) {
        paramVarArgs.g(1, this.ZRa);
      }
      paramVarArgs.bS(2, this.ZRL);
      AppMethodBeat.o(257337);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZRa == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZRa) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZRL);
      AppMethodBeat.o(257337);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257337);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bin localbin = (bin)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257337);
          return -1;
        case 1: 
          localbin.ZRa = locala.ajGk.readString();
          AppMethodBeat.o(257337);
          return 0;
        }
        localbin.ZRL = locala.ajGk.aar();
        AppMethodBeat.o(257337);
        return 0;
      }
      AppMethodBeat.o(257337);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bin
 * JD-Core Version:    0.7.0.1
 */