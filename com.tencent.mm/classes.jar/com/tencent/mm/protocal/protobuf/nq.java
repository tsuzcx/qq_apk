package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nq
  extends com.tencent.mm.bx.a
{
  public float YPF;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258525);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.latitude);
      paramVarArgs.l(2, this.longitude);
      paramVarArgs.l(3, this.YPF);
      AppMethodBeat.o(258525);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(258525);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258525);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      nq localnq = (nq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258525);
        return -1;
      case 1: 
        localnq.latitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258525);
        return 0;
      case 2: 
        localnq.longitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258525);
        return 0;
      }
      localnq.YPF = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(258525);
      return 0;
    }
    AppMethodBeat.o(258525);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */