package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class eho
  extends com.tencent.mm.bx.a
{
  public b JaK;
  public int ZNM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258969);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZNM);
      if (this.JaK != null) {
        paramVarArgs.d(2, this.JaK);
      }
      AppMethodBeat.o(258969);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZNM) + 0;
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.JaK);
      }
      AppMethodBeat.o(258969);
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
      AppMethodBeat.o(258969);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eho localeho = (eho)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258969);
        return -1;
      case 1: 
        localeho.ZNM = locala.ajGk.aar();
        AppMethodBeat.o(258969);
        return 0;
      }
      localeho.JaK = locala.ajGk.kFX();
      AppMethodBeat.o(258969);
      return 0;
    }
    AppMethodBeat.o(258969);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eho
 * JD-Core Version:    0.7.0.1
 */