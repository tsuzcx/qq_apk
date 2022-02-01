package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diq
  extends com.tencent.mm.bx.a
{
  public int BBE;
  public long CJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.CJK);
      paramVarArgs.bS(2, this.BBE);
      AppMethodBeat.o(260257);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.CJK);
      int i = i.a.a.b.b.a.cJ(2, this.BBE);
      AppMethodBeat.o(260257);
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
      AppMethodBeat.o(260257);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      diq localdiq = (diq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260257);
        return -1;
      case 1: 
        localdiq.CJK = locala.ajGk.aaw();
        AppMethodBeat.o(260257);
        return 0;
      }
      localdiq.BBE = locala.ajGk.aar();
      AppMethodBeat.o(260257);
      return 0;
    }
    AppMethodBeat.o(260257);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diq
 * JD-Core Version:    0.7.0.1
 */