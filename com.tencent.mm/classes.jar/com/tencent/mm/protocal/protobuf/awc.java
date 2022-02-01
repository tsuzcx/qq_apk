package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class awc
  extends com.tencent.mm.cd.a
{
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199232);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.left);
      paramVarArgs.i(2, this.top);
      paramVarArgs.i(3, this.right);
      paramVarArgs.i(4, this.bottom);
      AppMethodBeat.o(199232);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(199232);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199232);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      awc localawc = (awc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199232);
        return -1;
      case 1: 
        localawc.left = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(199232);
        return 0;
      case 2: 
        localawc.top = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(199232);
        return 0;
      case 3: 
        localawc.right = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(199232);
        return 0;
      }
      localawc.bottom = Float.intBitsToFloat(locala.abFh.AO());
      AppMethodBeat.o(199232);
      return 0;
    }
    AppMethodBeat.o(199232);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awc
 * JD-Core Version:    0.7.0.1
 */