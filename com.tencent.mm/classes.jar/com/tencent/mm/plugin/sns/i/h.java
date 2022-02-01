package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public int state;
  public String yMz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96159);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yMz != null) {
        paramVarArgs.d(1, this.yMz);
      }
      paramVarArgs.aS(2, this.state);
      AppMethodBeat.o(96159);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yMz == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.yMz) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.state);
      AppMethodBeat.o(96159);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(96159);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96159);
          return -1;
        case 1: 
          localh.yMz = locala.NPN.readString();
          AppMethodBeat.o(96159);
          return 0;
        }
        localh.state = locala.NPN.zc();
        AppMethodBeat.o(96159);
        return 0;
      }
      AppMethodBeat.o(96159);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.h
 * JD-Core Version:    0.7.0.1
 */