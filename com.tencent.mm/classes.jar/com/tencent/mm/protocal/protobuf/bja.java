package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bja
  extends com.tencent.mm.bx.a
{
  public String CJJ;
  public int ZSK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZSK);
      if (this.CJJ != null) {
        paramVarArgs.g(2, this.CJJ);
      }
      AppMethodBeat.o(260049);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZSK) + 0;
      paramInt = i;
      if (this.CJJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.CJJ);
      }
      AppMethodBeat.o(260049);
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
      AppMethodBeat.o(260049);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bja localbja = (bja)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260049);
        return -1;
      case 1: 
        localbja.ZSK = locala.ajGk.aar();
        AppMethodBeat.o(260049);
        return 0;
      }
      localbja.CJJ = locala.ajGk.readString();
      AppMethodBeat.o(260049);
      return 0;
    }
    AppMethodBeat.o(260049);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bja
 * JD-Core Version:    0.7.0.1
 */