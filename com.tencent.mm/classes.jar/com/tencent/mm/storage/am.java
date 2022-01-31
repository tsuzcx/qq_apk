package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bv.a
{
  public int yMB;
  public LinkedList<Integer> yMC;
  public LinkedList<Integer> yMD;
  public LinkedList<Integer> yME;
  public LinkedList<Long> yMF;
  public LinkedList<Long> yMG;
  public LinkedList<Long> yMH;
  
  public am()
  {
    AppMethodBeat.i(60134);
    this.yMC = new LinkedList();
    this.yMD = new LinkedList();
    this.yME = new LinkedList();
    this.yMF = new LinkedList();
    this.yMG = new LinkedList();
    this.yMH = new LinkedList();
    AppMethodBeat.o(60134);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60135);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yMB);
      paramVarArgs.e(2, 2, this.yMC);
      paramVarArgs.e(3, 2, this.yMD);
      paramVarArgs.e(4, 2, this.yME);
      paramVarArgs.e(5, 3, this.yMF);
      paramVarArgs.e(6, 3, this.yMG);
      paramVarArgs.e(7, 3, this.yMH);
      AppMethodBeat.o(60135);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.yMB);
      int i = e.a.a.a.c(2, 2, this.yMC);
      int j = e.a.a.a.c(3, 2, this.yMD);
      int k = e.a.a.a.c(4, 2, this.yME);
      int m = e.a.a.a.c(5, 3, this.yMF);
      int n = e.a.a.a.c(6, 3, this.yMG);
      int i1 = e.a.a.a.c(7, 3, this.yMH);
      AppMethodBeat.o(60135);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yMC.clear();
      this.yMD.clear();
      this.yME.clear();
      this.yMF.clear();
      this.yMG.clear();
      this.yMH.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60135);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60135);
        return -1;
      case 1: 
        localam.yMB = locala.CLY.sl();
        AppMethodBeat.o(60135);
        return 0;
      case 2: 
        localam.yMC.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(60135);
        return 0;
      case 3: 
        localam.yMD.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(60135);
        return 0;
      case 4: 
        localam.yME.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(60135);
        return 0;
      case 5: 
        localam.yMF.add(Long.valueOf(locala.CLY.sm()));
        AppMethodBeat.o(60135);
        return 0;
      case 6: 
        localam.yMG.add(Long.valueOf(locala.CLY.sm()));
        AppMethodBeat.o(60135);
        return 0;
      }
      localam.yMH.add(Long.valueOf(locala.CLY.sm()));
      AppMethodBeat.o(60135);
      return 0;
    }
    AppMethodBeat.o(60135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */