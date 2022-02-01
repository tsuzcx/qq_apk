package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dqj
  extends com.tencent.mm.bx.a
{
  public String ZhO;
  public String ZhP;
  public int aaWH;
  public int aaWI;
  public b aaWJ;
  public String aaWK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaWH);
      paramVarArgs.bS(2, this.aaWI);
      if (this.aaWJ != null) {
        paramVarArgs.d(3, this.aaWJ);
      }
      if (this.aaWK != null) {
        paramVarArgs.g(4, this.aaWK);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(5, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(6, this.ZhP);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaWH) + 0 + i.a.a.b.b.a.cJ(2, this.aaWI);
      paramInt = i;
      if (this.aaWJ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aaWJ);
      }
      i = paramInt;
      if (this.aaWK != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaWK);
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZhP);
      }
      AppMethodBeat.o(32353);
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
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dqj localdqj = (dqj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localdqj.aaWH = locala.ajGk.aar();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localdqj.aaWI = locala.ajGk.aar();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localdqj.aaWJ = locala.ajGk.kFX();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localdqj.aaWK = locala.ajGk.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localdqj.ZhO = locala.ajGk.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localdqj.ZhP = locala.ajGk.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqj
 * JD-Core Version:    0.7.0.1
 */