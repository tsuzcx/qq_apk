package com.tencent.mm.protocal.c;

public class bco
  extends com.tencent.mm.bv.a
{
  public String ffi;
  public String ffj;
  public String kRZ;
  public String mEb;
  public double sDm;
  public double sDn;
  public String sQh;
  public String sQi;
  public String txR;
  public String txS;
  public String txT;
  public String txU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      if (this.txR != null) {
        paramVarArgs.d(2, this.txR);
      }
      paramVarArgs.b(3, this.sDm);
      paramVarArgs.b(4, this.sDn);
      if (this.txS != null) {
        paramVarArgs.d(5, this.txS);
      }
      if (this.mEb != null) {
        paramVarArgs.d(6, this.mEb);
      }
      if (this.txT != null) {
        paramVarArgs.d(7, this.txT);
      }
      if (this.ffi != null) {
        paramVarArgs.d(8, this.ffi);
      }
      if (this.ffj != null) {
        paramVarArgs.d(9, this.ffj);
      }
      if (this.sQh != null) {
        paramVarArgs.d(10, this.sQh);
      }
      if (this.sQi != null) {
        paramVarArgs.d(11, this.sQi);
      }
      if (this.txU != null) {
        paramVarArgs.d(12, this.txU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.txR != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.txR);
      }
      i = i + (d.a.a.b.b.a.dQ(3) + 8) + (d.a.a.b.b.a.dQ(4) + 8);
      paramInt = i;
      if (this.txS != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.txS);
      }
      i = paramInt;
      if (this.mEb != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.mEb);
      }
      paramInt = i;
      if (this.txT != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.txT);
      }
      i = paramInt;
      if (this.ffi != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.ffi);
      }
      paramInt = i;
      if (this.ffj != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ffj);
      }
      i = paramInt;
      if (this.sQh != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sQh);
      }
      paramInt = i;
      if (this.sQi != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sQi);
      }
      i = paramInt;
      if (this.txU != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.txU);
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
        bco localbco = (bco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbco.kRZ = locala.xpH.readString();
          return 0;
        case 2: 
          localbco.txR = locala.xpH.readString();
          return 0;
        case 3: 
          localbco.sDm = locala.xpH.readDouble();
          return 0;
        case 4: 
          localbco.sDn = locala.xpH.readDouble();
          return 0;
        case 5: 
          localbco.txS = locala.xpH.readString();
          return 0;
        case 6: 
          localbco.mEb = locala.xpH.readString();
          return 0;
        case 7: 
          localbco.txT = locala.xpH.readString();
          return 0;
        case 8: 
          localbco.ffi = locala.xpH.readString();
          return 0;
        case 9: 
          localbco.ffj = locala.xpH.readString();
          return 0;
        case 10: 
          localbco.sQh = locala.xpH.readString();
          return 0;
        case 11: 
          localbco.sQi = locala.xpH.readString();
          return 0;
        }
        localbco.txU = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bco
 * JD-Core Version:    0.7.0.1
 */