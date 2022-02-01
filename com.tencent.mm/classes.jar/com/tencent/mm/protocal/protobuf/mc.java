package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
  extends com.tencent.mm.bx.a
{
  public float FET;
  public float dAp;
  public float dyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.dyz);
      paramVarArgs.z(2, this.dAp);
      paramVarArgs.z(3, this.FET);
      AppMethodBeat.o(191535);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(1);
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      AppMethodBeat.o(191535);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(191535);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mc localmc = (mc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(191535);
        return -1;
      case 1: 
        localmc.dyz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(191535);
        return 0;
      case 2: 
        localmc.dAp = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(191535);
        return 0;
      }
      localmc.FET = Float.intBitsToFloat(locala.NPN.grz());
      AppMethodBeat.o(191535);
      return 0;
    }
    AppMethodBeat.o(191535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mc
 * JD-Core Version:    0.7.0.1
 */