package com.tencent.mm.plugin.product.c;

public final class n
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int bcw;
  public String mTc;
  public String name;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.mTc != null) {
        paramVarArgs.d(3, this.mTc);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      paramVarArgs.gB(5, this.bcw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label379;
      }
    }
    label379:
    for (int i = d.a.a.b.b.a.e(1, this.bOL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.mTc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mTc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.username);
      }
      return paramInt + d.a.a.a.gy(5, this.bcw);
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
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localn.name = locala.xpH.readString();
          return 0;
        case 3: 
          localn.mTc = locala.xpH.readString();
          return 0;
        case 4: 
          localn.username = locala.xpH.readString();
          return 0;
        }
        localn.bcw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.n
 * JD-Core Version:    0.7.0.1
 */