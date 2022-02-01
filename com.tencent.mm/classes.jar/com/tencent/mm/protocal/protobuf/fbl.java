package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbl
  extends com.tencent.mm.bx.a
{
  public String MD5;
  public int Nju;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.g(1, this.MD5);
      }
      paramVarArgs.bS(2, this.Nju);
      AppMethodBeat.o(32450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label262;
      }
    }
    label262:
    for (paramInt = i.a.a.b.b.a.h(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Nju);
      AppMethodBeat.o(32450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32450);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fbl localfbl = (fbl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32450);
          return -1;
        case 1: 
          localfbl.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(32450);
          return 0;
        }
        localfbl.Nju = locala.ajGk.aar();
        AppMethodBeat.o(32450);
        return 0;
      }
      AppMethodBeat.o(32450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbl
 * JD-Core Version:    0.7.0.1
 */