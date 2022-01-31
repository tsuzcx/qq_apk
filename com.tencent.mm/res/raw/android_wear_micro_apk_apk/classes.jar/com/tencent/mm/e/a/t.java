package com.tencent.mm.e.a;

import a.a.a.b;

public final class t
  extends com.tencent.mm.d.a
{
  public long VY;
  public boolean VZ;
  public String Vm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vm == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.Vm != null) {
        paramVarArgs.d(1, this.Vm);
      }
      paramVarArgs.g(2, this.VY);
      paramVarArgs.g(3, this.VZ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vm == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = a.a.a.b.b.a.e(1, this.Vm) + 0;; paramInt = 0)
    {
      return paramInt + a.a.a.a.e(2, this.VY) + (a.a.a.b.b.a.cp(3) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.Vm != null) {
          break;
        }
        throw new b("Not all required fields were included: Username");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localt.Vm = locala.ou();
          return 0;
        case 2: 
          localt.VY = locala.ow();
          return 0;
        }
        localt.VZ = locala.ov();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.t
 * JD-Core Version:    0.7.0.1
 */