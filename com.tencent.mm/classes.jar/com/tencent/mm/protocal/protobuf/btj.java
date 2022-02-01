package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btj
  extends com.tencent.mm.bx.a
{
  public double latitude;
  public double longitude;
  public String oBD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.latitude);
      paramVarArgs.e(2, this.longitude);
      if (this.oBD != null) {
        paramVarArgs.d(3, this.oBD);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alT(1) + 0 + f.a.a.b.b.a.alT(2);
      paramInt = i;
      if (this.oBD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oBD);
      }
      AppMethodBeat.o(93333);
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
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btj localbtj = (btj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localbtj.latitude = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localbtj.longitude = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(93333);
        return 0;
      }
      localbtj.oBD = locala.NPN.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */