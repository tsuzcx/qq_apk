package com.tencent.mm.protocal.c;

public final class btd
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kVs;
  public int mPL;
  public int swS;
  public String sxM;
  public String tJO;
  public int tJt;
  public int tJu;
  public int tJv;
  public long tJw;
  public long tJx;
  public int tJz;
  public String tqh;
  public int ttD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxM != null) {
        paramVarArgs.d(1, this.sxM);
      }
      if (this.tqh != null) {
        paramVarArgs.d(2, this.tqh);
      }
      paramVarArgs.gB(3, this.swS);
      paramVarArgs.gB(4, this.hQR);
      if (this.kVs != null) {
        paramVarArgs.d(5, this.kVs);
      }
      paramVarArgs.gB(6, this.mPL);
      paramVarArgs.gB(7, this.tJu);
      paramVarArgs.gB(8, this.tJt);
      if (this.tJO != null) {
        paramVarArgs.d(9, this.tJO);
      }
      paramVarArgs.gB(10, this.tJv);
      paramVarArgs.Y(11, this.tJw);
      paramVarArgs.Y(12, this.tJx);
      paramVarArgs.gB(13, this.ttD);
      paramVarArgs.gB(14, this.tJz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxM == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tqh != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tqh);
      }
      i = i + d.a.a.a.gy(3, this.swS) + d.a.a.a.gy(4, this.hQR);
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kVs);
      }
      i = paramInt + d.a.a.a.gy(6, this.mPL) + d.a.a.a.gy(7, this.tJu) + d.a.a.a.gy(8, this.tJt);
      paramInt = i;
      if (this.tJO != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tJO);
      }
      return paramInt + d.a.a.a.gy(10, this.tJv) + d.a.a.a.X(11, this.tJw) + d.a.a.a.X(12, this.tJx) + d.a.a.a.gy(13, this.ttD) + d.a.a.a.gy(14, this.tJz);
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
        btd localbtd = (btd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbtd.sxM = locala.xpH.readString();
          return 0;
        case 2: 
          localbtd.tqh = locala.xpH.readString();
          return 0;
        case 3: 
          localbtd.swS = locala.xpH.oD();
          return 0;
        case 4: 
          localbtd.hQR = locala.xpH.oD();
          return 0;
        case 5: 
          localbtd.kVs = locala.xpH.readString();
          return 0;
        case 6: 
          localbtd.mPL = locala.xpH.oD();
          return 0;
        case 7: 
          localbtd.tJu = locala.xpH.oD();
          return 0;
        case 8: 
          localbtd.tJt = locala.xpH.oD();
          return 0;
        case 9: 
          localbtd.tJO = locala.xpH.readString();
          return 0;
        case 10: 
          localbtd.tJv = locala.xpH.oD();
          return 0;
        case 11: 
          localbtd.tJw = locala.xpH.oE();
          return 0;
        case 12: 
          localbtd.tJx = locala.xpH.oE();
          return 0;
        case 13: 
          localbtd.ttD = locala.xpH.oD();
          return 0;
        }
        localbtd.tJz = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.btd
 * JD-Core Version:    0.7.0.1
 */