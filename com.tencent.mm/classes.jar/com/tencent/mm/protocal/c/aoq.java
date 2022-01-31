package com.tencent.mm.protocal.c;

public final class aoq
  extends com.tencent.mm.bv.a
{
  public int cMX;
  public long cMY;
  public String cMZ;
  public String cNa;
  public String cNb;
  public String cNc;
  public String ffm;
  public String kRP;
  public String kSy;
  public String sAE;
  public String syp;
  public String tkA;
  public int tkB;
  public String tkr;
  public String tks;
  public int tkt;
  public int tku;
  public int tkv;
  public int tkw;
  public String tkx;
  public String tky;
  public String tkz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tkr != null) {
        paramVarArgs.d(1, this.tkr);
      }
      if (this.syp != null) {
        paramVarArgs.d(2, this.syp);
      }
      if (this.sAE != null) {
        paramVarArgs.d(3, this.sAE);
      }
      if (this.tks != null) {
        paramVarArgs.d(4, this.tks);
      }
      paramVarArgs.gB(5, this.tkt);
      paramVarArgs.gB(6, this.tku);
      paramVarArgs.gB(7, this.tkv);
      paramVarArgs.gB(8, this.tkw);
      if (this.tkx != null) {
        paramVarArgs.d(9, this.tkx);
      }
      if (this.ffm != null) {
        paramVarArgs.d(10, this.ffm);
      }
      if (this.kSy != null) {
        paramVarArgs.d(11, this.kSy);
      }
      if (this.kRP != null) {
        paramVarArgs.d(12, this.kRP);
      }
      if (this.tky != null) {
        paramVarArgs.d(13, this.tky);
      }
      if (this.tkz != null) {
        paramVarArgs.d(14, this.tkz);
      }
      if (this.tkA != null) {
        paramVarArgs.d(15, this.tkA);
      }
      paramVarArgs.gB(16, this.tkB);
      paramVarArgs.gB(17, this.cMX);
      paramVarArgs.Y(18, this.cMY);
      if (this.cMZ != null) {
        paramVarArgs.d(19, this.cMZ);
      }
      if (this.cNa != null) {
        paramVarArgs.d(20, this.cNa);
      }
      if (this.cNb != null) {
        paramVarArgs.d(21, this.cNb);
      }
      if (this.cNc != null) {
        paramVarArgs.d(22, this.cNc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkr == null) {
        break label1246;
      }
    }
    label1246:
    for (int i = d.a.a.b.b.a.e(1, this.tkr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.syp);
      }
      i = paramInt;
      if (this.sAE != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAE);
      }
      paramInt = i;
      if (this.tks != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tks);
      }
      i = paramInt + d.a.a.a.gy(5, this.tkt) + d.a.a.a.gy(6, this.tku) + d.a.a.a.gy(7, this.tkv) + d.a.a.a.gy(8, this.tkw);
      paramInt = i;
      if (this.tkx != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tkx);
      }
      i = paramInt;
      if (this.ffm != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.ffm);
      }
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.kSy);
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.kRP);
      }
      paramInt = i;
      if (this.tky != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.tky);
      }
      i = paramInt;
      if (this.tkz != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.tkz);
      }
      paramInt = i;
      if (this.tkA != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.tkA);
      }
      i = paramInt + d.a.a.a.gy(16, this.tkB) + d.a.a.a.gy(17, this.cMX) + d.a.a.a.X(18, this.cMY);
      paramInt = i;
      if (this.cMZ != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.cMZ);
      }
      i = paramInt;
      if (this.cNa != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.cNa);
      }
      paramInt = i;
      if (this.cNb != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.cNb);
      }
      i = paramInt;
      if (this.cNc != null) {
        i = paramInt + d.a.a.b.b.a.e(22, this.cNc);
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
        aoq localaoq = (aoq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaoq.tkr = locala.xpH.readString();
          return 0;
        case 2: 
          localaoq.syp = locala.xpH.readString();
          return 0;
        case 3: 
          localaoq.sAE = locala.xpH.readString();
          return 0;
        case 4: 
          localaoq.tks = locala.xpH.readString();
          return 0;
        case 5: 
          localaoq.tkt = locala.xpH.oD();
          return 0;
        case 6: 
          localaoq.tku = locala.xpH.oD();
          return 0;
        case 7: 
          localaoq.tkv = locala.xpH.oD();
          return 0;
        case 8: 
          localaoq.tkw = locala.xpH.oD();
          return 0;
        case 9: 
          localaoq.tkx = locala.xpH.readString();
          return 0;
        case 10: 
          localaoq.ffm = locala.xpH.readString();
          return 0;
        case 11: 
          localaoq.kSy = locala.xpH.readString();
          return 0;
        case 12: 
          localaoq.kRP = locala.xpH.readString();
          return 0;
        case 13: 
          localaoq.tky = locala.xpH.readString();
          return 0;
        case 14: 
          localaoq.tkz = locala.xpH.readString();
          return 0;
        case 15: 
          localaoq.tkA = locala.xpH.readString();
          return 0;
        case 16: 
          localaoq.tkB = locala.xpH.oD();
          return 0;
        case 17: 
          localaoq.cMX = locala.xpH.oD();
          return 0;
        case 18: 
          localaoq.cMY = locala.xpH.oE();
          return 0;
        case 19: 
          localaoq.cMZ = locala.xpH.readString();
          return 0;
        case 20: 
          localaoq.cNa = locala.xpH.readString();
          return 0;
        case 21: 
          localaoq.cNb = locala.xpH.readString();
          return 0;
        }
        localaoq.cNc = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aoq
 * JD-Core Version:    0.7.0.1
 */