package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epm
  extends com.tencent.mm.bx.a
{
  public String AyS;
  public String AyT;
  public int EUp;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259222);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.AyT != null) {
        paramVarArgs.g(2, this.AyT);
      }
      if (this.AyS != null) {
        paramVarArgs.g(3, this.AyS);
      }
      paramVarArgs.bS(4, this.EUp);
      AppMethodBeat.o(259222);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AyT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.AyT);
      }
      i = paramInt;
      if (this.AyS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.AyS);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.EUp);
      AppMethodBeat.o(259222);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259222);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        epm localepm = (epm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259222);
          return -1;
        case 1: 
          localepm.appid = locala.ajGk.readString();
          AppMethodBeat.o(259222);
          return 0;
        case 2: 
          localepm.AyT = locala.ajGk.readString();
          AppMethodBeat.o(259222);
          return 0;
        case 3: 
          localepm.AyS = locala.ajGk.readString();
          AppMethodBeat.o(259222);
          return 0;
        }
        localepm.EUp = locala.ajGk.aar();
        AppMethodBeat.o(259222);
        return 0;
      }
      AppMethodBeat.o(259222);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epm
 * JD-Core Version:    0.7.0.1
 */