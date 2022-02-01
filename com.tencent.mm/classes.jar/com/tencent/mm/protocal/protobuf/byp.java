package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byp
  extends com.tencent.mm.bx.a
{
  public float GTA;
  public float GTB;
  public float GTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.GTz);
      paramVarArgs.z(2, this.GTA);
      paramVarArgs.z(3, this.GTB);
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(1);
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      AppMethodBeat.o(125746);
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
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byp localbyp = (byp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125746);
        return -1;
      case 1: 
        localbyp.GTz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125746);
        return 0;
      case 2: 
        localbyp.GTA = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(125746);
        return 0;
      }
      localbyp.GTB = Float.intBitsToFloat(locala.NPN.grz());
      AppMethodBeat.o(125746);
      return 0;
    }
    AppMethodBeat.o(125746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */