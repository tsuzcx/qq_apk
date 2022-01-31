package com.tencent.mm.protocal.c;

public final class iv
  extends com.tencent.mm.bv.a
{
  public String ipb;
  public String sCJ;
  public int sCK;
  public String sCN;
  public String sCP;
  public String sCX;
  public int ver;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCP != null) {
        paramVarArgs.d(1, this.sCP);
      }
      if (this.ipb != null) {
        paramVarArgs.d(2, this.ipb);
      }
      paramVarArgs.gB(3, this.ver);
      if (this.sCJ != null) {
        paramVarArgs.d(4, this.sCJ);
      }
      if (this.sCX != null) {
        paramVarArgs.d(5, this.sCX);
      }
      paramVarArgs.gB(6, this.sCK);
      if (this.sCN != null) {
        paramVarArgs.d(7, this.sCN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCP == null) {
        break label481;
      }
    }
    label481:
    for (paramInt = d.a.a.b.b.a.e(1, this.sCP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ipb != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ipb);
      }
      i += d.a.a.a.gy(3, this.ver);
      paramInt = i;
      if (this.sCJ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sCJ);
      }
      i = paramInt;
      if (this.sCX != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sCX);
      }
      i += d.a.a.a.gy(6, this.sCK);
      paramInt = i;
      if (this.sCN != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sCN);
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
        iv localiv = (iv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localiv.sCP = locala.xpH.readString();
          return 0;
        case 2: 
          localiv.ipb = locala.xpH.readString();
          return 0;
        case 3: 
          localiv.ver = locala.xpH.oD();
          return 0;
        case 4: 
          localiv.sCJ = locala.xpH.readString();
          return 0;
        case 5: 
          localiv.sCX = locala.xpH.readString();
          return 0;
        case 6: 
          localiv.sCK = locala.xpH.oD();
          return 0;
        }
        localiv.sCN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.iv
 * JD-Core Version:    0.7.0.1
 */