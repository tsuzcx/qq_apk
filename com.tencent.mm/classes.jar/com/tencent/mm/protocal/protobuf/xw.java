package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xw
  extends com.tencent.mm.bx.a
{
  public String ZgL;
  public String announcement;
  public int end_time;
  public String iaI;
  public int update_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI != null) {
        paramVarArgs.g(1, this.iaI);
      }
      if (this.announcement != null) {
        paramVarArgs.g(2, this.announcement);
      }
      paramVarArgs.bS(3, this.end_time);
      paramVarArgs.bS(4, this.update_time);
      if (this.ZgL != null) {
        paramVarArgs.g(5, this.ZgL);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iaI == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.iaI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.announcement != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.announcement);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.end_time) + i.a.a.b.b.a.cJ(4, this.update_time);
      paramInt = i;
      if (this.ZgL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZgL);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        xw localxw = (xw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localxw.iaI = locala.ajGk.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localxw.announcement = locala.ajGk.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localxw.end_time = locala.ajGk.aar();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localxw.update_time = locala.ajGk.aar();
          AppMethodBeat.o(113981);
          return 0;
        }
        localxw.ZgL = locala.ajGk.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xw
 * JD-Core Version:    0.7.0.1
 */