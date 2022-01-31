package com.tencent.mm.protocal.c;

public final class bej
  extends com.tencent.mm.bv.a
{
  public String kVn;
  public String mPI;
  public String mPK;
  public int mPL;
  public String mPM;
  public int mPN;
  public String mPO;
  public int mPP;
  public int mPQ;
  public String mPS;
  public String mPT;
  public String mPU;
  public String mPV;
  public int tze;
  public String tzq;
  public String tzr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mPI != null) {
        paramVarArgs.d(1, this.mPI);
      }
      paramVarArgs.gB(2, this.tze);
      if (this.mPK != null) {
        paramVarArgs.d(3, this.mPK);
      }
      paramVarArgs.gB(4, this.mPL);
      if (this.mPM != null) {
        paramVarArgs.d(5, this.mPM);
      }
      paramVarArgs.gB(6, this.mPN);
      if (this.mPO != null) {
        paramVarArgs.d(7, this.mPO);
      }
      paramVarArgs.gB(8, this.mPP);
      paramVarArgs.gB(9, this.mPQ);
      if (this.kVn != null) {
        paramVarArgs.d(11, this.kVn);
      }
      if (this.mPS != null) {
        paramVarArgs.d(12, this.mPS);
      }
      if (this.mPT != null) {
        paramVarArgs.d(13, this.mPT);
      }
      if (this.mPU != null) {
        paramVarArgs.d(14, this.mPU);
      }
      if (this.mPV != null) {
        paramVarArgs.d(15, this.mPV);
      }
      if (this.tzq != null) {
        paramVarArgs.d(18, this.tzq);
      }
      if (this.tzr != null) {
        paramVarArgs.d(19, this.tzr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mPI == null) {
        break label956;
      }
    }
    label956:
    for (paramInt = d.a.a.b.b.a.e(1, this.mPI) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tze);
      paramInt = i;
      if (this.mPK != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.mPK);
      }
      i = paramInt + d.a.a.a.gy(4, this.mPL);
      paramInt = i;
      if (this.mPM != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mPM);
      }
      i = paramInt + d.a.a.a.gy(6, this.mPN);
      paramInt = i;
      if (this.mPO != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.mPO);
      }
      i = paramInt + d.a.a.a.gy(8, this.mPP) + d.a.a.a.gy(9, this.mPQ);
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.kVn);
      }
      i = paramInt;
      if (this.mPS != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.mPS);
      }
      paramInt = i;
      if (this.mPT != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.mPT);
      }
      i = paramInt;
      if (this.mPU != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.mPU);
      }
      paramInt = i;
      if (this.mPV != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.mPV);
      }
      i = paramInt;
      if (this.tzq != null) {
        i = paramInt + d.a.a.b.b.a.e(18, this.tzq);
      }
      paramInt = i;
      if (this.tzr != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.tzr);
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
        bej localbej = (bej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          return -1;
        case 1: 
          localbej.mPI = locala.xpH.readString();
          return 0;
        case 2: 
          localbej.tze = locala.xpH.oD();
          return 0;
        case 3: 
          localbej.mPK = locala.xpH.readString();
          return 0;
        case 4: 
          localbej.mPL = locala.xpH.oD();
          return 0;
        case 5: 
          localbej.mPM = locala.xpH.readString();
          return 0;
        case 6: 
          localbej.mPN = locala.xpH.oD();
          return 0;
        case 7: 
          localbej.mPO = locala.xpH.readString();
          return 0;
        case 8: 
          localbej.mPP = locala.xpH.oD();
          return 0;
        case 9: 
          localbej.mPQ = locala.xpH.oD();
          return 0;
        case 11: 
          localbej.kVn = locala.xpH.readString();
          return 0;
        case 12: 
          localbej.mPS = locala.xpH.readString();
          return 0;
        case 13: 
          localbej.mPT = locala.xpH.readString();
          return 0;
        case 14: 
          localbej.mPU = locala.xpH.readString();
          return 0;
        case 15: 
          localbej.mPV = locala.xpH.readString();
          return 0;
        case 18: 
          localbej.tzq = locala.xpH.readString();
          return 0;
        }
        localbej.tzr = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bej
 * JD-Core Version:    0.7.0.1
 */