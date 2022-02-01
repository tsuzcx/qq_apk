package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpe
  extends com.tencent.mm.bw.a
{
  public String UserName;
  public int kem;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.kem);
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      AppMethodBeat.o(124537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.kem) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      AppMethodBeat.o(124537);
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
      AppMethodBeat.o(124537);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cpe localcpe = (cpe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124537);
        return -1;
      case 1: 
        localcpe.kem = locala.UbS.zi();
        AppMethodBeat.o(124537);
        return 0;
      }
      localcpe.UserName = locala.UbS.readString();
      AppMethodBeat.o(124537);
      return 0;
    }
    AppMethodBeat.o(124537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpe
 * JD-Core Version:    0.7.0.1
 */