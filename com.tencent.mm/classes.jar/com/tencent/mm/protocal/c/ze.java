package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ze
  extends com.tencent.mm.bv.a
{
  public int hQL;
  public String sYw;
  public long sYx;
  public String sYy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sYw == null) {
        throw new b("Not all required fields were included: Rid");
      }
      if (this.sYy == null) {
        throw new b("Not all required fields were included: MimeType");
      }
      if (this.sYw != null) {
        paramVarArgs.d(1, this.sYw);
      }
      paramVarArgs.Y(2, this.sYx);
      paramVarArgs.gB(3, this.hQL);
      if (this.sYy != null) {
        paramVarArgs.d(4, this.sYy);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sYw == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = d.a.a.b.b.a.e(1, this.sYw) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sYx) + d.a.a.a.gy(3, this.hQL);
      paramInt = i;
      if (this.sYy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYy);
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
        if (this.sYw == null) {
          throw new b("Not all required fields were included: Rid");
        }
        if (this.sYy != null) {
          break;
        }
        throw new b("Not all required fields were included: MimeType");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ze localze = (ze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localze.sYw = locala.xpH.readString();
          return 0;
        case 2: 
          localze.sYx = locala.xpH.oE();
          return 0;
        case 3: 
          localze.hQL = locala.xpH.oD();
          return 0;
        }
        localze.sYy = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ze
 * JD-Core Version:    0.7.0.1
 */