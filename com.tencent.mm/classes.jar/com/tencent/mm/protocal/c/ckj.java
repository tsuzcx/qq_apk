package com.tencent.mm.protocal.c;

public final class ckj
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public int hQR;
  public String kWm;
  public int mPL;
  public String svK;
  public int tXL;
  public int ttf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWm != null) {
        paramVarArgs.d(1, this.kWm);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.hPS);
      paramVarArgs.gB(4, this.mPL);
      paramVarArgs.gB(5, this.ttf);
      if (this.svK != null) {
        paramVarArgs.d(6, this.svK);
      }
      paramVarArgs.gB(7, this.tXL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWm == null) {
        break label425;
      }
    }
    label425:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWm) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.hPS) + d.a.a.a.gy(4, this.mPL) + d.a.a.a.gy(5, this.ttf);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.svK);
      }
      return paramInt + d.a.a.a.gy(7, this.tXL);
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
        ckj localckj = (ckj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localckj.kWm = locala.xpH.readString();
          return 0;
        case 2: 
          localckj.hQR = locala.xpH.oD();
          return 0;
        case 3: 
          localckj.hPS = locala.xpH.oD();
          return 0;
        case 4: 
          localckj.mPL = locala.xpH.oD();
          return 0;
        case 5: 
          localckj.ttf = locala.xpH.oD();
          return 0;
        case 6: 
          localckj.svK = locala.xpH.readString();
          return 0;
        }
        localckj.tXL = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ckj
 * JD-Core Version:    0.7.0.1
 */