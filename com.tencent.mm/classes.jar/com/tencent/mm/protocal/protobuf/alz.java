package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class alz
  extends com.tencent.mm.bx.a
{
  public int ZsX;
  public int ZsY;
  public String zzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257796);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zzS == null)
      {
        paramVarArgs = new b("Not all required fields were included: configID");
        AppMethodBeat.o(257796);
        throw paramVarArgs;
      }
      if (this.zzS != null) {
        paramVarArgs.g(1, this.zzS);
      }
      paramVarArgs.bS(2, this.ZsX);
      paramVarArgs.bS(3, this.ZsY);
      AppMethodBeat.o(257796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zzS == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = i.a.a.b.b.a.h(1, this.zzS) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZsX);
      int j = i.a.a.b.b.a.cJ(3, this.ZsY);
      AppMethodBeat.o(257796);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.zzS == null)
        {
          paramVarArgs = new b("Not all required fields were included: configID");
          AppMethodBeat.o(257796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257796);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        alz localalz = (alz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257796);
          return -1;
        case 1: 
          localalz.zzS = locala.ajGk.readString();
          AppMethodBeat.o(257796);
          return 0;
        case 2: 
          localalz.ZsX = locala.ajGk.aar();
          AppMethodBeat.o(257796);
          return 0;
        }
        localalz.ZsY = locala.ajGk.aar();
        AppMethodBeat.o(257796);
        return 0;
      }
      AppMethodBeat.o(257796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */