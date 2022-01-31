package com.tencent.mm.protocal.c;

public final class bfb
  extends com.tencent.mm.bv.a
{
  public double sDm;
  public double sDn;
  public double tzO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, this.sDn);
      paramVarArgs.b(2, this.sDm);
      paramVarArgs.b(3, this.tzO);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 8 + 0 + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8);
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
      bfb localbfb = (bfb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbfb.sDn = locala.xpH.readDouble();
        return 0;
      case 2: 
        localbfb.sDm = locala.xpH.readDouble();
        return 0;
      }
      localbfb.tzO = locala.xpH.readDouble();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfb
 * JD-Core Version:    0.7.0.1
 */