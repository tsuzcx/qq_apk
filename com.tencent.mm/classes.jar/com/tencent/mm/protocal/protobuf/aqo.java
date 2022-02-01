package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqo
  extends com.tencent.mm.bx.a
{
  public float GoH;
  public long dtq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.dtq);
      paramVarArgs.z(2, this.GoH);
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.dtq);
      int i = f.a.a.b.b.a.alU(2);
      AppMethodBeat.o(184208);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184208);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqo localaqo = (aqo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184208);
        return -1;
      case 1: 
        localaqo.dtq = locala.NPN.zd();
        AppMethodBeat.o(184208);
        return 0;
      }
      localaqo.GoH = Float.intBitsToFloat(locala.NPN.grz());
      AppMethodBeat.o(184208);
      return 0;
    }
    AppMethodBeat.o(184208);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqo
 * JD-Core Version:    0.7.0.1
 */