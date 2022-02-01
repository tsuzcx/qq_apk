package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcg
  extends com.tencent.mm.bw.a
{
  public String LIb;
  public float dTj;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164044);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LIb != null) {
        paramVarArgs.e(1, this.LIb);
      }
      paramVarArgs.E(2, this.dTj);
      paramVarArgs.E(3, this.latitude);
      AppMethodBeat.o(164044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LIb == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = g.a.a.b.b.a.f(1, this.LIb) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(164044);
      return paramInt + (i + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(164044);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bcg localbcg = (bcg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(164044);
          return -1;
        case 1: 
          localbcg.LIb = locala.UbS.readString();
          AppMethodBeat.o(164044);
          return 0;
        case 2: 
          localbcg.dTj = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(164044);
          return 0;
        }
        localbcg.latitude = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(164044);
        return 0;
      }
      AppMethodBeat.o(164044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcg
 * JD-Core Version:    0.7.0.1
 */