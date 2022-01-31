package com.tencent.mm.protocal.c;

public final class yh
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public String sRu;
  public String sWW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jnU != null) {
        paramVarArgs.d(1, this.jnU);
      }
      if (this.sRu != null) {
        paramVarArgs.d(2, this.sRu);
      }
      if (this.sWW != null) {
        paramVarArgs.d(3, this.sWW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jnU == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.jnU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sRu != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sRu);
      }
      i = paramInt;
      if (this.sWW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sWW);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        yh localyh = (yh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localyh.jnU = locala.xpH.readString();
          return 0;
        case 2: 
          localyh.sRu = locala.xpH.readString();
          return 0;
        }
        localyh.sWW = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.yh
 * JD-Core Version:    0.7.0.1
 */