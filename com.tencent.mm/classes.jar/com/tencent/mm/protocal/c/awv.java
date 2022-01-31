package com.tencent.mm.protocal.c;

public final class awv
  extends com.tencent.mm.bv.a
{
  public int ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public String ffq;
  public String hPY;
  public int hQR;
  public String sLD;
  public String sLE;
  public int ttk;
  public int ttl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.ffh);
      if (this.ffj != null) {
        paramVarArgs.d(4, this.ffj);
      }
      if (this.ffi != null) {
        paramVarArgs.d(5, this.ffi);
      }
      if (this.ffk != null) {
        paramVarArgs.d(6, this.ffk);
      }
      paramVarArgs.gB(7, this.ttk);
      paramVarArgs.gB(8, this.ttl);
      if (this.ffq != null) {
        paramVarArgs.d(9, this.ffq);
      }
      if (this.sLD != null) {
        paramVarArgs.d(10, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(11, this.sLE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label673;
      }
    }
    label673:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.ffh);
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffj);
      }
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffi);
      }
      paramInt = i;
      if (this.ffk != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ffk);
      }
      i = paramInt + d.a.a.a.gy(7, this.ttk) + d.a.a.a.gy(8, this.ttl);
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ffq);
      }
      i = paramInt;
      if (this.sLD != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sLD);
      }
      paramInt = i;
      if (this.sLE != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sLE);
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
        awv localawv = (awv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localawv.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localawv.hQR = locala.xpH.oD();
          return 0;
        case 3: 
          localawv.ffh = locala.xpH.oD();
          return 0;
        case 4: 
          localawv.ffj = locala.xpH.readString();
          return 0;
        case 5: 
          localawv.ffi = locala.xpH.readString();
          return 0;
        case 6: 
          localawv.ffk = locala.xpH.readString();
          return 0;
        case 7: 
          localawv.ttk = locala.xpH.oD();
          return 0;
        case 8: 
          localawv.ttl = locala.xpH.oD();
          return 0;
        case 9: 
          localawv.ffq = locala.xpH.readString();
          return 0;
        case 10: 
          localawv.sLD = locala.xpH.readString();
          return 0;
        }
        localawv.sLE = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awv
 * JD-Core Version:    0.7.0.1
 */