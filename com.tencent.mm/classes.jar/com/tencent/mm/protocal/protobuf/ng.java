package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ng
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int KHb;
  public int KSf;
  public int KSg;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KSf);
      paramVarArgs.aM(2, this.CreateTime);
      paramVarArgs.aM(3, this.KHb);
      paramVarArgs.aM(4, this.oUv);
      paramVarArgs.aM(5, this.KSg);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KSf);
      int i = g.a.a.b.b.a.bu(2, this.CreateTime);
      int j = g.a.a.b.b.a.bu(3, this.KHb);
      int k = g.a.a.b.b.a.bu(4, this.oUv);
      int m = g.a.a.b.b.a.bu(5, this.KSg);
      AppMethodBeat.o(124398);
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
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ng localng = (ng)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        localng.KSf = locala.UbS.zi();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        localng.CreateTime = locala.UbS.zi();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        localng.KHb = locala.UbS.zi();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        localng.oUv = locala.UbS.zi();
        AppMethodBeat.o(124398);
        return 0;
      }
      localng.KSg = locala.UbS.zi();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ng
 * JD-Core Version:    0.7.0.1
 */