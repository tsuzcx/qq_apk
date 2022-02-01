package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eab
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.top);
      paramVarArgs.l(2, this.bottom);
      paramVarArgs.l(3, this.left);
      paramVarArgs.l(4, this.right);
      AppMethodBeat.o(91570);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(91570);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91570);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eab localeab = (eab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91570);
        return -1;
      case 1: 
        localeab.top = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(91570);
        return 0;
      case 2: 
        localeab.bottom = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(91570);
        return 0;
      case 3: 
        localeab.left = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(91570);
        return 0;
      }
      localeab.right = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(91570);
      return 0;
    }
    AppMethodBeat.o(91570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eab
 * JD-Core Version:    0.7.0.1
 */