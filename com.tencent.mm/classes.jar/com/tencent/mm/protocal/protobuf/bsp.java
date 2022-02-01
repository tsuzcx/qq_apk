package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsp
  extends com.tencent.mm.bx.a
{
  public String GNj;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32334);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yhw != null) {
        paramVarArgs.d(1, this.yhw);
      }
      if (this.GNj != null) {
        paramVarArgs.d(2, this.GNj);
      }
      AppMethodBeat.o(32334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhw == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.yhw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GNj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GNj);
      }
      AppMethodBeat.o(32334);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32334);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsp localbsp = (bsp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32334);
          return -1;
        case 1: 
          localbsp.yhw = locala.NPN.readString();
          AppMethodBeat.o(32334);
          return 0;
        }
        localbsp.GNj = locala.NPN.readString();
        AppMethodBeat.o(32334);
        return 0;
      }
      AppMethodBeat.o(32334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */