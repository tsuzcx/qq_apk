package com.tencent.mm.protocal.c;

public final class awj
  extends com.tencent.mm.bv.a
{
  public int tsV;
  public int tsW;
  public int tsX;
  public int tsY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tsV);
      paramVarArgs.gB(2, this.tsW);
      paramVarArgs.gB(3, this.tsX);
      paramVarArgs.gB(4, this.tsY);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tsV) + 0 + d.a.a.a.gy(2, this.tsW) + d.a.a.a.gy(3, this.tsX) + d.a.a.a.gy(4, this.tsY);
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
      awj localawj = (awj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localawj.tsV = locala.xpH.oD();
        return 0;
      case 2: 
        localawj.tsW = locala.xpH.oD();
        return 0;
      case 3: 
        localawj.tsX = locala.xpH.oD();
        return 0;
      }
      localawj.tsY = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awj
 * JD-Core Version:    0.7.0.1
 */