package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class v
  extends com.tencent.mm.d.a
{
  public LinkedList<Integer> XX = new LinkedList();
  public boolean XY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, 2, this.XX);
      paramVarArgs.h(2, this.XY);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 2, this.XX) + 0 + (a.a.a.b.b.a.cK(2) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.XX.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Xe);
      for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.pm();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localv.XX.add(Integer.valueOf(locala.pg()));
        return 0;
      }
      localv.XY = locala.pi();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.v
 * JD-Core Version:    0.7.0.1
 */