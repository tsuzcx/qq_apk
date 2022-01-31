package com.tencent.mm.protocal.c;

public final class ayr
  extends com.tencent.mm.bv.a
{
  public String path;
  public int sEs;
  public String tux;
  public String tuy;
  public int type;
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
      if (this.tuy != null) {
        paramVarArgs.d(3, this.tuy);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.gB(5, this.sEs);
      paramVarArgs.gB(6, this.type);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label418;
      }
    }
    label418:
    for (int i = d.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tux != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tux);
      }
      i = paramInt;
      if (this.tuy != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tuy);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.path);
      }
      return paramInt + d.a.a.a.gy(5, this.sEs) + d.a.a.a.gy(6, this.type);
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
        ayr localayr = (ayr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localayr.username = locala.xpH.readString();
          return 0;
        case 2: 
          localayr.tux = locala.xpH.readString();
          return 0;
        case 3: 
          localayr.tuy = locala.xpH.readString();
          return 0;
        case 4: 
          localayr.path = locala.xpH.readString();
          return 0;
        case 5: 
          localayr.sEs = locala.xpH.oD();
          return 0;
        }
        localayr.type = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayr
 * JD-Core Version:    0.7.0.1
 */