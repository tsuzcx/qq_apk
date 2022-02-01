package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aat
  extends com.tencent.mm.bw.a
{
  public String Lmb;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50084);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmb != null) {
        paramVarArgs.e(1, this.Lmb);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      AppMethodBeat.o(50084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lmb == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lmb) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(50084);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50084);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aat localaat = (aat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50084);
          return -1;
        case 1: 
          localaat.Lmb = locala.UbS.readString();
          AppMethodBeat.o(50084);
          return 0;
        case 2: 
          localaat.longitude = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(50084);
          return 0;
        }
        localaat.latitude = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(50084);
        return 0;
      }
      AppMethodBeat.o(50084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aat
 * JD-Core Version:    0.7.0.1
 */