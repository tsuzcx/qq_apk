package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az
  extends com.tencent.mm.bx.a
{
  public long uin;
  public long xdu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215242);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.aY(2, this.xdu);
      AppMethodBeat.o(215242);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.uin);
      int i = f.a.a.b.b.a.p(2, this.xdu);
      AppMethodBeat.o(215242);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(215242);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      az localaz = (az)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215242);
        return -1;
      case 1: 
        localaz.uin = locala.NPN.zd();
        AppMethodBeat.o(215242);
        return 0;
      }
      localaz.xdu = locala.NPN.zd();
      AppMethodBeat.o(215242);
      return 0;
    }
    AppMethodBeat.o(215242);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.az
 * JD-Core Version:    0.7.0.1
 */