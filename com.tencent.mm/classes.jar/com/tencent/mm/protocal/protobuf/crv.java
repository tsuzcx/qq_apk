package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crv
  extends com.tencent.mm.bw.a
{
  public String MwU;
  public String MwV;
  public String MwW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwU != null) {
        paramVarArgs.e(1, this.MwU);
      }
      if (this.MwV != null) {
        paramVarArgs.e(2, this.MwV);
      }
      if (this.MwW != null) {
        paramVarArgs.e(3, this.MwW);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwU == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.MwU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MwV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MwV);
      }
      i = paramInt;
      if (this.MwW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MwW);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crv localcrv = (crv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localcrv.MwU = locala.UbS.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localcrv.MwV = locala.UbS.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localcrv.MwW = locala.UbS.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crv
 * JD-Core Version:    0.7.0.1
 */