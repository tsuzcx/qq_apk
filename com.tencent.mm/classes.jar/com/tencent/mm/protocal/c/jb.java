package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public class jb
  extends com.tencent.mm.bv.a
{
  public long bHR;
  public int cancel;
  public int pos;
  public int sDA;
  public int sDB;
  public int sDC;
  public int sDD;
  public int sDE;
  public int sDF;
  public String sDG;
  public long sDH;
  public int sDI;
  public int sDJ;
  public int sDK;
  public int sDL;
  public int sDM;
  public int sDN;
  public int sDO;
  public String sDq;
  public LinkedList<Integer> sDr = new LinkedList();
  public int sDs;
  public int sDt;
  public int sDu;
  public int sDv;
  public int sDw;
  public int sDx;
  public int sDy;
  public int sDz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sDq != null) {
        paramVarArgs.d(1, this.sDq);
      }
      paramVarArgs.Y(2, this.bHR);
      paramVarArgs.gB(3, this.pos);
      paramVarArgs.d(4, 2, this.sDr);
      paramVarArgs.gB(5, this.sDs);
      paramVarArgs.gB(6, this.sDt);
      paramVarArgs.gB(7, this.sDu);
      paramVarArgs.gB(8, this.sDv);
      paramVarArgs.gB(9, this.sDw);
      paramVarArgs.gB(10, this.sDx);
      paramVarArgs.gB(11, this.sDy);
      paramVarArgs.gB(12, this.sDz);
      paramVarArgs.gB(13, this.sDA);
      paramVarArgs.gB(14, this.cancel);
      paramVarArgs.gB(15, this.sDB);
      paramVarArgs.gB(16, this.sDC);
      paramVarArgs.gB(17, this.sDD);
      paramVarArgs.gB(18, this.sDE);
      paramVarArgs.gB(19, this.sDF);
      if (this.sDG != null) {
        paramVarArgs.d(20, this.sDG);
      }
      paramVarArgs.Y(21, this.sDH);
      paramVarArgs.gB(22, this.sDI);
      paramVarArgs.gB(23, this.sDJ);
      paramVarArgs.gB(24, this.sDK);
      paramVarArgs.gB(25, this.sDL);
      paramVarArgs.gB(26, this.sDM);
      paramVarArgs.gB(27, this.sDN);
      paramVarArgs.gB(28, this.sDO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sDq == null) {
        break label1259;
      }
    }
    label1259:
    for (paramInt = d.a.a.b.b.a.e(1, this.sDq) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.bHR) + d.a.a.a.gy(3, this.pos) + d.a.a.a.c(4, 2, this.sDr) + d.a.a.a.gy(5, this.sDs) + d.a.a.a.gy(6, this.sDt) + d.a.a.a.gy(7, this.sDu) + d.a.a.a.gy(8, this.sDv) + d.a.a.a.gy(9, this.sDw) + d.a.a.a.gy(10, this.sDx) + d.a.a.a.gy(11, this.sDy) + d.a.a.a.gy(12, this.sDz) + d.a.a.a.gy(13, this.sDA) + d.a.a.a.gy(14, this.cancel) + d.a.a.a.gy(15, this.sDB) + d.a.a.a.gy(16, this.sDC) + d.a.a.a.gy(17, this.sDD) + d.a.a.a.gy(18, this.sDE) + d.a.a.a.gy(19, this.sDF);
      paramInt = i;
      if (this.sDG != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.sDG);
      }
      return paramInt + d.a.a.a.X(21, this.sDH) + d.a.a.a.gy(22, this.sDI) + d.a.a.a.gy(23, this.sDJ) + d.a.a.a.gy(24, this.sDK) + d.a.a.a.gy(25, this.sDL) + d.a.a.a.gy(26, this.sDM) + d.a.a.a.gy(27, this.sDN) + d.a.a.a.gy(28, this.sDO);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sDr.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        jb localjb = (jb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localjb.sDq = locala.xpH.readString();
          return 0;
        case 2: 
          localjb.bHR = locala.xpH.oE();
          return 0;
        case 3: 
          localjb.pos = locala.xpH.oD();
          return 0;
        case 4: 
          localjb.sDr.add(Integer.valueOf(locala.xpH.oD()));
          return 0;
        case 5: 
          localjb.sDs = locala.xpH.oD();
          return 0;
        case 6: 
          localjb.sDt = locala.xpH.oD();
          return 0;
        case 7: 
          localjb.sDu = locala.xpH.oD();
          return 0;
        case 8: 
          localjb.sDv = locala.xpH.oD();
          return 0;
        case 9: 
          localjb.sDw = locala.xpH.oD();
          return 0;
        case 10: 
          localjb.sDx = locala.xpH.oD();
          return 0;
        case 11: 
          localjb.sDy = locala.xpH.oD();
          return 0;
        case 12: 
          localjb.sDz = locala.xpH.oD();
          return 0;
        case 13: 
          localjb.sDA = locala.xpH.oD();
          return 0;
        case 14: 
          localjb.cancel = locala.xpH.oD();
          return 0;
        case 15: 
          localjb.sDB = locala.xpH.oD();
          return 0;
        case 16: 
          localjb.sDC = locala.xpH.oD();
          return 0;
        case 17: 
          localjb.sDD = locala.xpH.oD();
          return 0;
        case 18: 
          localjb.sDE = locala.xpH.oD();
          return 0;
        case 19: 
          localjb.sDF = locala.xpH.oD();
          return 0;
        case 20: 
          localjb.sDG = locala.xpH.readString();
          return 0;
        case 21: 
          localjb.sDH = locala.xpH.oE();
          return 0;
        case 22: 
          localjb.sDI = locala.xpH.oD();
          return 0;
        case 23: 
          localjb.sDJ = locala.xpH.oD();
          return 0;
        case 24: 
          localjb.sDK = locala.xpH.oD();
          return 0;
        case 25: 
          localjb.sDL = locala.xpH.oD();
          return 0;
        case 26: 
          localjb.sDM = locala.xpH.oD();
          return 0;
        case 27: 
          localjb.sDN = locala.xpH.oD();
          return 0;
        }
        localjb.sDO = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jb
 * JD-Core Version:    0.7.0.1
 */