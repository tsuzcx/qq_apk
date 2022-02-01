package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aui
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public String YTl;
  public int ZEN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257879);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YTl != null) {
        paramVarArgs.g(1, this.YTl);
      }
      if (this.ADE != null) {
        paramVarArgs.g(2, this.ADE);
      }
      paramVarArgs.bS(3, this.ZEN);
      AppMethodBeat.o(257879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YTl == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.YTl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ADE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ADE);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZEN);
      AppMethodBeat.o(257879);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257879);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257879);
          return -1;
        case 1: 
          localaui.YTl = locala.ajGk.readString();
          AppMethodBeat.o(257879);
          return 0;
        case 2: 
          localaui.ADE = locala.ajGk.readString();
          AppMethodBeat.o(257879);
          return 0;
        }
        localaui.ZEN = locala.ajGk.aar();
        AppMethodBeat.o(257879);
        return 0;
      }
      AppMethodBeat.o(257879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */