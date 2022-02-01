package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvt
  extends com.tencent.mm.bx.a
{
  public int Gan;
  public int HIe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gan);
      paramVarArgs.aS(2, this.HIe);
      AppMethodBeat.o(184495);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gan);
      int i = f.a.a.b.b.a.bz(2, this.HIe);
      AppMethodBeat.o(184495);
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
      AppMethodBeat.o(184495);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvt localdvt = (dvt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184495);
        return -1;
      case 1: 
        localdvt.Gan = locala.NPN.zc();
        AppMethodBeat.o(184495);
        return 0;
      }
      localdvt.HIe = locala.NPN.zc();
      AppMethodBeat.o(184495);
      return 0;
    }
    AppMethodBeat.o(184495);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvt
 * JD-Core Version:    0.7.0.1
 */