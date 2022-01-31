package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cjf
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kVs;
  public int kWl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kVs == null) {
        throw new b("Not all required fields were included: Content");
      }
      paramVarArgs.gB(1, this.kWl);
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kVs != null) {
        paramVarArgs.d(3, this.kVs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.kWl) + 0;
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
    } while (this.kVs == null);
    return paramInt + d.a.a.b.b.a.e(3, this.kVs);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kVs == null) {
        throw new b("Not all required fields were included: Content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cjf localcjf = (cjf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcjf.kWl = locala.xpH.oD();
        return 0;
      case 2: 
        localcjf.bGw = locala.xpH.readString();
        return 0;
      }
      localcjf.kVs = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjf
 * JD-Core Version:    0.7.0.1
 */