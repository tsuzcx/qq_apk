package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvf
  extends com.tencent.mm.bw.a
{
  public int KXP;
  public int Llx;
  public int MAD;
  public String MAE;
  public String MAG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXP);
      if (this.MAG != null) {
        paramVarArgs.e(3, this.MAG);
      }
      paramVarArgs.aM(4, this.MAD);
      paramVarArgs.aM(5, this.Llx);
      if (this.MAE != null) {
        paramVarArgs.e(6, this.MAE);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KXP) + 0;
      paramInt = i;
      if (this.MAG != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MAG);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MAD) + g.a.a.b.b.a.bu(5, this.Llx);
      paramInt = i;
      if (this.MAE != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MAE);
      }
      AppMethodBeat.o(43114);
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
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cvf localcvf = (cvf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localcvf.KXP = locala.UbS.zi();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localcvf.MAG = locala.UbS.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localcvf.MAD = locala.UbS.zi();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localcvf.Llx = locala.UbS.zi();
        AppMethodBeat.o(43114);
        return 0;
      }
      localcvf.MAE = locala.UbS.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvf
 * JD-Core Version:    0.7.0.1
 */