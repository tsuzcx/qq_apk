package com.tencent.mm.protocal.c;

public final class ds
  extends com.tencent.mm.bv.a
{
  public int nSM;
  public String sxi;
  public long sxj;
  public int sxk;
  public int sxl;
  public long sxm;
  public int sxn;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxi != null) {
        paramVarArgs.d(1, this.sxi);
      }
      paramVarArgs.Y(2, this.sxj);
      paramVarArgs.gB(3, this.nSM);
      paramVarArgs.gB(4, this.sxk);
      paramVarArgs.gB(5, this.sxl);
      paramVarArgs.Y(6, this.sxm);
      paramVarArgs.gB(7, this.sxn);
      if (this.url != null) {
        paramVarArgs.d(8, this.url);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxi == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxi) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sxj) + d.a.a.a.gy(3, this.nSM) + d.a.a.a.gy(4, this.sxk) + d.a.a.a.gy(5, this.sxl) + d.a.a.a.X(6, this.sxm) + d.a.a.a.gy(7, this.sxn);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.url);
      }
      return paramInt;
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
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localds.sxi = locala.xpH.readString();
          return 0;
        case 2: 
          localds.sxj = locala.xpH.oE();
          return 0;
        case 3: 
          localds.nSM = locala.xpH.oD();
          return 0;
        case 4: 
          localds.sxk = locala.xpH.oD();
          return 0;
        case 5: 
          localds.sxl = locala.xpH.oD();
          return 0;
        case 6: 
          localds.sxm = locala.xpH.oE();
          return 0;
        case 7: 
          localds.sxn = locala.xpH.oD();
          return 0;
        }
        localds.url = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ds
 * JD-Core Version:    0.7.0.1
 */