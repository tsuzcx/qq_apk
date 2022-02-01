package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajt
  extends com.tencent.mm.bx.a
{
  public int FuW;
  public String Fvc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuW);
      if (this.Fvc != null) {
        paramVarArgs.d(2, this.Fvc);
      }
      AppMethodBeat.o(127465);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FuW) + 0;
      paramInt = i;
      if (this.Fvc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fvc);
      }
      AppMethodBeat.o(127465);
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
      AppMethodBeat.o(127465);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajt localajt = (ajt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127465);
        return -1;
      case 1: 
        localajt.FuW = locala.NPN.zc();
        AppMethodBeat.o(127465);
        return 0;
      }
      localajt.Fvc = locala.NPN.readString();
      AppMethodBeat.o(127465);
      return 0;
    }
    AppMethodBeat.o(127465);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajt
 * JD-Core Version:    0.7.0.1
 */