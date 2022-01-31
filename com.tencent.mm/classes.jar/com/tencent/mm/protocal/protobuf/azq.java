package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azq
  extends com.tencent.mm.bv.a
{
  public String kpP;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114435);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.latitude);
      paramVarArgs.f(2, this.longitude);
      if (this.kpP != null) {
        paramVarArgs.e(3, this.kpP);
      }
      AppMethodBeat.o(114435);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 8 + 0 + (e.a.a.b.b.a.eW(2) + 8);
      paramInt = i;
      if (this.kpP != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kpP);
      }
      AppMethodBeat.o(114435);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(114435);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      azq localazq = (azq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114435);
        return -1;
      case 1: 
        localazq.latitude = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(114435);
        return 0;
      case 2: 
        localazq.longitude = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(114435);
        return 0;
      }
      localazq.kpP = locala.CLY.readString();
      AppMethodBeat.o(114435);
      return 0;
    }
    AppMethodBeat.o(114435);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azq
 * JD-Core Version:    0.7.0.1
 */