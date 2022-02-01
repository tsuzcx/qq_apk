package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bw.a
{
  public boolean iJ;
  public String id;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91274);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.cc(3, this.iJ);
      AppMethodBeat.o(91274);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.name);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(91274);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91274);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91274);
          return -1;
        case 1: 
          localh.id = locala.UbS.readString();
          AppMethodBeat.o(91274);
          return 0;
        case 2: 
          localh.name = locala.UbS.readString();
          AppMethodBeat.o(91274);
          return 0;
        }
        localh.iJ = locala.UbS.yZ();
        AppMethodBeat.o(91274);
        return 0;
      }
      AppMethodBeat.o(91274);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.h
 * JD-Core Version:    0.7.0.1
 */