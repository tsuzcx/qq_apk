package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ww
  extends com.tencent.mm.bx.a
{
  public String ZeC;
  public String ZeD;
  public int ZeE;
  public int ZeF;
  public int ZeG;
  public int ZeH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZeC != null) {
        paramVarArgs.g(1, this.ZeC);
      }
      if (this.ZeD != null) {
        paramVarArgs.g(2, this.ZeD);
      }
      paramVarArgs.bS(3, this.ZeE);
      paramVarArgs.bS(4, this.ZeF);
      paramVarArgs.bS(5, this.ZeG);
      paramVarArgs.bS(6, this.ZeH);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZeC == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZeC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZeD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZeD);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZeE);
      int j = i.a.a.b.b.a.cJ(4, this.ZeF);
      int k = i.a.a.b.b.a.cJ(5, this.ZeG);
      int m = i.a.a.b.b.a.cJ(6, this.ZeH);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ww localww = (ww)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localww.ZeC = locala.ajGk.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localww.ZeD = locala.ajGk.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localww.ZeE = locala.ajGk.aar();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localww.ZeF = locala.ajGk.aar();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localww.ZeG = locala.ajGk.aar();
          AppMethodBeat.o(123560);
          return 0;
        }
        localww.ZeH = locala.ajGk.aar();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ww
 * JD-Core Version:    0.7.0.1
 */