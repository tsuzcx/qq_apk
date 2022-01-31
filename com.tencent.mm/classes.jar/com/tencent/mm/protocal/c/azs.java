package com.tencent.mm.protocal.c;

public final class azs
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String gkl;
  public String scope;
  public int tvP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.gB(3, this.tvP);
      if (this.gkl != null) {
        paramVarArgs.d(4, this.gkl);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.desc);
      }
      i += d.a.a.a.gy(3, this.tvP);
      paramInt = i;
      if (this.gkl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.gkl);
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
        azs localazs = (azs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localazs.scope = locala.xpH.readString();
          return 0;
        case 2: 
          localazs.desc = locala.xpH.readString();
          return 0;
        case 3: 
          localazs.tvP = locala.xpH.oD();
          return 0;
        }
        localazs.gkl = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azs
 * JD-Core Version:    0.7.0.1
 */