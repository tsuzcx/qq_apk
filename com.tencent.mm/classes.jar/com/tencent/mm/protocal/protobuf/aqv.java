package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqv
  extends com.tencent.mm.bx.a
{
  public String GoS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GoS != null) {
        paramVarArgs.d(1, this.GoS);
      }
      AppMethodBeat.o(209348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GoS == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.GoS) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqv localaqv = (aqv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209348);
          return -1;
        }
        localaqv.GoS = locala.NPN.readString();
        AppMethodBeat.o(209348);
        return 0;
      }
      AppMethodBeat.o(209348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqv
 * JD-Core Version:    0.7.0.1
 */