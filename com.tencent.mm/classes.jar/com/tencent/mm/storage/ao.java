package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
  extends com.tencent.mm.bx.a
{
  public int Fyi;
  public LinkedList<Integer> Fyj;
  public LinkedList<Integer> Fyk;
  public LinkedList<Integer> Fyl;
  public LinkedList<Long> Fym;
  public LinkedList<Long> Fyn;
  public LinkedList<Long> Fyo;
  
  public ao()
  {
    AppMethodBeat.i(43195);
    this.Fyj = new LinkedList();
    this.Fyk = new LinkedList();
    this.Fyl = new LinkedList();
    this.Fym = new LinkedList();
    this.Fyn = new LinkedList();
    this.Fyo = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fyi);
      paramVarArgs.e(2, 2, this.Fyj);
      paramVarArgs.e(3, 2, this.Fyk);
      paramVarArgs.e(4, 2, this.Fyl);
      paramVarArgs.e(5, 3, this.Fym);
      paramVarArgs.e(6, 3, this.Fyn);
      paramVarArgs.e(7, 3, this.Fyo);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Fyi);
      int i = f.a.a.a.c(2, 2, this.Fyj);
      int j = f.a.a.a.c(3, 2, this.Fyk);
      int k = f.a.a.a.c(4, 2, this.Fyl);
      int m = f.a.a.a.c(5, 3, this.Fym);
      int n = f.a.a.a.c(6, 3, this.Fyn);
      int i1 = f.a.a.a.c(7, 3, this.Fyo);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fyj.clear();
      this.Fyk.clear();
      this.Fyl.clear();
      this.Fym.clear();
      this.Fyn.clear();
      this.Fyo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localao.Fyi = locala.KhF.xS();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localao.Fyj.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localao.Fyk.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localao.Fyl.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localao.Fym.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localao.Fyn.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localao.Fyo.add(Long.valueOf(locala.KhF.xT()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ao
 * JD-Core Version:    0.7.0.1
 */