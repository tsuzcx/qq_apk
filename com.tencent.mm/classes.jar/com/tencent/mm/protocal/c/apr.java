package com.tencent.mm.protocal.c;

public final class apr
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int hQR;
  public String kSC;
  public String kVn;
  public String sNb;
  public String tlJ;
  public String tlK;
  public String tlL;
  public String tlM;
  public int tlN;
  public String tlO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(2, this.tlJ);
      }
      paramVarArgs.gB(3, this.hQR);
      if (this.kSC != null) {
        paramVarArgs.d(4, this.kSC);
      }
      if (this.tlK != null) {
        paramVarArgs.d(5, this.tlK);
      }
      if (this.sNb != null) {
        paramVarArgs.d(6, this.sNb);
      }
      if (this.tlL != null) {
        paramVarArgs.d(7, this.tlL);
      }
      if (this.kVn != null) {
        paramVarArgs.d(8, this.kVn);
      }
      if (this.tlM != null) {
        paramVarArgs.d(9, this.tlM);
      }
      paramVarArgs.gB(10, this.tlN);
      if (this.tlO != null) {
        paramVarArgs.d(11, this.tlO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label709;
      }
    }
    label709:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tlJ);
      }
      i += d.a.a.a.gy(3, this.hQR);
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSC);
      }
      i = paramInt;
      if (this.tlK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tlK);
      }
      paramInt = i;
      if (this.sNb != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sNb);
      }
      i = paramInt;
      if (this.tlL != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tlL);
      }
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.kVn);
      }
      i = paramInt;
      if (this.tlM != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tlM);
      }
      i += d.a.a.a.gy(10, this.tlN);
      paramInt = i;
      if (this.tlO != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tlO);
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
        apr localapr = (apr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapr.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localapr.tlJ = locala.xpH.readString();
          return 0;
        case 3: 
          localapr.hQR = locala.xpH.oD();
          return 0;
        case 4: 
          localapr.kSC = locala.xpH.readString();
          return 0;
        case 5: 
          localapr.tlK = locala.xpH.readString();
          return 0;
        case 6: 
          localapr.sNb = locala.xpH.readString();
          return 0;
        case 7: 
          localapr.tlL = locala.xpH.readString();
          return 0;
        case 8: 
          localapr.kVn = locala.xpH.readString();
          return 0;
        case 9: 
          localapr.tlM = locala.xpH.readString();
          return 0;
        case 10: 
          localapr.tlN = locala.xpH.oD();
          return 0;
        }
        localapr.tlO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apr
 * JD-Core Version:    0.7.0.1
 */