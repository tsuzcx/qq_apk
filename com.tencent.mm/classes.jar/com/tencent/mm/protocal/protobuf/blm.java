package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blm
  extends com.tencent.mm.bw.a
{
  public int KZk;
  public long LRV;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      paramVarArgs.aM(2, this.KZk);
      paramVarArgs.bb(3, this.LRV);
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.oUv);
      int i = g.a.a.b.b.a.bu(2, this.KZk);
      int j = g.a.a.b.b.a.r(3, this.LRV);
      AppMethodBeat.o(117868);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117868);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      blm localblm = (blm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117868);
        return -1;
      case 1: 
        localblm.oUv = locala.UbS.zi();
        AppMethodBeat.o(117868);
        return 0;
      case 2: 
        localblm.KZk = locala.UbS.zi();
        AppMethodBeat.o(117868);
        return 0;
      }
      localblm.LRV = locala.UbS.zl();
      AppMethodBeat.o(117868);
      return 0;
    }
    AppMethodBeat.o(117868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blm
 * JD-Core Version:    0.7.0.1
 */