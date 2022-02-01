package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fay
  extends com.tencent.mm.bw.a
{
  public int Mro;
  public String Nxq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145672);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mro);
      if (this.Nxq != null) {
        paramVarArgs.e(2, this.Nxq);
      }
      AppMethodBeat.o(145672);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Mro) + 0;
      paramInt = i;
      if (this.Nxq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nxq);
      }
      AppMethodBeat.o(145672);
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
      AppMethodBeat.o(145672);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fay localfay = (fay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(145672);
        return -1;
      case 1: 
        localfay.Mro = locala.UbS.zi();
        AppMethodBeat.o(145672);
        return 0;
      }
      localfay.Nxq = locala.UbS.readString();
      AppMethodBeat.o(145672);
      return 0;
    }
    AppMethodBeat.o(145672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fay
 * JD-Core Version:    0.7.0.1
 */