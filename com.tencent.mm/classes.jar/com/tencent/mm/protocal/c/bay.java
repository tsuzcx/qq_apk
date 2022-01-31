package com.tencent.mm.protocal.c;

public final class bay
  extends com.tencent.mm.bv.a
{
  public String aHm;
  public String bSM;
  public String ioW;
  public String twW;
  public String twX;
  public int twY;
  public String twZ;
  public String txa;
  public String txb;
  public int txc;
  public int txd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.aHm != null) {
        paramVarArgs.d(1, this.aHm);
      }
      if (this.twW != null) {
        paramVarArgs.d(2, this.twW);
      }
      if (this.twX != null) {
        paramVarArgs.d(3, this.twX);
      }
      paramVarArgs.gB(4, this.twY);
      if (this.bSM != null) {
        paramVarArgs.d(5, this.bSM);
      }
      if (this.twZ != null) {
        paramVarArgs.d(6, this.twZ);
      }
      if (this.txa != null) {
        paramVarArgs.d(7, this.txa);
      }
      if (this.ioW != null) {
        paramVarArgs.d(8, this.ioW);
      }
      if (this.txb != null) {
        paramVarArgs.d(9, this.txb);
      }
      paramVarArgs.gB(10, this.txc);
      paramVarArgs.gB(11, this.txd);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aHm == null) {
        break label689;
      }
    }
    label689:
    for (int i = d.a.a.b.b.a.e(1, this.aHm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.twW != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.twW);
      }
      i = paramInt;
      if (this.twX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.twX);
      }
      i += d.a.a.a.gy(4, this.twY);
      paramInt = i;
      if (this.bSM != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bSM);
      }
      i = paramInt;
      if (this.twZ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.twZ);
      }
      paramInt = i;
      if (this.txa != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.txa);
      }
      i = paramInt;
      if (this.ioW != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.ioW);
      }
      paramInt = i;
      if (this.txb != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.txb);
      }
      return paramInt + d.a.a.a.gy(10, this.txc) + d.a.a.a.gy(11, this.txd);
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
        bay localbay = (bay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbay.aHm = locala.xpH.readString();
          return 0;
        case 2: 
          localbay.twW = locala.xpH.readString();
          return 0;
        case 3: 
          localbay.twX = locala.xpH.readString();
          return 0;
        case 4: 
          localbay.twY = locala.xpH.oD();
          return 0;
        case 5: 
          localbay.bSM = locala.xpH.readString();
          return 0;
        case 6: 
          localbay.twZ = locala.xpH.readString();
          return 0;
        case 7: 
          localbay.txa = locala.xpH.readString();
          return 0;
        case 8: 
          localbay.ioW = locala.xpH.readString();
          return 0;
        case 9: 
          localbay.txb = locala.xpH.readString();
          return 0;
        case 10: 
          localbay.txc = locala.xpH.oD();
          return 0;
        }
        localbay.txd = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bay
 * JD-Core Version:    0.7.0.1
 */