package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyn
  extends com.tencent.mm.bx.a
{
  public String aaDq;
  public String aaDr;
  public String icon;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaDq != null) {
        paramVarArgs.g(1, this.aaDq);
      }
      if (this.aaDr != null) {
        paramVarArgs.g(2, this.aaDr);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.icon != null) {
        paramVarArgs.g(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaDq == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.aaDq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaDr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaDr);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cyn localcyn = (cyn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localcyn.aaDq = locala.ajGk.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localcyn.aaDr = locala.ajGk.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localcyn.url = locala.ajGk.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localcyn.icon = locala.ajGk.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyn
 * JD-Core Version:    0.7.0.1
 */