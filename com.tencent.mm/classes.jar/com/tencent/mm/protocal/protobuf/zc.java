package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zc
  extends com.tencent.mm.bx.a
{
  public int FYH;
  public String FxR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FxR != null) {
        paramVarArgs.d(1, this.FxR);
      }
      paramVarArgs.aS(2, this.FYH);
      AppMethodBeat.o(124477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FxR == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.FxR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FYH);
      AppMethodBeat.o(124477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124477);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        zc localzc = (zc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124477);
          return -1;
        case 1: 
          localzc.FxR = locala.NPN.readString();
          AppMethodBeat.o(124477);
          return 0;
        }
        localzc.FYH = locala.NPN.zc();
        AppMethodBeat.o(124477);
        return 0;
      }
      AppMethodBeat.o(124477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zc
 * JD-Core Version:    0.7.0.1
 */