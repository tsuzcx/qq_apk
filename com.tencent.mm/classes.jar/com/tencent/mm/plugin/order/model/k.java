package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bw.a
{
  public String APy;
  public String ThumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91263);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ThumbUrl != null) {
        paramVarArgs.e(1, this.ThumbUrl);
      }
      if (this.APy != null) {
        paramVarArgs.e(2, this.APy);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.ThumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.APy != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.APy);
      }
      AppMethodBeat.o(91263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91263);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91263);
          return -1;
        case 1: 
          localk.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(91263);
          return 0;
        }
        localk.APy = locala.UbS.readString();
        AppMethodBeat.o(91263);
        return 0;
      }
      AppMethodBeat.o(91263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.k
 * JD-Core Version:    0.7.0.1
 */