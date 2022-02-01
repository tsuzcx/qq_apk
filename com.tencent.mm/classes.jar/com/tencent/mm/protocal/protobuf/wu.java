package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wu
  extends com.tencent.mm.bx.a
{
  public int YFv;
  public String YSF;
  public int ZeA;
  public long Zez;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YSF != null) {
        paramVarArgs.g(1, this.YSF);
      }
      paramVarArgs.bv(2, this.Zez);
      paramVarArgs.bS(3, this.ZeA);
      paramVarArgs.bS(4, this.YFv);
      paramVarArgs.bS(5, this.vhk);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YSF == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = i.a.a.b.b.a.h(1, this.YSF) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.Zez);
      int j = i.a.a.b.b.a.cJ(3, this.ZeA);
      int k = i.a.a.b.b.a.cJ(4, this.YFv);
      int m = i.a.a.b.b.a.cJ(5, this.vhk);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        wu localwu = (wu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localwu.YSF = locala.ajGk.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localwu.Zez = locala.ajGk.aaw();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localwu.ZeA = locala.ajGk.aar();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localwu.YFv = locala.ajGk.aar();
          AppMethodBeat.o(93332);
          return 0;
        }
        localwu.vhk = locala.ajGk.aar();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wu
 * JD-Core Version:    0.7.0.1
 */