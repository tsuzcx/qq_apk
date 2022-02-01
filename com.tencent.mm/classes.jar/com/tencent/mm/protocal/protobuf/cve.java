package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cve
  extends com.tencent.mm.bw.a
{
  public int KXP;
  public int Llx;
  public int MAD;
  public String MAE;
  public String MAF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32361);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXP);
      if (this.MAF != null) {
        paramVarArgs.e(3, this.MAF);
      }
      paramVarArgs.aM(4, this.MAD);
      paramVarArgs.aM(5, this.Llx);
      if (this.MAE != null) {
        paramVarArgs.e(6, this.MAE);
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.KXP) + 0;
      paramInt = i;
      if (this.MAF != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MAF);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MAD) + g.a.a.b.b.a.bu(5, this.Llx);
      paramInt = i;
      if (this.MAE != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MAE);
      }
      AppMethodBeat.o(32361);
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
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cve localcve = (cve)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(32361);
        return -1;
      case 1: 
        localcve.KXP = locala.UbS.zi();
        AppMethodBeat.o(32361);
        return 0;
      case 3: 
        localcve.MAF = locala.UbS.readString();
        AppMethodBeat.o(32361);
        return 0;
      case 4: 
        localcve.MAD = locala.UbS.zi();
        AppMethodBeat.o(32361);
        return 0;
      case 5: 
        localcve.Llx = locala.UbS.zi();
        AppMethodBeat.o(32361);
        return 0;
      }
      localcve.MAE = locala.UbS.readString();
      AppMethodBeat.o(32361);
      return 0;
    }
    AppMethodBeat.o(32361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cve
 * JD-Core Version:    0.7.0.1
 */