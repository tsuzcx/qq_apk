package com.tencent.mm.plugin.product.c;

public final class h
  extends com.tencent.mm.bv.a
{
  public String id;
  public boolean mSU;
  public String name;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aA(3, this.mSU);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = d.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.name);
      }
      return i + (d.a.a.b.b.a.dQ(3) + 1);
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
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localh.id = locala.xpH.readString();
          return 0;
        case 2: 
          localh.name = locala.xpH.readString();
          return 0;
        }
        localh.mSU = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.h
 * JD-Core Version:    0.7.0.1
 */