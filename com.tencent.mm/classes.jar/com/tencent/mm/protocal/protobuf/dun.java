package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dun
  extends com.tencent.mm.bx.a
{
  public int abay;
  public int abaz;
  public long lastReportTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259004);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abay);
      paramVarArgs.bv(2, this.lastReportTime);
      paramVarArgs.bS(3, this.abaz);
      AppMethodBeat.o(259004);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abay);
      int i = i.a.a.b.b.a.q(2, this.lastReportTime);
      int j = i.a.a.b.b.a.cJ(3, this.abaz);
      AppMethodBeat.o(259004);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259004);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dun localdun = (dun)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259004);
        return -1;
      case 1: 
        localdun.abay = locala.ajGk.aar();
        AppMethodBeat.o(259004);
        return 0;
      case 2: 
        localdun.lastReportTime = locala.ajGk.aaw();
        AppMethodBeat.o(259004);
        return 0;
      }
      localdun.abaz = locala.ajGk.aar();
      AppMethodBeat.o(259004);
      return 0;
    }
    AppMethodBeat.o(259004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dun
 * JD-Core Version:    0.7.0.1
 */