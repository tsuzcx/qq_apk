package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drb
  extends com.tencent.mm.bx.a
{
  public int aaXb;
  public int aaXc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143984);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaXb);
      paramVarArgs.bS(2, this.aaXc);
      AppMethodBeat.o(143984);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaXb);
      int i = i.a.a.b.b.a.cJ(2, this.aaXc);
      AppMethodBeat.o(143984);
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
      AppMethodBeat.o(143984);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      drb localdrb = (drb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143984);
        return -1;
      case 1: 
        localdrb.aaXb = locala.ajGk.aar();
        AppMethodBeat.o(143984);
        return 0;
      }
      localdrb.aaXc = locala.ajGk.aar();
      AppMethodBeat.o(143984);
      return 0;
    }
    AppMethodBeat.o(143984);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drb
 * JD-Core Version:    0.7.0.1
 */