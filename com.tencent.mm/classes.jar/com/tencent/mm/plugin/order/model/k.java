package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bw.a
{
  public String ThumbUrl;
  public String vyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91263);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ThumbUrl != null) {
        paramVarArgs.d(1, this.ThumbUrl);
      }
      if (this.vyA != null) {
        paramVarArgs.d(2, this.vyA);
      }
      AppMethodBeat.o(91263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ThumbUrl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.ThumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vyA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vyA);
      }
      AppMethodBeat.o(91263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91263);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91263);
          return -1;
        case 1: 
          localk.ThumbUrl = locala.LVo.readString();
          AppMethodBeat.o(91263);
          return 0;
        }
        localk.vyA = locala.LVo.readString();
        AppMethodBeat.o(91263);
        return 0;
      }
      AppMethodBeat.o(91263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.k
 * JD-Core Version:    0.7.0.1
 */