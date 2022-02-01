package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggz
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b YID;
  public int YTh;
  public String abvu;
  public boolean acdm;
  public boolean acdn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.abvu != null) {
        paramVarArgs.g(1, this.abvu);
      }
      paramVarArgs.bS(2, this.YTh);
      if (this.YID != null) {
        paramVarArgs.d(3, this.YID);
      }
      paramVarArgs.di(4, this.acdm);
      paramVarArgs.di(5, this.acdn);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abvu == null) {
        break label461;
      }
    }
    label461:
    for (paramInt = i.a.a.b.b.a.h(1, this.abvu) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YTh);
      paramInt = i;
      if (this.YID != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YID);
      }
      i = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(32564);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abvu == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ggz localggz = (ggz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localggz.abvu = locala.ajGk.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localggz.YTh = locala.ajGk.aar();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localggz.YID = locala.ajGk.kFX();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localggz.acdm = locala.ajGk.aai();
          AppMethodBeat.o(32564);
          return 0;
        }
        localggz.acdn = locala.ajGk.aai();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggz
 * JD-Core Version:    0.7.0.1
 */