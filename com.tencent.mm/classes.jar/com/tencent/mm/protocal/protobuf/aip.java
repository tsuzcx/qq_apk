package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aip
  extends com.tencent.mm.bw.a
{
  public int centerX;
  public int centerY;
  public float mat;
  public float scale;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201294);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.centerX);
      paramVarArgs.aM(2, this.centerY);
      paramVarArgs.E(3, this.scale);
      paramVarArgs.E(4, this.mat);
      AppMethodBeat.o(201294);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.centerX);
      int i = g.a.a.b.b.a.bu(2, this.centerY);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(201294);
      return paramInt + 0 + i + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(201294);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aip localaip = (aip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(201294);
        return -1;
      case 1: 
        localaip.centerX = locala.UbS.zi();
        AppMethodBeat.o(201294);
        return 0;
      case 2: 
        localaip.centerY = locala.UbS.zi();
        AppMethodBeat.o(201294);
        return 0;
      case 3: 
        localaip.scale = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(201294);
        return 0;
      }
      localaip.mat = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(201294);
      return 0;
    }
    AppMethodBeat.o(201294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aip
 * JD-Core Version:    0.7.0.1
 */