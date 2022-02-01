package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecz
  extends com.tencent.mm.bw.a
{
  public int Ndq;
  public boolean Ndr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ndq);
      paramVarArgs.cc(2, this.Ndr);
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Ndq);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(116476);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116476);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ecz localecz = (ecz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116476);
        return -1;
      case 1: 
        localecz.Ndq = locala.UbS.zi();
        AppMethodBeat.o(116476);
        return 0;
      }
      localecz.Ndr = locala.UbS.yZ();
      AppMethodBeat.o(116476);
      return 0;
    }
    AppMethodBeat.o(116476);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecz
 * JD-Core Version:    0.7.0.1
 */