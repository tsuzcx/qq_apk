package com.tencent.mm.protocal.c;

public final class aze
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int tou;
  public int tvo;
  public int tvp;
  public int tvq;
  public int tvr;
  public int tvs;
  public int tvt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tou);
      paramVarArgs.gB(2, this.tvo);
      paramVarArgs.gB(3, this.tvp);
      paramVarArgs.gB(4, this.tvq);
      paramVarArgs.gB(5, this.tvr);
      paramVarArgs.gB(6, this.tvs);
      paramVarArgs.gB(7, this.tvt);
      paramVarArgs.gB(8, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tou) + 0 + d.a.a.a.gy(2, this.tvo) + d.a.a.a.gy(3, this.tvp) + d.a.a.a.gy(4, this.tvq) + d.a.a.a.gy(5, this.tvr) + d.a.a.a.gy(6, this.tvs) + d.a.a.a.gy(7, this.tvt) + d.a.a.a.gy(8, this.hQR);
    }
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
      aze localaze = (aze)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaze.tou = locala.xpH.oD();
        return 0;
      case 2: 
        localaze.tvo = locala.xpH.oD();
        return 0;
      case 3: 
        localaze.tvp = locala.xpH.oD();
        return 0;
      case 4: 
        localaze.tvq = locala.xpH.oD();
        return 0;
      case 5: 
        localaze.tvr = locala.xpH.oD();
        return 0;
      case 6: 
        localaze.tvs = locala.xpH.oD();
        return 0;
      case 7: 
        localaze.tvt = locala.xpH.oD();
        return 0;
      }
      localaze.hQR = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aze
 * JD-Core Version:    0.7.0.1
 */