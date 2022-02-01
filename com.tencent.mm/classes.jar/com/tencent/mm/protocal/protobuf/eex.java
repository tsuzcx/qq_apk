package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eex
  extends com.tencent.mm.bx.a
{
  public boolean HQm;
  public boolean HQn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.HQm);
      paramVarArgs.bt(2, this.HQn);
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(110855);
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
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eex localeex = (eex)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110855);
        return -1;
      case 1: 
        localeex.HQm = locala.NPN.grw();
        AppMethodBeat.o(110855);
        return 0;
      }
      localeex.HQn = locala.NPN.grw();
      AppMethodBeat.o(110855);
      return 0;
    }
    AppMethodBeat.o(110855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eex
 * JD-Core Version:    0.7.0.1
 */