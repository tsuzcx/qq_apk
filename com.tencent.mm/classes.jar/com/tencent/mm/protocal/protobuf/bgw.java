package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgw
  extends com.tencent.mm.bx.a
{
  public int YFb;
  public String ZQn;
  public boolean ZQo;
  public String ZQp;
  public boolean ZQq;
  public int ZQr;
  public int ZQs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258042);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZQn != null) {
        paramVarArgs.g(1, this.ZQn);
      }
      paramVarArgs.di(2, this.ZQo);
      paramVarArgs.bS(3, this.YFb);
      if (this.ZQp != null) {
        paramVarArgs.g(4, this.ZQp);
      }
      paramVarArgs.di(5, this.ZQq);
      paramVarArgs.bS(6, this.ZQr);
      paramVarArgs.bS(7, this.ZQs);
      AppMethodBeat.o(258042);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZQn == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZQn) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.YFb);
      paramInt = i;
      if (this.ZQp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZQp);
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.cJ(6, this.ZQr);
      int k = i.a.a.b.b.a.cJ(7, this.ZQs);
      AppMethodBeat.o(258042);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258042);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bgw localbgw = (bgw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258042);
          return -1;
        case 1: 
          localbgw.ZQn = locala.ajGk.readString();
          AppMethodBeat.o(258042);
          return 0;
        case 2: 
          localbgw.ZQo = locala.ajGk.aai();
          AppMethodBeat.o(258042);
          return 0;
        case 3: 
          localbgw.YFb = locala.ajGk.aar();
          AppMethodBeat.o(258042);
          return 0;
        case 4: 
          localbgw.ZQp = locala.ajGk.readString();
          AppMethodBeat.o(258042);
          return 0;
        case 5: 
          localbgw.ZQq = locala.ajGk.aai();
          AppMethodBeat.o(258042);
          return 0;
        case 6: 
          localbgw.ZQr = locala.ajGk.aar();
          AppMethodBeat.o(258042);
          return 0;
        }
        localbgw.ZQs = locala.ajGk.aar();
        AppMethodBeat.o(258042);
        return 0;
      }
      AppMethodBeat.o(258042);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgw
 * JD-Core Version:    0.7.0.1
 */