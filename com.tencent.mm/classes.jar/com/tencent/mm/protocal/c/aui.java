package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class aui
  extends com.tencent.mm.bv.a
{
  public float aXH;
  public String country;
  public String ffj;
  public String lFn;
  public String oQs;
  public int oQu;
  public int oQw;
  public float sGJ;
  public float sGK;
  public int score;
  public String tpQ;
  public String tpR;
  public int tpS;
  public int tpT;
  public b tpU;
  public String tpV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.m(1, this.sGJ);
      paramVarArgs.m(2, this.sGK);
      if (this.ffj != null) {
        paramVarArgs.d(3, this.ffj);
      }
      if (this.lFn != null) {
        paramVarArgs.d(4, this.lFn);
      }
      if (this.oQs != null) {
        paramVarArgs.d(5, this.oQs);
      }
      if (this.tpQ != null) {
        paramVarArgs.d(6, this.tpQ);
      }
      paramVarArgs.gB(7, this.oQu);
      if (this.tpR != null) {
        paramVarArgs.d(8, this.tpR);
      }
      paramVarArgs.gB(9, this.tpS);
      paramVarArgs.gB(10, this.tpT);
      paramVarArgs.gB(11, this.oQw);
      paramVarArgs.m(12, this.aXH);
      if (this.tpU != null) {
        paramVarArgs.b(13, this.tpU);
      }
      paramVarArgs.gB(14, this.score);
      if (this.tpV != null) {
        paramVarArgs.d(15, this.tpV);
      }
      if (this.country != null) {
        paramVarArgs.d(16, this.country);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.b.b.a.dQ(1) + 4 + 0 + (d.a.a.b.b.a.dQ(2) + 4);
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.ffj);
      }
      i = paramInt;
      if (this.lFn != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lFn);
      }
      paramInt = i;
      if (this.oQs != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.oQs);
      }
      i = paramInt;
      if (this.tpQ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tpQ);
      }
      i += d.a.a.a.gy(7, this.oQu);
      paramInt = i;
      if (this.tpR != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tpR);
      }
      i = paramInt + d.a.a.a.gy(9, this.tpS) + d.a.a.a.gy(10, this.tpT) + d.a.a.a.gy(11, this.oQw) + (d.a.a.b.b.a.dQ(12) + 4);
      paramInt = i;
      if (this.tpU != null) {
        paramInt = i + d.a.a.a.a(13, this.tpU);
      }
      i = paramInt + d.a.a.a.gy(14, this.score);
      paramInt = i;
      if (this.tpV != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.tpV);
      }
      i = paramInt;
    } while (this.country == null);
    return paramInt + d.a.a.b.b.a.e(16, this.country);
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
      aui localaui = (aui)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaui.sGJ = locala.xpH.readFloat();
        return 0;
      case 2: 
        localaui.sGK = locala.xpH.readFloat();
        return 0;
      case 3: 
        localaui.ffj = locala.xpH.readString();
        return 0;
      case 4: 
        localaui.lFn = locala.xpH.readString();
        return 0;
      case 5: 
        localaui.oQs = locala.xpH.readString();
        return 0;
      case 6: 
        localaui.tpQ = locala.xpH.readString();
        return 0;
      case 7: 
        localaui.oQu = locala.xpH.oD();
        return 0;
      case 8: 
        localaui.tpR = locala.xpH.readString();
        return 0;
      case 9: 
        localaui.tpS = locala.xpH.oD();
        return 0;
      case 10: 
        localaui.tpT = locala.xpH.oD();
        return 0;
      case 11: 
        localaui.oQw = locala.xpH.oD();
        return 0;
      case 12: 
        localaui.aXH = locala.xpH.readFloat();
        return 0;
      case 13: 
        localaui.tpU = locala.cUs();
        return 0;
      case 14: 
        localaui.score = locala.xpH.oD();
        return 0;
      case 15: 
        localaui.tpV = locala.xpH.readString();
        return 0;
      }
      localaui.country = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aui
 * JD-Core Version:    0.7.0.1
 */