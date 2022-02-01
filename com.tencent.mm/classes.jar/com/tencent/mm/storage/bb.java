package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.cd.a
{
  public int VER;
  public LinkedList<Integer> VES;
  public LinkedList<Integer> VET;
  public LinkedList<Integer> VEU;
  public LinkedList<Long> VEV;
  public LinkedList<Long> VEW;
  public LinkedList<Long> VEX;
  
  public bb()
  {
    AppMethodBeat.i(43195);
    this.VES = new LinkedList();
    this.VET = new LinkedList();
    this.VEU = new LinkedList();
    this.VEV = new LinkedList();
    this.VEW = new LinkedList();
    this.VEX = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.VER);
      paramVarArgs.e(2, 2, this.VES);
      paramVarArgs.e(3, 2, this.VET);
      paramVarArgs.e(4, 2, this.VEU);
      paramVarArgs.e(5, 3, this.VEV);
      paramVarArgs.e(6, 3, this.VEW);
      paramVarArgs.e(7, 3, this.VEX);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.VER);
      int i = g.a.a.a.c(2, 2, this.VES);
      int j = g.a.a.a.c(3, 2, this.VET);
      int k = g.a.a.a.c(4, 2, this.VEU);
      int m = g.a.a.a.c(5, 3, this.VEV);
      int n = g.a.a.a.c(6, 3, this.VEW);
      int i1 = g.a.a.a.c(7, 3, this.VEX);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.VES.clear();
      this.VET.clear();
      this.VEU.clear();
      this.VEV.clear();
      this.VEW.clear();
      this.VEX.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localbb.VER = locala.abFh.AK();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localbb.VES.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localbb.VET.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localbb.VEU.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localbb.VEV.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localbb.VEW.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localbb.VEX.add(Long.valueOf(locala.abFh.AN()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */