package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ald
  extends com.tencent.mm.bx.a
{
  public String FVK;
  public int FVQ;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVK != null) {
        paramVarArgs.d(1, this.FVK);
      }
      paramVarArgs.aS(2, this.FVQ);
      paramVarArgs.aS(3, this.nDG);
      AppMethodBeat.o(127494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVK == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.FVK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FVQ);
      int j = f.a.a.b.b.a.bz(3, this.nDG);
      AppMethodBeat.o(127494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127494);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ald localald = (ald)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127494);
          return -1;
        case 1: 
          localald.FVK = locala.NPN.readString();
          AppMethodBeat.o(127494);
          return 0;
        case 2: 
          localald.FVQ = locala.NPN.zc();
          AppMethodBeat.o(127494);
          return 0;
        }
        localald.nDG = locala.NPN.zc();
        AppMethodBeat.o(127494);
        return 0;
      }
      AppMethodBeat.o(127494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */