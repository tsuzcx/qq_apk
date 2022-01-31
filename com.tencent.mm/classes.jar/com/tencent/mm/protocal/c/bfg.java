package com.tencent.mm.protocal.c;

public final class bfg
  extends com.tencent.mm.bv.a
{
  public int tzV;
  public int tzW;
  public String tzX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tzV);
      paramVarArgs.gB(2, this.tzW);
      if (this.tzX != null) {
        paramVarArgs.d(3, this.tzX);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.tzV) + 0 + d.a.a.a.gy(2, this.tzW);
      paramInt = i;
    } while (this.tzX == null);
    return i + d.a.a.b.b.a.e(3, this.tzX);
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
      bfg localbfg = (bfg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbfg.tzV = locala.xpH.oD();
        return 0;
      case 2: 
        localbfg.tzW = locala.xpH.oD();
        return 0;
      }
      localbfg.tzX = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfg
 * JD-Core Version:    0.7.0.1
 */