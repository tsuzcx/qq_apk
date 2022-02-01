package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class afm
  extends com.tencent.mm.bx.a
{
  public b ZoB;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.openid != null) {
        paramVarArgs.g(1, this.openid);
      }
      if (this.ZoB != null) {
        paramVarArgs.d(2, this.ZoB);
      }
      AppMethodBeat.o(259859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.openid == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.openid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZoB != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZoB);
      }
      AppMethodBeat.o(259859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259859);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        afm localafm = (afm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259859);
          return -1;
        case 1: 
          localafm.openid = locala.ajGk.readString();
          AppMethodBeat.o(259859);
          return 0;
        }
        localafm.ZoB = locala.ajGk.kFX();
        AppMethodBeat.o(259859);
        return 0;
      }
      AppMethodBeat.o(259859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afm
 * JD-Core Version:    0.7.0.1
 */