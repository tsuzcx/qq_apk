package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class brm
  extends com.tencent.mm.bx.a
{
  public long ADo;
  public int ZZK;
  public int ZZL;
  public b ZZM;
  public int ZZN;
  public String xUk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257356);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ADo);
      if (this.xUk != null) {
        paramVarArgs.g(2, this.xUk);
      }
      paramVarArgs.bS(3, this.ZZK);
      paramVarArgs.bS(4, this.ZZL);
      if (this.ZZM != null) {
        paramVarArgs.d(5, this.ZZM);
      }
      paramVarArgs.bS(6, this.ZZN);
      AppMethodBeat.o(257356);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ADo) + 0;
      paramInt = i;
      if (this.xUk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xUk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZZK) + i.a.a.b.b.a.cJ(4, this.ZZL);
      paramInt = i;
      if (this.ZZM != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZZM);
      }
      i = i.a.a.b.b.a.cJ(6, this.ZZN);
      AppMethodBeat.o(257356);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257356);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      brm localbrm = (brm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257356);
        return -1;
      case 1: 
        localbrm.ADo = locala.ajGk.aaw();
        AppMethodBeat.o(257356);
        return 0;
      case 2: 
        localbrm.xUk = locala.ajGk.readString();
        AppMethodBeat.o(257356);
        return 0;
      case 3: 
        localbrm.ZZK = locala.ajGk.aar();
        AppMethodBeat.o(257356);
        return 0;
      case 4: 
        localbrm.ZZL = locala.ajGk.aar();
        AppMethodBeat.o(257356);
        return 0;
      case 5: 
        localbrm.ZZM = locala.ajGk.kFX();
        AppMethodBeat.o(257356);
        return 0;
      }
      localbrm.ZZN = locala.ajGk.aar();
      AppMethodBeat.o(257356);
      return 0;
    }
    AppMethodBeat.o(257356);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brm
 * JD-Core Version:    0.7.0.1
 */