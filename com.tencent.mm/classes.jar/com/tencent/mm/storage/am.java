package com.tencent.mm.storage;

import java.util.LinkedList;

public final class am
  extends com.tencent.mm.bv.a
{
  public int uAs;
  public LinkedList<Integer> uAt = new LinkedList();
  public LinkedList<Integer> uAu = new LinkedList();
  public LinkedList<Integer> uAv = new LinkedList();
  public LinkedList<Long> uAw = new LinkedList();
  public LinkedList<Long> uAx = new LinkedList();
  public LinkedList<Long> uAy = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uAs);
      paramVarArgs.d(2, 2, this.uAt);
      paramVarArgs.d(3, 2, this.uAu);
      paramVarArgs.d(4, 2, this.uAv);
      paramVarArgs.d(5, 3, this.uAw);
      paramVarArgs.d(6, 3, this.uAx);
      paramVarArgs.d(7, 3, this.uAy);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.uAs) + 0 + d.a.a.a.c(2, 2, this.uAt) + d.a.a.a.c(3, 2, this.uAu) + d.a.a.a.c(4, 2, this.uAv) + d.a.a.a.c(5, 3, this.uAw) + d.a.a.a.c(6, 3, this.uAx) + d.a.a.a.c(7, 3, this.uAy);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uAt.clear();
      this.uAu.clear();
      this.uAv.clear();
      this.uAw.clear();
      this.uAx.clear();
      this.uAy.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localam.uAs = locala.xpH.oD();
        return 0;
      case 2: 
        localam.uAt.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      case 3: 
        localam.uAu.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      case 4: 
        localam.uAv.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      case 5: 
        localam.uAw.add(Long.valueOf(locala.xpH.oE()));
        return 0;
      case 6: 
        localam.uAx.add(Long.valueOf(locala.xpH.oE()));
        return 0;
      }
      localam.uAy.add(Long.valueOf(locala.xpH.oE()));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */