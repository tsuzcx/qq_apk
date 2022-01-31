package com.tencent.mm.protocal.c;

public final class chp
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String lsL;
  public int svx;
  public String syc;
  public String tAh;
  public String tWt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.tAh != null) {
        paramVarArgs.d(2, this.tAh);
      }
      if (this.lsL != null) {
        paramVarArgs.d(3, this.lsL);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.tWt != null) {
        paramVarArgs.d(5, this.tWt);
      }
      paramVarArgs.gB(6, this.svx);
      if (this.syc != null) {
        paramVarArgs.d(7, this.syc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label497;
      }
    }
    label497:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tAh != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tAh);
      }
      i = paramInt;
      if (this.lsL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.lsL);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.tWt != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tWt);
      }
      i += d.a.a.a.gy(6, this.svx);
      paramInt = i;
      if (this.syc != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.syc);
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
        chp localchp = (chp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localchp.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localchp.tAh = locala.xpH.readString();
          return 0;
        case 3: 
          localchp.lsL = locala.xpH.readString();
          return 0;
        case 4: 
          localchp.kRN = locala.xpH.readString();
          return 0;
        case 5: 
          localchp.tWt = locala.xpH.readString();
          return 0;
        case 6: 
          localchp.svx = locala.xpH.oD();
          return 0;
        }
        localchp.syc = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chp
 * JD-Core Version:    0.7.0.1
 */