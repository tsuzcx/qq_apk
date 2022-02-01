package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> IKA;
  public LinkedList<Long> IKB;
  public LinkedList<Long> IKC;
  public int IKw;
  public LinkedList<Integer> IKx;
  public LinkedList<Integer> IKy;
  public LinkedList<Integer> IKz;
  
  public av()
  {
    AppMethodBeat.i(43195);
    this.IKx = new LinkedList();
    this.IKy = new LinkedList();
    this.IKz = new LinkedList();
    this.IKA = new LinkedList();
    this.IKB = new LinkedList();
    this.IKC = new LinkedList();
    AppMethodBeat.o(43195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IKw);
      paramVarArgs.e(2, 2, this.IKx);
      paramVarArgs.e(3, 2, this.IKy);
      paramVarArgs.e(4, 2, this.IKz);
      paramVarArgs.e(5, 3, this.IKA);
      paramVarArgs.e(6, 3, this.IKB);
      paramVarArgs.e(7, 3, this.IKC);
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.IKw);
      int i = f.a.a.a.c(2, 2, this.IKx);
      int j = f.a.a.a.c(3, 2, this.IKy);
      int k = f.a.a.a.c(4, 2, this.IKz);
      int m = f.a.a.a.c(5, 3, this.IKA);
      int n = f.a.a.a.c(6, 3, this.IKB);
      int i1 = f.a.a.a.c(7, 3, this.IKC);
      AppMethodBeat.o(43196);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IKx.clear();
      this.IKy.clear();
      this.IKz.clear();
      this.IKA.clear();
      this.IKB.clear();
      this.IKC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43196);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      av localav = (av)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43196);
        return -1;
      case 1: 
        localav.IKw = locala.NPN.zc();
        AppMethodBeat.o(43196);
        return 0;
      case 2: 
        localav.IKx.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 3: 
        localav.IKy.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 4: 
        localav.IKz.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(43196);
        return 0;
      case 5: 
        localav.IKA.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(43196);
        return 0;
      case 6: 
        localav.IKB.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(43196);
        return 0;
      }
      localav.IKC.add(Long.valueOf(locala.NPN.zd()));
      AppMethodBeat.o(43196);
      return 0;
    }
    AppMethodBeat.o(43196);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.av
 * JD-Core Version:    0.7.0.1
 */