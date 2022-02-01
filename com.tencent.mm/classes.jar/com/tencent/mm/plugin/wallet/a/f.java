package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public String BgF;
  public String BgG;
  public String BgH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91290);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BgF != null) {
        paramVarArgs.d(1, this.BgF);
      }
      if (this.BgG != null) {
        paramVarArgs.d(2, this.BgG);
      }
      if (this.BgH != null) {
        paramVarArgs.d(3, this.BgH);
      }
      AppMethodBeat.o(91290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BgF == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.BgF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.BgG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BgG);
      }
      i = paramInt;
      if (this.BgH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.BgH);
      }
      AppMethodBeat.o(91290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91290);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91290);
          return -1;
        case 1: 
          localf.BgF = locala.LVo.readString();
          AppMethodBeat.o(91290);
          return 0;
        case 2: 
          localf.BgG = locala.LVo.readString();
          AppMethodBeat.o(91290);
          return 0;
        }
        localf.BgH = locala.LVo.readString();
        AppMethodBeat.o(91290);
        return 0;
      }
      AppMethodBeat.o(91290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */