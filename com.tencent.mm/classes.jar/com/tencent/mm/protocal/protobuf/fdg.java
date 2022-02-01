package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdg
  extends com.tencent.mm.bw.a
{
  public String NyR;
  public int NyS;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NyR != null) {
        paramVarArgs.e(1, this.NyR);
      }
      paramVarArgs.aM(2, this.scene);
      paramVarArgs.aM(3, this.NyS);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NyR == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.NyR) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.scene);
      int j = g.a.a.b.b.a.bu(3, this.NyS);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fdg localfdg = (fdg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localfdg.NyR = locala.UbS.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localfdg.scene = locala.UbS.zi();
          AppMethodBeat.o(123704);
          return 0;
        }
        localfdg.NyS = locala.UbS.zi();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdg
 * JD-Core Version:    0.7.0.1
 */