package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehi
  extends com.tencent.mm.bw.a
{
  public String NgV;
  public String NgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209819);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NgV != null) {
        paramVarArgs.e(1, this.NgV);
      }
      if (this.NgW != null) {
        paramVarArgs.e(2, this.NgW);
      }
      AppMethodBeat.o(209819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NgV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.NgV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NgW != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NgW);
      }
      AppMethodBeat.o(209819);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209819);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehi localehi = (ehi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209819);
          return -1;
        case 1: 
          localehi.NgV = locala.UbS.readString();
          AppMethodBeat.o(209819);
          return 0;
        }
        localehi.NgW = locala.UbS.readString();
        AppMethodBeat.o(209819);
        return 0;
      }
      AppMethodBeat.o(209819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehi
 * JD-Core Version:    0.7.0.1
 */