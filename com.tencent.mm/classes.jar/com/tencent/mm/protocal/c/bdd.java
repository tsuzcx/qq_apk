package com.tencent.mm.protocal.c;

public final class bdd
  extends com.tencent.mm.bv.a
{
  public String cCA;
  public String cCB;
  public double latitude;
  public double longitude;
  public long sum;
  public String sun;
  public String suo;
  public String sup;
  public String suq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.cCA != null) {
        paramVarArgs.d(1, this.cCA);
      }
      if (this.cCB != null) {
        paramVarArgs.d(2, this.cCB);
      }
      paramVarArgs.b(3, this.latitude);
      paramVarArgs.b(4, this.longitude);
      paramVarArgs.Y(5, this.sum);
      if (this.sun != null) {
        paramVarArgs.d(6, this.sun);
      }
      if (this.suo != null) {
        paramVarArgs.d(7, this.suo);
      }
      if (this.sup != null) {
        paramVarArgs.d(8, this.sup);
      }
      if (this.suq != null) {
        paramVarArgs.d(9, this.suq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.cCA == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = d.a.a.b.b.a.e(1, this.cCA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cCB != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.cCB);
      }
      i = i + (d.a.a.b.b.a.dQ(3) + 8) + (d.a.a.b.b.a.dQ(4) + 8) + d.a.a.a.X(5, this.sum);
      paramInt = i;
      if (this.sun != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sun);
      }
      i = paramInt;
      if (this.suo != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.suo);
      }
      paramInt = i;
      if (this.sup != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sup);
      }
      i = paramInt;
      if (this.suq != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.suq);
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
        bdd localbdd = (bdd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbdd.cCA = locala.xpH.readString();
          return 0;
        case 2: 
          localbdd.cCB = locala.xpH.readString();
          return 0;
        case 3: 
          localbdd.latitude = locala.xpH.readDouble();
          return 0;
        case 4: 
          localbdd.longitude = locala.xpH.readDouble();
          return 0;
        case 5: 
          localbdd.sum = locala.xpH.oE();
          return 0;
        case 6: 
          localbdd.sun = locala.xpH.readString();
          return 0;
        case 7: 
          localbdd.suo = locala.xpH.readString();
          return 0;
        case 8: 
          localbdd.sup = locala.xpH.readString();
          return 0;
        }
        localbdd.suq = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdd
 * JD-Core Version:    0.7.0.1
 */