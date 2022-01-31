package com.tencent.mm.e.a;

import a.a.a.b;

public final class am
  extends com.tencent.mm.d.a
{
  public String VN;
  public boolean WD;
  public int WE;
  public String Wt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.Wt == null) {
        throw new b("Not all required fields were included: Text");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      if (this.Wt != null) {
        paramVarArgs.d(2, this.Wt);
      }
      paramVarArgs.g(3, this.WD);
      paramVarArgs.aq(4, this.WE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label356;
      }
    }
    label356:
    for (paramInt = a.a.a.b.b.a.e(1, this.VN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Wt != null) {
        i = paramInt + a.a.a.b.b.a.e(2, this.Wt);
      }
      return i + (a.a.a.b.b.a.cp(3) + 1) + a.a.a.a.ak(4, this.WE);
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
        if (this.Wt != null) {
          break;
        }
        throw new b("Not all required fields were included: Text");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localam.VN = locala.ou();
          return 0;
        case 2: 
          localam.Wt = locala.ou();
          return 0;
        case 3: 
          localam.WD = locala.ov();
          return 0;
        }
        localam.WE = locala.ot();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.am
 * JD-Core Version:    0.7.0.1
 */