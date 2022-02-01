package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bx.a
{
  public String MFB;
  public String ThumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91263);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ThumbUrl != null) {
        paramVarArgs.g(1, this.ThumbUrl);
      }
      if (this.MFB != null) {
        paramVarArgs.g(2, this.MFB);
      }
      AppMethodBeat.o(91263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ThumbUrl == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.ThumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MFB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.MFB);
      }
      AppMethodBeat.o(91263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91263);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91263);
          return -1;
        case 1: 
          localk.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(91263);
          return 0;
        }
        localk.MFB = locala.ajGk.readString();
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