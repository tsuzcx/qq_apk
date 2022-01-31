package com.tencent.mm.protocal.c;

public final class bbc
  extends com.tencent.mm.bv.a
{
  public String aVr;
  public String appId;
  public String dtK;
  public String sQf;
  public String sQg;
  public int txf;
  public String txg;
  public String txh;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.aVr != null) {
        paramVarArgs.d(2, this.aVr);
      }
      if (this.dtK != null) {
        paramVarArgs.d(3, this.dtK);
      }
      if (this.sQf != null) {
        paramVarArgs.d(4, this.sQf);
      }
      if (this.sQg != null) {
        paramVarArgs.d(5, this.sQg);
      }
      paramVarArgs.gB(6, this.txf);
      if (this.appId != null) {
        paramVarArgs.d(7, this.appId);
      }
      if (this.txg != null) {
        paramVarArgs.d(8, this.txg);
      }
      if (this.txh != null) {
        paramVarArgs.d(9, this.txh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label611;
      }
    }
    label611:
    for (int i = d.a.a.b.b.a.e(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aVr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.aVr);
      }
      i = paramInt;
      if (this.dtK != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.dtK);
      }
      paramInt = i;
      if (this.sQf != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sQf);
      }
      i = paramInt;
      if (this.sQg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sQg);
      }
      i += d.a.a.a.gy(6, this.txf);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.appId);
      }
      i = paramInt;
      if (this.txg != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.txg);
      }
      paramInt = i;
      if (this.txh != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.txh);
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
        bbc localbbc = (bbc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbbc.userName = locala.xpH.readString();
          return 0;
        case 2: 
          localbbc.aVr = locala.xpH.readString();
          return 0;
        case 3: 
          localbbc.dtK = locala.xpH.readString();
          return 0;
        case 4: 
          localbbc.sQf = locala.xpH.readString();
          return 0;
        case 5: 
          localbbc.sQg = locala.xpH.readString();
          return 0;
        case 6: 
          localbbc.txf = locala.xpH.oD();
          return 0;
        case 7: 
          localbbc.appId = locala.xpH.readString();
          return 0;
        case 8: 
          localbbc.txg = locala.xpH.readString();
          return 0;
        }
        localbbc.txh = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bbc
 * JD-Core Version:    0.7.0.1
 */