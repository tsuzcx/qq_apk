package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bix
  extends com.tencent.mm.bx.a
{
  public b ZSE;
  public int ZSF;
  public String ZSG;
  public int show_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.show_type);
      if (this.ZSE != null) {
        paramVarArgs.d(2, this.ZSE);
      }
      paramVarArgs.bS(3, this.ZSF);
      if (this.ZSG != null) {
        paramVarArgs.g(4, this.ZSG);
      }
      AppMethodBeat.o(260172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.show_type) + 0;
      paramInt = i;
      if (this.ZSE != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZSE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZSF);
      paramInt = i;
      if (this.ZSG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZSG);
      }
      AppMethodBeat.o(260172);
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
      AppMethodBeat.o(260172);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bix localbix = (bix)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260172);
        return -1;
      case 1: 
        localbix.show_type = locala.ajGk.aar();
        AppMethodBeat.o(260172);
        return 0;
      case 2: 
        localbix.ZSE = locala.ajGk.kFX();
        AppMethodBeat.o(260172);
        return 0;
      case 3: 
        localbix.ZSF = locala.ajGk.aar();
        AppMethodBeat.o(260172);
        return 0;
      }
      localbix.ZSG = locala.ajGk.readString();
      AppMethodBeat.o(260172);
      return 0;
    }
    AppMethodBeat.o(260172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bix
 * JD-Core Version:    0.7.0.1
 */