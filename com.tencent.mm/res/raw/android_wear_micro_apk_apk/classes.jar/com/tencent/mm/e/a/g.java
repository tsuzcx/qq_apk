package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class g
  extends com.tencent.mm.d.a
{
  public LinkedList<String> Xp = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).b(1, 1, this.Xp);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 1, this.Xp) + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Xp.clear();
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
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      }
      localg.Xp.add(locala.ph());
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.g
 * JD-Core Version:    0.7.0.1
 */