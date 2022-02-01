package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdm
  extends com.tencent.mm.bw.a
{
  public int Nza;
  public int Nzb;
  public int Nzc;
  public int Nzd;
  public int Nze;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nza);
      paramVarArgs.aM(2, this.Nzb);
      paramVarArgs.aM(3, this.Nzc);
      paramVarArgs.aM(4, this.Nzd);
      paramVarArgs.aM(5, this.Nze);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Nza);
      int i = g.a.a.b.b.a.bu(2, this.Nzb);
      int j = g.a.a.b.b.a.bu(3, this.Nzc);
      int k = g.a.a.b.b.a.bu(4, this.Nzd);
      int m = g.a.a.b.b.a.bu(5, this.Nze);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdm localfdm = (fdm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localfdm.Nza = locala.UbS.zi();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localfdm.Nzb = locala.UbS.zi();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localfdm.Nzc = locala.UbS.zi();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localfdm.Nzd = locala.UbS.zi();
        AppMethodBeat.o(50122);
        return 0;
      }
      localfdm.Nze = locala.UbS.zi();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdm
 * JD-Core Version:    0.7.0.1
 */