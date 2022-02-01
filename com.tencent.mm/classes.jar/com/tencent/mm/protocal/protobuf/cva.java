package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cva
  extends com.tencent.mm.bx.a
{
  public int FwM;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aS(2, this.FwM);
      paramVarArgs.aS(3, this.Scene);
      AppMethodBeat.o(6427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FwM);
      int j = f.a.a.b.b.a.bz(3, this.Scene);
      AppMethodBeat.o(6427);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6427);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cva localcva = (cva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6427);
          return -1;
        case 1: 
          localcva.Url = locala.NPN.readString();
          AppMethodBeat.o(6427);
          return 0;
        case 2: 
          localcva.FwM = locala.NPN.zc();
          AppMethodBeat.o(6427);
          return 0;
        }
        localcva.Scene = locala.NPN.zc();
        AppMethodBeat.o(6427);
        return 0;
      }
      AppMethodBeat.o(6427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cva
 * JD-Core Version:    0.7.0.1
 */