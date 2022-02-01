package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxz
  extends com.tencent.mm.bx.a
{
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.top);
      paramVarArgs.z(2, this.bottom);
      paramVarArgs.z(3, this.left);
      paramVarArgs.z(4, this.right);
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(1);
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.alU(4);
      AppMethodBeat.o(91537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxz localbxz = (bxz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91537);
        return -1;
      case 1: 
        localbxz.top = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(91537);
        return 0;
      case 2: 
        localbxz.bottom = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(91537);
        return 0;
      case 3: 
        localbxz.left = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(91537);
        return 0;
      }
      localbxz.right = Float.intBitsToFloat(locala.NPN.grz());
      AppMethodBeat.o(91537);
      return 0;
    }
    AppMethodBeat.o(91537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxz
 * JD-Core Version:    0.7.0.1
 */