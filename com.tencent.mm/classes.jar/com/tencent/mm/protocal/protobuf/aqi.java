package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqi
  extends com.tencent.mm.cd.a
{
  public String RVH;
  public String RVI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RVI != null) {
        paramVarArgs.f(1, this.RVI);
      }
      if (this.RVH != null) {
        paramVarArgs.f(2, this.RVH);
      }
      AppMethodBeat.o(229691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RVI == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RVI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RVH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RVH);
      }
      AppMethodBeat.o(229691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229691);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aqi localaqi = (aqi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(229691);
          return -1;
        case 1: 
          localaqi.RVI = locala.abFh.readString();
          AppMethodBeat.o(229691);
          return 0;
        }
        localaqi.RVH = locala.abFh.readString();
        AppMethodBeat.o(229691);
        return 0;
      }
      AppMethodBeat.o(229691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqi
 * JD-Core Version:    0.7.0.1
 */