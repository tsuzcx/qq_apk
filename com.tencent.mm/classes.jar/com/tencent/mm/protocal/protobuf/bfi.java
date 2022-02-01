package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfi
  extends com.tencent.mm.bw.a
{
  public String LOU;
  public String LOV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169383);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LOU != null) {
        paramVarArgs.e(1, this.LOU);
      }
      if (this.LOV != null) {
        paramVarArgs.e(2, this.LOV);
      }
      AppMethodBeat.o(169383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LOU == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.LOU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LOV != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LOV);
      }
      AppMethodBeat.o(169383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169383);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfi localbfi = (bfi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169383);
          return -1;
        case 1: 
          localbfi.LOU = locala.UbS.readString();
          AppMethodBeat.o(169383);
          return 0;
        }
        localbfi.LOV = locala.UbS.readString();
        AppMethodBeat.o(169383);
        return 0;
      }
      AppMethodBeat.o(169383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfi
 * JD-Core Version:    0.7.0.1
 */