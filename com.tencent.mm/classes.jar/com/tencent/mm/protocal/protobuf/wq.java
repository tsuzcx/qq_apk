package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wq
  extends com.tencent.mm.bx.a
{
  public String CYL;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYL != null) {
        paramVarArgs.d(1, this.CYL);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      AppMethodBeat.o(50084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYL == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = f.a.a.b.b.a.e(1, this.CYL) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(50084);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50084);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wq localwq = (wq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50084);
          return -1;
        case 1: 
          localwq.CYL = locala.KhF.readString();
          AppMethodBeat.o(50084);
          return 0;
        case 2: 
          localwq.longitude = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(50084);
          return 0;
        }
        localwq.latitude = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(50084);
        return 0;
      }
      AppMethodBeat.o(50084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wq
 * JD-Core Version:    0.7.0.1
 */