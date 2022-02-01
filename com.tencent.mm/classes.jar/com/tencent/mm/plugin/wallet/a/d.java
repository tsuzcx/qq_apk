package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int BgD;
  public String wJS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91288);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wJS != null) {
        paramVarArgs.d(1, this.wJS);
      }
      paramVarArgs.aR(2, this.BgD);
      AppMethodBeat.o(91288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wJS == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.wJS) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.BgD);
      AppMethodBeat.o(91288);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91288);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91288);
          return -1;
        case 1: 
          locald.wJS = locala.LVo.readString();
          AppMethodBeat.o(91288);
          return 0;
        }
        locald.BgD = locala.LVo.xF();
        AppMethodBeat.o(91288);
        return 0;
      }
      AppMethodBeat.o(91288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.d
 * JD-Core Version:    0.7.0.1
 */