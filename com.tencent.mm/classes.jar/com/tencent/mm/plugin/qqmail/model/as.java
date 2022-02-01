package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends com.tencent.mm.bx.a
{
  public String NkT;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267040);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.uin);
      if (this.NkT != null) {
        paramVarArgs.g(2, this.NkT);
      }
      AppMethodBeat.o(267040);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.uin) + 0;
      paramInt = i;
      if (this.NkT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.NkT);
      }
      AppMethodBeat.o(267040);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(267040);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      as localas = (as)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267040);
        return -1;
      case 1: 
        localas.uin = locala.ajGk.aaw();
        AppMethodBeat.o(267040);
        return 0;
      }
      localas.NkT = locala.ajGk.readString();
      AppMethodBeat.o(267040);
      return 0;
    }
    AppMethodBeat.o(267040);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.as
 * JD-Core Version:    0.7.0.1
 */