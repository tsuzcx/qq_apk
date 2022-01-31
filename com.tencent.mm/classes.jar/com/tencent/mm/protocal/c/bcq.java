package com.tencent.mm.protocal.c;

public final class bcq
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public String kRN;
  public String mQp;
  public String sRt;
  public String sRu;
  public String sRv;
  public String sRw;
  public String sRx;
  public String txX;
  public String txY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.txX != null) {
        paramVarArgs.d(1, this.txX);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.jnU != null) {
        paramVarArgs.d(3, this.jnU);
      }
      if (this.sRu != null) {
        paramVarArgs.d(4, this.sRu);
      }
      if (this.txY != null) {
        paramVarArgs.d(5, this.txY);
      }
      if (this.mQp != null) {
        paramVarArgs.d(6, this.mQp);
      }
      if (this.sRt != null) {
        paramVarArgs.d(7, this.sRt);
      }
      if (this.sRv != null) {
        paramVarArgs.d(8, this.sRv);
      }
      if (this.sRw != null) {
        paramVarArgs.d(9, this.sRw);
      }
      if (this.sRx != null) {
        paramVarArgs.d(10, this.sRx);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.txX == null) {
        break label682;
      }
    }
    label682:
    for (int i = d.a.a.b.b.a.e(1, this.txX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.jnU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.jnU);
      }
      paramInt = i;
      if (this.sRu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sRu);
      }
      i = paramInt;
      if (this.txY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.txY);
      }
      paramInt = i;
      if (this.mQp != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.mQp);
      }
      i = paramInt;
      if (this.sRt != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sRt);
      }
      paramInt = i;
      if (this.sRv != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sRv);
      }
      i = paramInt;
      if (this.sRw != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sRw);
      }
      paramInt = i;
      if (this.sRx != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sRx);
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
        bcq localbcq = (bcq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbcq.txX = locala.xpH.readString();
          return 0;
        case 2: 
          localbcq.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localbcq.jnU = locala.xpH.readString();
          return 0;
        case 4: 
          localbcq.sRu = locala.xpH.readString();
          return 0;
        case 5: 
          localbcq.txY = locala.xpH.readString();
          return 0;
        case 6: 
          localbcq.mQp = locala.xpH.readString();
          return 0;
        case 7: 
          localbcq.sRt = locala.xpH.readString();
          return 0;
        case 8: 
          localbcq.sRv = locala.xpH.readString();
          return 0;
        case 9: 
          localbcq.sRw = locala.xpH.readString();
          return 0;
        }
        localbcq.sRx = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcq
 * JD-Core Version:    0.7.0.1
 */