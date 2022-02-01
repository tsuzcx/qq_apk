package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzl
  extends com.tencent.mm.bx.a
{
  public String HMH;
  public int HMI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147793);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMH != null) {
        paramVarArgs.d(1, this.HMH);
      }
      paramVarArgs.aS(2, this.HMI);
      AppMethodBeat.o(147793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMH == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.HMH) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HMI);
      AppMethodBeat.o(147793);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147793);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzl localdzl = (dzl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147793);
          return -1;
        case 1: 
          localdzl.HMH = locala.NPN.readString();
          AppMethodBeat.o(147793);
          return 0;
        }
        localdzl.HMI = locala.NPN.zc();
        AppMethodBeat.o(147793);
        return 0;
      }
      AppMethodBeat.o(147793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzl
 * JD-Core Version:    0.7.0.1
 */