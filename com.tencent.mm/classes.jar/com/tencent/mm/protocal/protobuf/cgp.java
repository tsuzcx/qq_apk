package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgp
  extends com.tencent.mm.bw.a
{
  public String LtA;
  public String oTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LtA != null) {
        paramVarArgs.e(1, this.LtA);
      }
      if (this.oTI != null) {
        paramVarArgs.e(2, this.oTI);
      }
      AppMethodBeat.o(256412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LtA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.LtA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oTI);
      }
      AppMethodBeat.o(256412);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256412);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cgp localcgp = (cgp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256412);
          return -1;
        case 1: 
          localcgp.LtA = locala.UbS.readString();
          AppMethodBeat.o(256412);
          return 0;
        }
        localcgp.oTI = locala.UbS.readString();
        AppMethodBeat.o(256412);
        return 0;
      }
      AppMethodBeat.o(256412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgp
 * JD-Core Version:    0.7.0.1
 */