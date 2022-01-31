package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class aqe
  extends com.tencent.mm.bv.a
{
  public String mQn;
  public String mSq;
  public String taz;
  public String tme;
  public String tmf;
  public String tmg;
  public String tmh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mSq == null) {
        throw new b("Not all required fields were included: product_id");
      }
      if (this.mQn == null) {
        throw new b("Not all required fields were included: price");
      }
      if (this.taz == null) {
        throw new b("Not all required fields were included: currency_type");
      }
      if (this.tme == null) {
        throw new b("Not all required fields were included: session_data");
      }
      if (this.mSq != null) {
        paramVarArgs.d(1, this.mSq);
      }
      if (this.mQn != null) {
        paramVarArgs.d(2, this.mQn);
      }
      if (this.taz != null) {
        paramVarArgs.d(3, this.taz);
      }
      if (this.tme != null) {
        paramVarArgs.d(4, this.tme);
      }
      if (this.tmf != null) {
        paramVarArgs.d(5, this.tmf);
      }
      if (this.tmg != null) {
        paramVarArgs.d(6, this.tmg);
      }
      if (this.tmh != null) {
        paramVarArgs.d(7, this.tmh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mSq == null) {
        break label649;
      }
    }
    label649:
    for (int i = d.a.a.b.b.a.e(1, this.mSq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mQn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mQn);
      }
      i = paramInt;
      if (this.taz != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.taz);
      }
      paramInt = i;
      if (this.tme != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tme);
      }
      i = paramInt;
      if (this.tmf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tmf);
      }
      paramInt = i;
      if (this.tmg != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmg);
      }
      i = paramInt;
      if (this.tmh != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tmh);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.mSq == null) {
          throw new b("Not all required fields were included: product_id");
        }
        if (this.mQn == null) {
          throw new b("Not all required fields were included: price");
        }
        if (this.taz == null) {
          throw new b("Not all required fields were included: currency_type");
        }
        if (this.tme != null) {
          break;
        }
        throw new b("Not all required fields were included: session_data");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aqe localaqe = (aqe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaqe.mSq = locala.xpH.readString();
          return 0;
        case 2: 
          localaqe.mQn = locala.xpH.readString();
          return 0;
        case 3: 
          localaqe.taz = locala.xpH.readString();
          return 0;
        case 4: 
          localaqe.tme = locala.xpH.readString();
          return 0;
        case 5: 
          localaqe.tmf = locala.xpH.readString();
          return 0;
        case 6: 
          localaqe.tmg = locala.xpH.readString();
          return 0;
        }
        localaqe.tmh = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqe
 * JD-Core Version:    0.7.0.1
 */