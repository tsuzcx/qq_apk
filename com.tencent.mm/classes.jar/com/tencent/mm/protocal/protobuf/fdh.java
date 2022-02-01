package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdh
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MjZ;
  public int MqC;
  public int MqD;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MjZ);
      paramVarArgs.aM(2, this.KSa);
      paramVarArgs.aM(3, this.Scene);
      paramVarArgs.aM(5, this.MqD);
      paramVarArgs.aM(6, this.MqC);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MjZ);
      int i = g.a.a.b.b.a.bu(2, this.KSa);
      int j = g.a.a.b.b.a.bu(3, this.Scene);
      int k = g.a.a.b.b.a.bu(5, this.MqD);
      int m = g.a.a.b.b.a.bu(6, this.MqC);
      AppMethodBeat.o(50118);
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
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdh localfdh = (fdh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localfdh.MjZ = locala.UbS.zi();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localfdh.KSa = locala.UbS.zi();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localfdh.Scene = locala.UbS.zi();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localfdh.MqD = locala.UbS.zi();
        AppMethodBeat.o(50118);
        return 0;
      }
      localfdh.MqC = locala.UbS.zi();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdh
 * JD-Core Version:    0.7.0.1
 */