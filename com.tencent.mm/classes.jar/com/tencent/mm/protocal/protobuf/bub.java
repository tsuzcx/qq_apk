package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bub
  extends com.tencent.mm.bw.a
{
  public float FjY;
  public float FjZ;
  public float Fka;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.FjY);
      paramVarArgs.x(2, this.FjZ);
      paramVarArgs.x(3, this.Fka);
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(125746);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bub localbub = (bub)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125746);
        return -1;
      case 1: 
        localbub.FjY = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125746);
        return 0;
      case 2: 
        localbub.FjZ = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125746);
        return 0;
      }
      localbub.Fka = Float.intBitsToFloat(locala.LVo.gaa());
      AppMethodBeat.o(125746);
      return 0;
    }
    AppMethodBeat.o(125746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bub
 * JD-Core Version:    0.7.0.1
 */