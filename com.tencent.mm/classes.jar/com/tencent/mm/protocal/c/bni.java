package com.tencent.mm.protocal.c;

public final class bni
  extends com.tencent.mm.bv.a
{
  public int kTS;
  public int sSK;
  public int tGp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tGp);
      paramVarArgs.gB(2, this.sSK);
      paramVarArgs.gB(3, this.kTS);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tGp) + 0 + d.a.a.a.gy(2, this.sSK) + d.a.a.a.gy(3, this.kTS);
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
      bni localbni = (bni)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbni.tGp = locala.xpH.oD();
        return 0;
      case 2: 
        localbni.sSK = locala.xpH.oD();
        return 0;
      }
      localbni.kTS = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bni
 * JD-Core Version:    0.7.0.1
 */