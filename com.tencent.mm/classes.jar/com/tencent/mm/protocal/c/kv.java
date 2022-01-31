package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class kv
  extends com.tencent.mm.bv.a
{
  public String mQq;
  public String sFP;
  public String sFQ;
  public String sFR;
  public int sFS;
  public String sFT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sFP == null) {
        throw new b("Not all required fields were included: ProductId");
      }
      if (this.mQq == null) {
        throw new b("Not all required fields were included: ProductName");
      }
      if (this.sFQ == null) {
        throw new b("Not all required fields were included: SellerName");
      }
      if (this.sFR == null) {
        throw new b("Not all required fields were included: SellerUserName");
      }
      if (this.sFP != null) {
        paramVarArgs.d(1, this.sFP);
      }
      if (this.mQq != null) {
        paramVarArgs.d(2, this.mQq);
      }
      if (this.sFQ != null) {
        paramVarArgs.d(3, this.sFQ);
      }
      if (this.sFR != null) {
        paramVarArgs.d(4, this.sFR);
      }
      paramVarArgs.gB(5, this.sFS);
      if (this.sFT != null) {
        paramVarArgs.d(6, this.sFT);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sFP == null) {
        break label574;
      }
    }
    label574:
    for (int i = d.a.a.b.b.a.e(1, this.sFP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mQq != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mQq);
      }
      i = paramInt;
      if (this.sFQ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sFQ);
      }
      paramInt = i;
      if (this.sFR != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sFR);
      }
      i = paramInt + d.a.a.a.gy(5, this.sFS);
      paramInt = i;
      if (this.sFT != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sFT);
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
        if (this.sFP == null) {
          throw new b("Not all required fields were included: ProductId");
        }
        if (this.mQq == null) {
          throw new b("Not all required fields were included: ProductName");
        }
        if (this.sFQ == null) {
          throw new b("Not all required fields were included: SellerName");
        }
        if (this.sFR != null) {
          break;
        }
        throw new b("Not all required fields were included: SellerUserName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        kv localkv = (kv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localkv.sFP = locala.xpH.readString();
          return 0;
        case 2: 
          localkv.mQq = locala.xpH.readString();
          return 0;
        case 3: 
          localkv.sFQ = locala.xpH.readString();
          return 0;
        case 4: 
          localkv.sFR = locala.xpH.readString();
          return 0;
        case 5: 
          localkv.sFS = locala.xpH.oD();
          return 0;
        }
        localkv.sFT = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kv
 * JD-Core Version:    0.7.0.1
 */