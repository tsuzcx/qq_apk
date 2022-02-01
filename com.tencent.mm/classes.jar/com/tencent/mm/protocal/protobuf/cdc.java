package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdc
  extends com.tencent.mm.bw.a
{
  public long MiS;
  public int MiT;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.key);
      paramVarArgs.bb(2, this.MiS);
      paramVarArgs.aM(3, this.length);
      paramVarArgs.aM(4, this.MiT);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.key);
      int i = g.a.a.b.b.a.r(2, this.MiS);
      int j = g.a.a.b.b.a.bu(3, this.length);
      int k = g.a.a.b.b.a.bu(4, this.MiT);
      AppMethodBeat.o(111786);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cdc localcdc = (cdc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localcdc.key = locala.UbS.zi();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localcdc.MiS = locala.UbS.zl();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localcdc.length = locala.UbS.zi();
        AppMethodBeat.o(111786);
        return 0;
      }
      localcdc.MiT = locala.UbS.zi();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdc
 * JD-Core Version:    0.7.0.1
 */