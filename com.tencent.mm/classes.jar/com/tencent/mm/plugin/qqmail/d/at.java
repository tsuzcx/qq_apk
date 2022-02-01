package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends com.tencent.mm.bx.a
{
  public long uin;
  public String xcR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215236);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      if (this.xcR != null) {
        paramVarArgs.d(2, this.xcR);
      }
      AppMethodBeat.o(215236);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.uin) + 0;
      paramInt = i;
      if (this.xcR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xcR);
      }
      AppMethodBeat.o(215236);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215236);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      at localat = (at)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215236);
        return -1;
      case 1: 
        localat.uin = locala.NPN.zd();
        AppMethodBeat.o(215236);
        return 0;
      }
      localat.xcR = locala.NPN.readString();
      AppMethodBeat.o(215236);
      return 0;
    }
    AppMethodBeat.o(215236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.at
 * JD-Core Version:    0.7.0.1
 */