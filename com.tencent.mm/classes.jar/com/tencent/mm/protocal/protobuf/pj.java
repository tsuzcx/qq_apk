package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pj
  extends com.tencent.mm.bx.a
{
  public int YSQ;
  public String YSR;
  public String YSS;
  public int start_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258377);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.start_time);
      paramVarArgs.bS(2, this.YSQ);
      if (this.YSR != null) {
        paramVarArgs.g(3, this.YSR);
      }
      if (this.YSS != null) {
        paramVarArgs.g(4, this.YSS);
      }
      AppMethodBeat.o(258377);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.start_time) + 0 + i.a.a.b.b.a.cJ(2, this.YSQ);
      paramInt = i;
      if (this.YSR != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YSR);
      }
      i = paramInt;
      if (this.YSS != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YSS);
      }
      AppMethodBeat.o(258377);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258377);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      pj localpj = (pj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258377);
        return -1;
      case 1: 
        localpj.start_time = locala.ajGk.aar();
        AppMethodBeat.o(258377);
        return 0;
      case 2: 
        localpj.YSQ = locala.ajGk.aar();
        AppMethodBeat.o(258377);
        return 0;
      case 3: 
        localpj.YSR = locala.ajGk.readString();
        AppMethodBeat.o(258377);
        return 0;
      }
      localpj.YSS = locala.ajGk.readString();
      AppMethodBeat.o(258377);
      return 0;
    }
    AppMethodBeat.o(258377);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pj
 * JD-Core Version:    0.7.0.1
 */