package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends com.tencent.mm.bw.a
{
  public String BsL;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198638);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uin);
      if (this.BsL != null) {
        paramVarArgs.e(2, this.BsL);
      }
      AppMethodBeat.o(198638);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.uin) + 0;
      paramInt = i;
      if (this.BsL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.BsL);
      }
      AppMethodBeat.o(198638);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(198638);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      at localat = (at)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198638);
        return -1;
      case 1: 
        localat.uin = locala.UbS.zl();
        AppMethodBeat.o(198638);
        return 0;
      }
      localat.BsL = locala.UbS.readString();
      AppMethodBeat.o(198638);
      return 0;
    }
    AppMethodBeat.o(198638);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.at
 * JD-Core Version:    0.7.0.1
 */