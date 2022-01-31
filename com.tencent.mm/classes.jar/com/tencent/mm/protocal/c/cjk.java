package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjk
  extends com.tencent.mm.bv.a
{
  public int kWl;
  public String tTD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tTD == null) {
        throw new b("Not all required fields were included: Data");
      }
      paramVarArgs.gB(1, this.kWl);
      if (this.tTD != null) {
        paramVarArgs.d(2, this.tTD);
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
      i = d.a.a.a.gy(1, this.kWl) + 0;
      paramInt = i;
    } while (this.tTD == null);
    return i + d.a.a.b.b.a.e(2, this.tTD);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tTD == null) {
        throw new b("Not all required fields were included: Data");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cjk localcjk = (cjk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcjk.kWl = locala.xpH.oD();
        return 0;
      }
      localcjk.tTD = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjk
 * JD-Core Version:    0.7.0.1
 */