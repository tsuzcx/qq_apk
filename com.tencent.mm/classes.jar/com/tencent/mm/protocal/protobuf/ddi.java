package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddi
  extends com.tencent.mm.bw.a
{
  public float LbC;
  public float LbD;
  public int LuT;
  public String LuU;
  public String LuV;
  public int LuW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152663);
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
      AppMethodBeat.o(152663);
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
      paramInt = g.a.a.b.b.a.bu(6, this.LuW);
      AppMethodBeat.o(152663);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ddi localddi = (ddi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152663);
        return -1;
      case 1: 
        localddi.LbC = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(152663);
        return 0;
      case 2: 
        localddi.LbD = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(152663);
        return 0;
      case 3: 
        localddi.LuT = locala.UbS.zi();
        AppMethodBeat.o(152663);
        return 0;
      case 4: 
        localddi.LuU = locala.UbS.readString();
        AppMethodBeat.o(152663);
        return 0;
      case 5: 
        localddi.LuV = locala.UbS.readString();
        AppMethodBeat.o(152663);
        return 0;
      }
      localddi.LuW = locala.UbS.zi();
      AppMethodBeat.o(152663);
      return 0;
    }
    AppMethodBeat.o(152663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddi
 * JD-Core Version:    0.7.0.1
 */