package com.tencent.mm.protocal.c;

public final class zj
  extends com.tencent.mm.bv.a
{
  public boolean sYI;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aA(2, this.sYI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label205;
      }
    }
    label205:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      return paramInt + (d.a.a.b.b.a.dQ(2) + 1);
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
        zj localzj = (zj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localzj.username = locala.xpH.readString();
          return 0;
        }
        localzj.sYI = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zj
 * JD-Core Version:    0.7.0.1
 */