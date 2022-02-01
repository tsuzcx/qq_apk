package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cor
  extends com.tencent.mm.bx.a
{
  public int aavG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259512);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).bS(1, this.aavG);
      AppMethodBeat.o(259512);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aavG);
      AppMethodBeat.o(259512);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259512);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cor localcor = (cor)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259512);
        return -1;
      }
      localcor.aavG = locala.ajGk.aar();
      AppMethodBeat.o(259512);
      return 0;
    }
    AppMethodBeat.o(259512);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cor
 * JD-Core Version:    0.7.0.1
 */