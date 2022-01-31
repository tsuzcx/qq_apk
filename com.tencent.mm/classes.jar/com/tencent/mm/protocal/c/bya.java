package com.tencent.mm.protocal.c;

public final class bya
  extends com.tencent.mm.bv.a
{
  public String ivD;
  public String sign;
  public String tNW;
  public int tNX;
  public String taA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tNW != null) {
        paramVarArgs.d(4, this.tNW);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      if (this.ivD != null) {
        paramVarArgs.d(6, this.ivD);
      }
      paramVarArgs.gB(7, this.tNX);
      if (this.taA != null) {
        paramVarArgs.d(8, this.taA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tNW == null) {
        break label387;
      }
    }
    label387:
    for (int i = d.a.a.b.b.a.e(4, this.tNW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sign);
      }
      i = paramInt;
      if (this.ivD != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.ivD);
      }
      i += d.a.a.a.gy(7, this.tNX);
      paramInt = i;
      if (this.taA != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.taA);
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
        bya localbya = (bya)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 4: 
          localbya.tNW = locala.xpH.readString();
          return 0;
        case 5: 
          localbya.sign = locala.xpH.readString();
          return 0;
        case 6: 
          localbya.ivD = locala.xpH.readString();
          return 0;
        case 7: 
          localbya.tNX = locala.xpH.oD();
          return 0;
        }
        localbya.taA = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bya
 * JD-Core Version:    0.7.0.1
 */