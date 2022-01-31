package com.tencent.mm.e.a;

import a.a.a.b;

public final class x
  extends com.tencent.mm.d.a
{
  public String VN;
  public int We;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.VN == null) {
        throw new b("Not all required fields were included: Talker");
      }
      if (this.VN != null) {
        paramVarArgs.d(1, this.VN);
      }
      paramVarArgs.aq(2, this.We);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VN == null) {
        break label238;
      }
    }
    label238:
    for (paramInt = a.a.a.b.b.a.e(1, this.VN) + 0;; paramInt = 0)
    {
      return paramInt + a.a.a.a.ak(2, this.We);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Vj);
        for (paramInt = paramVarArgs.oy(); paramInt > 0; paramInt = paramVarArgs.oy()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.oz();
          }
        }
        if (this.VN != null) {
          break;
        }
        throw new b("Not all required fields were included: Talker");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localx.VN = locala.ou();
          return 0;
        }
        localx.We = locala.ot();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.x
 * JD-Core Version:    0.7.0.1
 */