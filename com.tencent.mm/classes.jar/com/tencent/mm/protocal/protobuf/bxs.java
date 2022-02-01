package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxs
  extends com.tencent.mm.bx.a
{
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.top);
      paramVarArgs.x(2, this.bottom);
      paramVarArgs.x(3, this.left);
      paramVarArgs.x(4, this.right);
      AppMethodBeat.o(91570);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(91570);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91570);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxs localbxs = (bxs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91570);
        return -1;
      case 1: 
        localbxs.top = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(91570);
        return 0;
      case 2: 
        localbxs.bottom = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(91570);
        return 0;
      case 3: 
        localbxs.left = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(91570);
        return 0;
      }
      localbxs.right = Float.intBitsToFloat(locala.KhF.fHx());
      AppMethodBeat.o(91570);
      return 0;
    }
    AppMethodBeat.o(91570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxs
 * JD-Core Version:    0.7.0.1
 */