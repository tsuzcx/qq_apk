package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwi
  extends com.tencent.mm.bw.a
{
  public int LBB;
  public String jGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jGZ != null) {
        paramVarArgs.e(1, this.jGZ);
      }
      paramVarArgs.aM(2, this.LBB);
      AppMethodBeat.o(152650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jGZ == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.jGZ) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LBB);
      AppMethodBeat.o(152650);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152650);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cwi localcwi = (cwi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152650);
          return -1;
        case 1: 
          localcwi.jGZ = locala.UbS.readString();
          AppMethodBeat.o(152650);
          return 0;
        }
        localcwi.LBB = locala.UbS.zi();
        AppMethodBeat.o(152650);
        return 0;
      }
      AppMethodBeat.o(152650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwi
 * JD-Core Version:    0.7.0.1
 */