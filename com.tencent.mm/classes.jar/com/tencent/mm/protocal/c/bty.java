package com.tencent.mm.protocal.c;

public final class bty
  extends com.tencent.mm.bv.a
{
  public int oTt;
  public int oTu;
  public String swU;
  public String swV;
  public String swW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swU != null) {
        paramVarArgs.d(1, this.swU);
      }
      if (this.swV != null) {
        paramVarArgs.d(2, this.swV);
      }
      if (this.swW != null) {
        paramVarArgs.d(3, this.swW);
      }
      paramVarArgs.gB(4, this.oTt);
      paramVarArgs.gB(5, this.oTu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.swU == null) {
        break label363;
      }
    }
    label363:
    for (int i = d.a.a.b.b.a.e(1, this.swU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swV != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swV);
      }
      i = paramInt;
      if (this.swW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.swW);
      }
      return i + d.a.a.a.gy(4, this.oTt) + d.a.a.a.gy(5, this.oTu);
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
        bty localbty = (bty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbty.swU = locala.xpH.readString();
          return 0;
        case 2: 
          localbty.swV = locala.xpH.readString();
          return 0;
        case 3: 
          localbty.swW = locala.xpH.readString();
          return 0;
        case 4: 
          localbty.oTt = locala.xpH.oD();
          return 0;
        }
        localbty.oTu = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bty
 * JD-Core Version:    0.7.0.1
 */