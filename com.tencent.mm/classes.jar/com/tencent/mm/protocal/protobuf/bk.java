package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bk
  extends com.tencent.mm.bx.a
{
  public boolean YCO;
  public boolean YCP;
  public int YCQ;
  public boolean YCR;
  public b YCS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.YCO);
      paramVarArgs.di(2, this.YCP);
      paramVarArgs.bS(3, this.YCQ);
      paramVarArgs.di(4, this.YCR);
      if (this.YCS != null) {
        paramVarArgs.d(5, this.YCS);
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.YCQ) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.YCS != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YCS);
      }
      AppMethodBeat.o(123537);
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
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bk localbk = (bk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbk.YCO = locala.ajGk.aai();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbk.YCP = locala.ajGk.aai();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbk.YCQ = locala.ajGk.aar();
        AppMethodBeat.o(123537);
        return 0;
      case 4: 
        localbk.YCR = locala.ajGk.aai();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbk.YCS = locala.ajGk.kFX();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */