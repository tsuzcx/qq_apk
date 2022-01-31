package com.tencent.mm.protocal.c;

public final class ayz
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public int jwX;
  public String sAY;
  public String sPt;
  public int sTj;
  public int tmx;
  public String tuM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.jwX);
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.sAY != null) {
        paramVarArgs.d(3, this.sAY);
      }
      if (this.sPt != null) {
        paramVarArgs.d(4, this.sPt);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      paramVarArgs.gB(6, this.tmx);
      paramVarArgs.gB(7, this.sTj);
      if (this.tuM != null) {
        paramVarArgs.d(8, this.tuM);
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
      i = d.a.a.a.gy(1, this.jwX) + 0;
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.sAY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAY);
      }
      paramInt = i;
      if (this.sPt != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPt);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      i = i + d.a.a.a.gy(6, this.tmx) + d.a.a.a.gy(7, this.sTj);
      paramInt = i;
    } while (this.tuM == null);
    return i + d.a.a.b.b.a.e(8, this.tuM);
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
      ayz localayz = (ayz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localayz.jwX = locala.xpH.oD();
        return 0;
      case 2: 
        localayz.hRf = locala.xpH.readString();
        return 0;
      case 3: 
        localayz.sAY = locala.xpH.readString();
        return 0;
      case 4: 
        localayz.sPt = locala.xpH.readString();
        return 0;
      case 5: 
        localayz.hPY = locala.xpH.readString();
        return 0;
      case 6: 
        localayz.tmx = locala.xpH.oD();
        return 0;
      case 7: 
        localayz.sTj = locala.xpH.oD();
        return 0;
      }
      localayz.tuM = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayz
 * JD-Core Version:    0.7.0.1
 */