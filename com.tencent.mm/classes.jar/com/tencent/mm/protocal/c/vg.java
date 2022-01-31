package com.tencent.mm.protocal.c;

public final class vg
  extends com.tencent.mm.bv.a
{
  public String kSy;
  public int sAs;
  public String sRW;
  public String sRX;
  public int sRY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRX != null) {
        paramVarArgs.d(1, this.sRX);
      }
      paramVarArgs.gB(2, this.sAs);
      paramVarArgs.gB(3, this.sRY);
      if (this.kSy != null) {
        paramVarArgs.d(4, this.kSy);
      }
      if (this.sRW != null) {
        paramVarArgs.d(5, this.sRW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRX == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = d.a.a.b.b.a.e(1, this.sRX) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sAs) + d.a.a.a.gy(3, this.sRY);
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSy);
      }
      i = paramInt;
      if (this.sRW != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sRW);
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
        vg localvg = (vg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localvg.sRX = locala.xpH.readString();
          return 0;
        case 2: 
          localvg.sAs = locala.xpH.oD();
          return 0;
        case 3: 
          localvg.sRY = locala.xpH.oD();
          return 0;
        case 4: 
          localvg.kSy = locala.xpH.readString();
          return 0;
        }
        localvg.sRW = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.vg
 * JD-Core Version:    0.7.0.1
 */