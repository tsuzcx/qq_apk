package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmy
  extends com.tencent.mm.cd.a
{
  public float ScO;
  public float ScP;
  public int Sxt;
  public String Sxu;
  public String Sxv;
  public int Sxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.ScO);
      paramVarArgs.i(2, this.ScP);
      paramVarArgs.aY(3, this.Sxt);
      if (this.Sxu != null) {
        paramVarArgs.f(4, this.Sxu);
      }
      if (this.Sxv != null) {
        paramVarArgs.f(5, this.Sxv);
      }
      paramVarArgs.aY(6, this.Sxw);
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 4 + 0 + (g.a.a.b.b.a.gL(2) + 4) + g.a.a.b.b.a.bM(3, this.Sxt);
      paramInt = i;
      if (this.Sxu != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sxu);
      }
      i = paramInt;
      if (this.Sxv != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sxv);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.Sxw);
      AppMethodBeat.o(152663);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dmy localdmy = (dmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152663);
        return -1;
      case 1: 
        localdmy.ScO = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(152663);
        return 0;
      case 2: 
        localdmy.ScP = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(152663);
        return 0;
      case 3: 
        localdmy.Sxt = locala.abFh.AK();
        AppMethodBeat.o(152663);
        return 0;
      case 4: 
        localdmy.Sxu = locala.abFh.readString();
        AppMethodBeat.o(152663);
        return 0;
      case 5: 
        localdmy.Sxv = locala.abFh.readString();
        AppMethodBeat.o(152663);
        return 0;
      }
      localdmy.Sxw = locala.abFh.AK();
      AppMethodBeat.o(152663);
      return 0;
    }
    AppMethodBeat.o(152663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmy
 * JD-Core Version:    0.7.0.1
 */