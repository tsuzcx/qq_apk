package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chh
  extends com.tencent.mm.bw.a
{
  public double latitude;
  public double longitude;
  public String pVT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93333);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.latitude);
      paramVarArgs.e(2, this.longitude);
      if (this.pVT != null) {
        paramVarArgs.e(3, this.pVT);
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 8 + 0 + (g.a.a.b.b.a.fS(2) + 8);
      paramInt = i;
      if (this.pVT != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pVT);
      }
      AppMethodBeat.o(93333);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(93333);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      chh localchh = (chh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93333);
        return -1;
      case 1: 
        localchh.latitude = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(93333);
        return 0;
      case 2: 
        localchh.longitude = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(93333);
        return 0;
      }
      localchh.pVT = locala.UbS.readString();
      AppMethodBeat.o(93333);
      return 0;
    }
    AppMethodBeat.o(93333);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chh
 * JD-Core Version:    0.7.0.1
 */