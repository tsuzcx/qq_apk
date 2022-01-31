package com.tencent.mm.e.a;

import a.a.a.b;

public final class a
  extends com.tencent.mm.d.a
{
  public long Vl;
  public String Vm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vm == null) {
        throw new b("Not all required fields were included: Username");
      }
      paramVarArgs.g(1, this.Vl);
      if (this.Vm != null) {
        paramVarArgs.d(2, this.Vm);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.e(1, this.Vl) + 0;
      paramInt = i;
    } while (this.Vm == null);
    return i + a.a.a.b.b.a.e(2, this.Vm);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Vm == null) {
        throw new b("Not all required fields were included: Username");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locala1.Vl = locala.ow();
        return 0;
      }
      locala1.Vm = locala.ou();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.a
 * JD-Core Version:    0.7.0.1
 */