package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ol
  extends com.tencent.mm.bx.a
{
  public String YRA;
  public int YRw;
  public int YRx;
  public int YRy;
  public String YRz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YRw);
      paramVarArgs.bS(2, this.YRx);
      paramVarArgs.bS(3, this.YRy);
      if (this.YRz != null) {
        paramVarArgs.g(4, this.YRz);
      }
      if (this.YRA != null) {
        paramVarArgs.g(5, this.YRA);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YRw) + 0 + i.a.a.b.b.a.cJ(2, this.YRx) + i.a.a.b.b.a.cJ(3, this.YRy);
      paramInt = i;
      if (this.YRz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YRz);
      }
      i = paramInt;
      if (this.YRA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YRA);
      }
      AppMethodBeat.o(124410);
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
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ol localol = (ol)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localol.YRw = locala.ajGk.aar();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localol.YRx = locala.ajGk.aar();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localol.YRy = locala.ajGk.aar();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localol.YRz = locala.ajGk.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localol.YRA = locala.ajGk.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */