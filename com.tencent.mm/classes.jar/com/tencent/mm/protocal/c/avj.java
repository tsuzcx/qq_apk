package com.tencent.mm.protocal.c;

public final class avj
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public String sEb;
  public long tqQ;
  public long tqR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.pyo);
      if (this.sEb != null) {
        paramVarArgs.d(2, this.sEb);
      }
      paramVarArgs.Y(3, this.tqR);
      paramVarArgs.Y(4, this.tqQ);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.pyo) + 0;
      paramInt = i;
      if (this.sEb != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sEb);
      }
      return paramInt + d.a.a.a.X(3, this.tqR) + d.a.a.a.X(4, this.tqQ);
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
      avj localavj = (avj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localavj.pyo = locala.xpH.oD();
        return 0;
      case 2: 
        localavj.sEb = locala.xpH.readString();
        return 0;
      case 3: 
        localavj.tqR = locala.xpH.oE();
        return 0;
      }
      localavj.tqQ = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avj
 * JD-Core Version:    0.7.0.1
 */