package com.tencent.mm.protocal.c;

public final class baq
  extends com.tencent.mm.bv.a
{
  public String kRX;
  public int kSe;
  public String kSq;
  public String kVn;
  public String sCv;
  public int sCy;
  public String suv;
  public String sux;
  public String twA;
  public String twB;
  public String twC;
  public String twx;
  public String twy;
  public String twz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      if (this.kVn != null) {
        paramVarArgs.d(2, this.kVn);
      }
      if (this.twx != null) {
        paramVarArgs.d(3, this.twx);
      }
      if (this.suv != null) {
        paramVarArgs.d(4, this.suv);
      }
      if (this.kSq != null) {
        paramVarArgs.d(5, this.kSq);
      }
      paramVarArgs.gB(6, this.sCy);
      if (this.twy != null) {
        paramVarArgs.d(7, this.twy);
      }
      if (this.sux != null) {
        paramVarArgs.d(8, this.sux);
      }
      if (this.sCv != null) {
        paramVarArgs.d(9, this.sCv);
      }
      if (this.twz != null) {
        paramVarArgs.d(10, this.twz);
      }
      if (this.twA != null) {
        paramVarArgs.d(11, this.twA);
      }
      if (this.twB != null) {
        paramVarArgs.d(12, this.twB);
      }
      if (this.twC != null) {
        paramVarArgs.d(13, this.twC);
      }
      paramVarArgs.gB(14, this.kSe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label878;
      }
    }
    label878:
    for (int i = d.a.a.b.b.a.e(1, this.kRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVn);
      }
      i = paramInt;
      if (this.twx != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.twx);
      }
      paramInt = i;
      if (this.suv != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.suv);
      }
      i = paramInt;
      if (this.kSq != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSq);
      }
      i += d.a.a.a.gy(6, this.sCy);
      paramInt = i;
      if (this.twy != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.twy);
      }
      i = paramInt;
      if (this.sux != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sux);
      }
      paramInt = i;
      if (this.sCv != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sCv);
      }
      i = paramInt;
      if (this.twz != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.twz);
      }
      paramInt = i;
      if (this.twA != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.twA);
      }
      i = paramInt;
      if (this.twB != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.twB);
      }
      paramInt = i;
      if (this.twC != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.twC);
      }
      return paramInt + d.a.a.a.gy(14, this.kSe);
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
        baq localbaq = (baq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbaq.kRX = locala.xpH.readString();
          return 0;
        case 2: 
          localbaq.kVn = locala.xpH.readString();
          return 0;
        case 3: 
          localbaq.twx = locala.xpH.readString();
          return 0;
        case 4: 
          localbaq.suv = locala.xpH.readString();
          return 0;
        case 5: 
          localbaq.kSq = locala.xpH.readString();
          return 0;
        case 6: 
          localbaq.sCy = locala.xpH.oD();
          return 0;
        case 7: 
          localbaq.twy = locala.xpH.readString();
          return 0;
        case 8: 
          localbaq.sux = locala.xpH.readString();
          return 0;
        case 9: 
          localbaq.sCv = locala.xpH.readString();
          return 0;
        case 10: 
          localbaq.twz = locala.xpH.readString();
          return 0;
        case 11: 
          localbaq.twA = locala.xpH.readString();
          return 0;
        case 12: 
          localbaq.twB = locala.xpH.readString();
          return 0;
        case 13: 
          localbaq.twC = locala.xpH.readString();
          return 0;
        }
        localbaq.kSe = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.baq
 * JD-Core Version:    0.7.0.1
 */