package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edv
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public long abiU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257368);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIZ != null) {
        paramVarArgs.g(1, this.YIZ);
      }
      paramVarArgs.bv(2, this.abiU);
      AppMethodBeat.o(257368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIZ == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIZ) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abiU);
      AppMethodBeat.o(257368);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257368);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        edv localedv = (edv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257368);
          return -1;
        case 1: 
          localedv.YIZ = locala.ajGk.readString();
          AppMethodBeat.o(257368);
          return 0;
        }
        localedv.abiU = locala.ajGk.aaw();
        AppMethodBeat.o(257368);
        return 0;
      }
      AppMethodBeat.o(257368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edv
 * JD-Core Version:    0.7.0.1
 */