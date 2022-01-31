package com.tencent.mm.protocal.c;

public final class aqd
  extends com.tencent.mm.bv.a
{
  public int bGv;
  public int tlX;
  public int tlY;
  public int tlZ;
  public int tma;
  public int tmb;
  public int tmc;
  public int tmd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tlX);
      paramVarArgs.gB(2, this.bGv);
      paramVarArgs.gB(3, this.tlY);
      paramVarArgs.gB(4, this.tlZ);
      paramVarArgs.gB(5, this.tma);
      paramVarArgs.gB(6, this.tmb);
      paramVarArgs.gB(7, this.tmc);
      paramVarArgs.gB(8, this.tmd);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tlX) + 0 + d.a.a.a.gy(2, this.bGv) + d.a.a.a.gy(3, this.tlY) + d.a.a.a.gy(4, this.tlZ) + d.a.a.a.gy(5, this.tma) + d.a.a.a.gy(6, this.tmb) + d.a.a.a.gy(7, this.tmc) + d.a.a.a.gy(8, this.tmd);
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
      aqd localaqd = (aqd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaqd.tlX = locala.xpH.oD();
        return 0;
      case 2: 
        localaqd.bGv = locala.xpH.oD();
        return 0;
      case 3: 
        localaqd.tlY = locala.xpH.oD();
        return 0;
      case 4: 
        localaqd.tlZ = locala.xpH.oD();
        return 0;
      case 5: 
        localaqd.tma = locala.xpH.oD();
        return 0;
      case 6: 
        localaqd.tmb = locala.xpH.oD();
        return 0;
      case 7: 
        localaqd.tmc = locala.xpH.oD();
        return 0;
      }
      localaqd.tmd = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqd
 * JD-Core Version:    0.7.0.1
 */