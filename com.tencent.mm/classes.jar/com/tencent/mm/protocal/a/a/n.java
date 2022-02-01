package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.cd.a
{
  public int RCX;
  public int RCY;
  public int RCZ;
  public int RCo;
  public int RDa;
  public int RDb;
  public int RDc;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCo);
      paramVarArgs.aY(2, this.RCX);
      paramVarArgs.aY(3, this.RCY);
      paramVarArgs.aY(4, this.RCZ);
      paramVarArgs.aY(5, this.RDa);
      paramVarArgs.aY(6, this.RDb);
      paramVarArgs.aY(7, this.RDc);
      paramVarArgs.aY(8, this.type);
      AppMethodBeat.o(143958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RCo);
      int i = g.a.a.b.b.a.bM(2, this.RCX);
      int j = g.a.a.b.b.a.bM(3, this.RCY);
      int k = g.a.a.b.b.a.bM(4, this.RCZ);
      int m = g.a.a.b.b.a.bM(5, this.RDa);
      int n = g.a.a.b.b.a.bM(6, this.RDb);
      int i1 = g.a.a.b.b.a.bM(7, this.RDc);
      int i2 = g.a.a.b.b.a.bM(8, this.type);
      AppMethodBeat.o(143958);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        localn.RCo = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 2: 
        localn.RCX = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 3: 
        localn.RCY = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 4: 
        localn.RCZ = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 5: 
        localn.RDa = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 6: 
        localn.RDb = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      case 7: 
        localn.RDc = locala.abFh.AK();
        AppMethodBeat.o(143958);
        return 0;
      }
      localn.type = locala.abFh.AK();
      AppMethodBeat.o(143958);
      return 0;
    }
    AppMethodBeat.o(143958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.n
 * JD-Core Version:    0.7.0.1
 */