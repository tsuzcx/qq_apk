package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eko
  extends com.tencent.mm.bw.a
{
  public long NjG;
  public long NjH;
  public long NjI;
  public double NjJ;
  public double NjK;
  public double NjL;
  public double NjM;
  public long NjN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NjG);
      paramVarArgs.bb(2, this.NjH);
      paramVarArgs.bb(3, this.NjI);
      paramVarArgs.e(4, this.NjJ);
      paramVarArgs.e(5, this.NjK);
      paramVarArgs.e(6, this.NjL);
      paramVarArgs.e(7, this.NjM);
      paramVarArgs.bb(8, this.NjN);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.NjG);
      int i = g.a.a.b.b.a.r(2, this.NjH);
      int j = g.a.a.b.b.a.r(3, this.NjI);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      int i1 = g.a.a.b.b.a.fS(7);
      int i2 = g.a.a.b.b.a.r(8, this.NjN);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + (k + 8) + (m + 8) + (n + 8) + (i1 + 8) + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eko localeko = (eko)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localeko.NjG = locala.UbS.zl();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localeko.NjH = locala.UbS.zl();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localeko.NjI = locala.UbS.zl();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localeko.NjJ = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localeko.NjK = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localeko.NjL = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localeko.NjM = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(110914);
        return 0;
      }
      localeko.NjN = locala.UbS.zl();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eko
 * JD-Core Version:    0.7.0.1
 */