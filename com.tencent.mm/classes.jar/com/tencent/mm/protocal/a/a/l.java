package com.tencent.mm.protocal.a.a;

public final class l
  extends com.tencent.mm.bv.a
{
  public int action;
  public int sqS;
  public int sqT;
  public int sqU;
  public int sqV;
  public int sqW;
  public int sqX;
  public int sqY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sqS);
      paramVarArgs.gB(2, this.action);
      paramVarArgs.gB(3, this.sqT);
      paramVarArgs.gB(4, this.sqU);
      paramVarArgs.gB(5, this.sqV);
      paramVarArgs.gB(6, this.sqW);
      paramVarArgs.gB(7, this.sqX);
      paramVarArgs.gB(8, this.sqY);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.sqS) + 0 + d.a.a.a.gy(2, this.action) + d.a.a.a.gy(3, this.sqT) + d.a.a.a.gy(4, this.sqU) + d.a.a.a.gy(5, this.sqV) + d.a.a.a.gy(6, this.sqW) + d.a.a.a.gy(7, this.sqX) + d.a.a.a.gy(8, this.sqY);
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
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locall.sqS = locala.xpH.oD();
        return 0;
      case 2: 
        locall.action = locala.xpH.oD();
        return 0;
      case 3: 
        locall.sqT = locala.xpH.oD();
        return 0;
      case 4: 
        locall.sqU = locala.xpH.oD();
        return 0;
      case 5: 
        locall.sqV = locala.xpH.oD();
        return 0;
      case 6: 
        locall.sqW = locala.xpH.oD();
        return 0;
      case 7: 
        locall.sqX = locala.xpH.oD();
        return 0;
      }
      locall.sqY = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */