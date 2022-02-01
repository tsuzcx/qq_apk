package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eit
  extends com.tencent.mm.bx.a
{
  public int GZD;
  public String HTk;
  public boolean HTp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HTk != null) {
        paramVarArgs.d(1, this.HTk);
      }
      paramVarArgs.bt(2, this.HTp);
      paramVarArgs.aS(3, this.GZD);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HTk == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.HTk) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.bz(3, this.GZD);
      AppMethodBeat.o(50127);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eit localeit = (eit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localeit.HTk = locala.NPN.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localeit.HTp = locala.NPN.grw();
          AppMethodBeat.o(50127);
          return 0;
        }
        localeit.GZD = locala.NPN.zc();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eit
 * JD-Core Version:    0.7.0.1
 */