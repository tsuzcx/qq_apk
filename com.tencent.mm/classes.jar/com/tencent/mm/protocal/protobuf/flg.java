package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flg
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YFu;
  public String YPo;
  public String abLH;
  public String pSi;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      paramVarArgs.bS(3, this.YFu);
      if (this.abLH != null) {
        paramVarArgs.g(4, this.abLH);
      }
      if (this.pSi != null) {
        paramVarArgs.g(5, this.pSi);
      }
      if (this.YPo != null) {
        paramVarArgs.g(6, this.YPo);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.vhX);
      }
      i += i.a.a.b.b.a.cJ(3, this.YFu);
      paramInt = i;
      if (this.abLH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abLH);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSi);
      }
      paramInt = i;
      if (this.YPo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YPo);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        flg localflg = (flg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localflg.UserName = locala.ajGk.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localflg.vhX = locala.ajGk.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localflg.YFu = locala.ajGk.aar();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localflg.abLH = locala.ajGk.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localflg.pSi = locala.ajGk.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localflg.YPo = locala.ajGk.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flg
 * JD-Core Version:    0.7.0.1
 */