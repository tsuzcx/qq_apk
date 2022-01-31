package com.tencent.mm.protocal.c;

public final class clb
  extends com.tencent.mm.bv.a
{
  public boolean tYp;
  public boolean tYq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.tYp);
      paramVarArgs.aA(2, this.tYq);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 1 + 0 + (d.a.a.b.b.a.dQ(2) + 1);
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
      clb localclb = (clb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localclb.tYp = locala.cUr();
        return 0;
      }
      localclb.tYq = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clb
 * JD-Core Version:    0.7.0.1
 */