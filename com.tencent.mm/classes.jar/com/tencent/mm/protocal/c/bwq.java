package com.tencent.mm.protocal.c;

public final class bwq
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public int tMW;
  public String tMX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.tMW);
      if (this.tMX != null) {
        paramVarArgs.d(4, this.tMX);
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
      i = d.a.a.a.gy(2, this.hQR) + 0 + d.a.a.a.gy(3, this.tMW);
      paramInt = i;
    } while (this.tMX == null);
    return i + d.a.a.b.b.a.e(4, this.tMX);
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
      bwq localbwq = (bwq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 2: 
        localbwq.hQR = locala.xpH.oD();
        return 0;
      case 3: 
        localbwq.tMW = locala.xpH.oD();
        return 0;
      }
      localbwq.tMX = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bwq
 * JD-Core Version:    0.7.0.1
 */