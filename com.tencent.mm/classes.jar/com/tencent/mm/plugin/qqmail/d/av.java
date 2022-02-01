package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends com.tencent.mm.bw.a
{
  public int color;
  public String dyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217984);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      paramVarArgs.aS(2, this.color);
      AppMethodBeat.o(217984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.color);
      AppMethodBeat.o(217984);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217984);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        av localav = (av)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(217984);
          return -1;
        case 1: 
          localav.dyI = locala.OmT.readString();
          AppMethodBeat.o(217984);
          return 0;
        }
        localav.color = locala.OmT.zc();
        AppMethodBeat.o(217984);
        return 0;
      }
      AppMethodBeat.o(217984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.av
 * JD-Core Version:    0.7.0.1
 */