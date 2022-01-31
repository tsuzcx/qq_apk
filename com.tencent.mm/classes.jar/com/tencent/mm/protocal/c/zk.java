package com.tencent.mm.protocal.c;

public final class zk
  extends com.tencent.mm.bv.a
{
  public int bLB;
  public String id;
  public int kpu;
  public String sYJ;
  public long sYK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.gB(2, this.kpu);
      if (this.sYJ != null) {
        paramVarArgs.d(3, this.sYJ);
      }
      paramVarArgs.Y(4, this.sYK);
      paramVarArgs.gB(5, this.bLB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label347;
      }
    }
    label347:
    for (paramInt = d.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kpu);
      paramInt = i;
      if (this.sYJ != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sYJ);
      }
      return paramInt + d.a.a.a.X(4, this.sYK) + d.a.a.a.gy(5, this.bLB);
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
        zk localzk = (zk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localzk.id = locala.xpH.readString();
          return 0;
        case 2: 
          localzk.kpu = locala.xpH.oD();
          return 0;
        case 3: 
          localzk.sYJ = locala.xpH.readString();
          return 0;
        case 4: 
          localzk.sYK = locala.xpH.oE();
          return 0;
        }
        localzk.bLB = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zk
 * JD-Core Version:    0.7.0.1
 */