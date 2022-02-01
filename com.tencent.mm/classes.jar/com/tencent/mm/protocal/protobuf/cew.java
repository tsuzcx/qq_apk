package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cew
  extends com.tencent.mm.bx.a
{
  public int GYY;
  public String ugo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GYY);
      if (this.ugo != null) {
        paramVarArgs.d(2, this.ugo);
      }
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GYY) + 0;
      paramInt = i;
      if (this.ugo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ugo);
      }
      AppMethodBeat.o(152639);
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
      AppMethodBeat.o(152639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cew localcew = (cew)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152639);
        return -1;
      case 1: 
        localcew.GYY = locala.NPN.zc();
        AppMethodBeat.o(152639);
        return 0;
      }
      localcew.ugo = locala.NPN.readString();
      AppMethodBeat.o(152639);
      return 0;
    }
    AppMethodBeat.o(152639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cew
 * JD-Core Version:    0.7.0.1
 */