package com.tencent.mm.e.a;

import java.util.LinkedList;

public final class v
  extends com.tencent.mm.d.a
{
  public LinkedList<Integer> Wc = new LinkedList();
  public boolean Wd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, 2, this.Wc);
      paramVarArgs.g(2, this.Wd);
      return 0;
    }
    if (paramInt == 1) {
      return a.a.a.a.a(1, 2, this.Wc) + 0 + (a.a.a.b.b.a.cp(2) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Wc.clear();
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
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localv.Wc.add(Integer.valueOf(locala.ot()));
        return 0;
      }
      localv.Wd = locala.ov();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.v
 * JD-Core Version:    0.7.0.1
 */