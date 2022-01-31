package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class cx
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bQZ == null) {
        throw new b("Not all required fields were included: wording");
      }
      if (this.url == null) {
        throw new b("Not all required fields were included: url");
      }
      paramVarArgs.gB(1, this.type);
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = paramInt;
    } while (this.url == null);
    return paramInt + d.a.a.b.b.a.e(3, this.url);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.bQZ == null) {
        throw new b("Not all required fields were included: wording");
      }
      if (this.url == null) {
        throw new b("Not all required fields were included: url");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      cx localcx = (cx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localcx.type = locala.xpH.oD();
        return 0;
      case 2: 
        localcx.bQZ = locala.xpH.readString();
        return 0;
      }
      localcx.url = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cx
 * JD-Core Version:    0.7.0.1
 */