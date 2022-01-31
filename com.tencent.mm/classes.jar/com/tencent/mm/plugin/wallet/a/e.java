package com.tencent.mm.plugin.wallet.a;

public final class e
  extends com.tencent.mm.bv.a
{
  public String qkQ;
  public String qkR;
  public String qkS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.qkQ != null) {
        paramVarArgs.d(1, this.qkQ);
      }
      if (this.qkR != null) {
        paramVarArgs.d(2, this.qkR);
      }
      if (this.qkS != null) {
        paramVarArgs.d(3, this.qkS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.qkQ == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.qkQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.qkR);
      }
      i = paramInt;
      if (this.qkS != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.qkS);
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
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locale.qkQ = locala.xpH.readString();
          return 0;
        case 2: 
          locale.qkR = locala.xpH.readString();
          return 0;
        }
        locale.qkS = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.e
 * JD-Core Version:    0.7.0.1
 */