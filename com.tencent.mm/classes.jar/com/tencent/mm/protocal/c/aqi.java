package com.tencent.mm.protocal.c;

public final class aqi
  extends com.tencent.mm.bv.a
{
  public int key;
  public int length;
  public long tmo;
  public int tmp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.key);
      paramVarArgs.Y(2, this.tmo);
      paramVarArgs.gB(3, this.length);
      paramVarArgs.gB(4, this.tmp);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.key) + 0 + d.a.a.a.X(2, this.tmo) + d.a.a.a.gy(3, this.length) + d.a.a.a.gy(4, this.tmp);
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
      aqi localaqi = (aqi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaqi.key = locala.xpH.oD();
        return 0;
      case 2: 
        localaqi.tmo = locala.xpH.oE();
        return 0;
      case 3: 
        localaqi.length = locala.xpH.oD();
        return 0;
      }
      localaqi.tmp = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqi
 * JD-Core Version:    0.7.0.1
 */