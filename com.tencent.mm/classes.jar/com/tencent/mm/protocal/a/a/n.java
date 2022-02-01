package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int KAy;
  public int KBh;
  public int KBi;
  public int KBj;
  public int KBk;
  public int KBl;
  public int KBm;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KAy);
      paramVarArgs.aM(2, this.KBh);
      paramVarArgs.aM(3, this.KBi);
      paramVarArgs.aM(4, this.KBj);
      paramVarArgs.aM(5, this.KBk);
      paramVarArgs.aM(6, this.KBl);
      paramVarArgs.aM(7, this.KBm);
      paramVarArgs.aM(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KAy);
      int i = g.a.a.b.b.a.bu(2, this.KBh);
      int j = g.a.a.b.b.a.bu(3, this.KBi);
      int k = g.a.a.b.b.a.bu(4, this.KBj);
      int m = g.a.a.b.b.a.bu(5, this.KBk);
      int n = g.a.a.b.b.a.bu(6, this.KBl);
      int i1 = g.a.a.b.b.a.bu(7, this.KBm);
      int i2 = g.a.a.b.b.a.bu(8, this.type);
      AppMethodBeat.o(143958);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143958);
        return -1;
      case 1: 
        localn.KAy = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.KBh = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.KBi = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.KBj = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.KBk = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.KBl = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.KBm = locala.UbS.zi();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.UbS.zi();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */