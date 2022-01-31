package com.tencent.mm.e.a;

import a.a.a.b;

public final class d
  extends com.tencent.mm.d.a
{
  public int Vq;
  public String Vr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Vr == null) {
        throw new b("Not all required fields were included: MD5");
      }
      paramVarArgs.aq(1, this.Vq);
      if (this.Vr != null) {
        paramVarArgs.d(2, this.Vr);
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
      i = a.a.a.a.ak(1, this.Vq) + 0;
      paramInt = i;
    } while (this.Vr == null);
    return i + a.a.a.b.b.a.e(2, this.Vr);
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
      for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.oz();
        }
      }
      if (this.Vr == null) {
        throw new b("Not all required fields were included: MD5");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locald.Vq = locala.ot();
        return 0;
      }
      locald.Vr = locala.ou();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.d
 * JD-Core Version:    0.7.0.1
 */