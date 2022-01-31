package com.tencent.mm.protocal.c;

public final class ar
  extends com.tencent.mm.bv.a
{
  public String ffm;
  public String hPY;
  public int hQq;
  public String hRf;
  public int stM;
  public String stN;
  public String stO;
  public int stP;
  public int stQ;
  public String stR;
  public int stS;
  public String stT;
  public String stU;
  public int stV;
  public String stW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      paramVarArgs.gB(3, this.stM);
      if (this.stN != null) {
        paramVarArgs.d(4, this.stN);
      }
      if (this.stO != null) {
        paramVarArgs.d(5, this.stO);
      }
      if (this.ffm != null) {
        paramVarArgs.d(6, this.ffm);
      }
      paramVarArgs.gB(8, this.hQq);
      paramVarArgs.gB(9, this.stP);
      paramVarArgs.gB(10, this.stQ);
      if (this.stR != null) {
        paramVarArgs.d(11, this.stR);
      }
      paramVarArgs.gB(12, this.stS);
      if (this.stT != null) {
        paramVarArgs.d(13, this.stT);
      }
      if (this.stU != null) {
        paramVarArgs.d(14, this.stU);
      }
      paramVarArgs.gB(15, this.stV);
      if (this.stW != null) {
        paramVarArgs.d(16, this.stW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label873;
      }
    }
    label873:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hRf);
      }
      i += d.a.a.a.gy(3, this.stM);
      paramInt = i;
      if (this.stN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.stN);
      }
      i = paramInt;
      if (this.stO != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.stO);
      }
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ffm);
      }
      i = paramInt + d.a.a.a.gy(8, this.hQq) + d.a.a.a.gy(9, this.stP) + d.a.a.a.gy(10, this.stQ);
      paramInt = i;
      if (this.stR != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.stR);
      }
      i = paramInt + d.a.a.a.gy(12, this.stS);
      paramInt = i;
      if (this.stT != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.stT);
      }
      i = paramInt;
      if (this.stU != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.stU);
      }
      i += d.a.a.a.gy(15, this.stV);
      paramInt = i;
      if (this.stW != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.stW);
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
        ar localar = (ar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          return -1;
        case 1: 
          localar.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localar.hRf = locala.xpH.readString();
          return 0;
        case 3: 
          localar.stM = locala.xpH.oD();
          return 0;
        case 4: 
          localar.stN = locala.xpH.readString();
          return 0;
        case 5: 
          localar.stO = locala.xpH.readString();
          return 0;
        case 6: 
          localar.ffm = locala.xpH.readString();
          return 0;
        case 8: 
          localar.hQq = locala.xpH.oD();
          return 0;
        case 9: 
          localar.stP = locala.xpH.oD();
          return 0;
        case 10: 
          localar.stQ = locala.xpH.oD();
          return 0;
        case 11: 
          localar.stR = locala.xpH.readString();
          return 0;
        case 12: 
          localar.stS = locala.xpH.oD();
          return 0;
        case 13: 
          localar.stT = locala.xpH.readString();
          return 0;
        case 14: 
          localar.stU = locala.xpH.readString();
          return 0;
        case 15: 
          localar.stV = locala.xpH.oD();
          return 0;
        }
        localar.stW = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ar
 * JD-Core Version:    0.7.0.1
 */