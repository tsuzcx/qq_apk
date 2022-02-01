package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int month;
  public String wDi;
  public int year;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.year);
      paramVarArgs.aS(2, this.month);
      if (this.wDi != null) {
        paramVarArgs.d(3, this.wDi);
      }
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.year) + 0 + f.a.a.b.b.a.bz(2, this.month);
      paramInt = i;
      if (this.wDi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wDi);
      }
      AppMethodBeat.o(91260);
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
      AppMethodBeat.o(91260);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91260);
        return -1;
      case 1: 
        locald.year = locala.NPN.zc();
        AppMethodBeat.o(91260);
        return 0;
      case 2: 
        locald.month = locala.NPN.zc();
        AppMethodBeat.o(91260);
        return 0;
      }
      locald.wDi = locala.NPN.readString();
      AppMethodBeat.o(91260);
      return 0;
    }
    AppMethodBeat.o(91260);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.d
 * JD-Core Version:    0.7.0.1
 */