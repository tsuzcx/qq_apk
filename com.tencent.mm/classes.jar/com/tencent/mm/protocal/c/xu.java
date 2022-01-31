package com.tencent.mm.protocal.c;

public final class xu
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public String sGQ;
  public int sGR;
  public String sLS;
  public String sLT;
  public String sLU;
  public int sLV;
  public String sUw;
  public String sUx;
  public int sUy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sLS != null) {
        paramVarArgs.d(1, this.sLS);
      }
      if (this.sLT != null) {
        paramVarArgs.d(2, this.sLT);
      }
      if (this.sLU != null) {
        paramVarArgs.d(3, this.sLU);
      }
      paramVarArgs.gB(4, this.sLV);
      if (this.sUw != null) {
        paramVarArgs.d(5, this.sUw);
      }
      if (this.sGQ != null) {
        paramVarArgs.d(6, this.sGQ);
      }
      paramVarArgs.gB(7, this.sGR);
      if (this.sUx != null) {
        paramVarArgs.d(8, this.sUx);
      }
      paramVarArgs.gB(9, this.hQq);
      paramVarArgs.gB(10, this.sUy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sLS == null) {
        break label614;
      }
    }
    label614:
    for (int i = d.a.a.b.b.a.e(1, this.sLS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sLT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sLT);
      }
      i = paramInt;
      if (this.sLU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLU);
      }
      i += d.a.a.a.gy(4, this.sLV);
      paramInt = i;
      if (this.sUw != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sUw);
      }
      i = paramInt;
      if (this.sGQ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sGQ);
      }
      i += d.a.a.a.gy(7, this.sGR);
      paramInt = i;
      if (this.sUx != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sUx);
      }
      return paramInt + d.a.a.a.gy(9, this.hQq) + d.a.a.a.gy(10, this.sUy);
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
        xu localxu = (xu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localxu.sLS = locala.xpH.readString();
          return 0;
        case 2: 
          localxu.sLT = locala.xpH.readString();
          return 0;
        case 3: 
          localxu.sLU = locala.xpH.readString();
          return 0;
        case 4: 
          localxu.sLV = locala.xpH.oD();
          return 0;
        case 5: 
          localxu.sUw = locala.xpH.readString();
          return 0;
        case 6: 
          localxu.sGQ = locala.xpH.readString();
          return 0;
        case 7: 
          localxu.sGR = locala.xpH.oD();
          return 0;
        case 8: 
          localxu.sUx = locala.xpH.readString();
          return 0;
        case 9: 
          localxu.hQq = locala.xpH.oD();
          return 0;
        }
        localxu.sUy = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xu
 * JD-Core Version:    0.7.0.1
 */