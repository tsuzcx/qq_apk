package com.tencent.mm.protocal.c;

public final class bue
  extends com.tencent.mm.bv.a
{
  public float aXH;
  public int oQw;
  public float tKS;
  public float tKT;
  public float tKU;
  public float tKV;
  public int tKW;
  public long tKX;
  public long tKY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.m(1, this.tKS);
      paramVarArgs.m(2, this.tKT);
      paramVarArgs.m(3, this.tKU);
      paramVarArgs.m(4, this.tKV);
      paramVarArgs.gB(5, this.tKW);
      paramVarArgs.Y(6, this.tKX);
      paramVarArgs.Y(7, this.tKY);
      paramVarArgs.m(8, this.aXH);
      paramVarArgs.gB(9, this.oQw);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 4 + 0 + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4) + (d.a.a.b.b.a.dQ(4) + 4) + d.a.a.a.gy(5, this.tKW) + d.a.a.a.X(6, this.tKX) + d.a.a.a.X(7, this.tKY) + (d.a.a.b.b.a.dQ(8) + 4) + d.a.a.a.gy(9, this.oQw);
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
      bue localbue = (bue)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbue.tKS = locala.xpH.readFloat();
        return 0;
      case 2: 
        localbue.tKT = locala.xpH.readFloat();
        return 0;
      case 3: 
        localbue.tKU = locala.xpH.readFloat();
        return 0;
      case 4: 
        localbue.tKV = locala.xpH.readFloat();
        return 0;
      case 5: 
        localbue.tKW = locala.xpH.oD();
        return 0;
      case 6: 
        localbue.tKX = locala.xpH.oE();
        return 0;
      case 7: 
        localbue.tKY = locala.xpH.oE();
        return 0;
      case 8: 
        localbue.aXH = locala.xpH.readFloat();
        return 0;
      }
      localbue.oQw = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bue
 * JD-Core Version:    0.7.0.1
 */