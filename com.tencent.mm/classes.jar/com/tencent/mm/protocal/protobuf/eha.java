package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eha
  extends com.tencent.mm.bx.a
{
  public boolean HRK;
  public boolean HRL;
  public int HRM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.HRK);
      paramVarArgs.bt(2, this.HRL);
      paramVarArgs.aS(3, this.HRM);
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.bz(3, this.HRM);
      AppMethodBeat.o(50120);
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
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eha localeha = (eha)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50120);
        return -1;
      case 1: 
        localeha.HRK = locala.NPN.grw();
        AppMethodBeat.o(50120);
        return 0;
      case 2: 
        localeha.HRL = locala.NPN.grw();
        AppMethodBeat.o(50120);
        return 0;
      }
      localeha.HRM = locala.NPN.zc();
      AppMethodBeat.o(50120);
      return 0;
    }
    AppMethodBeat.o(50120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eha
 * JD-Core Version:    0.7.0.1
 */