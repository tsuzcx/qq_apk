package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccy
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public float height;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91522);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.KNW != null) {
        paramVarArgs.e(2, this.KNW);
      }
      paramVarArgs.E(3, this.width);
      paramVarArgs.E(4, this.height);
      AppMethodBeat.o(91522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label368;
      }
    }
    label368:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KNW != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KNW);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(91522);
      return i + (paramInt + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91522);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ccy localccy = (ccy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91522);
          return -1;
        case 1: 
          localccy.url = locala.UbS.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 2: 
          localccy.KNW = locala.UbS.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 3: 
          localccy.width = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(91522);
          return 0;
        }
        localccy.height = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(91522);
        return 0;
      }
      AppMethodBeat.o(91522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */