package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chl
  extends com.tencent.mm.bw.a
{
  public float LbC;
  public float LbD;
  public int LuT;
  public String LuU;
  public String LuV;
  public int LuW;
  public String MmX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.LbC);
      paramVarArgs.E(2, this.LbD);
      paramVarArgs.aM(3, this.LuT);
      if (this.LuU != null) {
        paramVarArgs.e(4, this.LuU);
      }
      if (this.LuV != null) {
        paramVarArgs.e(5, this.LuV);
      }
      paramVarArgs.aM(6, this.LuW);
      if (this.MmX != null) {
        paramVarArgs.e(7, this.MmX);
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 4 + 0 + (g.a.a.b.b.a.fS(2) + 4) + g.a.a.b.b.a.bu(3, this.LuT);
      paramInt = i;
      if (this.LuU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LuU);
      }
      i = paramInt;
      if (this.LuV != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LuV);
      }
      i += g.a.a.b.b.a.bu(6, this.LuW);
      paramInt = i;
      if (this.MmX != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MmX);
      }
      AppMethodBeat.o(117875);
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
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      chl localchl = (chl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117875);
        return -1;
      case 1: 
        localchl.LbC = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(117875);
        return 0;
      case 2: 
        localchl.LbD = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(117875);
        return 0;
      case 3: 
        localchl.LuT = locala.UbS.zi();
        AppMethodBeat.o(117875);
        return 0;
      case 4: 
        localchl.LuU = locala.UbS.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 5: 
        localchl.LuV = locala.UbS.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 6: 
        localchl.LuW = locala.UbS.zi();
        AppMethodBeat.o(117875);
        return 0;
      }
      localchl.MmX = locala.UbS.readString();
      AppMethodBeat.o(117875);
      return 0;
    }
    AppMethodBeat.o(117875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chl
 * JD-Core Version:    0.7.0.1
 */