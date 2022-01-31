package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cja
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int hQR;
  public String hRf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.hRf == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      paramVarArgs.gB(3, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label337;
      }
    }
    label337:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hRf);
      }
      return i + d.a.a.a.gy(3, this.hQR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hPY == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.hRf != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cja localcja = (cja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcja.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localcja.hRf = locala.xpH.readString();
          return 0;
        }
        localcja.hQR = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cja
 * JD-Core Version:    0.7.0.1
 */