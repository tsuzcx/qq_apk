package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bog
  extends com.tencent.mm.bx.a
{
  public boolean ZWA;
  public String ZWB;
  public boolean ZWC;
  public boolean ZWD;
  public int Zrg;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258369);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.di(2, this.ZWA);
      if (this.ZWB != null) {
        paramVarArgs.g(3, this.ZWB);
      }
      paramVarArgs.di(4, this.ZWC);
      paramVarArgs.di(5, this.ZWD);
      paramVarArgs.bS(6, this.Zrg);
      AppMethodBeat.o(258369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.ZWB != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZWB);
      }
      i = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.ko(5);
      int k = i.a.a.b.b.a.cJ(6, this.Zrg);
      AppMethodBeat.o(258369);
      return paramInt + (i + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258369);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bog localbog = (bog)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258369);
          return -1;
        case 1: 
          localbog.appid = locala.ajGk.readString();
          AppMethodBeat.o(258369);
          return 0;
        case 2: 
          localbog.ZWA = locala.ajGk.aai();
          AppMethodBeat.o(258369);
          return 0;
        case 3: 
          localbog.ZWB = locala.ajGk.readString();
          AppMethodBeat.o(258369);
          return 0;
        case 4: 
          localbog.ZWC = locala.ajGk.aai();
          AppMethodBeat.o(258369);
          return 0;
        case 5: 
          localbog.ZWD = locala.ajGk.aai();
          AppMethodBeat.o(258369);
          return 0;
        }
        localbog.Zrg = locala.ajGk.aar();
        AppMethodBeat.o(258369);
        return 0;
      }
      AppMethodBeat.o(258369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */