package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahi
  extends com.tencent.mm.bx.a
{
  public int key;
  public String onf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91430);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.key);
      if (this.onf != null) {
        paramVarArgs.g(2, this.onf);
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.key) + 0;
      paramInt = i;
      if (this.onf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.onf);
      }
      AppMethodBeat.o(91430);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ahi localahi = (ahi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91430);
        return -1;
      case 1: 
        localahi.key = locala.ajGk.aar();
        AppMethodBeat.o(91430);
        return 0;
      }
      localahi.onf = locala.ajGk.readString();
      AppMethodBeat.o(91430);
      return 0;
    }
    AppMethodBeat.o(91430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahi
 * JD-Core Version:    0.7.0.1
 */