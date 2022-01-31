package com.tencent.mm.protocal.c;

public final class byw
  extends com.tencent.mm.bv.a
{
  public String lnT;
  public String mOb;
  public String nvA;
  public String nvB;
  public String nve;
  public String nvy;
  public String nvz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.nvy != null) {
        paramVarArgs.d(1, this.nvy);
      }
      if (this.nvz != null) {
        paramVarArgs.d(2, this.nvz);
      }
      if (this.nve != null) {
        paramVarArgs.d(3, this.nve);
      }
      if (this.lnT != null) {
        paramVarArgs.d(4, this.lnT);
      }
      if (this.mOb != null) {
        paramVarArgs.d(5, this.mOb);
      }
      if (this.nvA != null) {
        paramVarArgs.d(6, this.nvA);
      }
      if (this.nvB != null) {
        paramVarArgs.d(7, this.nvB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.nvy == null) {
        break label513;
      }
    }
    label513:
    for (int i = d.a.a.b.b.a.e(1, this.nvy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nvz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nvz);
      }
      i = paramInt;
      if (this.nve != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nve);
      }
      paramInt = i;
      if (this.lnT != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lnT);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.mOb);
      }
      paramInt = i;
      if (this.nvA != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.nvA);
      }
      i = paramInt;
      if (this.nvB != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.nvB);
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
        byw localbyw = (byw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbyw.nvy = locala.xpH.readString();
          return 0;
        case 2: 
          localbyw.nvz = locala.xpH.readString();
          return 0;
        case 3: 
          localbyw.nve = locala.xpH.readString();
          return 0;
        case 4: 
          localbyw.lnT = locala.xpH.readString();
          return 0;
        case 5: 
          localbyw.mOb = locala.xpH.readString();
          return 0;
        case 6: 
          localbyw.nvA = locala.xpH.readString();
          return 0;
        }
        localbyw.nvB = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byw
 * JD-Core Version:    0.7.0.1
 */