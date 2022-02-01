package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cml
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.top);
      paramVarArgs.E(2, this.bottom);
      paramVarArgs.E(3, this.left);
      paramVarArgs.E(4, this.right);
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(91537);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cml localcml = (cml)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91537);
        return -1;
      case 1: 
        localcml.top = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(91537);
        return 0;
      case 2: 
        localcml.bottom = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(91537);
        return 0;
      case 3: 
        localcml.left = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(91537);
        return 0;
      }
      localcml.right = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(91537);
      return 0;
    }
    AppMethodBeat.o(91537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cml
 * JD-Core Version:    0.7.0.1
 */