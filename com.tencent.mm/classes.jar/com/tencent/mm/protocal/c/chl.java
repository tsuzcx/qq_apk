package com.tencent.mm.protocal.c;

public final class chl
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String syc;
  public String tAh;
  public int tWj;
  public String tWk;
  public String tWl;
  public String tWm;
  public String tWn;
  public String tWo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.syc != null) {
        paramVarArgs.d(2, this.syc);
      }
      paramVarArgs.gB(3, this.tWj);
      if (this.tWk != null) {
        paramVarArgs.d(4, this.tWk);
      }
      if (this.tAh != null) {
        paramVarArgs.d(5, this.tAh);
      }
      if (this.tWl != null) {
        paramVarArgs.d(6, this.tWl);
      }
      if (this.tWm != null) {
        paramVarArgs.d(7, this.tWm);
      }
      if (this.tWn != null) {
        paramVarArgs.d(8, this.tWn);
      }
      if (this.tWo != null) {
        paramVarArgs.d(9, this.tWo);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label611;
      }
    }
    label611:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.syc);
      }
      i += d.a.a.a.gy(3, this.tWj);
      paramInt = i;
      if (this.tWk != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tWk);
      }
      i = paramInt;
      if (this.tAh != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tAh);
      }
      paramInt = i;
      if (this.tWl != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tWl);
      }
      i = paramInt;
      if (this.tWm != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tWm);
      }
      paramInt = i;
      if (this.tWn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tWn);
      }
      i = paramInt;
      if (this.tWo != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tWo);
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
        chl localchl = (chl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localchl.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localchl.syc = locala.xpH.readString();
          return 0;
        case 3: 
          localchl.tWj = locala.xpH.oD();
          return 0;
        case 4: 
          localchl.tWk = locala.xpH.readString();
          return 0;
        case 5: 
          localchl.tAh = locala.xpH.readString();
          return 0;
        case 6: 
          localchl.tWl = locala.xpH.readString();
          return 0;
        case 7: 
          localchl.tWm = locala.xpH.readString();
          return 0;
        case 8: 
          localchl.tWn = locala.xpH.readString();
          return 0;
        }
        localchl.tWo = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chl
 * JD-Core Version:    0.7.0.1
 */