package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpi
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int aaWh;
  public int aaWi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257866);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bS(2, this.aaWh);
      paramVarArgs.bS(3, this.aaWi);
      AppMethodBeat.o(257866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaWh);
      int j = i.a.a.b.b.a.cJ(3, this.aaWi);
      AppMethodBeat.o(257866);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257866);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dpi localdpi = (dpi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257866);
          return -1;
        case 1: 
          localdpi.UserName = locala.ajGk.readString();
          AppMethodBeat.o(257866);
          return 0;
        case 2: 
          localdpi.aaWh = locala.ajGk.aar();
          AppMethodBeat.o(257866);
          return 0;
        }
        localdpi.aaWi = locala.ajGk.aar();
        AppMethodBeat.o(257866);
        return 0;
      }
      AppMethodBeat.o(257866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpi
 * JD-Core Version:    0.7.0.1
 */