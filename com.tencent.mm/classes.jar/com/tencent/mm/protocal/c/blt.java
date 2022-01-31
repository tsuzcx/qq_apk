package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class blt
  extends com.tencent.mm.bv.a
{
  public int tFp;
  public String tFq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFq == null) {
        throw new b("Not all required fields were included: ResKey");
      }
      paramVarArgs.gB(1, this.tFp);
      if (this.tFq != null) {
        paramVarArgs.d(2, this.tFq);
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
      i = d.a.a.a.gy(1, this.tFp) + 0;
      paramInt = i;
    } while (this.tFq == null);
    return i + d.a.a.b.b.a.e(2, this.tFq);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tFq == null) {
        throw new b("Not all required fields were included: ResKey");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      blt localblt = (blt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localblt.tFp = locala.xpH.oD();
        return 0;
      }
      localblt.tFq = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blt
 * JD-Core Version:    0.7.0.1
 */