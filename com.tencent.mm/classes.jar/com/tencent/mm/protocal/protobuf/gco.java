package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gco
  extends com.tencent.mm.bx.a
{
  public int YDR;
  public long acay;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147802);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.acay);
      paramVarArgs.bS(2, this.YDR);
      AppMethodBeat.o(147802);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.acay);
      int i = i.a.a.b.b.a.cJ(2, this.YDR);
      AppMethodBeat.o(147802);
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
      AppMethodBeat.o(147802);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gco localgco = (gco)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147802);
        return -1;
      case 1: 
        localgco.acay = locala.ajGk.aaw();
        AppMethodBeat.o(147802);
        return 0;
      }
      localgco.YDR = locala.ajGk.aar();
      AppMethodBeat.o(147802);
      return 0;
    }
    AppMethodBeat.o(147802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gco
 * JD-Core Version:    0.7.0.1
 */