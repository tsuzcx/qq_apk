package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccu
  extends com.tencent.mm.bx.a
{
  public String GWX;
  public String GWY;
  public String GWZ;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GWX != null) {
        paramVarArgs.d(1, this.GWX);
      }
      if (this.GWY != null) {
        paramVarArgs.d(2, this.GWY);
      }
      if (this.GWZ != null) {
        paramVarArgs.d(3, this.GWZ);
      }
      paramVarArgs.aS(4, this.action);
      AppMethodBeat.o(211874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GWX == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.GWX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GWY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GWY);
      }
      i = paramInt;
      if (this.GWZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GWZ);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.action);
      AppMethodBeat.o(211874);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211874);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccu localccu = (ccu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211874);
          return -1;
        case 1: 
          localccu.GWX = locala.NPN.readString();
          AppMethodBeat.o(211874);
          return 0;
        case 2: 
          localccu.GWY = locala.NPN.readString();
          AppMethodBeat.o(211874);
          return 0;
        case 3: 
          localccu.GWZ = locala.NPN.readString();
          AppMethodBeat.o(211874);
          return 0;
        }
        localccu.action = locala.NPN.zc();
        AppMethodBeat.o(211874);
        return 0;
      }
      AppMethodBeat.o(211874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccu
 * JD-Core Version:    0.7.0.1
 */