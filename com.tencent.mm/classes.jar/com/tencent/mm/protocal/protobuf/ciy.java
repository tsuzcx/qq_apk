package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ciy
  extends com.tencent.mm.bw.a
{
  public String KDS;
  public String MnL;
  public String MnR;
  public String nickname;
  public String qFV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MnR != null) {
        paramVarArgs.e(1, this.MnR);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.qFV != null) {
        paramVarArgs.e(3, this.qFV);
      }
      if (this.MnL != null) {
        paramVarArgs.e(4, this.MnL);
      }
      if (this.KDS != null) {
        paramVarArgs.e(5, this.KDS);
      }
      AppMethodBeat.o(207503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MnR == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.MnR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.qFV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qFV);
      }
      paramInt = i;
      if (this.MnL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MnL);
      }
      i = paramInt;
      if (this.KDS != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KDS);
      }
      AppMethodBeat.o(207503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207503);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ciy localciy = (ciy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207503);
          return -1;
        case 1: 
          localciy.MnR = locala.UbS.readString();
          AppMethodBeat.o(207503);
          return 0;
        case 2: 
          localciy.nickname = locala.UbS.readString();
          AppMethodBeat.o(207503);
          return 0;
        case 3: 
          localciy.qFV = locala.UbS.readString();
          AppMethodBeat.o(207503);
          return 0;
        case 4: 
          localciy.MnL = locala.UbS.readString();
          AppMethodBeat.o(207503);
          return 0;
        }
        localciy.KDS = locala.UbS.readString();
        AppMethodBeat.o(207503);
        return 0;
      }
      AppMethodBeat.o(207503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciy
 * JD-Core Version:    0.7.0.1
 */