package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bbn
  extends com.tencent.mm.bx.a
{
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259650);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.left);
      paramVarArgs.l(2, this.top);
      paramVarArgs.l(3, this.right);
      paramVarArgs.l(4, this.bottom);
      AppMethodBeat.o(259650);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259650);
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
      AppMethodBeat.o(259650);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bbn localbbn = (bbn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259650);
        return -1;
      case 1: 
        localbbn.left = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259650);
        return 0;
      case 2: 
        localbbn.top = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259650);
        return 0;
      case 3: 
        localbbn.right = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259650);
        return 0;
      }
      localbbn.bottom = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(259650);
      return 0;
    }
    AppMethodBeat.o(259650);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */