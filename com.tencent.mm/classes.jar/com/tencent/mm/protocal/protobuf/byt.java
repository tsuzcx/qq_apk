package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byt
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.top);
      paramVarArgs.y(2, this.bottom);
      paramVarArgs.y(3, this.left);
      paramVarArgs.y(4, this.right);
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      AppMethodBeat.o(91537);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byt localbyt = (byt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91537);
        return -1;
      case 1: 
        localbyt.top = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(91537);
        return 0;
      case 2: 
        localbyt.bottom = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(91537);
        return 0;
      case 3: 
        localbyt.left = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(91537);
        return 0;
      }
      localbyt.right = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(91537);
      return 0;
    }
    AppMethodBeat.o(91537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byt
 * JD-Core Version:    0.7.0.1
 */