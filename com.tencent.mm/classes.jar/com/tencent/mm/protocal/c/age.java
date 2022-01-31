package com.tencent.mm.protocal.c;

public final class age
  extends com.tencent.mm.bv.a
{
  public String gSs;
  public String iQn;
  public String path;
  public String title;
  public int type;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iQn != null) {
        paramVarArgs.d(1, this.iQn);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.gB(3, this.type);
      if (this.gSs != null) {
        paramVarArgs.d(4, this.gSs);
      }
      if (this.username != null) {
        paramVarArgs.d(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.iQn == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = d.a.a.b.b.a.e(1, this.iQn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.title);
      }
      i += d.a.a.a.gy(3, this.type);
      paramInt = i;
      if (this.gSs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.gSs);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.path);
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
        age localage = (age)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localage.iQn = locala.xpH.readString();
          return 0;
        case 2: 
          localage.title = locala.xpH.readString();
          return 0;
        case 3: 
          localage.type = locala.xpH.oD();
          return 0;
        case 4: 
          localage.gSs = locala.xpH.readString();
          return 0;
        case 5: 
          localage.username = locala.xpH.readString();
          return 0;
        }
        localage.path = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.age
 * JD-Core Version:    0.7.0.1
 */