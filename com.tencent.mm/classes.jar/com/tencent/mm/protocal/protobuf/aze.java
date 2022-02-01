package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aze
  extends com.tencent.mm.bw.a
{
  public long LIV;
  public int dYx;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LIV);
      paramVarArgs.aM(2, this.dYx);
      if (this.objectNonceId != null) {
        paramVarArgs.e(3, this.objectNonceId);
      }
      AppMethodBeat.o(209611);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LIV) + 0 + g.a.a.b.b.a.bu(2, this.dYx);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.objectNonceId);
      }
      AppMethodBeat.o(209611);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209611);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aze localaze = (aze)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209611);
        return -1;
      case 1: 
        localaze.LIV = locala.UbS.zl();
        AppMethodBeat.o(209611);
        return 0;
      case 2: 
        localaze.dYx = locala.UbS.zi();
        AppMethodBeat.o(209611);
        return 0;
      }
      localaze.objectNonceId = locala.UbS.readString();
      AppMethodBeat.o(209611);
      return 0;
    }
    AppMethodBeat.o(209611);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aze
 * JD-Core Version:    0.7.0.1
 */