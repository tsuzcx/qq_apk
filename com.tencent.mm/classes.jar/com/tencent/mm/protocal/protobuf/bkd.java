package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkd
  extends com.tencent.mm.bv.a
{
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48916);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.top);
      paramVarArgs.q(2, this.bottom);
      paramVarArgs.q(3, this.left);
      paramVarArgs.q(4, this.right);
      AppMethodBeat.o(48916);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(48916);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48916);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bkd localbkd = (bkd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(48916);
        return -1;
      case 1: 
        localbkd.top = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(48916);
        return 0;
      case 2: 
        localbkd.bottom = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(48916);
        return 0;
      case 3: 
        localbkd.left = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(48916);
        return 0;
      }
      localbkd.right = Float.intBitsToFloat(locala.CLY.emx());
      AppMethodBeat.o(48916);
      return 0;
    }
    AppMethodBeat.o(48916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkd
 * JD-Core Version:    0.7.0.1
 */