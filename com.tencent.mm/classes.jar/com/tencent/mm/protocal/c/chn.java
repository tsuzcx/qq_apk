package com.tencent.mm.protocal.c;

public final class chn
  extends com.tencent.mm.bv.a
{
  public String kSF;
  public String kWn;
  public String tAh;
  public String tWp;
  public String tWq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tAh != null) {
        paramVarArgs.d(1, this.tAh);
      }
      if (this.tWp != null) {
        paramVarArgs.d(2, this.tWp);
      }
      if (this.kWn != null) {
        paramVarArgs.d(3, this.kWn);
      }
      if (this.kSF != null) {
        paramVarArgs.d(4, this.kSF);
      }
      if (this.tWq != null) {
        paramVarArgs.d(5, this.tWq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tAh == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.tAh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tWp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tWp);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWn);
      }
      paramInt = i;
      if (this.kSF != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSF);
      }
      i = paramInt;
      if (this.tWq != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tWq);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        chn localchn = (chn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localchn.tAh = locala.xpH.readString();
          return 0;
        case 2: 
          localchn.tWp = locala.xpH.readString();
          return 0;
        case 3: 
          localchn.kWn = locala.xpH.readString();
          return 0;
        case 4: 
          localchn.kSF = locala.xpH.readString();
          return 0;
        }
        localchn.tWq = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chn
 * JD-Core Version:    0.7.0.1
 */