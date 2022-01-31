package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cld
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public String sww;
  public int tYv;
  public int tYw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jnU == null) {
        throw new b("Not all required fields were included: Md5");
      }
      if (this.sww == null) {
        throw new b("Not all required fields were included: DownloadUrl");
      }
      if (this.jnU != null) {
        paramVarArgs.d(1, this.jnU);
      }
      if (this.sww != null) {
        paramVarArgs.d(2, this.sww);
      }
      paramVarArgs.gB(3, this.tYv);
      paramVarArgs.gB(4, this.tYw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jnU == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = d.a.a.b.b.a.e(1, this.jnU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sww != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sww);
      }
      return i + d.a.a.a.gy(3, this.tYv) + d.a.a.a.gy(4, this.tYw);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.jnU == null) {
          throw new b("Not all required fields were included: Md5");
        }
        if (this.sww != null) {
          break;
        }
        throw new b("Not all required fields were included: DownloadUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cld localcld = (cld)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcld.jnU = locala.xpH.readString();
          return 0;
        case 2: 
          localcld.sww = locala.xpH.readString();
          return 0;
        case 3: 
          localcld.tYv = locala.xpH.oD();
          return 0;
        }
        localcld.tYw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cld
 * JD-Core Version:    0.7.0.1
 */