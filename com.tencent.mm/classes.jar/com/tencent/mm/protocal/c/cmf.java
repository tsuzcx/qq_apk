package com.tencent.mm.protocal.c;

public final class cmf
  extends com.tencent.mm.bv.a
{
  public int caB;
  public String caC;
  public String euK;
  public String gYT;
  public int gYY;
  public int hQR;
  public int jxx;
  public int nFi;
  public int nFj;
  public int qZN;
  public String sxe;
  public String tZb;
  public String tZc;
  public int tZd;
  public String tZe;
  public int tZf;
  public String tZg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQR);
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.tZb != null) {
        paramVarArgs.d(3, this.tZb);
      }
      paramVarArgs.gB(4, this.nFi);
      paramVarArgs.gB(5, this.jxx);
      paramVarArgs.gB(6, this.nFj);
      if (this.tZc != null) {
        paramVarArgs.d(7, this.tZc);
      }
      paramVarArgs.gB(8, this.tZd);
      if (this.sxe != null) {
        paramVarArgs.d(9, this.sxe);
      }
      if (this.tZe != null) {
        paramVarArgs.d(10, this.tZe);
      }
      paramVarArgs.gB(11, this.qZN);
      paramVarArgs.gB(12, this.tZf);
      if (this.tZg != null) {
        paramVarArgs.d(13, this.tZg);
      }
      if (this.gYT != null) {
        paramVarArgs.d(14, this.gYT);
      }
      paramVarArgs.gB(15, this.caB);
      if (this.caC != null) {
        paramVarArgs.d(16, this.caC);
      }
      paramVarArgs.gB(17, this.gYY);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.hQR) + 0;
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.tZb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tZb);
      }
      i = i + d.a.a.a.gy(4, this.nFi) + d.a.a.a.gy(5, this.jxx) + d.a.a.a.gy(6, this.nFj);
      paramInt = i;
      if (this.tZc != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tZc);
      }
      i = paramInt + d.a.a.a.gy(8, this.tZd);
      paramInt = i;
      if (this.sxe != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sxe);
      }
      i = paramInt;
      if (this.tZe != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tZe);
      }
      i = i + d.a.a.a.gy(11, this.qZN) + d.a.a.a.gy(12, this.tZf);
      paramInt = i;
      if (this.tZg != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.tZg);
      }
      i = paramInt;
      if (this.gYT != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.gYT);
      }
      i += d.a.a.a.gy(15, this.caB);
      paramInt = i;
      if (this.caC != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.caC);
      }
      return paramInt + d.a.a.a.gy(17, this.gYY);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cmf localcmf = (cmf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcmf.hQR = locala.xpH.oD();
        return 0;
      case 2: 
        localcmf.euK = locala.xpH.readString();
        return 0;
      case 3: 
        localcmf.tZb = locala.xpH.readString();
        return 0;
      case 4: 
        localcmf.nFi = locala.xpH.oD();
        return 0;
      case 5: 
        localcmf.jxx = locala.xpH.oD();
        return 0;
      case 6: 
        localcmf.nFj = locala.xpH.oD();
        return 0;
      case 7: 
        localcmf.tZc = locala.xpH.readString();
        return 0;
      case 8: 
        localcmf.tZd = locala.xpH.oD();
        return 0;
      case 9: 
        localcmf.sxe = locala.xpH.readString();
        return 0;
      case 10: 
        localcmf.tZe = locala.xpH.readString();
        return 0;
      case 11: 
        localcmf.qZN = locala.xpH.oD();
        return 0;
      case 12: 
        localcmf.tZf = locala.xpH.oD();
        return 0;
      case 13: 
        localcmf.tZg = locala.xpH.readString();
        return 0;
      case 14: 
        localcmf.gYT = locala.xpH.readString();
        return 0;
      case 15: 
        localcmf.caB = locala.xpH.oD();
        return 0;
      case 16: 
        localcmf.caC = locala.xpH.readString();
        return 0;
      }
      localcmf.gYY = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmf
 * JD-Core Version:    0.7.0.1
 */