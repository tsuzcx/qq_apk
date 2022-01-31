package com.tencent.mm.plugin.qqmail.b;

public final class g
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public int ndm;
  public String ndn;
  public int ndo;
  public long ndp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ndm);
      if (this.ndn != null) {
        paramVarArgs.d(2, this.ndn);
      }
      paramVarArgs.gB(3, this.hQq);
      paramVarArgs.gB(4, this.ndo);
      paramVarArgs.Y(5, this.ndp);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.ndm) + 0;
      paramInt = i;
      if (this.ndn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ndn);
      }
      return paramInt + d.a.a.a.gy(3, this.hQq) + d.a.a.a.gy(4, this.ndo) + d.a.a.a.X(5, this.ndp);
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
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localg.ndm = locala.xpH.oD();
        return 0;
      case 2: 
        localg.ndn = locala.xpH.readString();
        return 0;
      case 3: 
        localg.hQq = locala.xpH.oD();
        return 0;
      case 4: 
        localg.ndo = locala.xpH.oD();
        return 0;
      }
      localg.ndp = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.g
 * JD-Core Version:    0.7.0.1
 */