package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bet
  extends com.tencent.mm.bx.a
{
  public int ZPc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258599);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).bS(1, this.ZPc);
      AppMethodBeat.o(258599);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZPc);
      AppMethodBeat.o(258599);
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
      AppMethodBeat.o(258599);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bet localbet = (bet)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258599);
        return -1;
      }
      localbet.ZPc = locala.ajGk.aar();
      AppMethodBeat.o(258599);
      return 0;
    }
    AppMethodBeat.o(258599);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bet
 * JD-Core Version:    0.7.0.1
 */