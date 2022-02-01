package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cae
  extends com.tencent.mm.bx.a
{
  public String GUX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GUX != null) {
        paramVarArgs.d(1, this.GUX);
      }
      AppMethodBeat.o(215757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUX == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.GUX) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(215757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215757);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cae localcae = (cae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215757);
          return -1;
        }
        localcae.GUX = locala.NPN.readString();
        AppMethodBeat.o(215757);
        return 0;
      }
      AppMethodBeat.o(215757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cae
 * JD-Core Version:    0.7.0.1
 */