package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diu
  extends com.tencent.mm.bx.a
{
  public long DVk;
  public int aaNC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260094);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaNC);
      paramVarArgs.bv(2, this.DVk);
      AppMethodBeat.o(260094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaNC);
      int i = i.a.a.b.b.a.q(2, this.DVk);
      AppMethodBeat.o(260094);
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
      AppMethodBeat.o(260094);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      diu localdiu = (diu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260094);
        return -1;
      case 1: 
        localdiu.aaNC = locala.ajGk.aar();
        AppMethodBeat.o(260094);
        return 0;
      }
      localdiu.DVk = locala.ajGk.aaw();
      AppMethodBeat.o(260094);
      return 0;
    }
    AppMethodBeat.o(260094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diu
 * JD-Core Version:    0.7.0.1
 */