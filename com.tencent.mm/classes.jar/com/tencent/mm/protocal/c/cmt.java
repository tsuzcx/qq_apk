package com.tencent.mm.protocal.c;

public final class cmt
  extends com.tencent.mm.bv.a
{
  public String path;
  public int sEs;
  public String tux;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.tux != null) {
        paramVarArgs.d(2, this.tux);
      }
      paramVarArgs.gB(3, this.sEs);
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tux != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tux);
      }
      i += d.a.a.a.gy(3, this.sEs);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.path);
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
        cmt localcmt = (cmt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcmt.username = locala.xpH.readString();
          return 0;
        case 2: 
          localcmt.tux = locala.xpH.readString();
          return 0;
        case 3: 
          localcmt.sEs = locala.xpH.oD();
          return 0;
        }
        localcmt.path = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmt
 * JD-Core Version:    0.7.0.1
 */