package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hc
  extends com.tencent.mm.bx.a
{
  public int YIE;
  public int YIF;
  public int YIG;
  public int YIH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32126);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YIE);
      paramVarArgs.bS(2, this.YIF);
      paramVarArgs.bS(3, this.YIG);
      paramVarArgs.bS(4, this.YIH);
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YIE);
      int i = i.a.a.b.b.a.cJ(2, this.YIF);
      int j = i.a.a.b.b.a.cJ(3, this.YIG);
      int k = i.a.a.b.b.a.cJ(4, this.YIH);
      AppMethodBeat.o(32126);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      hc localhc = (hc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32126);
        return -1;
      case 1: 
        localhc.YIE = locala.ajGk.aar();
        AppMethodBeat.o(32126);
        return 0;
      case 2: 
        localhc.YIF = locala.ajGk.aar();
        AppMethodBeat.o(32126);
        return 0;
      case 3: 
        localhc.YIG = locala.ajGk.aar();
        AppMethodBeat.o(32126);
        return 0;
      }
      localhc.YIH = locala.ajGk.aar();
      AppMethodBeat.o(32126);
      return 0;
    }
    AppMethodBeat.o(32126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */