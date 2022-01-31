package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cjr
  extends com.tencent.mm.bv.a
{
  public b hPF;
  public long tXf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tXf);
      if (this.hPF != null) {
        paramVarArgs.b(2, this.hPF);
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
    } while (this.hPF == null);
    return i + d.a.a.a.a(2, this.hPF);
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
      cjr localcjr = (cjr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcjr.tXf = locala.xpH.oE();
        return 0;
      }
      localcjr.hPF = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cjr
 * JD-Core Version:    0.7.0.1
 */