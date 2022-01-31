package com.tencent.mm.plugin.product.c;

public final class g
  extends com.tencent.mm.bv.a
{
  public String cCA;
  public String cCB;
  public String country;
  public String ekZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.d(1, this.country);
      }
      if (this.cCA != null) {
        paramVarArgs.d(2, this.cCA);
      }
      if (this.cCB != null) {
        paramVarArgs.d(3, this.cCB);
      }
      if (this.ekZ != null) {
        paramVarArgs.d(4, this.ekZ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cCA != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.cCA);
      }
      i = paramInt;
      if (this.cCB != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.cCB);
      }
      paramInt = i;
      if (this.ekZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ekZ);
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
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localg.country = locala.xpH.readString();
          return 0;
        case 2: 
          localg.cCA = locala.xpH.readString();
          return 0;
        case 3: 
          localg.cCB = locala.xpH.readString();
          return 0;
        }
        localg.ekZ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.g
 * JD-Core Version:    0.7.0.1
 */