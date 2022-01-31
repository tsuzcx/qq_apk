package com.tencent.mm.protocal.c;

public final class gb
  extends com.tencent.mm.bv.a
{
  public String imei;
  public String sAg;
  public String sAh;
  public String sAi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.d(1, this.imei);
      }
      if (this.sAg != null) {
        paramVarArgs.d(2, this.sAg);
      }
      if (this.sAh != null) {
        paramVarArgs.d(3, this.sAh);
      }
      if (this.sAi != null) {
        paramVarArgs.d(4, this.sAi);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAg != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAg);
      }
      i = paramInt;
      if (this.sAh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAh);
      }
      paramInt = i;
      if (this.sAi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sAi);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        gb localgb = (gb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localgb.imei = locala.xpH.readString();
          return 0;
        case 2: 
          localgb.sAg = locala.xpH.readString();
          return 0;
        case 3: 
          localgb.sAh = locala.xpH.readString();
          return 0;
        }
        localgb.sAi = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.gb
 * JD-Core Version:    0.7.0.1
 */