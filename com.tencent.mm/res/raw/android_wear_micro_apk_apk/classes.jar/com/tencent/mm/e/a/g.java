package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class g
  extends com.tencent.mm.d.a
{
  public LinkedList<String> Vu = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).b(1, 1, this.Vu);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 1, this.Vu) + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Vu.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
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
      localg.Vu.add(locala.ou());
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.g
 * JD-Core Version:    0.7.0.1
 */