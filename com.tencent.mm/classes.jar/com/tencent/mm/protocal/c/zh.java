package com.tencent.mm.protocal.c;

public final class zh
  extends com.tencent.mm.bv.a
{
  public int ghE;
  public int index;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.index);
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.gB(3, this.ghE);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.username);
      }
      return paramInt + d.a.a.a.gy(3, this.ghE);
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
      zh localzh = (zh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localzh.index = locala.xpH.oD();
        return 0;
      case 2: 
        localzh.username = locala.xpH.readString();
        return 0;
      }
      localzh.ghE = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zh
 * JD-Core Version:    0.7.0.1
 */