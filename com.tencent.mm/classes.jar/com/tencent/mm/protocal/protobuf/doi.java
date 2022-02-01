package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doi
  extends com.tencent.mm.bx.a
{
  public String aaVo;
  public String aaVp;
  public boolean aaVq;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258302);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaVo != null) {
        paramVarArgs.g(1, this.aaVo);
      }
      if (this.aaVp != null) {
        paramVarArgs.g(2, this.aaVp);
      }
      paramVarArgs.bS(3, this.vhJ);
      paramVarArgs.di(4, this.aaVq);
      AppMethodBeat.o(258302);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaVo == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaVo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaVp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaVp);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhJ);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(258302);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258302);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        doi localdoi = (doi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258302);
          return -1;
        case 1: 
          localdoi.aaVo = locala.ajGk.readString();
          AppMethodBeat.o(258302);
          return 0;
        case 2: 
          localdoi.aaVp = locala.ajGk.readString();
          AppMethodBeat.o(258302);
          return 0;
        case 3: 
          localdoi.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(258302);
          return 0;
        }
        localdoi.aaVq = locala.ajGk.aai();
        AppMethodBeat.o(258302);
        return 0;
      }
      AppMethodBeat.o(258302);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doi
 * JD-Core Version:    0.7.0.1
 */