package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends com.tencent.mm.bx.a
{
  public int color;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215238);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      paramVarArgs.aS(2, this.color);
      AppMethodBeat.o(215238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.dxD) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.color);
      AppMethodBeat.o(215238);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215238);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        av localav = (av)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215238);
          return -1;
        case 1: 
          localav.dxD = locala.NPN.readString();
          AppMethodBeat.o(215238);
          return 0;
        }
        localav.color = locala.NPN.zc();
        AppMethodBeat.o(215238);
        return 0;
      }
      AppMethodBeat.o(215238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.av
 * JD-Core Version:    0.7.0.1
 */