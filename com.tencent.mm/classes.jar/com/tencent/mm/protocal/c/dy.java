package com.tencent.mm.protocal.c;

public final class dy
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sxA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sxA == null) {
        throw new d.a.a.b("Not all required fields were included: Cookies");
      }
      if (this.sxA != null) {
        paramVarArgs.b(1, this.sxA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxA == null) {
        break label207;
      }
    }
    label207:
    for (paramInt = d.a.a.a.a(1, this.sxA) + 0;; paramInt = 0)
    {
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sxA != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Cookies");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        dy localdy = (dy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        }
        localdy.sxA = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dy
 * JD-Core Version:    0.7.0.1
 */