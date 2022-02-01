package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eea
  extends com.tencent.mm.bx.a
{
  public int abiX;
  public boolean abiY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260059);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abiX);
      paramVarArgs.di(2, this.abiY);
      AppMethodBeat.o(260059);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abiX);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(260059);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260059);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eea localeea = (eea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260059);
        return -1;
      case 1: 
        localeea.abiX = locala.ajGk.aar();
        AppMethodBeat.o(260059);
        return 0;
      }
      localeea.abiY = locala.ajGk.aai();
      AppMethodBeat.o(260059);
      return 0;
    }
    AppMethodBeat.o(260059);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eea
 * JD-Core Version:    0.7.0.1
 */