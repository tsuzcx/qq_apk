package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class c
  extends com.tencent.mm.bw.a
{
  public int type;
  public int zGB;
  public int zGC;
  public long zGD;
  public long zGE;
  public double zGF;
  public String zGG;
  public b zGH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194273);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      paramVarArgs.aM(2, this.zGB);
      paramVarArgs.aM(3, this.zGC);
      paramVarArgs.bb(4, this.zGD);
      paramVarArgs.bb(5, this.zGE);
      paramVarArgs.e(6, this.zGF);
      if (this.zGG != null) {
        paramVarArgs.e(7, this.zGG);
      }
      if (this.zGH != null) {
        paramVarArgs.c(8, this.zGH);
      }
      AppMethodBeat.o(194273);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.zGB) + g.a.a.b.b.a.bu(3, this.zGC) + g.a.a.b.b.a.r(4, this.zGD) + g.a.a.b.b.a.r(5, this.zGE) + (g.a.a.b.b.a.fS(6) + 8);
      paramInt = i;
      if (this.zGG != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.zGG);
      }
      i = paramInt;
      if (this.zGH != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.zGH);
      }
      AppMethodBeat.o(194273);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(194273);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194273);
        return -1;
      case 1: 
        localc.type = locala.UbS.zi();
        AppMethodBeat.o(194273);
        return 0;
      case 2: 
        localc.zGB = locala.UbS.zi();
        AppMethodBeat.o(194273);
        return 0;
      case 3: 
        localc.zGC = locala.UbS.zi();
        AppMethodBeat.o(194273);
        return 0;
      case 4: 
        localc.zGD = locala.UbS.zl();
        AppMethodBeat.o(194273);
        return 0;
      case 5: 
        localc.zGE = locala.UbS.zl();
        AppMethodBeat.o(194273);
        return 0;
      case 6: 
        localc.zGF = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(194273);
        return 0;
      case 7: 
        localc.zGG = locala.UbS.readString();
        AppMethodBeat.o(194273);
        return 0;
      }
      localc.zGH = locala.UbS.hPo();
      AppMethodBeat.o(194273);
      return 0;
    }
    AppMethodBeat.o(194273);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.c
 * JD-Core Version:    0.7.0.1
 */