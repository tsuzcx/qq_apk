package com.tencent.mm.protocal.c;

public final class cih
  extends com.tencent.mm.bv.a
{
  public int fdX;
  public String mQi;
  public int pyo;
  public String tEK;
  public String tWK;
  public String tWL;
  public String tWM;
  public String tWN;
  public String tWO;
  public String tqX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWK != null) {
        paramVarArgs.d(1, this.tWK);
      }
      if (this.tWL != null) {
        paramVarArgs.d(2, this.tWL);
      }
      if (this.tqX != null) {
        paramVarArgs.d(3, this.tqX);
      }
      if (this.tEK != null) {
        paramVarArgs.d(4, this.tEK);
      }
      paramVarArgs.gB(5, this.fdX);
      if (this.mQi != null) {
        paramVarArgs.d(6, this.mQi);
      }
      if (this.tWM != null) {
        paramVarArgs.d(7, this.tWM);
      }
      if (this.tWN != null) {
        paramVarArgs.d(8, this.tWN);
      }
      paramVarArgs.gB(9, this.pyo);
      if (this.tWO != null) {
        paramVarArgs.d(19, this.tWO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWK == null) {
        break label686;
      }
    }
    label686:
    for (int i = d.a.a.b.b.a.e(1, this.tWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tWL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tWL);
      }
      i = paramInt;
      if (this.tqX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tqX);
      }
      paramInt = i;
      if (this.tEK != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tEK);
      }
      i = paramInt + d.a.a.a.gy(5, this.fdX);
      paramInt = i;
      if (this.mQi != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.mQi);
      }
      i = paramInt;
      if (this.tWM != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tWM);
      }
      paramInt = i;
      if (this.tWN != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tWN);
      }
      i = paramInt + d.a.a.a.gy(9, this.pyo);
      paramInt = i;
      if (this.tWO != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.tWO);
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
        cih localcih = (cih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          return -1;
        case 1: 
          localcih.tWK = locala.xpH.readString();
          return 0;
        case 2: 
          localcih.tWL = locala.xpH.readString();
          return 0;
        case 3: 
          localcih.tqX = locala.xpH.readString();
          return 0;
        case 4: 
          localcih.tEK = locala.xpH.readString();
          return 0;
        case 5: 
          localcih.fdX = locala.xpH.oD();
          return 0;
        case 6: 
          localcih.mQi = locala.xpH.readString();
          return 0;
        case 7: 
          localcih.tWM = locala.xpH.readString();
          return 0;
        case 8: 
          localcih.tWN = locala.xpH.readString();
          return 0;
        case 9: 
          localcih.pyo = locala.xpH.oD();
          return 0;
        }
        localcih.tWO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cih
 * JD-Core Version:    0.7.0.1
 */