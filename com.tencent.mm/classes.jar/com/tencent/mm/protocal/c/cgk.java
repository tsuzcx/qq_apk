package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cgk
  extends com.tencent.mm.bv.a
{
  public String dCX;
  public b sRj;
  public int uC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uC);
      if (this.dCX != null) {
        paramVarArgs.d(2, this.dCX);
      }
      if (this.sRj != null) {
        paramVarArgs.b(3, this.sRj);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.uC) + 0;
      paramInt = i;
      if (this.dCX != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.dCX);
      }
      i = paramInt;
    } while (this.sRj == null);
    return paramInt + d.a.a.a.a(3, this.sRj);
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
      cgk localcgk = (cgk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcgk.uC = locala.xpH.oD();
        return 0;
      case 2: 
        localcgk.dCX = locala.xpH.readString();
        return 0;
      }
      localcgk.sRj = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgk
 * JD-Core Version:    0.7.0.1
 */