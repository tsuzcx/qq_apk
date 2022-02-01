package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akr
  extends com.tencent.mm.bx.a
{
  public int ZrU;
  public int ZrV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43095);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZrU);
      paramVarArgs.bS(2, this.ZrV);
      AppMethodBeat.o(43095);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZrU);
      int i = i.a.a.b.b.a.cJ(2, this.ZrV);
      AppMethodBeat.o(43095);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43095);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      akr localakr = (akr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43095);
        return -1;
      case 1: 
        localakr.ZrU = locala.ajGk.aar();
        AppMethodBeat.o(43095);
        return 0;
      }
      localakr.ZrV = locala.ajGk.aar();
      AppMethodBeat.o(43095);
      return 0;
    }
    AppMethodBeat.o(43095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akr
 * JD-Core Version:    0.7.0.1
 */