package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aje
  extends com.tencent.mm.cd.a
{
  public int centerX;
  public int centerY;
  public float oYk;
  public float scale;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255067);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.centerX);
      paramVarArgs.aY(2, this.centerY);
      paramVarArgs.i(3, this.scale);
      paramVarArgs.i(4, this.oYk);
      AppMethodBeat.o(255067);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.centerX);
      int i = g.a.a.b.b.a.bM(2, this.centerY);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(255067);
      return paramInt + 0 + i + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(255067);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aje localaje = (aje)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(255067);
        return -1;
      case 1: 
        localaje.centerX = locala.abFh.AK();
        AppMethodBeat.o(255067);
        return 0;
      case 2: 
        localaje.centerY = locala.abFh.AK();
        AppMethodBeat.o(255067);
        return 0;
      case 3: 
        localaje.scale = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(255067);
        return 0;
      }
      localaje.oYk = Float.intBitsToFloat(locala.abFh.AO());
      AppMethodBeat.o(255067);
      return 0;
    }
    AppMethodBeat.o(255067);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aje
 * JD-Core Version:    0.7.0.1
 */