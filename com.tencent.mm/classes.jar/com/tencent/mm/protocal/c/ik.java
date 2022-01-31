package com.tencent.mm.protocal.c;

public final class ik
  extends com.tencent.mm.bv.a
{
  public int nSM;
  public long sCD;
  public String sxi;
  public long sxj;
  public long sxm;
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
      paramVarArgs.Y(3, this.sxm);
      paramVarArgs.Y(4, this.sCD);
      paramVarArgs.gB(5, this.nSM);
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxi == null) {
        break label386;
      }
    }
    label386:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxi) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sxj) + d.a.a.a.X(3, this.sxm) + d.a.a.a.X(4, this.sCD) + d.a.a.a.gy(5, this.nSM);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.url);
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
        ik localik = (ik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localik.sxi = locala.xpH.readString();
          return 0;
        case 2: 
          localik.sxj = locala.xpH.oE();
          return 0;
        case 3: 
          localik.sxm = locala.xpH.oE();
          return 0;
        case 4: 
          localik.sCD = locala.xpH.oE();
          return 0;
        case 5: 
          localik.nSM = locala.xpH.oD();
          return 0;
        }
        localik.url = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ik
 * JD-Core Version:    0.7.0.1
 */