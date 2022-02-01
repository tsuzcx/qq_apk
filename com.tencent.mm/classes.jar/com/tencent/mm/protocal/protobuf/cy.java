package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cy
  extends com.tencent.mm.bw.a
{
  public int KGZ;
  public int KHa;
  public int KHb;
  public int KHc;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KGZ);
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.KHa);
      paramVarArgs.aM(4, this.KHb);
      paramVarArgs.aM(5, this.KHc);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KGZ);
      int i = g.a.a.b.b.a.bu(2, this.oUv);
      int j = g.a.a.b.b.a.bu(3, this.KHa);
      int k = g.a.a.b.b.a.bu(4, this.KHb);
      int m = g.a.a.b.b.a.bu(5, this.KHc);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cy localcy = (cy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localcy.KGZ = locala.UbS.zi();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localcy.oUv = locala.UbS.zi();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localcy.KHa = locala.UbS.zi();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localcy.KHb = locala.UbS.zi();
        AppMethodBeat.o(127429);
        return 0;
      }
      localcy.KHc = locala.UbS.zi();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */