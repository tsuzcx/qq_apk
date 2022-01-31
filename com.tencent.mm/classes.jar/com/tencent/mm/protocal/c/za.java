package com.tencent.mm.protocal.c;

public final class za
  extends com.tencent.mm.bv.a
{
  public String sKU;
  public long sXQ;
  public long sXR;
  public long sXS;
  public String sXT;
  public long sXU;
  public String sXV;
  public String sXW;
  public String sXX;
  public String sXY;
  public String sXZ;
  public String sYa;
  public int sYb;
  public String sYc;
  public int sYd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.sXQ);
      paramVarArgs.Y(2, this.sXR);
      paramVarArgs.Y(3, this.sXS);
      if (this.sXT != null) {
        paramVarArgs.d(4, this.sXT);
      }
      paramVarArgs.Y(5, this.sXU);
      if (this.sXV != null) {
        paramVarArgs.d(6, this.sXV);
      }
      if (this.sXW != null) {
        paramVarArgs.d(7, this.sXW);
      }
      if (this.sXX != null) {
        paramVarArgs.d(8, this.sXX);
      }
      if (this.sXY != null) {
        paramVarArgs.d(9, this.sXY);
      }
      if (this.sXZ != null) {
        paramVarArgs.d(10, this.sXZ);
      }
      if (this.sYa != null) {
        paramVarArgs.d(11, this.sYa);
      }
      paramVarArgs.gB(12, this.sYb);
      if (this.sYc != null) {
        paramVarArgs.d(13, this.sYc);
      }
      paramVarArgs.gB(14, this.sYd);
      if (this.sKU != null) {
        paramVarArgs.d(15, this.sKU);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.sXQ) + 0 + d.a.a.a.X(2, this.sXR) + d.a.a.a.X(3, this.sXS);
      paramInt = i;
      if (this.sXT != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sXT);
      }
      i = paramInt + d.a.a.a.X(5, this.sXU);
      paramInt = i;
      if (this.sXV != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sXV);
      }
      i = paramInt;
      if (this.sXW != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sXW);
      }
      paramInt = i;
      if (this.sXX != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sXX);
      }
      i = paramInt;
      if (this.sXY != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sXY);
      }
      paramInt = i;
      if (this.sXZ != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sXZ);
      }
      i = paramInt;
      if (this.sYa != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sYa);
      }
      i += d.a.a.a.gy(12, this.sYb);
      paramInt = i;
      if (this.sYc != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.sYc);
      }
      i = paramInt + d.a.a.a.gy(14, this.sYd);
      paramInt = i;
    } while (this.sKU == null);
    return i + d.a.a.b.b.a.e(15, this.sKU);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      za localza = (za)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localza.sXQ = locala.xpH.oE();
        return 0;
      case 2: 
        localza.sXR = locala.xpH.oE();
        return 0;
      case 3: 
        localza.sXS = locala.xpH.oE();
        return 0;
      case 4: 
        localza.sXT = locala.xpH.readString();
        return 0;
      case 5: 
        localza.sXU = locala.xpH.oE();
        return 0;
      case 6: 
        localza.sXV = locala.xpH.readString();
        return 0;
      case 7: 
        localza.sXW = locala.xpH.readString();
        return 0;
      case 8: 
        localza.sXX = locala.xpH.readString();
        return 0;
      case 9: 
        localza.sXY = locala.xpH.readString();
        return 0;
      case 10: 
        localza.sXZ = locala.xpH.readString();
        return 0;
      case 11: 
        localza.sYa = locala.xpH.readString();
        return 0;
      case 12: 
        localza.sYb = locala.xpH.oD();
        return 0;
      case 13: 
        localza.sYc = locala.xpH.readString();
        return 0;
      case 14: 
        localza.sYd = locala.xpH.oD();
        return 0;
      }
      localza.sKU = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.za
 * JD-Core Version:    0.7.0.1
 */