package com.tencent.mm.protocal.c;

public final class awq
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String ilp;
  public String path;
  public String title;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ilp != null) {
        paramVarArgs.d(1, this.ilp);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(5, this.path);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ilp == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.ilp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.path);
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
        awq localawq = (awq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localawq.ilp = locala.xpH.readString();
          return 0;
        case 2: 
          localawq.title = locala.xpH.readString();
          return 0;
        case 3: 
          localawq.desc = locala.xpH.readString();
          return 0;
        case 4: 
          localawq.username = locala.xpH.readString();
          return 0;
        }
        localawq.path = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awq
 * JD-Core Version:    0.7.0.1
 */