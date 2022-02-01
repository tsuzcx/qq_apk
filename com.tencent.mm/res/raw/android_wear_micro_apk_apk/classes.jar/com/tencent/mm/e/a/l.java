package com.tencent.mm.e.a;

import a.a.a.b;

public final class l
  extends com.tencent.mm.d.a
{
  public String XA;
  public String XB;
  public String XC;
  public String XD;
  public String XE;
  public int XF;
  public String Xw;
  public String Xx;
  public String Xy;
  public String Xz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.Xw == null) {
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (this.Xw != null) {
        paramVarArgs.d(1, this.Xw);
      }
      if (this.Xx != null) {
        paramVarArgs.d(2, this.Xx);
      }
      if (this.Xy != null) {
        paramVarArgs.d(3, this.Xy);
      }
      if (this.Xz != null) {
        paramVarArgs.d(4, this.Xz);
      }
      if (this.XA != null) {
        paramVarArgs.d(5, this.XA);
      }
      if (this.XB != null) {
        paramVarArgs.d(6, this.XB);
      }
      if (this.XC != null) {
        paramVarArgs.d(7, this.XC);
      }
      if (this.XD != null) {
        paramVarArgs.d(8, this.XD);
      }
      if (this.XE != null) {
        paramVarArgs.d(9, this.XE);
      }
      paramVarArgs.at(10, this.XF);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Xw == null) {
        break label664;
      }
    }
    label664:
    for (int i = a.a.a.b.b.a.e(1, this.Xw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Xx != null) {
        paramInt = i + a.a.a.b.b.a.e(2, this.Xx);
      }
      i = paramInt;
      if (this.Xy != null) {
        i = paramInt + a.a.a.b.b.a.e(3, this.Xy);
      }
      paramInt = i;
      if (this.Xz != null) {
        paramInt = i + a.a.a.b.b.a.e(4, this.Xz);
      }
      i = paramInt;
      if (this.XA != null) {
        i = paramInt + a.a.a.b.b.a.e(5, this.XA);
      }
      paramInt = i;
      if (this.XB != null) {
        paramInt = i + a.a.a.b.b.a.e(6, this.XB);
      }
      i = paramInt;
      if (this.XC != null) {
        i = paramInt + a.a.a.b.b.a.e(7, this.XC);
      }
      paramInt = i;
      if (this.XD != null) {
        paramInt = i + a.a.a.b.b.a.e(8, this.XD);
      }
      i = paramInt;
      if (this.XE != null) {
        i = paramInt + a.a.a.b.b.a.e(9, this.XE);
      }
      return i + a.a.a.a.an(10, this.XF);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], Xe);
        for (paramInt = paramVarArgs.pl(); paramInt > 0; paramInt = paramVarArgs.pl()) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.pm();
          }
        }
        if (this.Xw != null) {
          break;
        }
        throw new b("Not all required fields were included: LocalNodeId");
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locall.Xw = locala.ph();
          return 0;
        case 2: 
          locall.Xx = locala.ph();
          return 0;
        case 3: 
          locall.Xy = locala.ph();
          return 0;
        case 4: 
          locall.Xz = locala.ph();
          return 0;
        case 5: 
          locall.XA = locala.ph();
          return 0;
        case 6: 
          locall.XB = locala.ph();
          return 0;
        case 7: 
          locall.XC = locala.ph();
          return 0;
        case 8: 
          locall.XD = locala.ph();
          return 0;
        case 9: 
          locall.XE = locala.ph();
          return 0;
        }
        locall.XF = locala.pg();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.e.a.l
 * JD-Core Version:    0.7.0.1
 */