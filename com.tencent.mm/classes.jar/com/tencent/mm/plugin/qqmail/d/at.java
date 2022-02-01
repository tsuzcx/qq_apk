package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends com.tencent.mm.cd.a
{
  public String Hnf;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.uin);
      if (this.Hnf != null) {
        paramVarArgs.f(2, this.Hnf);
      }
      AppMethodBeat.o(250540);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.Hnf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Hnf);
      }
      AppMethodBeat.o(250540);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250540);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      at localat = (at)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(250540);
        return -1;
      case 1: 
        localat.uin = locala.abFh.AN();
        AppMethodBeat.o(250540);
        return 0;
      }
      localat.Hnf = locala.abFh.readString();
      AppMethodBeat.o(250540);
      return 0;
    }
    AppMethodBeat.o(250540);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.at
 * JD-Core Version:    0.7.0.1
 */