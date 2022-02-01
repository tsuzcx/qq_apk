package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nk
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String YPo;
  public String pSi;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.YPo != null) {
        paramVarArgs.g(3, this.YPo);
      }
      if (this.pSi != null) {
        paramVarArgs.g(4, this.pSi);
      }
      AppMethodBeat.o(258959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.YPo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YPo);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSi);
      }
      AppMethodBeat.o(258959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258959);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        nk localnk = (nk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258959);
          return -1;
        case 1: 
          localnk.UserName = locala.ajGk.readString();
          AppMethodBeat.o(258959);
          return 0;
        case 2: 
          localnk.vhX = locala.ajGk.readString();
          AppMethodBeat.o(258959);
          return 0;
        case 3: 
          localnk.YPo = locala.ajGk.readString();
          AppMethodBeat.o(258959);
          return 0;
        }
        localnk.pSi = locala.ajGk.readString();
        AppMethodBeat.o(258959);
        return 0;
      }
      AppMethodBeat.o(258959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nk
 * JD-Core Version:    0.7.0.1
 */