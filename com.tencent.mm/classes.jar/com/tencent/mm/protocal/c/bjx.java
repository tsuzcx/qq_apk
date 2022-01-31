package com.tencent.mm.protocal.c;

public final class bjx
  extends com.tencent.mm.bv.a
{
  public int tAb;
  public String tDI;
  public String tDJ;
  public int tDK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tAb);
      if (this.tDI != null) {
        paramVarArgs.d(2, this.tDI);
      }
      if (this.tDJ != null) {
        paramVarArgs.d(3, this.tDJ);
      }
      paramVarArgs.gB(4, this.tDK);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.tAb) + 0;
      paramInt = i;
      if (this.tDI != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tDI);
      }
      i = paramInt;
      if (this.tDJ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tDJ);
      }
      return i + d.a.a.a.gy(4, this.tDK);
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
      bjx localbjx = (bjx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbjx.tAb = locala.xpH.oD();
        return 0;
      case 2: 
        localbjx.tDI = locala.xpH.readString();
        return 0;
      case 3: 
        localbjx.tDJ = locala.xpH.readString();
        return 0;
      }
      localbjx.tDK = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjx
 * JD-Core Version:    0.7.0.1
 */