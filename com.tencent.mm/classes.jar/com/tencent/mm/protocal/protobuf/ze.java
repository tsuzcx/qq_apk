package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ze
  extends com.tencent.mm.bw.a
{
  public String Grf;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Grf != null) {
        paramVarArgs.d(1, this.Grf);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      AppMethodBeat.o(50084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Grf == null) {
        break label304;
      }
    }
    label304:
    for (paramInt = f.a.a.b.b.a.e(1, this.Grf) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amD(2);
      int j = f.a.a.b.b.a.amD(3);
      AppMethodBeat.o(50084);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50084);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ze localze = (ze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50084);
          return -1;
        case 1: 
          localze.Grf = locala.OmT.readString();
          AppMethodBeat.o(50084);
          return 0;
        case 2: 
          localze.longitude = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(50084);
          return 0;
        }
        localze.latitude = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(50084);
        return 0;
      }
      AppMethodBeat.o(50084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */