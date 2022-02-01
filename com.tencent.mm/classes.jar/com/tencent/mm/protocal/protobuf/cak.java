package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cak
  extends com.tencent.mm.bx.a
{
  public int GUG;
  public String GUK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43110);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GUK != null) {
        paramVarArgs.d(1, this.GUK);
      }
      paramVarArgs.aS(2, this.GUG);
      AppMethodBeat.o(43110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUK == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.GUK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GUG);
      AppMethodBeat.o(43110);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43110);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cak localcak = (cak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43110);
          return -1;
        case 1: 
          localcak.GUK = locala.NPN.readString();
          AppMethodBeat.o(43110);
          return 0;
        }
        localcak.GUG = locala.NPN.zc();
        AppMethodBeat.o(43110);
        return 0;
      }
      AppMethodBeat.o(43110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cak
 * JD-Core Version:    0.7.0.1
 */