package com.tencent.mm.protocal.c;

public final class at
  extends com.tencent.mm.bv.a
{
  public String euK;
  public String sua;
  public String sub;
  public String suc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      if (this.sua != null) {
        paramVarArgs.d(2, this.sua);
      }
      if (this.sub != null) {
        paramVarArgs.d(3, this.sub);
      }
      if (this.suc != null) {
        paramVarArgs.d(4, this.suc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.euK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sua != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sua);
      }
      i = paramInt;
      if (this.sub != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sub);
      }
      paramInt = i;
      if (this.suc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.suc);
      }
      return paramInt;
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
        at localat = (at)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localat.euK = locala.xpH.readString();
          return 0;
        case 2: 
          localat.sua = locala.xpH.readString();
          return 0;
        case 3: 
          localat.sub = locala.xpH.readString();
          return 0;
        }
        localat.suc = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.at
 * JD-Core Version:    0.7.0.1
 */