package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class don
  extends com.tencent.mm.bw.a
{
  public int KIS;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6427);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.aM(2, this.KIS);
      paramVarArgs.aM(3, this.Scene);
      AppMethodBeat.o(6427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = g.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KIS);
      int j = g.a.a.b.b.a.bu(3, this.Scene);
      AppMethodBeat.o(6427);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6427);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        don localdon = (don)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6427);
          return -1;
        case 1: 
          localdon.Url = locala.UbS.readString();
          AppMethodBeat.o(6427);
          return 0;
        case 2: 
          localdon.KIS = locala.UbS.zi();
          AppMethodBeat.o(6427);
          return 0;
        }
        localdon.Scene = locala.UbS.zi();
        AppMethodBeat.o(6427);
        return 0;
      }
      AppMethodBeat.o(6427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.don
 * JD-Core Version:    0.7.0.1
 */