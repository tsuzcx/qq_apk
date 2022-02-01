package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccn
  extends com.tencent.mm.bw.a
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
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(91570);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91570);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccn localccn = (ccn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91570);
        return -1;
      case 1: 
        localccn.top = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(91570);
        return 0;
      case 2: 
        localccn.bottom = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(91570);
        return 0;
      case 3: 
        localccn.left = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(91570);
        return 0;
      }
      localccn.right = Float.intBitsToFloat(locala.LVo.gaa());
      AppMethodBeat.o(91570);
      return 0;
    }
    AppMethodBeat.o(91570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */