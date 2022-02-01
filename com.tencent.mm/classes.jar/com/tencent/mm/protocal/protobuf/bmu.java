package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bmu
  extends com.tencent.mm.bx.a
{
  public b JaK;
  public int item_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.item_type);
      if (this.JaK != null) {
        paramVarArgs.d(2, this.JaK);
      }
      AppMethodBeat.o(258859);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.item_type) + 0;
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.JaK);
      }
      AppMethodBeat.o(258859);
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
      AppMethodBeat.o(258859);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmu localbmu = (bmu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258859);
        return -1;
      case 1: 
        localbmu.item_type = locala.ajGk.aar();
        AppMethodBeat.o(258859);
        return 0;
      }
      localbmu.JaK = locala.ajGk.kFX();
      AppMethodBeat.o(258859);
      return 0;
    }
    AppMethodBeat.o(258859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmu
 * JD-Core Version:    0.7.0.1
 */