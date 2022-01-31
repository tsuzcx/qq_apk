package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ciy
  extends com.tencent.mm.bv.a
{
  public String sxM;
  public long tXf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxM == null) {
        throw new b("Not all required fields were included: Username");
      }
      paramVarArgs.Y(1, this.tXf);
      if (this.sxM != null) {
        paramVarArgs.d(2, this.sxM);
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
      i = d.a.a.a.X(1, this.tXf) + 0;
      paramInt = i;
    } while (this.sxM == null);
    return i + d.a.a.b.b.a.e(2, this.sxM);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sxM == null) {
        throw new b("Not all required fields were included: Username");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ciy localciy = (ciy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localciy.tXf = locala.xpH.oE();
        return 0;
      }
      localciy.sxM = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ciy
 * JD-Core Version:    0.7.0.1
 */