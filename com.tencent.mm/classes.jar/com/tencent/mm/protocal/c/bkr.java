package com.tencent.mm.protocal.c;

public class bkr
  extends com.tencent.mm.bv.a
{
  public int kVX;
  public String sCE;
  public long tEo;
  public int tEp;
  public boolean tEq;
  public boolean tEr;
  public int tEs;
  public boolean tEt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCE != null) {
        paramVarArgs.d(1, this.sCE);
      }
      paramVarArgs.Y(2, this.tEo);
      paramVarArgs.gB(3, this.tEp);
      paramVarArgs.aA(4, this.tEq);
      paramVarArgs.aA(5, this.tEr);
      paramVarArgs.gB(6, this.tEs);
      paramVarArgs.gB(7, this.kVX);
      paramVarArgs.aA(8, this.tEt);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCE == null) {
        break label419;
      }
    }
    label419:
    for (paramInt = d.a.a.b.b.a.e(1, this.sCE) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tEo) + d.a.a.a.gy(3, this.tEp) + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1) + d.a.a.a.gy(6, this.tEs) + d.a.a.a.gy(7, this.kVX) + (d.a.a.b.b.a.dQ(8) + 1);
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
        bkr localbkr = (bkr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbkr.sCE = locala.xpH.readString();
          return 0;
        case 2: 
          localbkr.tEo = locala.xpH.oE();
          return 0;
        case 3: 
          localbkr.tEp = locala.xpH.oD();
          return 0;
        case 4: 
          localbkr.tEq = locala.cUr();
          return 0;
        case 5: 
          localbkr.tEr = locala.cUr();
          return 0;
        case 6: 
          localbkr.tEs = locala.xpH.oD();
          return 0;
        case 7: 
          localbkr.kVX = locala.xpH.oD();
          return 0;
        }
        localbkr.tEt = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkr
 * JD-Core Version:    0.7.0.1
 */