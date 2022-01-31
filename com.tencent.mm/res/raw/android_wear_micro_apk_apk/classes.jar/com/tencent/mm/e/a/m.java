package com.tencent.mm.e.a;

import a.a.a.b;

public final class m
  extends com.tencent.mm.d.a
{
  public String VL;
  public boolean VM;
  public String Vm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vm == null) {
        throw new b("Not all required fields were included: Username");
      }
      if (this.VL == null) {
        throw new b("Not all required fields were included: Language");
      }
      if (this.Vm != null) {
        paramVarArgs.d(1, this.Vm);
      }
      if (this.VL != null) {
        paramVarArgs.d(2, this.VL);
      }
      paramVarArgs.g(3, this.VM);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vm == null) {
        break label324;
      }
    }
    label324:
    for (paramInt = a.a.a.b.b.a.e(1, this.Vm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.VL != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.VL);
      }
      return i + (a.a.a.b.b.a.cp(3) + 1);
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
        if (this.VL != null) {
          break;
        }
        throw new b("Not all required fields were included: Language");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localm.Vm = locala.ou();
          return 0;
        case 2: 
          localm.VL = locala.ou();
          return 0;
        }
        localm.VM = locala.ov();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.m
 * JD-Core Version:    0.7.0.1
 */