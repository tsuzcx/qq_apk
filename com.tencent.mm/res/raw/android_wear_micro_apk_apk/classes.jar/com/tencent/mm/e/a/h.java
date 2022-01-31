package com.tencent.mm.e.a;

import a.a.a.b;

public final class h
  extends com.tencent.mm.d.a
{
  public int Vv;
  public String Vw;
  public String Vx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Vx == null) {
        throw new b("Not all required fields were included: Content");
      }
      paramVarArgs.aq(1, this.Vv);
      if (this.Vw != null) {
        paramVarArgs.d(2, this.Vw);
      }
      if (this.Vx != null) {
        paramVarArgs.d(3, this.Vx);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = a.a.a.a.ak(1, this.Vv) + 0;
      paramInt = i;
      if (this.Vw != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Vw);
      }
      i = paramInt;
    } while (this.Vx == null);
    return paramInt + a.a.a.b.b.a.e(3, this.Vx);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Vw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.Vx == null) {
        throw new b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localh.Vv = locala.ot();
        return 0;
      case 2: 
        localh.Vw = locala.ou();
        return 0;
      }
      localh.Vx = locala.ou();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.h
 * JD-Core Version:    0.7.0.1
 */