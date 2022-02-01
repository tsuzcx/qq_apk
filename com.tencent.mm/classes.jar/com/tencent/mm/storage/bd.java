package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bd
  extends com.tencent.mm.bx.a
{
  public int adiE;
  public LinkedList<Integer> adiF;
  public LinkedList<Integer> adiG;
  public LinkedList<Integer> adiH;
  public LinkedList<Long> adiI;
  public LinkedList<Long> adiJ;
  public LinkedList<Long> adiK;
  
  public bd()
  {
    AppMethodBeat.i(43195);
    this.adiF = new LinkedList();
    this.adiG = new LinkedList();
    this.adiH = new LinkedList();
    this.adiI = new LinkedList();
    this.adiJ = new LinkedList();
    this.adiK = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.adiE);
      paramVarArgs.e(2, 2, this.adiF);
      paramVarArgs.e(3, 2, this.adiG);
      paramVarArgs.e(4, 2, this.adiH);
      paramVarArgs.e(5, 3, this.adiI);
      paramVarArgs.e(6, 3, this.adiJ);
      paramVarArgs.e(7, 3, this.adiK);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.adiE);
      int i = i.a.a.a.c(2, 2, this.adiF);
      int j = i.a.a.a.c(3, 2, this.adiG);
      int k = i.a.a.a.c(4, 2, this.adiH);
      int m = i.a.a.a.c(5, 3, this.adiI);
      int n = i.a.a.a.c(6, 3, this.adiJ);
      int i1 = i.a.a.a.c(7, 3, this.adiK);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.adiF.clear();
      this.adiG.clear();
      this.adiH.clear();
      this.adiI.clear();
      this.adiJ.clear();
      this.adiK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bd localbd = (bd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localbd.adiE = locala.ajGk.aar();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localbd.adiF.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localbd.adiG.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localbd.adiH.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localbd.adiI.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localbd.adiJ.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localbd.adiK.add(Long.valueOf(locala.ajGk.aaw()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */