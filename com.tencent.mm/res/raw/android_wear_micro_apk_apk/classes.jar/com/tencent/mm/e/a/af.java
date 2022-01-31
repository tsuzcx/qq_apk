package com.tencent.mm.e.a;

import a.a.a.b;

public final class af
  extends com.tencent.mm.d.a
{
  public String VN;
  public String Vr;
  public String Vt;
  public int Ws;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Vr == null) {
        throw new b("Not all required fields were included: MD5");
      }
      if (this.Vt == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      if (this.Vr != null) {
        paramVarArgs.d(2, this.Vr);
      }
      if (this.Vt != null) {
        paramVarArgs.d(3, this.Vt);
      }
      paramVarArgs.aq(4, this.Ws);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label412;
      }
    }
    label412:
    for (int i = a.a.a.b.b.a.e(1, this.VN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Vr != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Vr);
      }
      i = paramInt;
      if (this.Vt != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Vt);
      }
      return i + a.a.a.a.ak(4, this.Ws);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN == null) {
          throw new b("Not all required fields were included: Talker");
        }
        if (this.Vr == null) {
          throw new b("Not all required fields were included: MD5");
        }
        if (this.Vt != null) {
          break;
        }
        throw new b("Not all required fields were included: ProductId");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaf.VN = locala.ou();
          return 0;
        case 2: 
          localaf.Vr = locala.ou();
          return 0;
        case 3: 
          localaf.Vt = locala.ou();
          return 0;
        }
        localaf.Ws = locala.ot();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.af
 * JD-Core Version:    0.7.0.1
 */