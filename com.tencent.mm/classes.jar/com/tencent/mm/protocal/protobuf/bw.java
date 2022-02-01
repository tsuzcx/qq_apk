package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bw
  extends com.tencent.mm.bx.a
{
  public int YDD;
  public String YDE;
  public int YDF;
  public int YDG;
  public String YDH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YDD);
      if (this.YDE != null) {
        paramVarArgs.g(2, this.YDE);
      }
      paramVarArgs.bS(3, this.YDF);
      paramVarArgs.bS(4, this.YDG);
      if (this.YDH != null) {
        paramVarArgs.g(5, this.YDH);
      }
      AppMethodBeat.o(259425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YDD) + 0;
      paramInt = i;
      if (this.YDE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YDE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.YDF) + i.a.a.b.b.a.cJ(4, this.YDG);
      paramInt = i;
      if (this.YDH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YDH);
      }
      AppMethodBeat.o(259425);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259425);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bw localbw = (bw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259425);
        return -1;
      case 1: 
        localbw.YDD = locala.ajGk.aar();
        AppMethodBeat.o(259425);
        return 0;
      case 2: 
        localbw.YDE = locala.ajGk.readString();
        AppMethodBeat.o(259425);
        return 0;
      case 3: 
        localbw.YDF = locala.ajGk.aar();
        AppMethodBeat.o(259425);
        return 0;
      case 4: 
        localbw.YDG = locala.ajGk.aar();
        AppMethodBeat.o(259425);
        return 0;
      }
      localbw.YDH = locala.ajGk.readString();
      AppMethodBeat.o(259425);
      return 0;
    }
    AppMethodBeat.o(259425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bw
 * JD-Core Version:    0.7.0.1
 */