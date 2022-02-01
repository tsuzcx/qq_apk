package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fva
  extends com.tencent.mm.bx.a
{
  public String ZWh;
  public String icon_url;
  public String title;
  public String wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258805);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.icon_url != null) {
        paramVarArgs.g(1, this.icon_url);
      }
      if (this.ZWh != null) {
        paramVarArgs.g(2, this.ZWh);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(4, this.wsz);
      }
      AppMethodBeat.o(258805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon_url == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.icon_url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZWh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZWh);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.wsz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wsz);
      }
      AppMethodBeat.o(258805);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258805);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fva localfva = (fva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258805);
          return -1;
        case 1: 
          localfva.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(258805);
          return 0;
        case 2: 
          localfva.ZWh = locala.ajGk.readString();
          AppMethodBeat.o(258805);
          return 0;
        case 3: 
          localfva.title = locala.ajGk.readString();
          AppMethodBeat.o(258805);
          return 0;
        }
        localfva.wsz = locala.ajGk.readString();
        AppMethodBeat.o(258805);
        return 0;
      }
      AppMethodBeat.o(258805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fva
 * JD-Core Version:    0.7.0.1
 */