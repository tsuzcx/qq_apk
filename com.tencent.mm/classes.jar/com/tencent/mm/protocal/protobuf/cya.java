package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cya
  extends com.tencent.mm.bw.a
{
  public int MCY;
  public String MCZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32367);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MCY);
      if (this.MCZ != null) {
        paramVarArgs.e(2, this.MCZ);
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MCY) + 0;
      paramInt = i;
      if (this.MCZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MCZ);
      }
      AppMethodBeat.o(32367);
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
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cya localcya = (cya)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32367);
        return -1;
      case 1: 
        localcya.MCY = locala.UbS.zi();
        AppMethodBeat.o(32367);
        return 0;
      }
      localcya.MCZ = locala.UbS.readString();
      AppMethodBeat.o(32367);
      return 0;
    }
    AppMethodBeat.o(32367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */