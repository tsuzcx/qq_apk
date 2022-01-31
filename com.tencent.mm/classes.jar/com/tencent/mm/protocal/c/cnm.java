package com.tencent.mm.protocal.c;

public final class cnm
  extends com.tencent.mm.bv.a
{
  public int uag;
  public boolean uah;
  public boolean uai;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uag);
      paramVarArgs.aA(2, this.uah);
      paramVarArgs.aA(3, this.uai);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.uag) + 0 + (d.a.a.b.b.a.dQ(2) + 1) + (d.a.a.b.b.a.dQ(3) + 1);
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
      cnm localcnm = (cnm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcnm.uag = locala.xpH.oD();
        return 0;
      case 2: 
        localcnm.uah = locala.cUr();
        return 0;
      }
      localcnm.uai = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cnm
 * JD-Core Version:    0.7.0.1
 */