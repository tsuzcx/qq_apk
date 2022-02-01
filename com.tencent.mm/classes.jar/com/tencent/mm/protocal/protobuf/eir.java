package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eir
  extends com.tencent.mm.bx.a
{
  public int HTh;
  public boolean HTi;
  public boolean HTj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HTh);
      paramVarArgs.bt(2, this.HTi);
      paramVarArgs.bt(3, this.HTj);
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HTh);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(123713);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eir localeir = (eir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123713);
        return -1;
      case 1: 
        localeir.HTh = locala.NPN.zc();
        AppMethodBeat.o(123713);
        return 0;
      case 2: 
        localeir.HTi = locala.NPN.grw();
        AppMethodBeat.o(123713);
        return 0;
      }
      localeir.HTj = locala.NPN.grw();
      AppMethodBeat.o(123713);
      return 0;
    }
    AppMethodBeat.o(123713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eir
 * JD-Core Version:    0.7.0.1
 */