package com.tencent.mm.plugin.order.model;

public final class k
  extends com.tencent.mm.bv.a
{
  public String mQp;
  public String mQq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mQp != null) {
        paramVarArgs.d(1, this.mQp);
      }
      if (this.mQq != null) {
        paramVarArgs.d(2, this.mQq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mQp == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = d.a.a.b.b.a.e(1, this.mQp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mQq != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.mQq);
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
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localk.mQp = locala.xpH.readString();
          return 0;
        }
        localk.mQq = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.k
 * JD-Core Version:    0.7.0.1
 */